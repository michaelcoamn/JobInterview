package input;
import java.util.Scanner;

import modelGenerator.IModelGenerator;
import stream.IStreamManager;

public class ScannerInputManager<Model> extends AbstractInputManager<Model>
{
	protected final String CLOSE ; 
	protected Scanner m_scanner;
	protected IStreamManager m_streamManager;
	
	public ScannerInputManager(String shutdown, IModelGenerator<String, Model> modelGenerator,
								IStreamManager streamManager) 
	{
		super(modelGenerator);
		CLOSE = shutdown;
		m_streamManager = streamManager;
		m_scanner= new Scanner(m_streamManager.getInputStream());
	}
	
	@Override
	public void start()
	{
		String userInput = m_scanner.nextLine();
		System.out.println(userInput);
		while(!userInput.equals(CLOSE))
		{
			notifyInput(userInput);
			
			userInput = m_scanner.nextLine();
		}
		
		m_scanner.close();
	}
}
