package kz.petsclinic.clinic.pets;
/**
 * ѕес, унаследованн от животного
 */
public class Dog extends Pet {

    /**
     * умение ѕса
     */
    private static final String DOG_ABILITY = "BARK";

    /**
     * класс ѕса
     */
    private static final Class ENEMY_OF_DOGS = Cat.class;

    /**
     *  онструктор, передает значени€: им€ животного
     * и умение животного в конструктор суперкласса
     * @param nameOfPet им€ животного
     */
    public Dog(String nameOfPet) {
        super(nameOfPet, DOG_ABILITY);
    }

    /**
     * ѕереопределение метода возвращающего класс врага животного
     * @return возвращает класс врага животного
     */
    @Override
    public Class<? extends Pet> doAction() {
        return ENEMY_OF_DOGS;
    }
}
