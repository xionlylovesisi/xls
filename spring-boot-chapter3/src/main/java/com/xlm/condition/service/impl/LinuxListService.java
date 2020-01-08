/**
 * 2017年9月26日
 */
package com.xlm.condition.service.impl;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import com.xlm.condition.LinuxCondition;
import com.xlm.condition.service.ListService;

/**
 * @author XIXI
 *
 */
@Service
@Conditional(LinuxCondition.class)
public class LinuxListService implements ListService {

	/* (non-Javadoc)
	 * @see com.xlm.condition.service.ListService#showListCmd()
	 */
	@Override
	public String showListCmd() {
		return "ls";
	}

}
