/**
 * 2017年9月19日
 */
package com.xlm.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author XIXI
 *
 */
public class ProfileMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles("dev");
		ctx.register(ProfileConfig.class);
		ctx.refresh();
		DemoBean demoBean = ctx.getBean(DemoBean.class);
		System.out.println(demoBean.getContent());
		ctx.close();
		
	}
}
