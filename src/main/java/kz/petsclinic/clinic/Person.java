package kz.petsclinic.clinic;

import kz.petsclinic.clinic.pets.Pet;

/**
 * �������
 */
public class Person {

    /**
     * ��� �������
     */
    private String nameOfPerson;

    /**
     * �������� �������
     */
    private Pet petOfPerson;

    /**
     * ����������� �������, �������������� ���� ��������� ���������
     * @param nameOfPerson ��� �������
     * @param petOfPerson �������� �������
     */
    public Person(String nameOfPerson, Pet petOfPerson) {
        this.nameOfPerson = nameOfPerson;
        this.petOfPerson = petOfPerson;
    }

    /**
     * �������� ��� �������
     * @return ���������� ��� �������
     */
    public String getNameOfPerson() {
        return this.nameOfPerson;
    }

    /**
     * �������� ��� ��������� �������
     * @return ���������� ��� ��������� �������
     * ��������� ������� ������ Pet
     */
    public String getPetNameOfPerson() {
        return this.petOfPerson.getNameOfPet();
    }

    /**
     * ������������� ��� �������
     * @param nameOfPerson ����� ��� �������
     */
    public void setNameOfPerson(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
    }

    /**
     * �������� ����� ����� ���������
     * @return ���������� ����� ����� ���������
     * ��������� ����� ������ Pet
     */
    public Class<? extends Pet> getClassEnemyOfPet() {
        return this.petOfPerson.doAction();
    }

    /**
     * �������� ����� ���������
     * @return ���������� ����� ���������
     * ��������� ������� ������
     */
    public Class<? extends Pet> getClassOfPet() {
        return petOfPerson.getClass();
    }

    /**
     * ������������� ��� ��������� �������
     * @param nameOfPet ����� ��� ���������
     */
    public void setPetNameOfPerson(String nameOfPet) {
        this.petOfPerson.setNameOfPet(nameOfPet);
    }

    /**
     * ��������������� ������ ������������� �������� �������
     * @return ���������� ������ ���������� �������� �������
     */
    @Override
    public String toString() {
        return "Name of Person: " + this.getNameOfPerson() + ", " + this.petOfPerson.toString();
    }
}
