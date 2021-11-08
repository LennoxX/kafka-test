package br.com.lucas.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.lucas.models.Car;

@Service
public class CarProducer {

	private static final Logger logger = LoggerFactory.getLogger(CarProducer.class);

	private final String topic;

	@Autowired
	private KafkaTemplate<String, Car> kafkaTemplate;

	public CarProducer(@Value("${topic.name}") String topic) {
		this.topic = topic;
	}

	public void send(Car car) {
		kafkaTemplate.send(topic, car).addCallback(
				(success) -> logger.info("Message sent: " + car),
				(failure) -> logger.info("Message failed")
				);
	}
}
