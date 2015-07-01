package kz.petsclinic.clinic.pets;
/**
 * животное
 */
public abstract class Pet {
    private final String typeOfPet;
    private final String ability;
    private String nameOfPet;

    /**
     * конструктор животного,
     * инициализирует поля входящими данными
     * и с помощью метода предка класса
     * @param nameOfPet имя животного
     * @param ability умение животного
     */
    public Pet(String nameOfPet, String ability) {
        this.nameOfPet = nameOfPet;
        this.ability = ability;
        this.typeOfPet = this.getClass().getName();
    }

    /**
     * Получить имя животного
     * @return возвращает строку содержащую имя животного
     */
    public String getNameOfPet() {
        return nameOfPet;
    }

    /**
     * Получить умение животного
     * @return возвращает строку содержащую умение животного
     */
    public String getAbility() {
        return ability;
    }

    /**
     * Получить имя животного
     * @return возвращает имя животного
     */
    public String getTypeOfPet() {
        return typeOfPet;
    }

    /**
     * Установить имя животного
     * @param nameOfPet новое имя животного
     */
    public void setNameOfPet(String nameOfPet) {
        this.nameOfPet = nameOfPet;
    }

    /**
     * Получение класса врага животного
     * @return возвращает класс врага животного
     */
    public Class<? extends Pet> doAction() {
        return this.getClass();
    }

    /**
     * Переопределение метода возвращающего описание животного
     * @return возвращает строку содержащую описание животного
     */
    @Override
    public String toString() {
        return "Type of pet is: " + getTypeOfPet() + ", name: " + getNameOfPet() + ", ability: " + getAbility();
    }
}
