package springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MessagePrinter
{
	MessageService ms;
	
	@Autowired
	public MessagePrinter(MessageService ms)
	{
		this.ms = ms;
	}
	
	public void printMsg(String msg)
	{
		System.out.println(String.format("Message %s - %s ",ms.getMessage() ,msg ));
	}
}