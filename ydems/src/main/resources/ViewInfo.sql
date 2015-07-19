DROP VIEW IF EXISTS em_check_log_v;
create ALGORITHM=MERGE view em_check_log_v as select m.* from em_check_log m ;
DROP VIEW IF EXISTS em_check_poi_log_v;
create ALGORITHM=MERGE view em_check_poi_log_v as select m.* from em_check_poi_log m ;
DROP VIEW IF EXISTS em_mainten_log_v;
create ALGORITHM=MERGE view em_mainten_log_v as select m.* from em_mainten_log m ;
DROP VIEW IF EXISTS em_mainten_repair_log_v;
create ALGORITHM=MERGE view em_mainten_repair_log_v as select m.* from em_mainten_repair_log m ;
DROP VIEW IF EXISTS em_mainten_repair_plan_v;
create ALGORITHM=MERGE view em_mainten_repair_plan_v as select m.* from em_mainten_repair_plan m ;
DROP VIEW IF EXISTS em_mainten_scrap_plan_v;
create ALGORITHM=MERGE view em_mainten_scrap_plan_v as select m.* from em_mainten_scrap_plan m ;
DROP VIEW IF EXISTS em_mdm_employee_v;
create ALGORITHM=MERGE view em_mdm_employee_v as select m.* from em_mdm_employee m ;
DROP VIEW IF EXISTS em_mdm_lifnr_v;
create ALGORITHM=MERGE view em_mdm_lifnr_v as select m.* from em_mdm_lifnr m ;
DROP VIEW IF EXISTS em_mdm_orgeh_v;
create ALGORITHM=MERGE view em_mdm_orgeh_v as select m.* from em_mdm_orgeh m ;
DROP VIEW IF EXISTS em_purchase_check_v;
create ALGORITHM=MERGE view em_purchase_check_v as 
select m.*
,che_status.code_name as che_status_name  from em_purchase_check m 
 left join cip_admin_codes che_status
 on m.che_status=che_status.code_type 
 and che_status.domain_id='che_status' ;
DROP VIEW IF EXISTS em_purchase_plain_v;
create ALGORITHM=MERGE view em_purchase_plain_v as 
select m.*
,pur_status.code_name as pur_status_name  from em_purchase_plain m 
 left join cip_admin_codes pur_status
 on m.pur_status=pur_status.code_type 
 and pur_status.domain_id='pur_status' ;
DROP VIEW IF EXISTS em_report_train_v;
create ALGORITHM=MERGE view em_report_train_v as select m.* from em_report_train m ;
DROP VIEW IF EXISTS em_report_travel_v;
create ALGORITHM=MERGE view em_report_travel_v as select m.* from em_report_travel m ;
DROP VIEW IF EXISTS em_storage_class_v;
create ALGORITHM=MERGE view em_storage_class_v as select m.* from em_storage_class m ;
DROP VIEW IF EXISTS em_storage_log_v;
create ALGORITHM=MERGE view em_storage_log_v as 
select m.*
,op_type.code_name as op_type_name  from em_storage_log m 
 left join cip_admin_codes op_type
 on m.op_type=op_type.code_type 
 and op_type.domain_id='op_type' ;
DROP VIEW IF EXISTS em_storage_object_v;
create ALGORITHM=MERGE view em_storage_object_v as select m.* from em_storage_object m ;
DROP VIEW IF EXISTS em_storage_op_doc_v;
create ALGORITHM=MERGE view em_storage_op_doc_v as 
select m.*
,doc_op_type.code_name as doc_op_type_name ,op_type.code_name as op_type_name  from em_storage_op_doc m 
 left join cip_admin_codes doc_op_type
 on m.doc_op_type=doc_op_type.code_type 
 and doc_op_type.domain_id='doc_op_type' 
 left join cip_admin_codes op_type
 on m.op_type=op_type.code_type 
 and op_type.domain_id='op_type' ;
