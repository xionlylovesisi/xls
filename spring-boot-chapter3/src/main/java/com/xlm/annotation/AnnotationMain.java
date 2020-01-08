/**
 * 2017年9月29日
 */
package com.xlm.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xlm.annotation.service.DemoService;

/**
 * @author XIXI
 *
 */
public class AnnotationMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		DemoService demoService = ctx.getBean(DemoService.class);
		demoService.outputResult();
		ctx.close();
	}

}
