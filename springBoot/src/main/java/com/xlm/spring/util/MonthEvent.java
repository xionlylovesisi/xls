/**
 * 2017年12月4日
 */
package com.xlm.spring.util;

import java.io.Serializable;
import java.util.List;

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
public class MonthEvent implements Serializable, Comparable<MonthEvent> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String month;
	private List<Event> events;

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(MonthEvent o) {
		if (o == null) {
			return NumberUtils.INTEGER_ONE;
		}
		return this.month.compareTo(o.getMonth());
	}

}
