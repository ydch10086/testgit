package com.yd.common.tool.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yd.common.tool.db.model.TypeMapping;

public class CIPDBUtils {

    public static CIPDatabase createDatabase(Connection connection) throws SQLException {
        
    	TypeMapping typeMapping = new TypeMapping();
    	String dbProduct = connection.getMetaData().getDatabaseProductName();
        if(dbProduct.toLowerCase().contains("oracle")){
            return new OracleDatabase(connection, typeMapping);
        } else if(dbProduct.toLowerCase().contains("sql server")){
            return new SqlServerDatabase(connection, typeMapping);
        } else if(dbProduct.toLowerCase().contains("mysql")){
            return new MySqlDatabase(connection, typeMapping);
        } else {
            return new DefaultDatabase(connection, typeMapping);
        }
    }
    
    public static CIPDomainInfo getCIPDomain(Connection conn, String domainId) throws SQLException{
    	CIPDomainInfo domain = null;
    	String sql = "select * from cip_admin_domain where domain_id='"+domainId+"'";
    	PreparedStatement ptst = conn.prepareStatement(sql);
    	ResultSet rs = ptst.executeQuery();
    	if(rs.next()){
    		domain = new CIPDomainInfo();
    		domain.refDomainId = rs.getString("ref_domain_id");
    		domain.refTableId = rs.getString("ref_table_id");
    	}
    	
    	return domain;
    }
}