package kz.petsclinic.clinic.io;
/**
 * Работа с выводом
 */
public class OutputInterface {

    /**
     * Выводит входящую строку
     * @param prnt входщая строка
     */
    public void pr(String prnt) {
        System.out.println(prnt);
    }

    /**
     * Главное меню программы
     */
    public void showFirstMenu() {
        pr("Select the operation: 1 - ADD, 2 - View all Persons, 3 - Find by Person name," +
                " 4 - Find by Pet name, 5 - Rename Person, 6 - Rename Pet," +
                " 7 - Remove Person by name, 8 - Remove Person by Pet name, 9 - Do pet action, 0 - QUIT");
    }

    /**
     * Запрашиваем имя Персоны
     */
    public void askForNameOfPerson() {
        pr("Enter name of Person");
    }

    /**
     * Запрашиваем новое имя Персоны
     */
    public void askForNewNameOfPerson() {
        pr("Enter new name of Person");
    }

    /**
     * Запрашиваем имя животного
     */
    public void askForPetName() {
        pr("Enter name of Pet");
    }

    /**
     * Запрашиваем новое имя живного
     */
    public void askForNewPetName() {
        pr("Enter new name of Pet");
    }

    /**
     * Запрашиваем тип животного
     */
    public void askForPetType() {
        pr("Enter type of Pet: 1 - CAT, 2 - DOG, 3 - BIRD (default CAT)");
    }

    /**
     * Сообщаем что Персона не найдена
     */
    public void saidPersonNotFound() {
        pr("Person not found");
    }

    /**
     *  Сообщаем что животное не найдено
     */
    public void saidPetNotFound() {
        pr("Pet not found");
    }

    /**
     *  Сообщаем что Персона уже существует
     */
    public void saidPersonAlreadyExist() {
        pr("Person already exist");
    }

    /**
     *  Сообщаем что в клинике нет Персон
     */
    public void saidNoPersonsInClinic() {
        pr("No Persons in Clinic");
    }

    /**
     * Сообщаем что в клинике нет места
     */
    public void saidClinicFull() {
        pr("Clinic is full, remove unnecessary Persons");
    }

    /**
     * Сообщаем что животное с именем nameOfPet
     * ест всех животных типа classOfAnimalThatIsEaten
     * @param nameOfPet Имя животного
     * @param classOfAnimalThatIsEaten поедаемый класс
     */
    public void saidPetEatingOtherPets(String nameOfPet, String classOfAnimalThatIsEaten) {
        pr(nameOfPet + " ate " + classOfAnimalThatIsEaten + "'s OM!NOM!NOM!");
    }
}
