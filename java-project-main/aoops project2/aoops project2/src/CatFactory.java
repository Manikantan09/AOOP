public class CatFactory implements AnimalFactory {
    private String breed;

    public CatFactory(String breed) {
        this.breed = breed;
    }

    @Override
    public Animal createAnimal() {
        return new Cat(breed);
    }
}
