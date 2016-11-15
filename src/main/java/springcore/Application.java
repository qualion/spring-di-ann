package springcore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
@Component
public class Application
{
	@Bean
	MessageService getMS()
	{
		return new MessageService()
		{
			public String getMessage()
			{
				return "Messsage Service !";
			}
		};
	}
	
	
	@Autowired
	public MessagePrinter mp;

	 
	public static void main(String a[])
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		
		MessagePrinter mp2 = context.getBean(MessagePrinter.class);
		mp2.printMsg("from context getBean");
				Application ap = context.getBean(Application.class);
				ap.mp.printMsg("from application , which is from context getbean");
		//the following Will thro error - null pointer ex - cos new is not intercepted. need AOP for that.
		(new Application()).mp.printMsg("autowiring in application class");
	}
}