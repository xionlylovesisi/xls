/**
 * 2017年9月22日
 */
package com.xlm.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xlm.taskexecutor.service.AsyncTaskService;
import com.xlm.taskscheduler.service.ScheduledTaskService;

/**
 * @author XIXI
 *
 */
public class TaskSchedulerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
		ScheduledTaskService scheduledTaskService = ctx.getBean(ScheduledTaskService.class);
//		ctx.close();
	}

}
