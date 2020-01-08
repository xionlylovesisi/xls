/**
 * 2017年9月19日
 */
package com.xlm.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author XIXI
 *
 */
@Configuration
@ComponentScan("com.xlm.profile")
public class ProfileConfig {
	@Bean
	@Profile("dev")
	public DemoBean devDemoBean(){
		return new DemoBean("from development profiles");
	}
	@Bean
	@Profile("prod")
	public DemoBean prodDemoBean(){
		return new DemoBean("from production profiles");
	}
}
