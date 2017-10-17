/**
 * 2017年9月22日
 */
package com.xlm.taskscheduler.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author XIXI
 *
 */
@Service
public class ScheduledTaskService {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate=5000)
	public void reportCurrentTime(){
		System.out.println("每5秒执行一次:"+DATE_FORMAT.format(new Date()));
	}
	
	@Scheduled(cron="0 28 9 ? * *")
	public void fixTimeExecution(){
		System.out.println("再指定时间"+DATE_FORMAT.format(new Date())+"执行");
		
	}
	
}
