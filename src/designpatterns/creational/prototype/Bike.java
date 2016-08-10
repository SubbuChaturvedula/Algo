package designpatterns.creational.prototype;

public class Bike implements Cloneable {

	private int gears;
	private String model;
	private String bikeType;

	public Bike() {
		bikeType = "Standard";
		model = "Leopard";
		gears = 4;
	}

	public int getGears() {
		return gears;
	}

	public void setGears(int gears) {
		this.gears = gears;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBikeType() {
		return bikeType;
	}

	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}

	public void makeAdvanced() {
		bikeType = "Advanced";
		model = "Jaguar";
		gears = 6;
	}

	public Bike clone() throws CloneNotSupportedException {
		return (Bike) super.clone();
	}

	public Bike makeJaguar(Bike basicBike) {
		basicBike.makeAdvanced();
		return basicBike;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Bike bike = new Bike();
		Bike basicBike = bike.clone();
		Bike advancedBike = bike.makeJaguar(basicBike);
		System.out.println("Prototype Design Pattern: " + advancedBike.getModel());
	}

}
