/**
 * 2017年9月19日
 */
package com.xlm.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author XIXI
 *
 */
@Component
public class DemoPublisher {
	@Autowired
	private ApplicationContext applicationContext;
	
	public void publish(String msg){
		applicationContext.publishEvent(new DemoEvent(this, msg));
	}
}
