/**
 * 2017年9月19日
 */
package com.xlm.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author XIXI
 *
 */
public class EventMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EventConfig.class);
		DemoPublisher demoPublisher = ctx.getBean(DemoPublisher.class);
		demoPublisher.publish("hello application event");
		ctx.close();
	}

}
