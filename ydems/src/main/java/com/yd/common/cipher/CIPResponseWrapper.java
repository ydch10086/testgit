package com.yd.common.cipher;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CIPResponseWrapper extends HttpServletResponseWrapper {
	
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	BufferedServletOutputStream bsos =  new BufferedServletOutputStream(baos);
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(baos));
	public CIPResponseWrapper(HttpServletResponse response) {
		super(response);
	}
	
	public ServletOutputStream getOutputStream() {
		return bsos;
	}
	
	public PrintWriter getPrintWriter(){
		return pw;
	}
	
	public byte[] getOutputData(){
		if(baos == null)
			return null;
		
		return baos.toByteArray();
	}
}

class BufferedServletOutputStream extends ServletOutputStream {

	ByteArrayOutputStream baos;

	public BufferedServletOutputStream(ByteArrayOutputStream baos) {
		this.baos = baos;
	}

	public void write(int arg0) throws IOException {
		baos.write(arg0);
	}

	@Override
	public void flush() throws IOException {
		baos.flush();
	}

	@Override
	public void write(byte[] buf, int off, int len) {
		baos.write(buf, off, len);
	}

}