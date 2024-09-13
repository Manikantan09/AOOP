public class DogFactory implements AnimalFactory {
    private String breed;

    public DogFactory(String breed) {
        this.breed = breed;
    }

    @Override
    public Animal createAnimal() {
        return new Dog(breed);
    }
}
