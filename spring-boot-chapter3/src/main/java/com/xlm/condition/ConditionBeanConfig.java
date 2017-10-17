/**
 * 2017年9月26日
 */
package com.xlm.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.xlm.condition.service.ListService;
import com.xlm.condition.service.impl.LinuxListService;
import com.xlm.condition.service.impl.WindowsListService;

/**
 * @author XIXI
 *
 */
@Configuration
public class ConditionBeanConfig {
	@Bean
	@Conditional(WindowsCondition.class)
	public ListService windowsListService(){
		return new WindowsListService();
	}
	@Bean
	@Conditional(LinuxCondition.class)
	public ListService linuxListService(){
		return new LinuxListService();
	}
}
