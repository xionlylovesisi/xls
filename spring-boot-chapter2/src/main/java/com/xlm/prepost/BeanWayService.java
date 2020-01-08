/**
 * 2017年9月19日
 */
package com.xlm.prepost;

/**
 * @author XIXI
 *
 */
public class BeanWayService {
	public void init(){
		System.out.println("@bean-init-method");
	}
	public BeanWayService(){
		System.out.println("初始化构造函数-BeanWayService");
	}
	public void destroy(){
		System.out.println("@bean-destroy-method");
	}
}
