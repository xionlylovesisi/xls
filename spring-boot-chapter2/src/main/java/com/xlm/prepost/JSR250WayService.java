/**
 * 2017年9月19日
 */
package com.xlm.prepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author XIXI
 *
 */
public class JSR250WayService {
	@PostConstruct
	public void init(){
		System.out.println("JSR250-init-method");
	}
	public JSR250WayService(){
		System.out.println("初始化构造函数-JSR250WayService");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("JSR250-destroy-method");
	}
}
