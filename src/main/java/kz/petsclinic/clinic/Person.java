package kz.petsclinic.clinic;

import kz.petsclinic.clinic.pets.Pet;

/**
 * Џерсона
 */
public class Person {

    /**
     * имя Персоны
     */
    private String nameOfPerson;

    /**
     * животное Персоны
     */
    private Pet petOfPerson;

    /**
     * Конструктор персоны, инициализирует поля входящими значеними
     * @param nameOfPerson имя Персоны
     * @param petOfPerson животное Персоны
     */
    public Person(String nameOfPerson, Pet petOfPerson) {
        this.nameOfPerson = nameOfPerson;
        this.petOfPerson = petOfPerson;
    }

    /**
     * Получить имя персоны
     * @return возвращает имя персоны
     */
    public String getNameOfPerson() {
        return this.nameOfPerson;
    }

    /**
     * Получить имя животного Персоны
     * @return возвращает имя животного Персоны
     * пользуясь методом класса Pet
     */
    public String getPetNameOfPerson() {
        return this.petOfPerson.getNameOfPet();
    }

    /**
     * Устанавливает имя Персоны
     * @param nameOfPerson новое имя Персоны
     */
    public void setNameOfPerson(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
    }

    /**
     * Получить класс врага животного
     * @return возвращает класс врага животного
     * используя метод класса Pet
     */
    public Class<? extends Pet> getClassEnemyOfPet() {
        return this.petOfPerson.doAction();
    }

    /**
     * Получить класс животного
     * @return возвращает класс животного
     * пользуясь методом предка
     */
    public Class<? extends Pet> getClassOfPet() {
        return petOfPerson.getClass();
    }

    /**
     * Устанавливает имя животного Персоны
     * @param nameOfPet новое имя животного
     */
    public void setPetNameOfPerson(String nameOfPet) {
        this.petOfPerson.setNameOfPet(nameOfPet);
    }

    /**
     * Переопределение метода возвращающего описание Персоны
     * @return возвращает строку содержащую описание Персоны
     */
    @Override
    public String toString() {
        return "Name of Person: " + this.getNameOfPerson() + ", " + this.petOfPerson.toString();
    }
}
