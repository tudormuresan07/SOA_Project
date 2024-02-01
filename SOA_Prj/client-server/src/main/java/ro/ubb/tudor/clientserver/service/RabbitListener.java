package ro.ubb.tudor.clientserver.service;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		String receivedMessage = new String(message.getBody());
		System.out.println("Received a new message = [" + receivedMessage + "]");
	}
}