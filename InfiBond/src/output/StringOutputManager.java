package output;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

public class StringOutputManager implements IOutputManager<String>
{
	Set<PrintStream> m_output = new HashSet<>();
	
	@Override
	public void send(String toSend) 
	{
		for (PrintStream printStream : m_output) {
			printStream.println(toSend);
		}
	}


	@Override
	public void addOutputStream(OutputStream stream) 
	{
		m_output.add(new PrintStream(stream));		
	}

}
