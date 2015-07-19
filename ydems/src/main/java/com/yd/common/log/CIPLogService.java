package com.yd.common.log;

import com.yd.common.log.data.CIPAccessAuditLog;
import com.yd.common.log.data.CIPBaseDataOperateLog;
import com.yd.common.log.data.CIPBatchTaskLog;
import com.yd.common.log.data.CIPErrorLog;
import com.yd.common.log.data.CIPFunctionTraceLog;
import com.yd.common.log.data.CIPSystemLog;
import com.yd.common.log.data.CIPTransactionLog;

public interface CIPLogService {
	// 系统任务执行日志==》任务重跑
	public void logBatch(CIPBatchTaskLog logData);

	// 系统事务执行日志==》断点重做
	public void logTransaction(CIPTransactionLog logData);

	// 系统数据修改日志（基础数据）==》审计及数据恢复
	public void logMasterDataChange(CIPBaseDataOperateLog logData);

	// 系统使用审计日志==》系统功能访问日志
	public void logSystemAccess(CIPAccessAuditLog logData);

	// 系统功能点过程跟踪日志 ==》技术验证流程
	public void logFunctionTrace(CIPFunctionTraceLog logData);

	// 系统功能点执行异常日志 ==》技术运维支持
	public void logError(CIPErrorLog logData);

	// 系统生命周期日志，运维日志
	public void logSystemLifecycle(CIPSystemLog logData);
}
