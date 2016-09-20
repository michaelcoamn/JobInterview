package stream;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStreamManager implements IStreamManager
{
	private ServerSocket echoServer = null;
	private DataInputStream is;
	private PrintStream os;
	private Socket clientSocket = null;
	
	public ServerStreamManager(int portNum)
	{
		try
		{
			echoServer = new ServerSocket(portNum);
			clientSocket = echoServer.accept();
			is = new DataInputStream(clientSocket.getInputStream());
			os = new PrintStream(clientSocket.getOutputStream());
		}
		catch (Throwable e)
		{
			System.out.println(e);
			// TODO something
		}
	}
	
	@Override
	public OutputStream getOutputStream()
	{
		return os;
	}

	@Override
	public InputStream getInputStream() 
	{
		return is;
	}

}
