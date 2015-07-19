package com.yd.ems.mainten.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
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
import com.yd.ems.mainten.service.EMS_mainten_scrap_fileService;
import com.yd.ems.mainten.service.EMS_mainten_scrap_planService;
import com.yd.ems.mainten.data.vo.EMS_mainten_scrap_fileVO;
import com.yd.ems.mainten.data.vo.EMS_mainten_scrap_planVO;
import com.yd.ems.mainten.data.mapper.EMS_mainten_scrap_planMapper;
import com.yd.ems.mainten.data.EMS_mainten_scrap_planData;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
/**
 * <p>控制层实现类</p>
 * <p>Class: EMS_mainten_scrap_planController</p>
 *
 * @since 2015-05-29 02:42:13
 */
@RestController
@RequestMapping(value = "/actions/mainten_scrap_plan")
public class EMS_mainten_scrap_planController {
	
	@Autowired
	private EMS_mainten_scrap_planService dataService  = null;
	@Autowired
	private EMS_mainten_scrap_fileService filedataService  = null;
	private static final String C_ACTION_ADD_DATA = "ems_mainten_scrap_plan_addData";
	/**
	* 新增设备报废计划表
	*/
	@RequestMapping(value="/addData")
	public CIPResponseMsg addData(@RequestBody EMS_mainten_scrap_planVO vo) {
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

	private static final String C_ACTION_GET_DATA = "ems_mainten_scrap_plan_getData";
	/**
	* 查看设备报废计划表
	*/
	@RequestMapping(value = "/getData")
	public CIPResponseMsg getData(@RequestBody EMS_mainten_scrap_planVO vo) {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			Object[] keys = vo.getKeys();
			EMS_mainten_scrap_planVO vo0 = dataService.getData(keys);
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
	/**
	* 传设备报废文件
	*/
	private static final String C_ACTION_UPLOAD_DATA = "ems_mainten_scrap_plan_uploadFile";
	//@RequestMapping(value = "/uploadFile")
	@RequestMapping(value = "/uploadFile")
	public CIPResponseMsg uploadFile(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException{
		CIPResponseMsg msg = new CIPResponseMsg();
		EMS_mainten_scrap_fileVO fileVO = new EMS_mainten_scrap_fileVO();
		String date = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		//String scrapNo = String.valueOf(vo.getScrap_no());
		  //1、创建一个DiskFileItemFactory工厂
       // DiskFileItemFactory factory = new DiskFileItemFactory();
        //2、创建一个文件上传解析器
       // ServletFileUpload upload = new ServletFileUpload(factory);
         //解决上传文件名的中文乱码
       // upload.setHeaderEncoding("UTF-8"); 
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		 String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"  
                 + file.getOriginalFilename();  
        String scrapNo = request.getParameter("id_scrap_no");
        fileVO.setScrap_no(Long.parseLong(scrapNo));
        File file1 = new File(filePath);
        if (!file1.exists()) {
			file1.mkdir();
		}
        String fileName = null;
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			// 上传文件名
			// System.out.println("key: " + entity.getKey());
			MultipartFile mf = entity.getValue();
			fileName = mf.getOriginalFilename();
			File uploadFile = new File(filePath + fileName);
			FileCopyUtils.copy(mf.getBytes(), uploadFile);
		}
		//request.setAttribute("files", loadFiles(request));
		//return new ModelAndView("success");
		return msg;
	}
    /*public CIPResponseMsg uploadFile(@RequestBody EMS_mainten_scrap_planVO vo,HttpServletRequest request) throws Exception {
		CIPResponseMsg msg = new CIPResponseMsg();
		String scrapNo = String.valueOf(vo.getScrap_no());
		String date = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
	     //文件上传个数
	         String data = "";
			  //int count = 0;
			  //文件上传地址
			  String filePath = request.getServletContext().getRealPath("/")+"UploadFile";
			  //如果文件夹不存在 则创建这个文件夹
			  File file = new File(filePath);
			  if(!file.exists())
			  {
			   file.mkdir();
			  }
			  //消息提示
              String message = "";
              //使用Apache文件上传组件处理文件上传步骤：
              //1、创建一个DiskFileItemFactory工厂
              DiskFileItemFactory factory = new DiskFileItemFactory();
              //2、创建一个文件上传解析器
              ServletFileUpload upload = new ServletFileUpload(factory);
               //解决上传文件名的中文乱码
              upload.setHeaderEncoding("UTF-8"); 
              //3、判断提交上来的数据是否是上传表单的数据
              if(!ServletFileUpload.isMultipartContent(request)){
                  //按照传统方式获取数据
                  return msg;
              }
         
          for(FileItem item : list){
              //如果fileitem中封装的是普通输入项的数据
              if(item.isFormField()){
                  String name = item.getFieldName();
                  //解决普通输入项的数据的中文乱码问题
                  String value = item.getString("UTF-8");
                  //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                  System.out.println(name + "=" + value);
              }else{
                 //如果fileitem中封装的是上传文件
                  //得到上传的文件名称，
                  String filename = item.getName();
                  System.out.println(filename);
                  if(filename==null || filename.trim().equals("")){
                      continue;
                  }
                  //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                  //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                  String filename1 = filename.substring(filename.lastIndexOf("\\")+1);
                  int index = filename1.lastIndexOf(".");
                  String lastName = filename1.substring(index,filename.length());//文件后缀
                  System.out.println(lastName);
                  //新产生的文件名称是：报销流水号+|+当前日期+后缀名
                  String newname =scrapNo+"|"+date + lastName;//新文件名
                  //获取item中的上传文件的输入流
                  InputStream in = item.getInputStream();
                  //创建一个文件输出流
                  FileOutputStream out = new FileOutputStream(filePath + "\\" + newname);
                  //创建一个缓冲区
                  byte buffer[] = new byte[1024];
                  //判断输入流中的数据是否已经读完的标识
                  int len = 0;
                  //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                  while((len=in.read(buffer))>0){
                      //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                      out.write(buffer, 0, len);
                  }
                 // filedataService.addData(vo,CIPRuntime.getOperateSubject());
                  //关闭输入流
                  in.close();
                  //关闭输出流
                  out.close();
                  //删除处理文件上传时生成的临时文件
                  item.delete();
                  data = "文件上传成功！";
              }
         }
		 msg.errorCode = CIPErrorCode.CALL_SUCCESS.code;
		 msg.msg = CIPErrorCode.CALL_SUCCESS.name;
		return msg;
	}*/
	/**
	* 下载文件
	*/
	/*private static final String C_ACTION_DOWNLOAD_DATA = "ems_mainten_scrap_plan_downloadFile";
	@RequestMapping(value = "/downloadFile")
	public CIPResponseMsg downloadFile(@RequestBody EMS_mainten_scrap_planVO vo) {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			Object[] keys = vo.getKeys();
			EMS_mainten_scrap_planVO vo0 = dataService.getData(keys);
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
	}*/
	private static final String C_ACTION_DELETE_DATA = "ems_mainten_scrap_plan_deleteData";
	/**
	* 删除设备报废计划表
	*/
	@RequestMapping(value = "/deleteData")
	public CIPResponseMsg deleteData(@RequestBody EMS_mainten_scrap_planVO vo) {
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
	
	private static final String C_ACTION_UPDATE_DATA = "ems_mainten_scrap_plan_updateData";
	/**
	* 更新设备报废计划表
	*/
	@RequestMapping(value = "/updateData")
	public CIPResponseMsg updateData(@RequestBody EMS_mainten_scrap_planVO vo) {
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
	private static final String C_ACTION_UPDATE_DATA2 = "ems_mainten_scrap_plan_updateScrapData";
	/**
	* 审核设备报废计划表
	*/
	@RequestMapping(value = "/updateScrapData")
	public CIPResponseMsg updateScrapData(@RequestBody EMS_mainten_scrap_planVO vo) {
		CIPResponseMsg msg = new CIPResponseMsg();
		try {
			dataService.updateScrapData(vo,CIPRuntime.getOperateSubject());
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
	
	private static final String C_ACTION_SEARCH_DATA = "ems_mainten_scrap_plan_searchData";
	
	/**
	* 查询设备报废计划表
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
			
			List<EMS_mainten_scrap_planData> vos = dataService.searchData(page,conditions);
			
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
	

	
	private static final String C_ACTION_EXPORT_EXCEL = "ems_mainten_scrap_plan_exportEntities";
	
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
			String as = "导出设备报废计划表_"+DateUtils.getDate(new Date());

			String fileName = new String(as.getBytes("GB2312"), "ISO_8859_1");
			response.setCharacterEncoding("utf-8");  
			response.setContentType("application/vnd.ms-excel");  
			response.setHeader("Content-Disposition", "attachment;fileName="+fileName+".xls");  
			String sheetName = "设备报废计划表";
			CIPPageInfo page = new CIPPageInfo(1,10000);

			//获取订单，每次最多导出1万条记录
			List<Map<String, Object>> entities = dataService.exportEntities(page, conditions, CIPRuntime.getOperateSubject(), true);
			SXSSFWorkbook wb = ExcelSheetParser.createWorkBook(sheetName,
					EMS_mainten_scrap_planMapper.getExcelTitle(), entities);
			
			int total = page.getTotal();
			int rows = page.getRows();
			if (total > rows) {
				int count = total / rows + 1;
				for (int i = 2; i <= count; i++) {
					page.setPage(i);
					entities = dataService.exportEntities(page, conditions, CIPRuntime.getOperateSubject(), false);
					ExcelSheetParser.appendWorkBook(wb, sheetName, EMS_mainten_scrap_planMapper.getExcelTitle(), entities);
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