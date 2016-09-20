import commandExecutor.Command;
import input.IInputManager;
import input.ScannerInputManager;
import output.IOutputManager;
import output.StringOutputManager;
import stream.ConsoleStreamManager;
import stream.IStreamManager;
import stream.ServerStreamManager;

public class Main 
{
	public static void main(String[] args) {
		IStreamManager consoleStreamManager = new ConsoleStreamManager();
		IStreamManager serverStreamManager = new ServerStreamManager(9999);
		
		IInputManager<Command> inputManager = 
				new ScannerInputManager<>("stop", EUserCommands.getModelGenerator(), serverStreamManager);
		
		IOutputManager<String> outputManager = new StringOutputManager();
		outputManager.addOutputStream(consoleStreamManager.getOutputStream());
		outputManager.addOutputStream(serverStreamManager.getOutputStream());
		
		PastaCommangGenearor pastas = new PastaCommangGenearor(outputManager);
		inputManager.addListener(pastas);
		
		inputManager.start();
	}
}