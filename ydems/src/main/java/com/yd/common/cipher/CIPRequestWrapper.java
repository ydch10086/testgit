package com.yd.common.cipher;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CIPRequestWrapper extends HttpServletRequestWrapper {

	ByteArrayInputStream bais;

	BufferedServletInputStream bsis;

	byte[] buffer;

	public CIPRequestWrapper(HttpServletRequest req) throws IOException {
		super(req);
	}
	
	public void setDecodeData(byte[] data){
		buffer = data;
	}
	
	public ServletInputStream getInputStream() {
        try {
            bais = new ByteArrayInputStream(buffer);
            bsis = new BufferedServletInputStream(bais);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return bsis;
    }

}

class BufferedServletInputStream extends ServletInputStream {

    ByteArrayInputStream bais;

    public BufferedServletInputStream(ByteArrayInputStream bais) {
        this.bais = bais;
    }

    public int available() {
        return bais.available();
    }

    public int read() {
        return bais.read();
    }

    public int read(byte[] buf, int off, int len) {
        return bais.read(buf, off, len);
    }

}

