package com.yd.common.tool.db.model;

public class CIPColumn implements java.io.Serializable, Cloneable {

	private static final long serialVersionUID = 241462432312500261L;

	private String columnName;

	private boolean isPrimaryKey;

	private boolean isForeignKey;
	private String targetTableName;
	private String targetColumnName;
	private int size;
	private int decimalDigits;
	private boolean nullable;
	private boolean unique;
	private String defaultValue;
	private String remarks;
	protected int jdbcType;
	protected String jdbcTypeName;
	private String javaProperty;
	private String javaType;
	private String fullJavaType;
	private String editor;
	private int propertyType=6; // 1:码表字段；2：文本字段；3：度量属性；4、日期属性；5、时间戳属性；6、其他类型；7、敏感属性

	// UI
	private String ui_control_type; // 控件类型
	private boolean ui_x_ddic;// 绑定ddic
	private String ui_class;
	private String ui_control;
	private String ui_require = "false";
	
	public int getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(int propertyType) {
		this.propertyType = propertyType;
	}

	public String getUi_require() {
		return ui_require;
	}

	public void setUi_require(String ui_require) {
		this.ui_require = ui_require;
	}

	public String getUi_control() {
		return ui_control;
	}

	public void setUi_control(String ui_control) {
		this.ui_control = ui_control;
	}

	public String getUi_class() {
		return ui_class;
	}

	public void setUi_class(String ui_class) {
		this.ui_class = ui_class;
	}

	public String getUi_control_type() {
		return ui_control_type;
	}

	public void setUi_control_type(String ui_control_type) {
		this.ui_control_type = ui_control_type;
	}

	public boolean isUi_x_ddic() {
		return ui_x_ddic;
	}

	public void setUi_x_ddic(boolean ui_x_ddic) {
		this.ui_x_ddic = ui_x_ddic;
	}

	public CIPColumn(String columnName) {
		this.columnName = columnName;
		javaProperty = columnName;// StringUtil.getCamelCaseString(columnName,
									// false);
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getDecimalDigits() {
		return decimalDigits;
	}

	public void setDecimalDigits(int decimalDigits) {
		this.decimalDigits = decimalDigits;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;

	}

	public String getDefaultValue() {
		return defaultValue == null ? "" : defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getRemarks() {
		return remarks == null ? "" : remarks;
	}

	public boolean isHasRemarks() {
		return StringUtil.isNotEmpty(remarks);
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarksUnicode() {
		return StringUtil.toUnicodeString(getRemarks());
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getJavaProperty() {
		return javaProperty;
	}

	public int getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(int jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getJdbcTypeName() {
		return jdbcTypeName;
	}
	
	public void generateUIInfo(){
		if( javaProperty.equals("operator")
				|| javaProperty.equals("op_time")
				|| javaProperty.equals("create_time")
				|| javaProperty.equals("create_user")
				|| javaProperty.equals("update_time")
				|| javaProperty.equals("ip")
				){
			propertyType = 8;
			return;
		}
		
		//1、是否必输项目
		if(nullable)
			ui_require = "false";
		else
			ui_require = "true";
		
		//2、控件信息
		//a、处理主键信息
		if(isPrimaryKey){
			propertyType=6;
			if (jdbcTypeName.equals("INTEGER")||jdbcTypeName.equals("BIGINT") ) {
				ui_class = "easyui-numberbox";
				ui_control_type = "";
				ui_control = "input";
			}
			else if (jdbcTypeName.equals("VARCHAR")||jdbcTypeName.equals("CHAR")) {
				ui_control = "input";
				ui_control_type = "text";
				ui_class = "easyui-validateBox";
			}
			else if(jdbcTypeName.equals("DATE")){
				ui_control = "input";
				ui_control_type = "text";
				ui_class = "easyui-datebox";
				propertyType=4;
			}
			else if (jdbcTypeName.equals("TIMESTAMP")) {
				ui_control = "input";
				ui_control_type = "text";
				ui_class = "easyui-datetimebox";
				propertyType=5;
			}
			else {
				ui_control = "input";
				ui_control_type = "text";
				ui_class = "easyui-validateBox";
			}
			
			if(javaProperty.endsWith("code")
					||javaProperty.endsWith("type")
					||javaProperty.endsWith("status")
					||javaProperty.endsWith("flag") ){
				ui_control = "input";
				ui_control_type = "text";
				ui_class = "easyui-combobox";
				ui_x_ddic = true;
				propertyType=1;
			}
			
		}
		//b、码表属性字段
		else if(javaProperty.endsWith("code")
				||javaProperty.endsWith("type")
				||javaProperty.endsWith("status")
				||javaProperty.endsWith("flag") ){
			ui_control = "input";
			ui_control_type = "text";
			ui_class = "easyui-combobox";
			ui_x_ddic = true;
			propertyType=1;
		}
		//c、描述性字段
		else if(javaProperty.endsWith("txt")
				||javaProperty.endsWith("name")){
			ui_control = "input";
			ui_control_type = "text";
			ui_class = "easyui-validateBox";
			propertyType=2;
		}
		//d、描述性长文本
		else if(javaProperty.endsWith("memo")
				||javaProperty.endsWith("remark")
				||javaProperty.endsWith("desc")
				||javaProperty.endsWith("url")){
			ui_control = "textarea";
			ui_control_type = "";
			ui_class = "easyui-validatebox";
			propertyType=2;
		}
		//e、密码等敏感信息
		else if(javaProperty.endsWith("pwd")
				||javaProperty.endsWith("sec")){
			ui_control = "input";
			ui_control_type = "password";
			ui_class = "";
			propertyType=7;
		}
		//f、日期信息
		else if(javaProperty.endsWith("date")){
			ui_control = "input";
			ui_control_type = "text";
			ui_class = "easyui-datebox";
			propertyType=4;
		}
		//g、时间戳信息
		else if(javaProperty.endsWith("time")){
			ui_control = "input";
			ui_control_type = "text";
			ui_class = "easyui-datetimebox";
			propertyType=5;
		}
		//h、度量信息
		else if(javaProperty.endsWith("amt")
				||javaProperty.endsWith("quan")
				||javaProperty.endsWith("count")
				||javaProperty.endsWith("num")){
			ui_class = "easyui-numberbox";
			ui_control_type = "";
			ui_control = "input";
			propertyType=3;
		}
		//i、其它非关键字段
		else {
			propertyType=6;
			if (jdbcTypeName.equals("INTEGER")|| jdbcTypeName.equals("DECIMAL")
					||jdbcTypeName.equals("BIGINT") ) {
				ui_class = "easyui-numberbox";
				ui_control_type = "";
				ui_control = "input";
				
			} else if (jdbcTypeName.equals("VARCHAR")||jdbcTypeName.equals("CHAR")) {
				if (size > 50) {
					ui_control = "textarea";
					ui_control_type = "";
					ui_class = "easyui-validatebox";
				} 
				else {
					ui_control = "input";
					ui_control_type = "text";
					ui_class = "easyui-validateBox";
				}
			} 
			else {
				propertyType=6;
				//TODO 特殊字段必须重新定义
				ui_control = "input";
				ui_control_type = "text";
				ui_class = "easyui-validateBox";
			}
		}
	
	}

	public void setJdbcTypeName(String jdbcTypeName) {
		this.jdbcTypeName = jdbcTypeName.toUpperCase();

	}

	public boolean isString() {
		return JavaTypeResolver.isString(javaType);
	}

	public boolean isFloat() {
		return JavaTypeResolver.isFloat(javaType);
	}

	public boolean isInteger() {
		return JavaTypeResolver.isInteger(javaType);
	}

	public boolean isBigDecimal() {
		return JavaTypeResolver.isBigDecimal(javaType);
	}

	public boolean isBoolean() {
		return JavaTypeResolver.isBoolean(javaType);
	}

	public boolean isDate() {
		return JavaTypeResolver.isDate(javaType);
	}

	public boolean isBLOB() {
		String typeName = getJdbcTypeName();

		return "BINARY".equals(typeName) || "BLOB".equals(typeName) //$NON-NLS-1$ //$NON-NLS-2$
				|| "CLOB".equals(typeName) || "LONGVARBINARY".equals(typeName) //$NON-NLS-1$ //$NON-NLS-2$
				|| "LONGVARCHAR".equals(typeName) || "VARBINARY".equals(typeName); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public boolean isUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	public boolean isPrimaryKey() {
		return isPrimaryKey;
	}

	public void setPrimaryKey(boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}

	public boolean isForeignKey() {
		return isForeignKey;
	}

	public void setForeignKey(boolean isForeignKey) {
		this.isForeignKey = isForeignKey;
	}

	public void setJavaProperty(String javaProperty) {
		this.javaProperty = javaProperty.toLowerCase();
	}

	public String getGetterMethodName() {
		if (JavaTypeResolver.isBoolean(javaType)) {
			return "is" + Character.toUpperCase(columnName.charAt(0))
					+ columnName.substring(1);// StringUtil.getCamelCaseString(columnName,
												// true);
		} else {
			return "get" + Character.toUpperCase(columnName.charAt(0))
					+ columnName.substring(1);// StringUtil.getCamelCaseString(columnName,
												// true);
		}
	}

	public String getSetterMethodName() {
		return "set" + Character.toUpperCase(columnName.charAt(0))
				+ columnName.substring(1);// StringUtil.getCamelCaseString(columnName,
											// true);
	}

	public String getFullJavaType() {
		return fullJavaType;
	}

	public void setFullJavaType(String fullJavaType) {
		this.fullJavaType = fullJavaType;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getTargetTableName() {
		return targetTableName;
	}

	public void setTargetTableName(String targetTableName) {
		this.targetTableName = targetTableName;
	}

	public String getTargetColumnName() {
		return targetColumnName;
	}

	public void setTargetColumnName(String targetColumnName) {
		this.targetColumnName = targetColumnName;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "CIPColumn [columnName=" + columnName + ", isPrimaryKey="
				+ isPrimaryKey + ", isForeignKey=" + isForeignKey
				+ ", targetTableName=" + targetTableName
				+ ", targetColumnName=" + targetColumnName + ", size=" + size
				+ ", decimalDigits=" + decimalDigits + ", nullable=" + nullable
				+ ", unique=" + unique + ", defaultValue=" + defaultValue
				+ ", remarks=" + remarks + ", jdbcType=" + jdbcType
				+ ", jdbcTypeName=" + jdbcTypeName + ", javaProperty="
				+ javaProperty + ", javaType=" + javaType + ", fullJavaType="
				+ fullJavaType + ", editor=" + editor + "]";
	}
}
