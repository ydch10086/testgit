package com.yd.common.tool.db.model;

import java.util.ArrayList;
import java.util.List;

import com.yd.common.tool.db.CIPTxtField;


public class CIPTable implements java.io.Serializable, Cloneable {

    private static final long serialVersionUID  = -7246043091254837124L;
    private String            tableName;
    private String            tableType;
    private String            tableAlias;
    private String            remarks;
    private String 			  moduleName;
    private String            className;
    private String            javaProperty;
    private String            catalog           = null;
    private String            schema            = null;
    
    private String  moduleId = null;


	private List<CIPColumn>      baseColumns       = new ArrayList<CIPColumn>();
    private List<CIPColumn>      primaryKeys = new ArrayList<CIPColumn>();
    private List<CIPTxtField>		 txtColumns = new ArrayList<CIPTxtField>();

    
    public void addTxtColumn(String columnId, String columnName){
    	CIPTxtField field = new CIPTxtField();
    	field.setTxtField(columnId+"_name");
    	field.setTxtFieldName(columnName+"名称");
    	txtColumns.add(field);
    }
    public List<CIPTxtField> getTxtColumns(){
    	return txtColumns;
    }
    
    public CIPTable(){
    }

    public String getTableName() {
        return tableName;
    }
    
    

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

    public void setTableName(String tableName) {
    	tableName = tableName.toLowerCase();
        this.tableName = tableName;
        this.tableAlias = tableName;
        int index = tableName.indexOf('_');
        String tempStr = tableName.substring(index+1);
        
        this.className = tempStr;//StringUtil.getCamelCaseString(tableAlias, true);
        this.javaProperty = tableName;//StringUtil.getCamelCaseString(tableAlias, false);
  
        if(tempStr.indexOf('_')>0 )
        	this.moduleId = tempStr.substring(0, tempStr.indexOf('_'));
        else 
        	this.moduleId = tempStr;
    }

    public String getRemarks() {
        return remarks == null ? "" : remarks;
    }

    public boolean isHasRemarks() {
        return StringUtil.isNotEmpty(remarks);
    }

    public String getRemarksUnicode() {
        return StringUtil.toUnicodeString(getRemarks());
    }

    public void setRemarks(String remarks) {
    	String[] tempStrs = remarks.split("/");
    	if( tempStrs.length > 1){
    		this.remarks = tempStrs[1];
    		this.moduleName = tempStrs[0];
    	}
    	else{
    		this.remarks = remarks;
    		this.moduleName = "";
    	}
        
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public CIPColumn getColumn(String columnName) {
        for (CIPColumn column : primaryKeys) {
            if (column.getColumnName().equals(columnName)) {
                return column;
            }
        }
        for (CIPColumn column : baseColumns) {
            if (column.getColumnName().equals(columnName)) {
                return column;
            }
        }
        return null;
    }

    public List<CIPColumn> getColumns() {
        List<CIPColumn> allColumns = new ArrayList<CIPColumn>();
        allColumns.addAll(primaryKeys);
        allColumns.addAll(baseColumns);
        return allColumns;
    }

    public List<CIPColumn> getBaseColumns() {
        return baseColumns;
    }

    public void addBaseColumn(CIPColumn column) {
        this.baseColumns.add(column);
    }

    public List<CIPColumn> getPrimaryKeys() {
        return primaryKeys;
    }

    public void addPrimaryKey(CIPColumn primaryKeyColumn) {
        this.primaryKeys.add(primaryKeyColumn);
    }

    public String getJavaProperty() {
        return javaProperty;
    }

    public void setJavaProperty(String javaProperty) {
        this.javaProperty = javaProperty;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getTableAlias() {
        return tableAlias;
    }

    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
        this.className = Character.toUpperCase(tableAlias.charAt(0))+ tableAlias.substring(1);//StringUtil.getCamelCaseString(tableAlias, true);
        this.javaProperty = Character.toUpperCase(tableAlias.charAt(0))+ tableAlias.substring(1);// StringUtil.getCamelCaseString(tableAlias, false);
    }

    public boolean isHasDateColumn() {
        for (CIPColumn column : getColumns()) {
            if (column.isDate()) {
                return true;
            }
        }
        return false;
    }

    public boolean isHasBigDecimalColumn() {
        for (CIPColumn column : getColumns()) {
            if (column.isBigDecimal()) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

	public String getModuleName() {
		return moduleName;
	}
}
