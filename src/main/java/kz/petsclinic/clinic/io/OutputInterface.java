package kz.petsclinic.clinic.io;
/**
 * ������ � �������
 */
public class OutputInterface {

    /**
     * ������� �������� ������
     * @param prnt ������� ������
     */
    public void pr(String prnt) {
        System.out.println(prnt);
    }

    /**
     * ������� ���� ���������
     */
    public void showFirstMenu() {
        pr("Select the operation: 1 - ADD, 2 - View all Persons, 3 - Find by Person name," +
                " 4 - Find by Pet name, 5 - Rename Person, 6 - Rename Pet," +
                " 7 - Remove Person by name, 8 - Remove Person by Pet name, 9 - Do pet action, 0 - QUIT");
    }

    /**
     * ����������� ��� �������
     */
    public void askForNameOfPerson() {
        pr("Enter name of Person");
    }

    /**
     * ����������� ����� ��� �������
     */
    public void askForNewNameOfPerson() {
        pr("Enter new name of Person");
    }

    /**
     * ����������� ��� ���������
     */
    public void askForPetName() {
        pr("Enter name of Pet");
    }

    /**
     * ����������� ����� ��� �������
     */
    public void askForNewPetName() {
        pr("Enter new name of Pet");
    }

    /**
     * ����������� ��� ���������
     */
    public void askForPetType() {
        pr("Enter type of Pet: 1 - CAT, 2 - DOG, 3 - BIRD (default CAT)");
    }

    /**
     * �������� ��� ������� �� �������
     */
    public void saidPersonNotFound() {
        pr("Person not found");
    }

    /**
     *  �������� ��� �������� �� �������
     */
    public void saidPetNotFound() {
        pr("Pet not found");
    }

    /**
     *  �������� ��� ������� ��� ����������
     */
    public void saidPersonAlreadyExist() {
        pr("Person already exist");
    }

    /**
     *  �������� ��� � ������� ��� ������
     */
    public void saidNoPersonsInClinic() {
        pr("No Persons in Clinic");
    }

    /**
     * �������� ��� � ������� ��� �����
     */
    public void saidClinicFull() {
        pr("Clinic is full, remove unnecessary Persons");
    }

    /**
     * �������� ��� �������� � ������ nameOfPet
     * ��� ���� �������� ���� classOfAnimalThatIsEaten
     * @param nameOfPet ��� ���������
     * @param classOfAnimalThatIsEaten ��������� �����
     */
    public void saidPetEatingOtherPets(String nameOfPet, String classOfAnimalThatIsEaten) {
        pr(nameOfPet + " ate " + classOfAnimalThatIsEaten + "'s OM!NOM!NOM!");
    }
}
