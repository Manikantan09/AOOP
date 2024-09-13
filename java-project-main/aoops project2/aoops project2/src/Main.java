public class Main {
        public static void main(String[] args) {
                AnimalFactory persianCatFactory = new CatFactory("Persian");
                Animal persianCat = persianCatFactory.createAnimal();
                System.out.println(
                                "Created a " + persianCat.getBreed() + " cat of type "
                                                + persianCat.getClass().getSimpleName());
                AnimalFactory bulldogDogFactory = new DogFactory("Bulldog");
                Animal bulldogDog = bulldogDogFactory.createAnimal();
                System.out.println(
                                "Created a " + bulldogDog.getBreed() + " dog of type "
                                                + bulldogDog.getClass().getSimpleName());

                AnimalFactory siameseCatFactory = new CatFactory("Siamese");
                Animal siameseCat = siameseCatFactory.createAnimal();
                System.out.println(
                                "Created a " + siameseCat.getBreed() + " cat of type "
                                                + siameseCat.getClass().getSimpleName());

                AnimalFactory beagleDogFactory = new DogFactory("Beagle");
                Animal beagleDog = beagleDogFactory.createAnimal();
                System.out
                                .println("Created a " + beagleDog.getBreed() + " dog of type "
                                                + beagleDog.getClass().getSimpleName());
        }
}
