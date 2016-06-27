package fr.treeptik.rest.configuration;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import fr.treeptik.rest.service.StockMessageService;

@Profile("jboss")
@Configuration
public class JmsConfiguration {

	@Resource(mappedName = "java:/jms/queue/StockQueue")
	private Queue queue;

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Bean
	public DefaultMessageListenerContainer messageListenerContainer(StockMessageService stockMessageService) {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setMessageListener(stockMessageService);
		container.setDestination(queue);
		return container;
	}

}
