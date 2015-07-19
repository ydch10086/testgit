package com.yd.common.cipher;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;


public class CIPBase64Filter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		int length = req.getContentLength();
		if (length > 0) {
			CIPRequestWrapper bufferedRequest = new CIPRequestWrapper(req);

			InputStream is = req.getInputStream();
			byte[] content = new byte[length];

			int pad = 0;
			while (pad < length) {
				pad += is.read(content, pad, length);
			}
			
			String decodeStr = Base64.encodeBase64String(content);
			bufferedRequest.setDecodeData(decodeStr.getBytes());
			request = bufferedRequest;
		}
		
		CIPResponseWrapper res = new CIPResponseWrapper((HttpServletResponse) response);
		chain.doFilter(request, res);
		
		byte[] dataReturns = res.getOutputData();
		if(dataReturns!=null){
			byte[] encodeData = Base64.encodeBase64(dataReturns);
			response.getOutputStream().write(encodeData);
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
