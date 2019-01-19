/**
 * 2017年12月4日
 */
package com.xls.springBoot.util;

import java.io.Serializable;

import org.apache.commons.lang3.math.NumberUtils;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author xls
 *
 */
@Data
@ToString
@EqualsAndHashCode
public class Event implements Serializable, Comparable<Event> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 事件名称
	 */
	private String eventName;
	/**
	 * 最终时间
	 */
	private String finalTime;
	/**
	 * 实际完成时间
	 */
	private String actualFinishTime;
	/**
	 * 当前阶段
	 */
	private String currentProgress;
	/**
	 * 备注
	 */
	private String remark;
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Event o) {
		if (o == null) {
			return NumberUtils.INTEGER_ONE;
		}
		return this.finalTime.compareTo(o.getFinalTime());
	}
}
