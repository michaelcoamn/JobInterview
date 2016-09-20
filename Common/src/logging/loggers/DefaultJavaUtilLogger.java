package logging.loggers;

import java.util.logging.Logger;

public class DefaultJavaUtilLogger implements ILogger
{
	Logger m_logger;
	
	public DefaultJavaUtilLogger(String name) 
	{
		m_logger = Logger.getLogger(name);
	}

	public void log(LoggerLevels level, String message) {
		// TODO Auto-generated method stub
		
	}

	public void log(LoggerLevels level, Object... param) {
		// TODO Auto-generated method stub
		
	}

	public void log(LoggerLevels level, String message, Throwable thrown) {
		// TODO Auto-generated method stub
		
	}

	public void severe(String msg) {
		// TODO Auto-generated method stub
		
	}

	public void warning(String msg) {
		// TODO Auto-generated method stub
		
	}

	public void info(String msg) {
		// TODO Auto-generated method stub
		
	}

	public void config(String msg) {
		// TODO Auto-generated method stub
		
	}

	public void fine(String msg) {
		// TODO Auto-generated method stub
		
	}
}
