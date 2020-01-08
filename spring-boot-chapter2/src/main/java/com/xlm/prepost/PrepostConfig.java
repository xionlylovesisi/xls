/**
 * 2017年9月19日
 */
package com.xlm.prepost;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author XIXI
 *
 */
@Configuration
@ComponentScan("com.xlm.prepost")
public class PrepostConfig {
	@Bean(initMethod="init",destroyMethod="destroy")
	public BeanWayService beanWayService(){
		return new BeanWayService();
	}
	@Bean
	public JSR250WayService jsr250WayService(){
		return new JSR250WayService();
	}
}
