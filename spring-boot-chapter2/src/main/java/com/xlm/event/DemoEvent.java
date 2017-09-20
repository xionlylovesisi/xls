/**
 * 2017年9月19日
 */
package com.xlm.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author XIXI
 *
 */
public class DemoEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String msg;
	/**
	 * @param source
	 */
	public DemoEvent(Object source,String msg) {
		super(source);
		this.msg = msg;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
