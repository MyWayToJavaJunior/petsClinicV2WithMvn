package kz.petsclinic.clinic;
import kz.petsclinic.clinic.pets.*;

import java.util.ArrayList;

/**
 * ����� ����������� �������� ��� �������� ������
 */
public class Clinic {
    /**
     * ������������ ���������� ������ � �������
     */
    private final static int MAX_PERSONS_IN_CLINIC = 100;
    /**
     * ������ ������
     */
    private ArrayList<Person> persons = new ArrayList<Person>(MAX_PERSONS_IN_CLINIC);

    /**
     * ���������� ������� � ������
     * @param nameOfPerson ��� �������
     * @param nameOfPet ��� ��������� �������
     * @param typeOfPet ��� ���������, ����� �������� ���������� �����
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
     * ������������ ���� ������ �������
     * ��� ������� ��� ������ �� ������
     */
    public void viewAllPersons() {
        if (!persons.isEmpty()) {
            for (Person person : persons) {
                System.out.println(person);
            }
        }
    }

    /**
     * ���������� ��� �����-��������� �� ����� ���������
     * @param nameOfPet ��� ���������
     * @return ��� �����-���������
     */
    public Class<? extends Pet> getClassEnemyOfPetByName(String nameOfPet) {
        return persons.get(findPersonIdByPetName(nameOfPet)).getClassEnemyOfPet();
    }

    /**
     * ���������� ������� ���� �������� ��������� ����
     * @param petClass �������� ��� ���������
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
     * ������� �������� �� ������ ����� ����� ���������
     * @param idPerson ����� ������� � ���������
     */
    public void remPersonById(int idPerson) {
        persons.remove(idPerson);
    }

    /**
     * ���������� ������ ������������ ������� toString,
     * ������ Persona, �� ����� �������
     * @param nameOfPerson ��� �������
     * @return ������ �������� ���������� �������
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
     * ���������� ������ ������������ ������� toString,
     * ������ Persona, �� ����� ���������
     * @param nameOfPet ��� ���������
     * @return ������ �������� ���������� �������
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
     * �������� ������� �� �����
     * @param nameOfPerson ��� �������
     */
    public void remPersonByName(String nameOfPerson) {
        remPersonById(findPersonIdByPersonName(nameOfPerson));
    }

    /**
     * �������� ������� �� ����� ���������
     * @param nameOfPet ��� ���������
     */
    public void remPersonByPetName(String nameOfPet) {
        remPersonById(findPersonIdByPetName(nameOfPet));
    }

    /**
     * ���������� ID ������� �� �����
     * @param nameOfPerson ��� �������
     * @return ID �������
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
     * ���������� ID ������� �� ����� ���������
     * @param petNameOfPerson ��� ���������
     * @return ID �������
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
     * �������������� �������
     * @param nameOfPerson ������ ��� �������
     * @param newNameOfPerson ����� ��� �������
     */
    public void renPerson(String nameOfPerson, String newNameOfPerson) {
        Person person = persons.get(findPersonIdByPersonName(nameOfPerson));
        person.setNameOfPerson(newNameOfPerson);
    }

    /**
     * �������������� ���������
     * @param nameOfPet ������ ��� ���������
     * @param newNameOfPet ����� ��� ���������
     */
    public void renPet(String nameOfPet, String newNameOfPet) {
        Person person = persons.get(findPersonIdByPetName(nameOfPet));
        person.setPetNameOfPerson(newNameOfPet);
    }

    /**
     * �������� �� ������������� ������� � �������� ������
     * @param nameOfPerson ��� �������
     * @return ���������� true ���� ������� � �������� ������ ���� � �������
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
     * �������� �� ������������� ��������� � �������� ������
     * @param nameOfPet ��� ���������
     * @return ���������� true ���� ���������� ������� � ��������
     * ��� �������� ��������� � ��������
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
     * �������� �� ������� ���� � �������
     * @return ���������� true ���� ���������� ������
     * �� �������� ������������� ������� �������
     */
    public boolean isClinicFull() {
        return (getCountOfPerson() == MAX_PERSONS_IN_CLINIC) ? true : false;
    }

    /**
     * �������� �� ������ �� ������
     * @return ���������� true ���� � ������� ���
     * �� ����� �������
     */
    public boolean isClinicEmpty() {
        return (getCountOfPerson() == 0) ? true : false;
    }

    /**
     * ���������� ���������� ������
     * @return ���������� ���������� ������ � �������
     * ��������� ����� ���������
     */
    public int getCountOfPerson() {
        return persons.size();
    }

}
