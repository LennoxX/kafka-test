package br.com.lucas.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.lucas.models.Car;

@Component
public class CarConsumer {

	private static final Logger logger = LoggerFactory.getLogger(CarConsumer.class);

	@Value("${topic.name}")
	private String topic;

	@Value("${spring.kafka.consumer.group-id}")
	private String groupId;

	@KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "carKafkaListenerContainerFactory")
	public void listenTopicCars(ConsumerRecord<String, Car> record) {
		logger.info("Received Message: " + record.partition() + " - " + record.value());
	}
}
