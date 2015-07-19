package com.yd.common.log;

import org.apache.log4j.Logger;

import com.yd.common.log.data.CIPAccessAuditLog;
import com.yd.common.log.data.CIPBaseDataOperateLog;
import com.yd.common.log.data.CIPBatchTaskLog;
import com.yd.common.log.data.CIPErrorLog;
import com.yd.common.log.data.CIPFunctionTraceLog;
import com.yd.common.log.data.CIPSystemLog;
import com.yd.common.log.data.CIPTransactionLog;
import com.yd.common.runtime.CIPRuntimeConfigure;
import com.yd.common.utils.HttpUtils;

//集成meta log服务
public class CIPRemoteLogService implements CIPLogService {

	private static Logger log = Logger.getLogger(CIPRemoteLogService.class);

	private String logURL = CIPRuntimeConfigure.cip_log_url;

	@Override
	public void logBatch(CIPBatchTaskLog logData) {
		doLog(logData);
	}

	private void doLog(Object logData) {
		try {
			HttpUtils.post(logURL, logData);
		} catch (Exception e) {
			log.error("发送日志到日志服务器失败!", e);
		}
	}

	@Override
	public void logTransaction(CIPTransactionLog logData) {
		doLog(logData);
	}

	@Override
	public void logMasterDataChange(CIPBaseDataOperateLog logData) {
		doLog(logData);
	}

	@Override
	public void logSystemAccess(CIPAccessAuditLog logData) {
		doLog(logData);
	}

	@Override
	public void logFunctionTrace(CIPFunctionTraceLog logData) {
		doLog(logData);
	}

	@Override
	public void logError(CIPErrorLog logData) {
		doLog(logData);
	}

	@Override
	public void logSystemLifecycle(CIPSystemLog logData) {
		doLog(logData);
	}

}
