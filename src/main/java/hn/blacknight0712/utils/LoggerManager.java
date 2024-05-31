package hn.blacknight0712.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerManager {
    private static final Logger HN = LoggerFactory.getLogger("HN");

    private LoggerManager() {} // 防止實例化

    public static void info(String message) {HN.info(message);}

    public static void error(String message) {HN.error(message);}

    public static void error(String message, Throwable throwable) {HN.error(message, throwable);}

    public static Logger getLogger(String name) {return LoggerFactory.getLogger(name);}
}
