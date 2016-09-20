package observer;

/**
 * Describes a subject that notifies {@link IListener}s
 * 
 * @author MIchaelC
 *
 * @param <T> The type of data that needs to be notified
 */
public interface ISubject<T, Listener extends IListener<T>>
{
	/**
	 * Adds the given listener if does not exist
	 * @param listener to add
	 */
	public void addListener(Listener listener);
	
	/**
	 * Removes the given listener if exists
	 * @param listener to remove
	 */
	public void removeListener(Listener listener);
	
	/**
	 * @param listener to check
	 * @return whether the given listener is contained by this subject
	 */
	public boolean contains(Listener listener);
}
