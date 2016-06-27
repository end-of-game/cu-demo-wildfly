package fr.treeptik.data.generator.configuration;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;

@Profile("jboss")
@Configuration
public class JmsConfiguration {

	@Resource(mappedName = "java:/jms/queue/StockQueue")
	private Queue queue;

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setDefaultDestination(queue);
		jmsTemplate.setConnectionFactory(connectionFactory);
		return jmsTemplate;
	}

}
