/**
 * 2017年9月22日
 */
package com.xlm.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author XIXI
 *
 */
@Configuration
@ComponentScan("com.xlm.taskscheduler")
@EnableScheduling
public class TaskSchedulerConfig  {}
