package com.yd.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化工具类
 * @author Rong.zhu
 *
 */
public class SerializeUtils {
	
	/**
	 * 序列化JAVA对象
	 * @param obj
	 * @return
	 */
	public static byte[] serialize(Object obj) throws Exception{
		if(obj == null) return null;
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		byte[] bytes = null;
		baos = new ByteArrayOutputStream();
		oos = new ObjectOutputStream(baos);
		oos.writeObject(obj);
		bytes = baos.toByteArray();
	
		return bytes;
	}
	
	/**
	 * 反序列化
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes) throws Exception {
		if(bytes == null) return null;
		ByteArrayInputStream bais = null;
		Object obj = null;
		bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bais);
		obj = ois.readObject();
		
		return obj;
	}
	
}
