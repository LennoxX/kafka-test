package br.com.lucas.deserializers;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lucas.models.Car;

public class CarDeserializer implements Deserializer<Car> {

	@Override
	public Car deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		Car car = null;
		try {
			car = mapper.readValue(data, Car.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return car;
	}

}
