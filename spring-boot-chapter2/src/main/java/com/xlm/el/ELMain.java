/**
 * 2017年9月19日
 */
package com.xlm.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author XIXI
 *
 */
public class ELMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ELConfig.class);
		ELConfig elConfig = ctx.getBean(ELConfig.class);
		elConfig.outputResource();
		ctx.close();
	}

}
