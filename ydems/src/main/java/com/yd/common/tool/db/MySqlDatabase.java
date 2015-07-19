package com.yd.common.tool.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yd.common.tool.db.model.CIPTable;
import com.yd.common.tool.db.model.TypeMapping;

public class MySqlDatabase extends DefaultDatabase {

    private static final String TABLE_COMMENTS_SQL  = "show table status where NAME=?";

    public MySqlDatabase(Connection connection, TypeMapping typeMapping){
        super(connection, typeMapping);
    }

	@Override
	public List<CIPTable> getTables(String catalog, String schema) {
		List<CIPTable> tables = super.getTables(catalog, schema);
		for( CIPTable table : tables) {
			try {
				introspectTableComments(table);
			} catch (SQLException e) {
				;
			}
		}
		
		return tables;
	}
    
    @Override
    public CIPTable getTable(String catalog, String schema, String tableName) throws SQLException {
        CIPTable table = super.getTable(catalog, schema, tableName);
        if (table != null) {
            introspectTableComments(table);
        }
        return table;
    }
    
    @Override
	public List<CIPTable> getViews(String catalog, String schema) {
		List<CIPTable> tables = super.getViews(catalog, schema);
		for( CIPTable table : tables) {
			try {
				introspectTableComments(table);
			} catch (SQLException e) {
				;
			}
		}
		
		return tables;
	}
    
    @Override
    public CIPTable getView(String catalog, String schema, String tableName) throws SQLException {
        CIPTable table = super.getView(catalog, schema, tableName);
        if (table != null) {
            introspectTableComments(table);
        }
        return table;
    }


    public void introspectTableComments(CIPTable table) throws SQLException {
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            psmt = connection.prepareStatement(TABLE_COMMENTS_SQL);
            psmt.setString(1, table.getTableName());
            rs = psmt.executeQuery();
            if (rs.next()) {
                table.setRemarks(rs.getString("COMMENT"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            close(rs);
            close(psmt);
        }
    }
}
