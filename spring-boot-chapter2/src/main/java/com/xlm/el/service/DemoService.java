/**
 * 2017年9月19日
 */
package com.xlm.el.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author XIXI
 *
 */
@Service
public class DemoService {
	@Value("其他类的属性")
	private String author;

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
