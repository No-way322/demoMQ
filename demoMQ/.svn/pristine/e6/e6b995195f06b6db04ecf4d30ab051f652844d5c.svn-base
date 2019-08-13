package com.qif.mainstate.util;

import java.io.IOException;
import java.util.Properties;

public class BaseStatic {
	private static Properties prop = new Properties();
	static {
		try {
			prop.load(BaseStatic.class.getResourceAsStream("/conf-base.properties"));//类加载器
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	//系统部署访问路径
	public static final String  baseUrl= prop.getProperty("base.call.url");	
	//系统部署的基础上下文路径
	public static final String  baseContext= prop.getProperty("base.call.context");
	//系统文件保存路径
	public static final String  saveUrl= prop.getProperty("base.save.url");
}
