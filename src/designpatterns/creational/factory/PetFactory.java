package designpatterns.creational.factory;

public class PetFactory {

	public Pet getPet(String petType) {
		Pet pet = null;
		if (petType.equals("Bark Bark")) {
			pet = new Dog();
		} else {
			pet = new Duck();
		}
		return pet;
	}

	public static void main(String[] args) {
		PetFactory petFactory = new PetFactory();
		Pet pet = petFactory.getPet("Bark Bark");
		System.out.println(pet.speak());
	}
}
