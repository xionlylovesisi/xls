/**
 * 2017年9月19日
 */
package com.xlm.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author XIXI
 *
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
	
	

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(DemoEvent event) {
		System.out.println("bean-demoListener接收到了bean-demopublisher发布的消息:"+event.getMsg());
	}

}
