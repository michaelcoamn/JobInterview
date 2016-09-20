package stream;

import java.io.InputStream;
import java.io.OutputStream;

public interface IStreamManager 
{
	public OutputStream getOutputStream();
	
	public InputStream getInputStream();
}
