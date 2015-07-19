package com.yd.common.function.domain.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yd.common.data.CIPResponseMsg;
import com.yd.common.function.admin.data.vo.CIP_admin_domainVO;
import com.yd.common.function.admin.service.CIP_admin_codesService;
import com.yd.common.function.domain.service.CIPDomainDataService;
import com.yd.common.function.domain.service.CIPDomainService;
import com.yd.common.function.domain.service.impl.CIPDomainDataServiceImpl;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.utils.JSONUtils;

@RestController
@RequestMapping(value = "/actions/common/domain")
public class CIPDomainController {

	@Autowired
	private CIPDomainService domainService = null;
	private Map<String, CIPDomainDataService<Object>> dataServices = new HashMap<String, CIPDomainDataService<Object>>();

	private static final String _domainId = "domainId";
	private static final String _domainValue = "domainValue";

	private <T> CIPDomainDataService<T> getService(Class<T> clazz) {
		return new CIPDomainDataServiceImpl<T>();
	}

	@RequestMapping(value = "/getDomainMeta")
	public CIPResponseMsg getDomainMeta(HttpServletRequest request) {
		String domainId = request.getParameter(_domainId);
		CIPResponseMsg msg = new CIPResponseMsg();

		try {
			CIP_admin_domainVO domainData = domainService.getDomain(domainId);
			msg.data = domainData;
		} catch (Exception e) {
			msg.errorCode = CIPErrorCode.ERROR_TECHNICAL_ERROR.code;
			msg.msg = e.getMessage();
		}

		return msg;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getDomains")
	public CIPResponseMsg getDomains(HttpServletRequest request)
			throws IOException {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			String domainId = request.getParameter(_domainId);
			String tableName = domainService.getTableName(domainId);
			if(tableName==null||tableName.toLowerCase().equals("cip_admin_codes")){
				msg.data = domainService.getDomainCodes(domainId);
			}
			else {
				CIPDomainDataService<Object> dataService = dataServices
						.get(domainId);

				if (dataService == null) {
					// 1. get domain meta data
					domainService.initDomain(domainId);
					String[] keys = domainService.getDomainTableKeys(domainId);
					Class<?> clazz = domainService.getDomainDataClass(domainId);

					// 2. 生成 domain dataService
					dataService = (CIPDomainDataService<Object>) this
							.getService(clazz);
					dataService.init(clazz, tableName, keys);

					dataServices.put(domainId, dataService);
				}

				msg.data = dataService.getDatas();
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg.errorCode = CIPErrorCode.ERROR_TECHNICAL_ERROR.code;
			msg.msg = e.getMessage();
		}

		return msg;
	}

	@RequestMapping(value = "/check")
	public CIPResponseMsg check(HttpServletRequest request)
			throws Exception {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			
			String domainId = request.getParameter(_domainId);
			String tableName = domainService.getDomainTableName(domainId);
			if(tableName==null||tableName.toLowerCase().equals("cip_admin_codes")){
				String domainValue = request.getParameter(_domainValue);
				
				msg.data = domainService.checkDomainCode(_domainId, domainValue);
			}
			else {
				CIPDomainDataService<Object> dataService = dataServices
						.get(domainId);
				Class<?> clazz = null;
				if (dataService == null) {
					// 1. get domain meta data
					domainService.initDomain(domainId);
					tableName = domainService.getDomainTableName(domainId);
					String[] keys = domainService.getDomainTableKeys(domainId);
					clazz = domainService.getDomainDataClass(domainId);

					// 2. 生成 domain dataService
					dataService = (CIPDomainDataService<Object>) this
							.getService(clazz);
					dataService.init(clazz, tableName, keys);

					dataServices.put(domainId, dataService);
				}
				
				clazz = domainService.getDomainDataClass(domainId);
						
				String dataStr = IOUtils.toString(request.getInputStream());
				Object data = JSONUtils.convertJson2Object(dataStr, clazz);

				boolean xValid = dataService.checkData(data);
				msg.data = xValid;
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg.errorCode = CIPErrorCode.ERROR_TECHNICAL_ERROR.code;
			msg.msg = e.getMessage();
		}
		return msg;

	}
}
