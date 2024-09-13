public class Cat implements Animal {
    private String breed;

    public Cat(String breed) {
        this.breed = breed;
    }

    @Override
    public String getBreed() {
        return breed;
    }
}
