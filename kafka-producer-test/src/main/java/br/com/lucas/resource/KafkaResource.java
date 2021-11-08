package br.com.lucas.resource;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.models.Car;
import br.com.lucas.producer.CarProducer;

@RestController
@RequestMapping("kafka")
public class KafkaResource {

	@Autowired
	CarProducer producer;

	@PostMapping("/teste/{model}")
	public ResponseEntity<Car> teste(@PathVariable String model) {
		
		Car car = new Car(UUID.randomUUID().toString(), model);
		System.out.println(car);
		producer.send(car);
		return ResponseEntity.status(HttpStatus.CREATED).body(car);
	}
}
