/**
 * 2017年9月26日
 */
package com.xlm.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xlm.condition.service.ListService;

/**
 * @author XIXI
 *
 */
public class ConditionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConditionBeanConfig.class);
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConditionConfig.class);
		ListService listService = ctx.getBean(ListService.class);
		System.out.println("当前系统下文件列表命令为:"+listService.showListCmd());
		ctx.close();
	}

}
