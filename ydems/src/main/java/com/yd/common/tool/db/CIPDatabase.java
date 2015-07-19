package com.yd.common.tool.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.yd.common.tool.db.model.CIPTable;
import com.yd.common.tool.db.model.TypeMapping;



public abstract class CIPDatabase {

    protected Connection connection;
    protected TypeMapping typeMapping;

    public CIPDatabase(Connection connection, TypeMapping typeMapping){
        this.connection = connection;
        this.typeMapping = typeMapping;
    }

    public abstract List<CIPTable> getTables(String catalog, String schema);
    
    public abstract CIPTable getTable(String catalog, String schema, String tableName) throws SQLException;

    
    public abstract List<CIPTable> getViews(String catalog, String schema);
    
    public abstract CIPTable getView(String catalog, String schema, String viewName) throws SQLException;

    
    public Connection getConnection() {
        return connection;
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {

        }
    }

    public static void close(Statement st) {
        try {
            if (st != null) {
                st.close();
                st = null;
            }
        } catch (SQLException e) {

        }
    }
}
