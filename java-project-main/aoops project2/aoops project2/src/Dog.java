public class Dog implements Animal {
    private String breed;

    public Dog(String breed) {
        this.breed = breed;
    }

    @Override
    public String getBreed() {
        return breed;
    }
}
