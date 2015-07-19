package com.yd.common.log;

import com.yd.common.log.data.CIPAccessAuditLog;
import com.yd.common.log.data.CIPBaseDataOperateLog;
import com.yd.common.log.data.CIPBatchTaskLog;
import com.yd.common.log.data.CIPErrorLog;
import com.yd.common.log.data.CIPFunctionTraceLog;
import com.yd.common.log.data.CIPSystemLog;
import com.yd.common.log.data.CIPTransactionLog;
import com.yd.common.runtime.CIPRuntimeConfigure;

public class CIPLogManager {
	
	private static CIPLogService logService;
	public static void init(){
		if( CIPRuntimeConfigure.cip_is_remote_conf ){
			logService = new CIPRemoteLogService();
		}
		else {
			logService = new CIPLocalLogService();
		}
	}
	
	// 系统任务执行日志==》任务重跑
	public static void logBatch(int taskId, int stepId, String message,
			int errorCode) {
		CIPBatchTaskLog logData = new CIPBatchTaskLog();
		logData.occur_time = System.currentTimeMillis();
		logData.sys_id = CIPRuntimeConfigure.cip_system_id;
		logData.task_id = taskId;
		logData.step_id = stepId;
		logData.step_msg = message;
		logData.error_code = errorCode;
		logService.logBatch(logData);
	}

	// 系统事务执行日志==》断点重做
	public static void logTransaction(int transId, int stepId, String message,
			int executeStatus) {
		CIPTransactionLog logData = new CIPTransactionLog();
		logData.occur_time = System.currentTimeMillis();
		logData.sys_id = CIPRuntimeConfigure.cip_system_id;
		logData.trans_id = transId;
		logData.step_id = stepId;
		logData.trans_msg = message;
		logData.execute_status = executeStatus;
		
		logService.logTransaction(logData);
	}

	// 系统数据修改日志（基础数据）==》审计及数据恢复
	public static void logMasterDataChange(String tableId, String recordId,
			String oldValue, String newValue, String userId, int operateType) {
		CIPBaseDataOperateLog logData = new CIPBaseDataOperateLog();
		logData.occur_time = System.currentTimeMillis();
		logData.sys_id = CIPRuntimeConfigure.cip_system_id;
		logData.old_values = oldValue;
		logData.new_values = newValue;
		logData.user_id = userId;
		logData.operate_type = operateType;
		logData.table_id = tableId;
		logData.ref_id = recordId;
		
		logService.logMasterDataChange(logData);
	}
	
	// 系统使用审计日志==》系统功能访问日志 
	public static void logSystemAccess(int funcId, String userId, String ip){
		CIPAccessAuditLog logData = new CIPAccessAuditLog();
		logData.occur_time = System.currentTimeMillis();
		logData.sys_id = CIPRuntimeConfigure.cip_system_id;
		logData.func_id = funcId;
		logData.user_id = userId;
		logData.ip = ip;
		
		logService.logSystemAccess(logData);
	}

	// 系统功能点过程跟踪日志 ==》技术验证流程
	public static void logFunctionTrace(int funcId, int stepId, String stepMsg){
		CIPFunctionTraceLog logData = new CIPFunctionTraceLog();
		logData.occur_time = System.currentTimeMillis();
		logData.sys_id = CIPRuntimeConfigure.cip_system_id;
		logData.func_id = funcId;
		logData.step_id = stepId;
		logData.step_msg = stepMsg;
		
		logService.logFunctionTrace(logData);
	}
	
	// 系统功能点执行异常日志 ==》技术运维支持
	public static void logError(int funcId, int errorCode, int errorLevel, String errorMsg){
		CIPErrorLog logData = new CIPErrorLog();
		logData.occur_time = System.currentTimeMillis();
		logData.func_id = funcId;
		logData.sys_id = CIPRuntimeConfigure.cip_system_id;
		logData.error_code = errorCode;
		logData.error_level = errorLevel;
		logData.error_msg = errorMsg;
		logService.logError(logData);
	}
	
	//系统生命周期日志，运维日志
	public static void logSystemLifecycle(int keyPoint, int errorcode, String keyMsg){
		CIPSystemLog logData = new CIPSystemLog();
		logData.occur_time = System.currentTimeMillis();
		logData.sys_id = CIPRuntimeConfigure.cip_system_id;
		logData.key_point = keyPoint;
		logData.key_msg = keyMsg;
		logData.error_code = errorcode;
		logService.logSystemLifecycle(logData);
	}
}
