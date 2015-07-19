package com.yd.common.tool.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yd.common.tool.db.model.CIPColumn;
import com.yd.common.tool.db.model.CIPTable;
import com.yd.common.tool.db.model.TypeMapping;


public class OracleDatabase extends DefaultDatabase {

    private static final String TABLE_COMMENTS_SQL  = "select * from user_tab_comments where TABLE_NAME=?";
    private static final String COLUMN_COMMENTS_SQL = "select * from user_col_comments where TABLE_NAME=?";

    public OracleDatabase(Connection connection, TypeMapping typeMapping){
        super(connection, typeMapping);
    }

    @Override
    public CIPTable getTable(String catalog, String schema, String tableName) throws SQLException {
        CIPTable table = super.getTable(catalog, schema, tableName);
        if (table != null) {
            introspectTableComments(table);
            introspectTableColumnsComments(table);
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
                table.setRemarks(rs.getString("COMMENTS"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            close(rs);
            close(psmt);
        }
    }

    public void introspectTableColumnsComments(CIPTable table) throws SQLException {
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            psmt = connection.prepareStatement(COLUMN_COMMENTS_SQL);
            psmt.setString(1, table.getTableName());
            rs = psmt.executeQuery();
            while (rs.next()) {
                String columnName = rs.getString("COLUMN_NAME");
                CIPColumn column = table.getColumn(columnName);
                if (column != null) {
                    column.setRemarks(rs.getString("COMMENTS"));
                }
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            close(rs);
            close(psmt);
        }
    }
}
