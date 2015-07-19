package com.yd.ems.report.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.data.CIPReqParameter;
import com.yd.common.data.CIPResponseMsg;
import com.yd.common.data.CIPResponseQueryMsg;
import com.yd.common.runtime.CIPRuntime;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.utils.DateUtils;
import com.yd.common.utils.JSONUtils;
import com.yd.common.utils.ExcelSheetParser;
import com.yd.common.exception.CIPRuntimeException;
import com.yd.common.exception.CIPServiceException;
import com.yd.common.exception.CIPDaoException;
import com.yd.ems.report.service.EMS_report_trainService;
import com.yd.ems.report.data.vo.EMS_report_trainVO;
import com.yd.ems.report.data.key.EMS_report_trainKey;
import com.yd.ems.report.data.mapper.EMS_report_trainMapper;
import com.yd.ems.report.data.EMS_report_trainData;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>控制层实现类</p>
 * <p>Class: EMS_report_trainController</p>
 *
 * @since 2015-05-29 02:42:14
 */
@RestController
@RequestMapping(value = "/actions/report_train")
public class EMS_report_trainController {
	
	@Autowired
	private EMS_report_trainService dataService  = null;
	
	private static final String C_ACTION_ADD_DATA = "ems_report_train_addData";
	/**
	* 新增设备培训方案表
	*/
	@RequestMapping(value="/addData")
	public CIPResponseMsg addData(@RequestBody EMS_report_trainVO vo) {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			dataService.addData(vo,CIPRuntime.getOperateSubject());
			msg.errorCode = CIPErrorCode.CALL_SUCCESS.code;
			msg.msg = CIPErrorCode.CALL_SUCCESS.name;
		} catch (CIPServiceException e) {
			CIPErrorCode error = e.getErrorCode();
			msg.errorCode = error.code;
			msg.msg = error.name;
		} catch (CIPDaoException e) {
			CIPErrorCode error = e.getErrorCode();
			msg.errorCode = error.code;
			msg.msg = error.name;
		} catch (CIPRuntimeException e) {
			CIPErrorCode error = e.getErrorCode();
			msg.errorCode = error.code;
			msg.msg = error.name;
		}

		return msg;
	}

	private static final String C_ACTION_GET_DATA = "ems_report_train_getData";
	/**
	* 查看设备培训方案表
	*/
	@RequestMapping(value = "/getData")
	public CIPResponseMsg getData(@RequestBody EMS_report_trainVO vo) {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			Object[] keys = vo.getKeys();
			EMS_report_trainVO vo0 = dataService.getData(keys);
			msg.errorCode = CIPErrorCode.CALL_SUCCESS.code;
			msg.msg = CIPErrorCode.CALL_SUCCESS.name;
			msg.data = vo0;
		} catch (CIPServiceException e) {
			CIPErrorCode error = e.getErrorCode();
			msg.errorCode = error.code;
			msg.msg = error.name;
		} catch (CIPDaoException e) {
			CIPErrorCode error = e.getErrorCode();
			msg.errorCode = error.code;
			msg.msg = error.name;
		} catch (CIPRuntimeException e) {
			CIPErrorCode error = e.getErrorCode();
			msg.errorCode = error.code;
			msg.msg = error.name;
		}

		return msg;
	}
	
	private static final String C_ACTION_DELETE_DATA = "ems_report_train_deleteData";
	/**
	* 删除设备培训方案表
	*/
	@RequestMapping(value = "/deleteData")
	public CIPResponseMsg deleteData(@RequestBody EMS_report_trainVO vo) {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			Object[] keys = vo.getKeys();
			dataService.deleteData(keys,CIPRuntime.getOperateSubject());
			msg.errorCode = CIPErrorCode.CALL_SUCCESS.code;
			msg.msg = CIPErrorCode.CALL_SUCCESS.name;
		} catch (CIPServiceException e) {
			CIPErrorCode error = e.getErrorCode();
			msg.errorCode = error.code;
			msg.msg = error.name;
		} catch (CIPDaoException e) {
			CIPErrorCode error = e.getErrorCode();
			msg.errorCode = error.code;
			msg.msg = error.name;
		} catch (CIPRuntimeException e) {
			CIPErrorCode error = e.getErrorCode();
			msg.errorCode = error.code;
			msg.msg = error.name;
		}

		return msg;
	}
	
	private static final String C_ACTION_UPDATE_DATA = "ems_report_train_updateData";
	/**
	* 更新设备培训方案表
	*/
	@RequestMapping(value = "/updateData")
	public CIPResponseMsg updateData(@RequestBody EMS_report_trainVO vo) {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			dataService.updateData(vo, CIPRuntime.getOperateSubject());
			msg.errorCode = CIPErrorCode.CALL_SUCCESS.code;
			msg.msg = CIPErrorCode.CALL_SUCCESS.name;
		} catch (CIPServiceException e) {
			CIPErrorCode error = e.getErrorCode();
			msg.errorCode = error.code;
			msg.msg = error.name;
		} catch (CIPDaoException e) {
			CIPErrorCode error = e.getErrorCode();
			msg.errorCode = error.code;
			msg.msg = error.name;
		} catch (CIPRuntimeException e) {
			CIPErrorCode error = e.getErrorCode();
			msg.errorCode = error.code;
			msg.msg = error.name;
		}

		return msg;
	}
	
	
	private static final String C_ACTION_SEARCH_DATA = "ems_report_train_searchData";
	
	/**
	* 查询设备培训方案表
	*/
	@RequestMapping(value = "/searchData")
	public CIPResponseQueryMsg searchData(CIPReqParameter parameter) {
		CIPResponseQueryMsg msg = new CIPResponseQueryMsg();
		try {
			CIPPageInfo page = new CIPPageInfo(parameter.getPage(),parameter.getRows());
			
			String conditonStr = parameter.getSearch_condition();
			
			CIPReqCondition[] conditions = null;
			if(conditonStr!=null){
				Map reqCondtions = JSONUtils.convertJson2Object(conditonStr, HashMap.class);
				//CIPConfigureData0 data = JSONUtils.convertJson2Object(msg.data.toString(), CIPConfigureData0.class);
				Set<String> keys = reqCondtions.keySet();
				CIPReqCondition req = null;
				CIPReqCondition[] tempConditions = new CIPReqCondition[keys.size()];
				int i = 0;
				String value;
				for( String key : keys ){
					value = (String) reqCondtions.get(key);
					if(value==null || value.trim().equals(""))
						continue;
					req = new CIPReqCondition();
					req.setFieldName(key);
					req.setLowValue(value);
					tempConditions[i++] = req;
				}
				if( i > 0 ){
					conditions = new CIPReqCondition[i];
					System.arraycopy(tempConditions, 0, conditions, 0, i);
				}
			}
			
			List<EMS_report_trainData> vos = dataService.searchData(page,conditions);
			
			msg.errorCode = CIPErrorCode.CALL_SUCCESS.code;
			msg.msg = CIPErrorCode.CALL_SUCCESS.name;
			msg.rows = vos;
			msg.total = page.getTotal();
		} catch (CIPServiceException e) {
			CIPErrorCode error = e.getErrorCode();
			msg.errorCode = error.code;
			msg.msg = error.name;
		} catch (CIPDaoException e) {
			CIPErrorCode error = e.getErrorCode();
			msg.errorCode = error.code;
			msg.msg = error.name;
		} catch (CIPRuntimeException e) {
			CIPErrorCode error = e.getErrorCode();
			msg.errorCode = error.code;
			msg.msg = error.name;
		}

		return msg;
	}
	

	
	private static final String C_ACTION_EXPORT_EXCEL = "ems_report_train_exportEntities";
	
	/** 
	 * 导出Excel
	 */
	@RequestMapping(value="/exportEntities")
	public void exportEntities(CIPReqParameter parameter, HttpServletRequest request, HttpServletResponse response) throws Exception {
		OutputStream os = null;
		try {
			//初始化检索条件
			//CIPPageInfo page = new CIPPageInfo(parameter.getPage(),parameter.getRows());
			String conditonStr = parameter.getSearch_condition();
			
			CIPReqCondition[] conditions = null;
			if(conditonStr!=null){
				Map reqCondtions = JSONUtils.convertJson2Object(conditonStr, HashMap.class);
				//CIPConfigureData0 data = JSONUtils.convertJson2Object(msg.data.toString(), CIPConfigureData0.class);
				Set<String> keys = reqCondtions.keySet();
				CIPReqCondition req = null;
				CIPReqCondition[] tempConditions = new CIPReqCondition[keys.size()];
				int i = 0;
				String value;
				for( String key : keys ){
					value = (String) reqCondtions.get(key);
					if(value==null || value.trim().equals(""))
						continue;
					req = new CIPReqCondition();
					req.setFieldName(key);
					req.setLowValue(value);
					tempConditions[i++] = req;
				}
				if( i > 0 ){
					conditions = new CIPReqCondition[i];
					System.arraycopy(tempConditions, 0, conditions, 0, i);
				}
			}
			
			//导出excel
			String as = "导出设备培训方案表_"+DateUtils.getDate(new Date());

			String fileName = new String(as.getBytes("GB2312"), "ISO_8859_1");
			response.setCharacterEncoding("utf-8");  
			response.setContentType("application/vnd.ms-excel");  
			response.setHeader("Content-Disposition", "attachment;fileName="+fileName+".xls");  
			String sheetName = "设备培训方案表";
			CIPPageInfo page = new CIPPageInfo(1,10000);

			//获取订单，每次最多导出1万条记录
			List<Map<String, Object>> entities = dataService.exportEntities(page, conditions, CIPRuntime.getOperateSubject(), true);
			SXSSFWorkbook wb = ExcelSheetParser.createWorkBook(sheetName,
					EMS_report_trainMapper.getExcelTitle(), entities);
			
			int total = page.getTotal();
			int rows = page.getRows();
			if (total > rows) {
				int count = total / rows + 1;
				for (int i = 2; i <= count; i++) {
					page.setPage(i);
					entities = dataService.exportEntities(page, conditions, CIPRuntime.getOperateSubject(), false);
					ExcelSheetParser.appendWorkBook(wb, sheetName, EMS_report_trainMapper.getExcelTitle(), entities);
				}
			}
			os = response.getOutputStream();
			wb.write(os);
		}
		catch (Exception e) {
			throw e;
		}finally {
			try {
				if(os!=null){
					os.flush();
					os.close();
				}
			} catch (IOException e) {
				
			}				
		}
	}
}