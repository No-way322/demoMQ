package com.qif.mainstate.common.interceptor;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.qif.mainstate.util.DealString;


public class CommonInterceptorAdapter extends HandlerInterceptorAdapter{

	final static Logger log = LoggerFactory.getLogger(CommonInterceptorAdapter.class);
	private static DateFormat sdf = new SimpleDateFormat("yyyyMMdd-HH:mm:ss:SSS");
	private NamedThreadLocal<Date> startTimeThreadLocal = new NamedThreadLocal<Date>(
			"StopWatch-StartTime");
	/**
	 * 最后执行，可用于释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex)throws Exception {
		Date endTime = new Date();// 2、结束时间
		Date beginTime = startTimeThreadLocal.get();// 得到线程绑定的局部变量（开始时间）
		long consumeTime = endTime.getTime() - beginTime.getTime();// 3、消耗的时间
		log.info("H5请求:" + request.getRequestURI() + "，请求处理开始时间："
				+ sdf.format(beginTime) + "，请求处理结束时间：" + sdf.format(endTime)
				+ "，耗时：" + consumeTime + "毫秒");
	}

	/**
	 * 显示视图前执行
	 */
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		startTimeThreadLocal.set(new Date());// 线程绑定变量（该数据只有当前请求的线程可见）
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * Controller之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		//添加跨域CORS
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type,token");
		response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
		String url = request.getRequestURI();
		log.debug(url);
		String style = DealString.toString(request.getParameter("style"));
		request.setAttribute("style", !"".equals(style) ? style :"darkgreen");
		log.info("当前主题为"+style);
		return super.preHandle(request, response, handler);
	}
}
