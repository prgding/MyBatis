package me.ding.pojo;

public class Car {
	private String carNum;
	private String brand;
	private Double producePrice;
	private String produceTime;
	private String carType;

	public Car(String carNum, String brand, Double producePrice, String produceTime, String carType) {
		this.carNum = carNum;
		this.brand = brand;
		this.producePrice = producePrice;
		this.produceTime = produceTime;
		this.carType = carType;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getProducePrice() {
		return producePrice;
	}

	public void setProducePrice(Double producePrice) {
		this.producePrice = producePrice;
	}

	public String getProduceTime() {
		return produceTime;
	}

	public void setProduceTime(String produceTime) {
		this.produceTime = produceTime;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	@Override
	public String toString() {
		return "Car{" +
				"carNum='" + carNum + '\'' +
				", brand='" + brand + '\'' +
				", producePrice=" + producePrice +
				", produceTime='" + produceTime + '\'' +
				", carType='" + carType + '\'' +
				'}';
	}
}
