package output;

import java.io.OutputStream;

public interface IOutputManager<T>
{
	public void addOutputStream(OutputStream stream);
	
	public void send(T toSend);
}
