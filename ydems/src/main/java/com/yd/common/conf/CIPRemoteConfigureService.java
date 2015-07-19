package com.yd.common.conf;

import java.util.ArrayList;
import java.util.List;

import com.yd.common.data.CIPParameter;
import com.yd.common.data.CIPResponseMsg;
import com.yd.common.exception.CIPRuntimeException;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.utils.HttpUtils;
import com.yd.common.utils.JSONUtils;

public class CIPRemoteConfigureService implements CIPConfigureService {

	public String confURL = null;
	public String sysType = null;

	@Override
	public void init(String parameter, String sysType) throws Exception {
		// 检查连接url是否有效
		confURL = parameter;
		this.sysType = sysType;
	}

	@Override
	public CIPConfigureData getConfigure(String sysId, String confId) {

		try {
			List<CIPParameter> params = new ArrayList<CIPParameter>(2);
			CIPParameter param = new CIPParameter();
			param.setKey("sys_id");
			param.setValue(sysId);
			params.add(param);
			param = new CIPParameter();
			param.setKey("sys_type");
			param.setValue(sysType);
			params.add(param);
			param = new CIPParameter();
			param.setKey("conf_id");
			param.setValue(confId);
			params.add(param);

			CIPResponseMsg msg = HttpUtils.post(confURL, params);
			if (msg.errorCode > 0) {
				throw new CIPRuntimeException(
						CIPErrorCode.ERROR_REMOTE_SERVER_RETURN_ERROR);
			}
			CIPConfigureData data = JSONUtils.convertJson2Object(
					msg.data.toString(), CIPConfigureData.class);

			return data;
		} catch (Exception e) {
			throw new CIPRuntimeException(
					CIPErrorCode.ERROR_HTTP_REQUEST_IS_NOT_AVAILABLE, e);
		}

	}

	@Override
	public List<CIPConfigureData> getConfigures(String sysId) {
		List<CIPParameter> params = new ArrayList<CIPParameter>(2);
		CIPParameter param = new CIPParameter();
		param.setKey("sys_id");
		param.setValue(sysId);
		params.add(param);
		param = new CIPParameter();
		param.setKey("sys_type");
		param.setValue(sysType);
		params.add(param);
		try {
			CIPResponseMsg msg = HttpUtils.post(confURL, params);
			if (msg.errorCode > 0) {
				throw new CIPRuntimeException(
						CIPErrorCode.ERROR_REMOTE_SERVER_RETURN_ERROR);
			}
			CIPConfigureData[] data = JSONUtils.convertJson2Object(
					msg.data.toString(), CIPConfigureData[].class);
			
			List<CIPConfigureData> datas = new ArrayList<CIPConfigureData>();
			for(int i=0;i<data.length;){
				datas.add(data[i++]);
			}
			return datas;
		} catch (Exception e) {
			throw new CIPRuntimeException(
					CIPErrorCode.ERROR_HTTP_REQUEST_IS_NOT_AVAILABLE, e);
		}
	}

}
