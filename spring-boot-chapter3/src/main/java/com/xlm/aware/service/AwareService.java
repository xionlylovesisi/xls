/**
 * 2017年9月20日
 */
package com.xlm.aware.service;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * @author XIXI
 *
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {
	
	private String beanName;
	private ResourceLoader resourceLoader;

	/* (non-Javadoc)
	 * @see org.springframework.context.ResourceLoaderAware#setResourceLoader(org.springframework.core.io.ResourceLoader)
	 */
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.String)
	 */
	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}
	public void outputResult(){
		System.out.println("bean的名称为:"+this.beanName);
		Resource resource = this.resourceLoader.getResource("classpath:com/xlm/aware/test.txt");
		try {
			System.out.println("resourceLoader加载的文件内容为:"+IOUtils.toString(resource.getInputStream(),Charset.forName("UTF-8")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
