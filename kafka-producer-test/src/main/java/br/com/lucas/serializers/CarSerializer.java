package br.com.lucas.serializers;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lucas.models.Car;

public class CarSerializer implements Serializer<Car> {


	@Override
	public byte[] serialize(String topic, Car data) {
		byte[] retVal = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			retVal = objectMapper.writeValueAsString(data).getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}

}
