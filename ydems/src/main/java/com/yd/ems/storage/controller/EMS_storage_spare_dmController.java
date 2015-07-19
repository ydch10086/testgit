package com.yd.ems.storage.controller;
import java.io.IOException;
import java.io.OutputStream;

import java.util.HashMap;
import java.util.List;
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
import com.yd.ems.code.data.vo.EMS_code_spare_dmVO;
import com.yd.ems.code.data.vo.EMS_store_spare_dmVO;
import com.yd.ems.storage.data.EMS_storage_spare_dmData;
import com.yd.ems.storage.data.mapper.EMS_storage_spare_dmMapper;
import com.yd.ems.storage.data.vo.EMS_storage_inout_dmVO;
import com.yd.ems.storage.data.vo.EMS_storage_inrecord_dmVO;
import com.yd.ems.storage.data.vo.EMS_storage_outrecord_dmVO;
import com.yd.ems.storage.data.vo.EMS_storage_spare_dmVO;
import com.yd.ems.storage.service.EMS_storage_inout_dmService;
import com.yd.ems.storage.service.EMS_storage_inrecord_dmService;
import com.yd.ems.storage.service.EMS_storage_outrecord_dmService;
import com.yd.ems.storage.service.EMS_storage_spare_dmService;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>控制层实现类</p>
 * <p>Class: EMS_storage_spare_dmController</p>
 *
 * @since 2015-05-29 02:42:12
 */
@RestController
@RequestMapping(value = "/actions/storage_spare_dm")
public class EMS_storage_spare_dmController {
	
	@Autowired
	private EMS_storage_spare_dmService dataService  = null;
	@Autowired
	private EMS_storage_inout_dmService inoutdataService  = null;
	@Autowired
	private EMS_storage_outrecord_dmService outRecordDataService  = null;
	@Autowired
	private EMS_storage_inrecord_dmService inRecordDataService  = null;
	private static final String C_ACTION_ADD_DATA = "ems_storage_spare_dm_addData";
	/**
	* 新增出入库记录
	*/
	@RequestMapping(value="/addData")
	public CIPResponseMsg addData(@RequestBody EMS_storage_spare_dmVO vo) {
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
	
	
	private static final String C_ACTION_GET_DATA = "ems_storage_spare_dm_getData";
	/**
	* 查看出入库记录
	*/
	@RequestMapping(value = "/getData")
	public CIPResponseMsg getData(@RequestBody EMS_storage_spare_dmVO vo) {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			Object[] keys = vo.getKeys();
			EMS_storage_spare_dmVO vo0 = dataService.getData(keys);
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
	private static final String C_ACTION_UPDATESTORE_DATA = "ems_storage_spare_dm_updateStoreData";
	/**
	* 操作新增入库按钮时会执行新增入库操作
	*/
	@RequestMapping(value = "/updateStoreData")
	public CIPResponseMsg updateStoreData(@RequestBody EMS_storage_spare_dmVO vo) {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			/*会更新备件备件库存数据表em_storage_spare_dm*/
			dataService.updateData(vo, CIPRuntime.getOperateSubject());
			EMS_storage_inout_dmVO inoutVO = convertInStoreVO(vo);
			EMS_storage_inrecord_dmVO inVO = convertInRecordDataVO(vo);
			/*将入库记录存放在出入库记录表中：em_storage_inout_dm，该表中主要会记录入库时间及其如今人信息*/
			inoutdataService.addData(inoutVO,CIPRuntime.getOperateSubject());
			/*将入库数据存放到入库记录表em_storage_inrecord_dm中*/
			inRecordDataService.addData(inVO, CIPRuntime.getOperateSubject());
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
	private static final String C_ACTION_DELETE_DATA = "ems_storage_spare_dm_deleteData";
	/**
	* 删除出入库记录
	*/
	@RequestMapping(value = "/deleteData")
	public CIPResponseMsg deleteData(@RequestBody EMS_storage_spare_dmVO vo) {
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
	
	private static final String C_ACTION_UPDATE_DATA = "ems_storage_spare_dm_updateData";
	/**
	* 提交入库数据时会执行下面方法
	*/
	@RequestMapping(value = "/updateData")
	public CIPResponseMsg updateData(@RequestBody EMS_storage_spare_dmVO vo) {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			/*会更新备件备件库存数据表em_storage_spare_dm*/
			dataService.updateData(vo, CIPRuntime.getOperateSubject());
			EMS_storage_inout_dmVO inoutVO = convertInStoreVO(vo);
			EMS_storage_inrecord_dmVO inVO = convertInRecordDataVO(vo);
			/*将入库记录存放在出入库记录表中：em_storage_inout_dm，该表中主要会记录入库时间及其如今人信息*/
			inoutdataService.addData(inoutVO,CIPRuntime.getOperateSubject());
			/*将入库数据存放到入库记录表em_storage_inrecord_dm中*/
			inRecordDataService.addData(inVO, CIPRuntime.getOperateSubject());
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
	/*入库VO转化*/
	public EMS_storage_inout_dmVO convertInStoreVO(EMS_storage_spare_dmVO vo)
	{
		EMS_storage_inout_dmVO storeVO = new EMS_storage_inout_dmVO();
		storeVO.setSpare_store_id(vo.getSpare_store_id());
		storeVO.setSpare_name(vo.getSpare_name());
		storeVO.setSpare_sub_type(vo.getSpare_sub_type());
		storeVO.setSpare_type(vo.getSpare_type());
		storeVO.setSup_code(vo.getSup_code());
		storeVO.setBrand(vo.getBrand());
		storeVO.setOrg_id(vo.getOrg_id());
		storeVO.setSpare_in_store_num(vo.getSpare_in_store_num());//入库数量
		storeVO.setStore_time(vo.getStore_time()==""?"0000-00-00":vo.getStore_time());
		storeVO.setSpare_out_store_num(vo.getSpare_out_store_num());
		storeVO.setUnit_code(vo.getUnit_code());
		storeVO.setIn_store_type(vo.getIn_store_type());
		storeVO.setStore_person_id(vo.getStore_person_id());
		storeVO.setStore_person_name(vo.getStore_person_name());
		return storeVO;
	}
	/*出库VO转化,该VO对应出入库总记录表*/
	public EMS_storage_inout_dmVO convertOutStoreVO(EMS_storage_spare_dmVO vo)
	{
		EMS_storage_inout_dmVO storeVO = new EMS_storage_inout_dmVO();
		storeVO.setSpare_store_id(vo.getSpare_store_id());
		storeVO.setSpare_name(vo.getSpare_name());
		storeVO.setSpare_sub_type(vo.getSpare_sub_type());
		storeVO.setSpare_type(vo.getSpare_type());
		storeVO.setSup_code(vo.getSup_code());
		storeVO.setBrand(vo.getBrand());
		storeVO.setOrg_id(vo.getOrg_id());
		storeVO.setSpare_in_store_num(vo.getSpare_in_store_num());//入库数量
		storeVO.setStore_time(vo.getStore_time());
		storeVO.setSpare_out_store_num(vo.getSpare_out_store_num());
		storeVO.setOut_store_time(vo.getOut_store_time()==""?"0000-00-00":vo.getOut_store_time());
		storeVO.setUnit_code(vo.getUnit_code());
		storeVO.setStore_person_id(vo.getStore_person_id());
		storeVO.setStore_person_name(vo.getStore_person_name());
		storeVO.setIn_store_type(vo.getIn_store_type());
		return storeVO;
	}
	/*出库VO转化，该VO对应出库记录表*/
	public EMS_storage_outrecord_dmVO convertOutStoreDataVO(EMS_storage_spare_dmVO vo)
	{
		EMS_storage_outrecord_dmVO storeVO = new EMS_storage_outrecord_dmVO();
		storeVO.setOut_store_person_id(vo.getStore_person_id());//出库人工号
		storeVO.setOut_store_person_name(vo.getStore_person_name());//出库人姓名
		storeVO.setUser_taken_id(vo.getUser_taken_id());//领用人工号
		storeVO.setUser_taken_name(vo.getUser_taken_name());//领用人名字
		storeVO.setUser_taken_type(vo.getUser_taken_type());//领用类型
		storeVO.setUser_taken_time(vo.getUser_taken_time()==""?"0000-00-00":vo.getOut_store_time());//领用时间
		storeVO.setSpare_store_id(vo.getSpare_store_id());
		storeVO.setSpare_name(vo.getSpare_name());
		storeVO.setSpare_sub_type(vo.getSpare_sub_type());
		storeVO.setSpare_type(vo.getSpare_type());
		storeVO.setSup_code(vo.getSup_code());
		storeVO.setBrand(vo.getBrand());
		storeVO.setOrg_id(vo.getOrg_id());
		storeVO.setSpare_out_store_num(vo.getSpare_out_store_num());
		storeVO.setOut_store_time(vo.getOut_store_time()==""?"0000-00-00":vo.getOut_store_time());
		storeVO.setUnit_code(vo.getUnit_code());
		return storeVO;
	}
	/*入库VO转化，该VO对应入库记录表*/
	public EMS_storage_inrecord_dmVO convertInRecordDataVO(EMS_storage_spare_dmVO vo)
	{
		EMS_storage_inrecord_dmVO storeVO = new EMS_storage_inrecord_dmVO();
		storeVO.setSpare_store_id(vo.getSpare_store_id());
		storeVO.setStore_person_id(vo.getStore_person_id());
		storeVO.setStore_person_name(vo.getStore_person_name());
		storeVO.setIn_store_type(String.valueOf(vo.getIn_store_type()));
		storeVO.setIn_store_time(vo.getStore_time()==""?"0000-00-00":vo.getStore_time());
		storeVO.setOrg_id(vo.getOrg_id());
		storeVO.setSpare_name(vo.getSpare_name());
		storeVO.setSpare_sub_type(vo.getSpare_sub_type());
		storeVO.setSpare_type(vo.getSpare_type());
		storeVO.setSup_code(vo.getSup_code());
		storeVO.setBrand(vo.getBrand());
		storeVO.setSpare_in_store_num(vo.getSpare_in_store_num());
		storeVO.setUnit_code(vo.getUnit_code());		
		return storeVO;
	}
	private static final String C_ACTION_UPDATE2_DATA = "ems_storage_spare_dm_updateOutStoreData";
	/**
	* 出库时会执行操作
	*/
	@RequestMapping(value = "/updateOutStoreData")
	public CIPResponseMsg updateOutStoreData(@RequestBody EMS_storage_spare_dmVO vo) {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			/*跟新备品备件库存表*/
			dataService.updateOutStoreData(vo, CIPRuntime.getOperateSubject());
			EMS_storage_inout_dmVO inoutVO = convertOutStoreVO(vo);
			EMS_storage_outrecord_dmVO outVO = convertOutStoreDataVO(vo);
			/*将记录添加到出入库记录表中*/
			inoutdataService.addOutStoreData(inoutVO,CIPRuntime.getOperateSubject());
			/*将记录添加到出库记录表中*/
			outRecordDataService.addData(outVO,CIPRuntime.getOperateSubject());
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
	
	private static final String C_ACTION_SEARCH_DATA = "ems_storage_spare_dm_searchData";
	
	/**
	* 查询出入库记录
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
			
			List<EMS_storage_spare_dmData> vos = dataService.searchData(page,conditions);
			
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
	

	
	private static final String C_ACTION_EXPORT_EXCEL = "ems_storage_spare_dm_exportEntities";
	
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
			String as = "导出出入库记录_"+DateUtils.getDate(new Date());

			String fileName = new String(as.getBytes("GB2312"), "ISO_8859_1");
			response.setCharacterEncoding("utf-8");  
			response.setContentType("application/vnd.ms-excel");  
			response.setHeader("Content-Disposition", "attachment;fileName="+fileName+".xls");  
			String sheetName = "出入库记录";
			CIPPageInfo page = new CIPPageInfo(1,10000);

			//获取订单，每次最多导出1万条记录
			List<Map<String, Object>> entities = dataService.exportEntities(page, conditions, CIPRuntime.getOperateSubject(), true);
			SXSSFWorkbook wb = ExcelSheetParser.createWorkBook(sheetName,
					EMS_storage_spare_dmMapper.getExcelTitle(), entities);
			
			int total = page.getTotal();
			int rows = page.getRows();
			if (total > rows) {
				int count = total / rows + 1;
				for (int i = 2; i <= count; i++) {
					page.setPage(i);
					entities = dataService.exportEntities(page, conditions, CIPRuntime.getOperateSubject(), false);
					ExcelSheetParser.appendWorkBook(wb, sheetName, EMS_storage_spare_dmMapper.getExcelTitle(), entities);
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