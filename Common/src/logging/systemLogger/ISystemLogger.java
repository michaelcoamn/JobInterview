package logging.systemLogger;

import logging.loggers.ILogger;

public interface ISystemLogger 
{
	public ILogger generateDefaultLogger(String name);
}
