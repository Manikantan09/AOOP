
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AnimalFactoryTest {

    @Test
    public void testPersianCatFactory() {
        AnimalFactory factory = new CatFactory("Persian");
        Animal cat = factory.createAnimal();
        assertEquals("Persian", cat.getBreed());
        assertEquals(Cat.class, cat.getClass());
    }

    @Test
    public void testBulldogDogFactory() {
        AnimalFactory factory = new DogFactory("Bulldog");
        Animal dog = factory.createAnimal();
        assertEquals("Bulldog", dog.getBreed());
        assertEquals(Dog.class, dog.getClass());
    }

    @Test
    public void testAnotherCatFactory() {
        AnimalFactory factory = new CatFactory("Siamese");
        Animal cat = factory.createAnimal();
        assertEquals("Siamese", cat.getBreed());
        assertEquals(Cat.class, cat.getClass());
    }

    @Test
    public void testAnotherDogFactory() {
        AnimalFactory factory = new DogFactory("Beagle");
        Animal dog = factory.createAnimal();
        assertEquals("Beagle", dog.getBreed());
        assertEquals(Dog.class, dog.getClass());
    }
}
