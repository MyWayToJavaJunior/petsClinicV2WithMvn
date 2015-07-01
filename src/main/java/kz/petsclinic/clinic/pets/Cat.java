package kz.petsclinic.clinic.pets;
/**
 * Кот, унаследованн от животного
 */
public class Cat extends Pet {

    /**
     * умение Кота
     */
    private static final String CAT_ABILITY = "CLIMB UP TREES";

    /**
     * класс Кота
     */
    private static final Class ENEMY_OF_CATS = Bird.class;

    /**
     * Конструктор, передает значения: имя животного
     * и умение животного в конструктор суперкласса
     * @param nameOfPet имя животного
     */
    public Cat(String nameOfPet) {
        super(nameOfPet, CAT_ABILITY);
    }

    /**
     * Переопределение метода возвращающего класс врага животного
     * @return возвращает класс врага животного
     */
    @Override
    public Class<? extends Pet> doAction() {
        return ENEMY_OF_CATS;
    }
}
