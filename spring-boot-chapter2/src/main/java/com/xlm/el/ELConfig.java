/**
 * 2017年9月19日
 */
package com.xlm.el;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * @author XIXI
 *
 */
@Configuration
@ComponentScan("com.xlm.el")
@PropertySource("classpath:com/xlm/el/test.properties")
public class ELConfig {
	@Value("i love you")
	private String normal;
	@Value("#{systemProperties['os.name']}")
	private String osName;
	@Value("#{T(java.lang.Math).random()*100.0}")
	private double randomNumber;
	@Value("#{demoService.author}")
	private String fromAuthor;
	@Value("classpath:com/xlm/el/test.txt")
	private Resource testFile;
	@Value("http://www.baidu.com")
	private Resource testUrl;
	@Value("${chapter.content}")
	private String content;
	
	@Autowired
	private Environment environment;
	
	public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	public void outputResource(){
		
		try {
			System.out.println(normal);
			System.out.println(osName);
			System.out.println(randomNumber);
			System.out.println(fromAuthor);
			System.out.println(IOUtils.toString(testFile.getInputStream(),Charset.forName("UTF-8")));
			System.out.println(IOUtils.toString(testUrl.getInputStream(), Charset.forName("UTF-8")));
			System.out.println(content);
			System.out.println(environment.getProperty("chapter.author"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
