package com.yd.common.log;

import org.apache.log4j.Logger;

import com.yd.common.log.data.CIPAccessAuditLog;
import com.yd.common.log.data.CIPBaseDataOperateLog;
import com.yd.common.log.data.CIPBatchTaskLog;
import com.yd.common.log.data.CIPErrorLog;
import com.yd.common.log.data.CIPFunctionTraceLog;
import com.yd.common.log.data.CIPSystemLog;
import com.yd.common.log.data.CIPTransactionLog;


//本地日志 则用  Logger落地到本地文件
public class CIPLocalLogService implements CIPLogService {

	private static Logger log = Logger.getLogger(CIPLocalLogService.class);
	
	@Override
	public void logBatch(CIPBatchTaskLog logData) {
		log.info(logData.toString());
	}

	@Override
	public void logTransaction(CIPTransactionLog logData) {
		log.info(logData.toString());
	}

	@Override
	public void logMasterDataChange(CIPBaseDataOperateLog logData) {
		log.info(logData.toString());
	}

	@Override
	public void logSystemAccess(CIPAccessAuditLog logData) {
		log.info(logData.toString());
	}

	@Override
	public void logFunctionTrace(CIPFunctionTraceLog logData) {
		log.info(logData.toString());
	}

	@Override
	public void logError(CIPErrorLog logData) {
		log.info(logData.toString());
	}

	@Override
	public void logSystemLifecycle(CIPSystemLog logData) {
		log.info(logData.toString());
	}

}
