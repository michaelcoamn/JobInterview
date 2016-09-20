package logging.systemLogger;

import logging.loggers.DefaultJavaUtilLogger;
import logging.loggers.ILogger;
import logging.loggers.Log4JLogger;

/**
 * 
 * @author MichaelC
 *
 * @param <Logger>
 */
public enum SystemLogger implements ISystemLogger
{
	JAVA_UTIL 
	{
		public ILogger generateDefaultLogger(String name) {
			// TODO Auto-generated method stub
			return new DefaultJavaUtilLogger(name);
		}
	},
	LOG4J 
	{
		public ILogger generateDefaultLogger(String name)
		{
			return new Log4JLogger(name);
		}
	};
	
	private static ISystemLogger m_currentSystemLogger = LOG4J;
	
	public static void setSystemLogger(ISystemLogger systemLogger)
	{
		m_currentSystemLogger = systemLogger;
	}
	
	public static ILogger getLogger(String name)
	{
		return m_currentSystemLogger.generateDefaultLogger(name);
	}
}
