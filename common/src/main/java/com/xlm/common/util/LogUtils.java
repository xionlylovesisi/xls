package com.xlm.common.util;

import org.slf4j.Logger;

public final class LogUtils {
	public static final void debug(Logger log, String msg) {
		_debug(log, msg, null);
	}
	public static final void debug(Logger log, String format, Object arg) {
		_debug(log, format, null, arg);
	}
	public static final void debug(Logger log, String format, Object arg1, Object arg2) {
		_debug(log, format, null, arg1,arg2);
	}
	public static final void debug(Logger log, String format, Object... arguments) {
		_debug(log, format, null, arguments);
	}
	public static final void debug(Logger log, String msg, Throwable t) {
		_debug(log, msg, t);
	}
	private static void _debug(Logger log, String msg, Throwable t, Object... arguments){
		if (log.isDebugEnabled()) {
			if (t!=null) {
				log.debug(msg,t);
			}else if(arguments==null||arguments.length==0){
				log.debug(msg);
			}else{
				if (arguments.length == 1) {
					log.debug(msg,arguments[0]);
				}else if(arguments.length == 2){
					log.debug(msg,arguments[0],arguments[1]);
				}else{
					log.debug(msg,arguments);
				}
			}
		}
	}
	public static final void info(Logger log, String message){
		_info(log, message,null);
	}
	public static final void info(Logger log, String format, Object arg){
		_info(log, format, null,arg);
	}
	public static final void info(Logger log, String format, Object arg1, Object arg2) {
		_info(log, format,null, arg1,arg2);
	}
	public static final void info(Logger log, String format, Object... arguments) {
		_info(log, format,null, arguments);
	}
	public static final void info(Logger log, String msg, Throwable t) {
		_info(log, msg, t);
	}
	private static final void _info(Logger log, String msg, Throwable t, Object... arguments){
		if (log.isInfoEnabled()) {
			if (t!=null) {
				log.info(msg,t);
			}else if(arguments==null||arguments.length==0){
				log.info(msg);
			}else{
				if (arguments.length == 1) {
					log.info(msg,arguments[0]);
				}else if(arguments.length == 2){
					log.info(msg,arguments[0],arguments[1]);
				}else{
					log.info(msg,arguments);
				}
			}
		}
	}
	public static final void warn(Logger log, String msg) {
		_warn(log, msg, null);
	}
	public static final void warn(Logger log, String format, Object arg) {
		_warn(log, format, null, arg);
	}
	public static final void warn(Logger log, String format, Object... arguments) {
		_warn(log, format, null, arguments);
	}
	public static final void warn(Logger log, String format, Object arg1, Object arg2) {
		_warn(log, format, null, arg1,arg2);
	}
	public static final void warn(Logger log, String msg, Throwable t) {
		_warn(log, msg, t);
	}
	
	private static final void _warn(Logger log, String msg, Throwable t, Object... arguments){
		if (log.isWarnEnabled()) {
			if (t!=null) {
				log.warn(msg,t);
			}else if(arguments==null||arguments.length==0){
				log.warn(msg);
			}else{
				if (arguments.length == 1) {
					log.warn(msg,arguments[0]);
				}else if(arguments.length == 2){
					log.warn(msg,arguments[0],arguments[1]);
				}else{
					log.warn(msg,arguments);
				}
			}
		}
	}
	
	public static final void error(Logger log, String msg) {
		_error(log, msg, null);
	}
	public static final void error(Logger log, String format, Object arg) {
		_error(log, format, null, arg);
	}
	public static final void error(Logger log, String format, Object arg1, Object arg2) {
		_error(log, format, null, arg1,arg2);
	}
	public static final void error(Logger log, String format, Object... arguments) {
		_error(log, format, null, arguments);
	}
	public static final void error(Logger log, String msg, Throwable t) {
		_error(log, msg, t);
	}
	
	private static final void _error(Logger log, String msg, Throwable t, Object... arguments){
		if (log.isErrorEnabled()) {
			if (t!=null) {
				log.error(msg,t);
			}else if(arguments==null||arguments.length==0){
				log.error(msg);
			}else{
				if (arguments.length == 1) {
					log.error(msg,arguments[0]);
				}else if(arguments.length == 2){
					log.error(msg,arguments[0],arguments[1]);
				}else{
					log.error(msg,arguments);
				}
			}
		}
	}
}
