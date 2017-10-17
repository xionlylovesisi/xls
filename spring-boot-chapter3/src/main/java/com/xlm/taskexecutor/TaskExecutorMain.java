/**
 * 2017年9月20日
 */
package com.xlm.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xlm.taskexecutor.service.AsyncTaskService;

/**
 * @author XIXI
 *
 */
public class TaskExecutorMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
		AsyncTaskService asyncTaskService = ctx.getBean(AsyncTaskService.class);
		for (int i = 0; i < 10; i++) {
			asyncTaskService.executeAsyncTask(i);
			asyncTaskService.executeAsyncTaskPlus(i);
		}
		ctx.close();
	}

}
