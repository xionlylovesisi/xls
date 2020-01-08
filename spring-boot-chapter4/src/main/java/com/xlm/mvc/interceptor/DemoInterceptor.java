/**
 * 2017年10月19日
 */
package com.xlm.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author XIXI
 *
 */
public class DemoInterceptor implements HandlerInterceptor {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(this.getClass().getName()+"--->[preHandle]:**[INFO]**[preHandle execute start]!");
		request.setAttribute("start", System.currentTimeMillis());
		System.out.println(this.getClass().getName()+"--->[preHandle]:**[INFO]**[start time:"+(request.getAttribute("start"))+"]!");
		System.out.println(this.getClass().getName()+"--->[preHandle]:**[INFO]**[preHandle execute end]!");
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(this.getClass().getName()+"--->[postHandle]:**[INFO]**[postHandle execute start]!");
		Long start = (Long) request.getAttribute("start");
		Long useTime = System.currentTimeMillis()-start;
		System.out.println(this.getClass().getName()+"--->[postHandle]:**[INFO]**[current request use time:"+(useTime)+"]!");
		request.setAttribute("handlingTime", useTime);
		System.out.println(this.getClass().getName()+"--->[postHandle]:**[INFO]**[postHandle execute end]!");
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println(this.getClass().getName()+"--->[agterCompletion]:**[INFO]**[afterCompletion execute start]!");
		System.out.println(this.getClass().getName()+"--->[afterCompletion]:**[INFO]**[start time:"+(request.getAttribute("start"))+",handlingTime time:"+request.getAttribute("handlingTime")+"]!");
		System.out.println(this.getClass().getName()+"--->[afterCompletion]:**[INFO]**[afterCompletion execute end]!");
	}

}
