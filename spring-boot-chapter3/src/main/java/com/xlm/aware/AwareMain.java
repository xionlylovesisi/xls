/**
 * 2017年9月20日
 */
package com.xlm.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xlm.aware.service.AwareService;

/**
 * @author XIXI
 *
 */
public class AwareMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AwareConfig.class);
		AwareService awareService = ctx.getBean(AwareService.class);
		awareService.outputResult();
		ctx.close();
		
	}
}
