package stream;

import java.io.InputStream;
import java.io.OutputStream;

public class ConsoleStreamManager implements IStreamManager 
{

	@Override
	public OutputStream getOutputStream() 
	{
		return System.out;
	}

	@Override
	public InputStream getInputStream() 
	{
		return System.in;
	}

}
