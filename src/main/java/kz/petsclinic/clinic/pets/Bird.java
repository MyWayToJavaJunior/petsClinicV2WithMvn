package kz.petsclinic.clinic.pets;
/**
 * Птица, унаследованна от животного
 */
public class Bird extends Pet{

    /**
     * умение Птицы
     */
    private static final String BIRD_ABILITY = "FLY";

    /**
     * класс Птицы
     */
    private static final Class ENEMY_OF_BIRDS = Dog.class;

    /**
     * Конструктор, передает значения: имя животного
     * и умение животного в конструктор суперкласса
     * @param nameOfPet имя животного
     */
    public Bird(String nameOfPet) {
        super(nameOfPet, BIRD_ABILITY);
    }

    /**
     * Переопределение метода возвращающего класс врага животного
     * @return возвращает класс врага животного
     */
    @Override
    public Class<? extends Pet> doAction() {
        return ENEMY_OF_BIRDS;
    }
}
