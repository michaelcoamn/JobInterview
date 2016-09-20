package input;
import modelGenerator.IModelGenerator;
import observer.AbstractSubject;

public abstract class AbstractInputManager<Model> extends AbstractSubject<Model, IInputListener<Model>> 
												  implements IInputManager<Model>
{
	private NotifyOnIputMethod m_notifyInputMethod = new NotifyOnIputMethod();
	private IModelGenerator<String, Model> m_modelGenerator;

	public AbstractInputManager(IModelGenerator<String, Model> modelGenerator) 
	{
		m_modelGenerator = modelGenerator;
	}
	
	protected void notifyInput(String input)
	{
		Model model = m_modelGenerator.generateModel(input);
		
		notifyListeneres(m_notifyInputMethod, model);
	}
	
	private class NotifyOnIputMethod extends NotifiableMethod<Model>
	{

		@Override
		public void notify(IInputListener<Model> listener, Model vaiable)
		{
			listener.onInputRecieved(vaiable);
		}
	}
}
