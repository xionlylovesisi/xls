/**
 * 2017年9月19日
 */
package com.xlm.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xlm.scope.service.DemoPrototypeService;
import com.xlm.scope.service.DemoSingletonService;

/**
 * @author XIXI
 *
 */
public class ScopeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ScopeConfig.class);
		DemoPrototypeService demoPrototypeService1 = ctx.getBean(DemoPrototypeService.class);
		DemoPrototypeService demoPrototypeService2 = ctx.getBean(DemoPrototypeService.class);
		
		DemoSingletonService demoSingletonService1 = ctx.getBean(DemoSingletonService.class);
		DemoSingletonService demoSingletonService2 = ctx.getBean(DemoSingletonService.class);
		
		System.out.println("demoPrototypeService1 与 demoPrototypeService2是否相等:"+demoPrototypeService1.equals(demoPrototypeService2));
		System.out.println("demoSingletonService1 与 demoSingletonService2是否相等:"+demoSingletonService1.equals(demoSingletonService2));
	}

}
