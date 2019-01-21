/**
 * 2017年12月4日
 */
package com.xlm.spring.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author xls
 *
 */
public class TaskManager {
	private static TaskManager taskManager;
	private TaskManager(){}
	static final String  JSON_FILE_PATH = "D:\\za_mcx\\task\\allTask.json";
	private static List<MonthEvent> monthEvents;
	static{
		monthEvents = JSON.parseArray(readFile(JSON_FILE_PATH), MonthEvent.class);
	}
	public static TaskManager getInstance(){
		if (taskManager == null) {
			taskManager = new TaskManager();
		}
		return taskManager;
	}
	public MonthEvent getByMonth(String month){
		for (MonthEvent monthEvent : monthEvents) {
			if (monthEvent.getMonth().equals(month)) {
				return monthEvent;
			}
		}
		return null;
	}
	public Boolean addMonth(MonthEvent monthEvent){
		if (monthEvent != null && CollectionUtils.isNotEmpty(monthEvent.getEvents())) {
			Collections.sort(monthEvent.getEvents());
		}
		return monthEvents.add(monthEvent);
	}
	public Boolean writeToFile() throws IOException{
		JSON.writeJSONString(new FileWriter(new File(JSON_FILE_PATH)), monthEvents, SerializerFeature.PrettyFormat);
		return Boolean.TRUE;
	}
	public Boolean sortMonthEvents(){
		Collections.sort(monthEvents);
		return Boolean.TRUE;
	}
	public static void main(String[] args) throws IOException {
		MonthEvent monthEvent = new MonthEvent();
		monthEvent.setMonth("2017-12");
		List<Event> events = new ArrayList<Event>();
		Event event = new Event();
		event.setEventName("Account功能分析整理");
		event.setFinalTime("12-01");
		event.setActualFinishTime("12-01");
		event.setCurrentProgress("已初步沟通");
		event.setRemark("初步整理了功能列表,及系统架构图");
		events.add(event);
		monthEvent.setEvents(events);
		TaskManager.getInstance().addMonth(monthEvent);
		TaskManager.getInstance().writeToFile();
	}

	public static String readFile(String Path) {
		BufferedReader reader = null;
		String laststr = "";
		try {
			FileInputStream fileInputStream = new FileInputStream(Path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				laststr += tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return laststr;
	}
}
