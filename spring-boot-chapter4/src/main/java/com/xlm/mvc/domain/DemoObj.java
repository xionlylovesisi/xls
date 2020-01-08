/**
 * 2017年10月19日
 */
package com.xlm.mvc.domain;

/**
 * @author XIXI
 *
 */
public class DemoObj {
	private Long id;
	private String name;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 */
	public DemoObj() {
		super();
	}
	/**
	 * @param id
	 * @param name
	 */
	public DemoObj(long id, String name) {
		this.id= id;
		this.name = name;
	}
	
}
