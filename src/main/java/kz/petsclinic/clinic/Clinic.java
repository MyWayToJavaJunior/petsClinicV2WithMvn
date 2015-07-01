package kz.petsclinic.clinic;
import kz.petsclinic.clinic.pets.*;

import java.util.ArrayList;

/**
 * Класс выполняющий действия над массивом персон
 */
public class Clinic {
    /**
     * максимальное количество персон в клинике
     */
    private final static int MAX_PERSONS_IN_CLINIC = 100;
    /**
     * массив персон
     */
    private ArrayList<Person> persons = new ArrayList<Person>(MAX_PERSONS_IN_CLINIC);

    /**
     * Добавление персоны в массив
     * @param nameOfPerson Имя персоны
     * @param nameOfPet Имя животного персоны
     * @param typeOfPet Тип животного, через условный порядковый номер
     */
    public void addPerson(String nameOfPerson, String nameOfPet, int typeOfPet) {
        Pet pet;
        switch (typeOfPet) {
            default:
            case 1:     pet = new Cat(nameOfPet);
                        break;
            case 2:     pet = new Dog(nameOfPet);
                        break;
            case 3:     pet = new Bird(nameOfPet);
                        break;
        }
        Person person = new Person(nameOfPerson, pet);
        persons.add(person);
    }

    /**
     * демонстрация всех Персон массива
     * при условии что массив не пустой
     */
    public void viewAllPersons() {
        if (!persons.isEmpty()) {
            for (Person person : persons) {
                System.out.println(person);
            }
        }
    }

    /**
     * Возвращает тип врага-животного по имени животного
     * @param nameOfPet имя животного
     * @return тип врага-животного
     */
    public Class<? extends Pet> getClassEnemyOfPetByName(String nameOfPet) {
        return persons.get(findPersonIdByPetName(nameOfPet)).getClassEnemyOfPet();
    }

    /**
     * Рекурсивно удаляет всех животных входящего типа
     * @param petClass входящий тип животного
     */
    public void remPersonsByClassOfPet(Class<? extends Pet> petClass) {
        for (int i = 0; i < persons.size(); i++) {
            if (petClass.equals(persons.get(i).getClassOfPet())) {
                remPersonById(i);
                remPersonsByClassOfPet(petClass);
            }
        }
    }

    /**
     * Удаляет Перрсону по номеру через метод Коллекции
     * @param idPerson номер Персоны в Коллекции
     */
    public void remPersonById(int idPerson) {
        persons.remove(idPerson);
    }

    /**
     * Возвращает строку возвращаемую методом toString,
     * класса Persona, по имени Персоны
     * @param nameOfPerson имя персоны
     * @return строка описания конкретной Персоны
     */
    public String viewPersonByName(String nameOfPerson) {
        String result = "";
        for (int i = 0; i < persons.size(); i++) {
            if (nameOfPerson.equals(persons.get(i).getNameOfPerson()))
                result = persons.get(i).toString();
        }
        return result;
    }

    /**
     * Возвращает строку возвращаемую методом toString,
     * класса Persona, по имени животного
     * @param nameOfPet имя животного
     * @return строка описания конкретной Персоны
     */
    public String viewPersonByPetName(String nameOfPet) {
        String result = "";
        for (int i = 0; i < persons.size(); i++) {
            if (nameOfPet.equals(persons.get(i).getPetNameOfPerson()))
                result = persons.get(i).toString();
        }
        return result;
    }

    /**
     * Удаление Персоны по имени
     * @param nameOfPerson имя Персоны
     */
    public void remPersonByName(String nameOfPerson) {
        remPersonById(findPersonIdByPersonName(nameOfPerson));
    }

    /**
     * Удаление Персоны по имени животного
     * @param nameOfPet имя животного
     */
    public void remPersonByPetName(String nameOfPet) {
        remPersonById(findPersonIdByPetName(nameOfPet));
    }

    /**
     * Возвращает ID Персоны по имени
     * @param nameOfPerson имя Персоны
     * @return ID Персоны
     */
    public int findPersonIdByPersonName(String nameOfPerson) {
        int result = -1;
        for (int i = 0; i < persons.size(); i++) {
            if (nameOfPerson.equals(persons.get(i).getNameOfPerson()))
                result = i;
        }
        return result;
    }

    /**
     * Возвращает ID Персоны по имени животного
     * @param petNameOfPerson имя животного
     * @return ID Персоны
     */
    public int findPersonIdByPetName(String petNameOfPerson) {
        int result = -1;
        for (int i = 0; i < persons.size(); i++) {
            if (petNameOfPerson.equals(persons.get(i).getPetNameOfPerson()))
                result = i;
        }
        return result;
    }

    /**
     * Переименование Персоны
     * @param nameOfPerson старое имя Персоны
     * @param newNameOfPerson новое имя Персоны
     */
    public void renPerson(String nameOfPerson, String newNameOfPerson) {
        Person person = persons.get(findPersonIdByPersonName(nameOfPerson));
        person.setNameOfPerson(newNameOfPerson);
    }

    /**
     * Переименование животного
     * @param nameOfPet старое имя животного
     * @param newNameOfPet новое имя животного
     */
    public void renPet(String nameOfPet, String newNameOfPet) {
        Person person = persons.get(findPersonIdByPetName(nameOfPet));
        person.setPetNameOfPerson(newNameOfPet);
    }

    /**
     * Проверка на существование персоны с заданным именем
     * @param nameOfPerson имя персоны
     * @return возвращает true если Персона с заданным именем есть в массиве
     */
    public boolean isPersonExistByName(String nameOfPerson) {
        boolean result = false;
        for (int i = 0; i < persons.size(); i++) {
            if (nameOfPerson.equals(persons.get(i).getNameOfPerson()))
                result = true;
        }
        return result;
    }

    /**
     * Проверка на существование животного с заданным именем
     * @param nameOfPet имя животного
     * @return возвращает true если существует персона с животным
     * имя которого совпадает с заданным
     */
    public boolean isPetExistByName(String nameOfPet) {
        boolean result = false;
        for (int i = 0; i < persons.size(); i++) {
            if (nameOfPet.equals(persons.get(i).getPetNameOfPerson()))
                result = true;
        }
        return result;
    }

    /**
     * Проверка на наличие мест в массиве
     * @return возвращает true если количество персон
     * не достигло максимального размера массива
     */
    public boolean isClinicFull() {
        return (getCountOfPerson() == MAX_PERSONS_IN_CLINIC) ? true : false;
    }

    /**
     * Проверка не пустой ли массив
     * @return возвращает true если в массиве нет
     * ни одной Персоны
     */
    public boolean isClinicEmpty() {
        return (getCountOfPerson() == 0) ? true : false;
    }

    /**
     * Возвращает количество Персон
     * @return возвращает количество Персон в массиве
     * используя метод Коллекции
     */
    public int getCountOfPerson() {
        return persons.size();
    }

}
