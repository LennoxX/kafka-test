package br.com.lucas.models;

public class Car {
	private String id;
	private String model;

	public Car() {
		super();
	}

	public Car(String id, String model) {
		super();
		this.id = id;
		this.model = model;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "{id:" + id + ", model:" + model + "}";
	}

}
