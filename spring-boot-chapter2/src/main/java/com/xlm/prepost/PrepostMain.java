/**
 * 2017年9月19日
 */
package com.xlm.prepost;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author XIXI
 *
 */
public class PrepostMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PrepostConfig.class);
		BeanWayService beanWayService = ctx.getBean(BeanWayService.class);
		JSR250WayService jsr250WayService = ctx.getBean(JSR250WayService.class);
		ctx.close();
	}

}
