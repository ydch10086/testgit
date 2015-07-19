package com.yd.common.tool.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yd.common.tool.db.model.CIPColumn;
import com.yd.common.tool.db.model.CIPTable;
import com.yd.common.tool.db.model.JdbcTypeResolver;
import com.yd.common.tool.db.model.StringUtil;
import com.yd.common.tool.db.model.TypeMapping;

public class DefaultDatabase extends CIPDatabase {

	public DefaultDatabase(Connection connection, TypeMapping typeMapping) {
		super(connection, typeMapping);
	}

	@Override
	public CIPTable getTable(String catalog, String schema, String tableName)
			throws SQLException {
		ResultSet rs = null;
		CIPTable table = null;
		String schemaPattern = null;
		try {
			if (StringUtil.isNotEmpty(schema)) {
				schemaPattern = schema;
			}
			rs = connection.getMetaData().getTables(catalog, schemaPattern,
					tableName, new String[] { "TABLE" });
			if (rs.next()) {
				table = new CIPTable();
				table.setCatalog(rs.getString("TABLE_CAT"));
				table.setSchema(rs.getString("TABLE_SCHEM"));
				table.setTableName(tableName);
				table.setRemarks(rs.getString("REMARKS"));
				table.setTableType(rs.getString("TABLE_TYPE"));

				introspectPrimaryKeys(table);
				introspectColumns(table);
				introspectForeignKeys(table);
				introspectIndex(table);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			close(rs);
		}
		return table;
	}

	protected void introspectPrimaryKeys(CIPTable table) throws SQLException {
		ResultSet rs = null;
		try {
			rs = connection.getMetaData().getPrimaryKeys(null,
					table.getSchema(), table.getTableName());
			while (rs.next()) {
				String columnName = rs.getString("COLUMN_NAME");
				CIPColumn column = table.getColumn(columnName);
				if (column == null) {
					column = new CIPColumn(columnName);
					table.addPrimaryKey(column);
				}
				column.setPrimaryKey(true);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			close(rs);
		}
	}

	protected void introspectColumns(CIPTable table) throws SQLException {
		ResultSet rs = null;
		try {
			rs = connection.getMetaData().getColumns(null, table.getSchema(),
					table.getTableName(), "%");
			while (rs.next()) {
				String columnName = rs.getString("COLUMN_NAME");// 获得字段名称
				if (StringUtil.isEmpty(columnName)) {
					continue;
				}

				CIPColumn column = table.getColumn(columnName);
				if (column == null) {
					column = new CIPColumn(columnName);
					table.addBaseColumn(column);
				}
				column.setJavaProperty(columnName);
				column.setJdbcType(rs.getInt("DATA_TYPE"));
				column.setSize(rs.getInt("COLUMN_SIZE"));
				column.setNullable(rs.getInt("NULLABLE") == 1);
				column.setDefaultValue(rs.getString("COLUMN_DEF"));
				column.setDecimalDigits(rs.getInt("DECIMAL_DIGITS"));
				column.setRemarks(rs.getString("REMARKS"));
				column.setJdbcTypeName(JdbcTypeResolver.getJdbcTypeName(column
						.getJdbcType()));
				column.setJavaType(typeMapping.calculateJavaType(column));
				column.setFullJavaType(typeMapping
						.calculateFullJavaType(column));
				
				column.generateUIInfo();
				
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			close(rs);
		}
	}

	// 获得外键的信息
	protected void introspectForeignKeys(CIPTable table) throws SQLException {
		ResultSet rs = null;
		try {
			rs = connection.getMetaData().getImportedKeys(null,
					table.getSchema(), table.getTableName());
			while (rs.next()) {
				String columnName = rs.getString("FKCOLUMN_NAME");
				if (StringUtil.isEmpty(columnName)) {
					continue;
				}
				String pkTableName = rs.getString("PKTABLE_NAME");
				String pkColumnName = rs.getString("PKCOLUMN_NAME");
				CIPColumn column = table.getColumn(columnName);
				if (column != null) {
					column.setForeignKey(true);
					column.setTargetTableName(pkTableName);
					column.setTargetColumnName(pkColumnName);
				}
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			close(rs);
		}
	}

	// 获得索引
	protected void introspectIndex(CIPTable table) throws SQLException {
		ResultSet rs = null;
		try {
			rs = connection.getMetaData().getIndexInfo(null, table.getSchema(),
					table.getTableName(), true, true);
			while (rs.next()) {
				String columnName = rs.getString("COLUMN_NAME");
				if (StringUtil.isEmpty(columnName)) {
					continue;
				}
				CIPColumn column = table.getColumn(columnName);
				if (column != null) {
					column.setUnique(!rs.getBoolean("NON_UNIQUE"));
				}
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			close(rs);
		}
	}

	@Override
	public List<CIPTable> getTables(String catalog, String schema) {
		
		ResultSet rs = null;
		CIPTable table = null;
		String schemaPattern = null;
		String tableName;
		List<CIPTable> tables = null;
		try {
			if (StringUtil.isNotEmpty(schema)) {
				schemaPattern = schema;
			}
			rs = connection.getMetaData().getTables(catalog, schemaPattern,
					"%", new String[] { "TABLE", "VIEW" });
			tables = new ArrayList<CIPTable>(rs.getFetchSize());
			while (rs.next()) {
				table = new CIPTable();
				table.setCatalog(rs.getString("TABLE_CAT"));
				table.setSchema(rs.getString("TABLE_SCHEM"));
				tableName = rs.getString(3);
				table.setTableName(tableName);
				table.setRemarks(rs.getString("REMARKS"));
				table.setTableType(rs.getString("TABLE_TYPE"));

				introspectPrimaryKeys(table);
				introspectColumns(table);
				introspectForeignKeys(table);
				introspectIndex(table);
				tables.add(table);
			}
		} catch (SQLException e) {
			return null;
		} finally {
			close(rs);
		}
		return tables;
	}

	@Override
	public List<CIPTable> getViews(String catalog, String schema) {
		ResultSet rs = null;
		CIPTable table = null;
		String schemaPattern = null;
		String tableName;
		List<CIPTable> tables = null;
		try {
			if (StringUtil.isNotEmpty(schema)) {
				schemaPattern = schema;
			}
			rs = connection.getMetaData().getTables(catalog, schemaPattern,
					"%", new String[] {"VIEW" });
			tables = new ArrayList<CIPTable>(rs.getFetchSize());
			while (rs.next()) {
				table = new CIPTable();
				table.setCatalog(rs.getString("TABLE_CAT"));
				table.setSchema(rs.getString("TABLE_SCHEM"));
				tableName = rs.getString(3);
				table.setTableName(tableName);
				table.setRemarks(rs.getString("REMARKS"));
				table.setTableType(rs.getString("TABLE_TYPE"));

				introspectPrimaryKeys(table);
				introspectColumns(table);
				introspectForeignKeys(table);
				introspectIndex(table);
				tables.add(table);
			}
		} catch (SQLException e) {
			return null;
		} finally {
			close(rs);
		}
		return tables;
	}

	@Override
	public CIPTable getView(String catalog, String schema, String viewName)
			throws SQLException {
		ResultSet rs = null;
		CIPTable table = null;
		String schemaPattern = null;
		try {
			if (StringUtil.isNotEmpty(schema)) {
				schemaPattern = schema;
			}
			rs = connection.getMetaData().getTables(catalog, schemaPattern,
					viewName, new String[] { "VIEW" });
			if (rs.next()) {
				table = new CIPTable();
				table.setCatalog(rs.getString("TABLE_CAT"));
				table.setSchema(rs.getString("TABLE_SCHEM"));
				table.setTableName(viewName);
				table.setRemarks(rs.getString("REMARKS"));
				table.setTableType(rs.getString("TABLE_TYPE"));

				introspectPrimaryKeys(table);
				introspectColumns(table);
				introspectForeignKeys(table);
				introspectIndex(table);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			close(rs);
		}
		return table;
	}
}
