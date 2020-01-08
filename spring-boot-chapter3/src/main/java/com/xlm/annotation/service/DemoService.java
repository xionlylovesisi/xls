/**
 * 2017年9月29日
 */
package com.xlm.annotation.service;

import org.springframework.stereotype.Service;

/**
 * @author XIXI
 *
 */
@Service
public class DemoService {
	public void outputResult(){
		System.out.println("从组合注解配置照样获得bean");
	}
}
