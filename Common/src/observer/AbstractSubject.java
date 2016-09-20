package observer;

import java.util.Collection;
import java.util.HashSet;

import logging.loggers.ILogger;
import logging.systemLogger.SystemLogger;

/**
 * An abstract subject that generates the notification of listeners to catch exceptions 
 * in a given listener and not interfere with other notifications. 
 * 
 * @author MichaelC
 *
 * @param <T> The type of data that needs to be notified
 */
public abstract class AbstractSubject<T, Listener extends IListener<T>> implements ISubject<T, Listener>
{
	/**
	 * The listeners to be notified.</br>
	 * Set as {@link HashSet} as my standard
	 */
	private Collection<Listener> m_listeners = new HashSet<Listener>();
	
	protected ILogger m_logger = SystemLogger.getLogger(getClass().getName());
	
	public void addListener(Listener listener) 
	{
		if(listener == null)
		{
			// TOOD: log 
			return;
		}
		
		m_listeners.add(listener);
	}
	
	public void removeListener(Listener listener) 
	{
		if(listener == null)
		{
			// TOOD: log 
			return;
		}
		
		m_listeners.remove(listener);
	}
	
	public boolean contains(Listener listener) 
	{
		if(listener == null)
		{
			// TOOD: log 
			return false;
		}
		
		return m_listeners.contains(listener);
	}
	
	/**
	 * Notifies all listeners contained by this subject of the given method with the given variable
	 * 
	 * @param method - The method to invoke in the listeners
	 * @param var - The variable to pass to the listeners
	 */
	protected <Variable> void notifyListeneres(NotifiableMethod<Variable> method, Variable var)
	{
		if(method == null)
		{
			// TODO: log
			return;
		}
		
		for (Listener listener : m_listeners) 
		{
			try
			{
				method.notify(listener, var);
			}
			catch(Exception e)
			{
				// TODO: log
			}
		}
	}
	
	/**
	 * Defines a method to invoke in a listener with the given variable
	 * 
	 * @author MichaelC
	 *
	 * @param <Variable> - The variable to pass to the listener.</br> 
	 * If the method does not accept a variable, then Void must be defined.
	 */
	protected abstract class NotifiableMethod<Variable>
	{
		/**
		 * Calls a method in the given listener with the given variable
		 * 
		 * @param listener to notify
		 * @param vaiable to pass
		 */
		public abstract void notify(Listener listener, Variable vaiable);
	}
}
