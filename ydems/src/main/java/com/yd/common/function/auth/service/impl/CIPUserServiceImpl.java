package com.yd.common.function.auth.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yd.common.auth.CIPAuthManager;
import com.yd.common.auth.CIPResource;
import com.yd.common.auth.CIPUserProfileData;
import com.yd.common.cache.CIPCacheManager;
import com.yd.common.cache.CIPCacheService;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.exception.CIPRuntimeException;
import com.yd.common.function.admin.dao.CIP_admin_userDao;
import com.yd.common.function.admin.dao.CIP_admin_user_2_rolesDao;
import com.yd.common.function.admin.data.CIP_admin_user_2_rolesData;
import com.yd.common.function.admin.data.po.CIP_admin_rolesPO;
import com.yd.common.function.admin.data.po.CIP_admin_userPO;
import com.yd.common.function.admin.data.po.CIP_admin_user_2_rolesPO;
import com.yd.common.function.auth.data.CIPLoginData;
import com.yd.common.function.auth.data.CIPAuthResult;
import com.yd.common.function.auth.data.CIPRole2ResourceData;
import com.yd.common.function.auth.service.CIPUserService;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.runtime.CIPRuntime;
import com.yd.common.runtime.CIPRuntimeConfigure;
import com.yd.common.runtime.CIPRuntimeConstants;

@Service
public class CIPUserServiceImpl implements CIPUserService {

	private static final int USER_LOCK = 1;
	
	private String sys_id = CIPRuntimeConfigure.cip_system_id;
	
	@Autowired
	private CIP_admin_userDao userDao = null;
	@Autowired
	private CIP_admin_user_2_rolesDao user2roleDao = null;

	@Override
	public CIPAuthResult loginUser(CIPLoginData loginData) {
		if(loginData.user_id==null || loginData.user_id.trim().equals("")){
			return CIPAuthResult.LOGIN_FAIL;
		}
		
		if(loginData.local_pass_code==null||loginData.local_pass_code.equals("")){
			return CIPAuthResult.PASS_CODE_ERROR;
		}
		
		if(loginData.pass_code==null||loginData.pass_code.equals("")){
			return CIPAuthResult.PASS_CODE_ERROR;
		}
		
		if(!loginData.pass_code.equals(loginData.local_pass_code)){
			return CIPAuthResult.PASS_CODE_ERROR;
		}
		
		if(CIPRuntimeConfigure.cip_user_xremote){
			//远程登录
			boolean xValid = CIPRuntime.authManager.validateUser(loginData.user_id, loginData.user_pwd);
			if(!xValid)
				return CIPAuthResult.LOGIN_FAIL;
		}
		else {
			//本地登录
			CIP_admin_userPO userData = userDao.getSingle(loginData.user_id);
			if(userData == null){
				return CIPAuthResult.LOGIN_FAIL;
			}
			if(userData.getPwd_init_flag()>0){
				return CIPAuthResult.PASSWORD_RESET;
			}
			else if(userData.getUser_status() == USER_LOCK){
				return CIPAuthResult.USER_LOCKED;
			}
			else if(!userData.getUser_pwd().equals(loginData.user_pwd)){
				return CIPAuthResult.PASSWORD_ERROR;
			}
			
		}
		
		//TODO 用户登录日志
		
		return CIPAuthResult.LOGIN_SUCCESS;

	}

	@Override
	public CIPAuthResult logoutUser(CIPLoginData loginData) {
		// TODO 用户登出日志
		CIPRuntime.authManager.logoutUserAuth(loginData.user_id);
		return CIPAuthResult.LOGOUT_SUCCESS;
	}

	@Override
	public CIPAuthResult resetPassword(String user_id, String oldP, String newP) {
		if(user_id==null || user_id.trim().equals("")){
			return CIPAuthResult.USER_IS_NULL;
		}
		if(oldP==null||newP==null||oldP.trim().equals("")||newP.trim().equals("")||oldP.equals(newP)){
			return CIPAuthResult.PASSWORD_IS_NULL;
		}
		if(CIPRuntimeConfigure.cip_user_xremote){
			//远程修改密码,不支持！！！
			throw new CIPRuntimeException(CIPErrorCode.ERROR_FUNCTION_NOT_SUPPORT);
		}
		else {
			CIP_admin_userPO userData = userDao.getSingle(user_id);
			if(!userData.getUser_pwd().equals(oldP)){
				return CIPAuthResult.PASSWORD_ERROR;
			}
			else {
				String pwd1 = userData.getUser_his1_pwd();
				String pwd2 = userData.getUser_his2_pwd();
				String pwd3 = userData.getUser_his3_pwd();
				if(newP.equals(pwd1)||newP.equals(pwd2)
						||newP.equals(pwd3)){
					return CIPAuthResult.PASSWORD_IS_USED;
				}
				else {
					pwd3 = pwd2;
					pwd2 = pwd1;
					pwd1 = oldP;
				}
				Map<String, Object> params = new HashMap<String, Object>(7);
				params.put("user_pwd", newP);
				params.put("user_pwd_init", 0);
				params.put("user_pwd_his1", pwd1);
				params.put("user_pwd_his2", pwd2);
				params.put("user_pwd_his3", pwd3);
				params.put("pwd_set_time", System.currentTimeMillis());
				params.put("pwd_reset_flag", 0);

				userDao.updateKV(params , user_id);
			}
		}
	
		return CIPAuthResult.SUCCESS;
	}

	@Override
	public CIPUserProfileData getUserProfile(String userId) {
		
		CIPUserProfileData userProfile = null;
		userProfile = CIPRuntime.authManager.getUserProfile(userId);
		if(userProfile == null){
			CIP_admin_userPO userData = null;
			
			userData = userDao.getSingle(userId);
			userProfile = new CIPUserProfileData();
			userProfile.user_id = userData.getUser_id();
			userProfile.start_date = userData.getStart_date().toString();
			userProfile.end_date = userData.getEnd_date().toString();
			userProfile.pwd_reset_flag = userData.getPwd_reset_flag();
			userProfile.persion_id = userData.getPerson_id();
			userProfile.org_id = userData.getOrg_id();
			userProfile.user_name = userData.getUser_name();
			
			CIPRuntime.authManager.setUserProfile(userProfile);
		}
		
		return userProfile;
	}

	@Override
	public String getPassCode(OutputStream os) throws IOException {
		// 在内存中创建图象
		int width = 60, height = 20;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// 获取图形上下文
		Graphics g = image.getGraphics();

		// 生成随机类
		Random random = new Random();

		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		// 画边框
		// g.setColor(new Color());
		// g.drawRect(0,0,width-1,height-1);

		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// 取随机产生的认证码(4位数字)
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(rand, 13 * i + 6, 16);
		}

		// 图象生效
		g.dispose();
		// 输出图象到页面
		ImageIO.write(image, "JPEG", os);

		return sRand;
	}

	private Color getRandColor(int fc, int bc) {// 给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	@Override
	public List<String> getRoles(String userId) {
		if(CIPRuntimeConfigure.cip_user_xremote){
			return CIPRuntime.authManager.getUserRole(userId);
		}
		else {
			CIPPageInfo page = new CIPPageInfo(1,100);
			CIPReqCondition[] conditions = new CIPReqCondition[1];
			conditions[0] = new CIPReqCondition();
			conditions[0].setFieldName("user_id");
			conditions[0].setLowValue(userId);
			List<CIP_admin_user_2_rolesData> roles = user2roleDao.searchData(page, conditions);
			if(roles==null)
				return null;
			List<String> roleIds = new ArrayList<String>();
			for(CIP_admin_user_2_rolesData role : roles){
				roleIds.add(role.getRole_id());
			}
			return roleIds;
		}
		
	}

}
