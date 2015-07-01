package kz.petsclinic.clinic;

import kz.petsclinic.clinic.pets.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * �������� ������ ��� ������ � �������� ������
 */
public class ClinicTest {

    private static final String NAME_OF_FIRST_PERSON = "Vasily";
    private static final String NAME_OF_SECOND_PERSON = "Tuz";
    private static final String NAME_OF_THIRD_PERSON = "Inokenti";
    private static final String NAME_OF_PET_FIRST_PERSON = "Vaska";
    private static final String NAME_OF_PET_SECOND_PERSON = "Tuzik";
    private static final String NAME_OF_PET_THIRD_PERSON = "Kesha";
    private static final Pet FIRST_INPUT_PET = new Cat(NAME_OF_PET_FIRST_PERSON);
    private static final Pet SECOND_INPUT_PET = new Dog(NAME_OF_PET_SECOND_PERSON);
    private static final Pet THIRD_INPUT_PET = new Bird(NAME_OF_PET_THIRD_PERSON);
    private static final Person FIRST_INPUT_PERSON = new Person(NAME_OF_FIRST_PERSON, FIRST_INPUT_PET);
    private static final Person SECOND_INPUT_PERSON = new Person(NAME_OF_SECOND_PERSON, SECOND_INPUT_PET);
    private static final Person THIRD_INPUT_PERSON = new Person(NAME_OF_THIRD_PERSON, THIRD_INPUT_PET);
    private static final int NUMBER_OF_CAT_TYPE = 1;
    private static final int NUMBER_OF_DOG_TYPE = 2;
    private static final int NUMBER_OF_BIRD_TIPE = 3;
    private static final int COUNT_OF_PERSONS_AFTER_USE_ADD_METHOD = 3;


    private Clinic clinic = new Clinic();
    private ArrayList<Person> expectedPersons = new ArrayList<Person>(clinic.getMaxPersonsInClinic());
    private ArrayList<Person> actualPersons;

    public ClinicTest() {
        expectedPersons.add(FIRST_INPUT_PERSON);
        expectedPersons.add(SECOND_INPUT_PERSON);
        expectedPersons.add(THIRD_INPUT_PERSON);
    }

    /**
     * ���������� ���������� ���� �����������
     * ��� ������������� ������
     * ������ � ������(���������) ������
     * ���������� ������ Clinic.
     * � ���������� ������������ ��� ������������ �������
     */
    public void addPersonsToClinic() {
        clinic.addPerson(NAME_OF_FIRST_PERSON, NAME_OF_PET_FIRST_PERSON, NUMBER_OF_CAT_TYPE);
        clinic.addPerson(NAME_OF_SECOND_PERSON, NAME_OF_PET_SECOND_PERSON, NUMBER_OF_DOG_TYPE);
        clinic.addPerson(NAME_OF_THIRD_PERSON, NAME_OF_PET_THIRD_PERSON, NUMBER_OF_BIRD_TIPE);
    }

    public void addPersonsToMaxCountOfClinic() {
        for (int i = 0; i < clinic.getMaxPersonsInClinic(); i++) {
            clinic.addPerson("nameOfPerson" + i, "nameOfPet" + i, NUMBER_OF_CAT_TYPE);
        }
    }
    /**
     * ��������� ���������� �������(���������) ������
     * � ��������(���������) ��������������� � �������
     * ������ AddPerson ������ Clinic
     * ����� ����� addPersonToClinic()
     * !��� ������� ��������� � �������,
     * � ������������ ������, �.� �
     * ���� �� ���� ��� �������� ���������
     * � asssert
     * @throws Exception ����������� ������
     * ���� �������(���������) ������������ � ������
     * �� ������.
     */
    @Test
    public void testAddPerson() throws Exception {
        addPersonsToClinic();
        actualPersons = clinic.getPersonsArray();
        assertEquals(expectedPersons.toString(), actualPersons.toString());
    }

    @Test
    public void testViewAllPersons() throws Exception {

    }

    /**
     * ��������� ���������� ������ ����� ���������
     * � ����������� �� ����� ��������� �������
     * ������ Clinic, ������������ �����
     * AddPerson ������ Clinic ����� �����
     * addPersonToClinic() ��� ����������
     * �������(���������) ������
     * @throws Exception ����������� ������
     * ���� ������ ����� ���������, ��������� � ����������, �� �����
     */
    @Test
    public void testGetClassEnemyOfPetByName() throws Exception {
        addPersonsToClinic();
        final Class<? extends Pet> EXPECTED_CLASS_ENEMY_OF_PET_FIRST_PERSON = Bird.class;
        final Class<? extends Pet> ACTUAL_ENEMY_OF_PET_CLASS = clinic.getClassEnemyOfPetByName(NAME_OF_PET_FIRST_PERSON);
        assertEquals(EXPECTED_CLASS_ENEMY_OF_PET_FIRST_PERSON, ACTUAL_ENEMY_OF_PET_CLASS);
    }

    @Test
    public void testRemPersonsByClassOfPet() throws Exception {

    }

    @Test
    public void testRemPersonById() throws Exception {

    }

    @Test
    public void testViewPersonByName() throws Exception {

    }

    @Test
    public void testViewPersonByPetName() throws Exception {

    }

    @Test
    public void testRemPersonByName() throws Exception {
        addPersonsToClinic();
        final int EXPECTED_RESULT_BEFORE_REM = 0;
        final int ACTUAL_RESULT_BEFORE_REM = clinic.findPersonIdByPersonName(NAME_OF_FIRST_PERSON);
        assertEquals(EXPECTED_RESULT_BEFORE_REM, ACTUAL_RESULT_BEFORE_REM);
        clinic.remPersonByName(NAME_OF_FIRST_PERSON);
        final int EXPECTED_VALUE_AFTER_REM = -1;
        final int ACTUAL_VALUE_AFTER_REM = clinic.findPersonIdByPersonName(NAME_OF_FIRST_PERSON);
        assertEquals(EXPECTED_VALUE_AFTER_REM, ACTUAL_VALUE_AFTER_REM);
    }

    @Test
    public void testRemPersonByPetName() throws Exception {
        addPersonsToClinic();
        final int EXPECTED_RESULT_BEFORE_REM = 0;
        final int ACTUAL_RESULT_BEFORE_REM = clinic.findPersonIdByPetName(NAME_OF_PET_FIRST_PERSON);
        assertEquals(EXPECTED_RESULT_BEFORE_REM, ACTUAL_RESULT_BEFORE_REM);
        clinic.remPersonByPetName(NAME_OF_PET_FIRST_PERSON);
        final int EXPECTED_VALUE_AFTER_REM = -1;
        final int ACTUAL_VALUE_AFTER_REM = clinic.findPersonIdByPetName(NAME_OF_PET_FIRST_PERSON);
        assertEquals(EXPECTED_VALUE_AFTER_REM, ACTUAL_VALUE_AFTER_REM);
    }

    @Test
    public void testFindPersonIdByPersonName() throws Exception {
        final int EXPECTED_RESULT_BEFORE_ADD = -1;
        final int ACTUAL_RESULT_BEFORE_ADD = clinic.findPersonIdByPersonName(NAME_OF_FIRST_PERSON);
        assertEquals(EXPECTED_RESULT_BEFORE_ADD, ACTUAL_RESULT_BEFORE_ADD);
        addPersonsToClinic();
        final int EXPECTED_VALUE_AFTER_ADD = 0;
        final int ACTUAL_VALUE_AFTER_ADD = clinic.findPersonIdByPersonName(NAME_OF_FIRST_PERSON);
        assertEquals(EXPECTED_VALUE_AFTER_ADD, ACTUAL_VALUE_AFTER_ADD);
    }

    @Test
    public void testFindPersonIdByPetName() throws Exception {
        final int EXPECTED_RESULT_BEFORE_ADD = -1;
        final int ACTUAL_RESULT_BEFORE_ADD = clinic.findPersonIdByPetName(NAME_OF_PET_FIRST_PERSON);
        assertEquals(EXPECTED_RESULT_BEFORE_ADD, ACTUAL_RESULT_BEFORE_ADD);
        addPersonsToClinic();
        final int EXPECTED_VALUE_AFTER_ADD = 0;
        final int ACTUAL_VALUE_AFTER_ADD = clinic.findPersonIdByPetName(NAME_OF_PET_FIRST_PERSON);
        assertEquals(EXPECTED_VALUE_AFTER_ADD, ACTUAL_VALUE_AFTER_ADD);
    }

    @Test
    public void testRenPerson() throws Exception {
        final boolean EXPECTED_RESULT = true;
        boolean ACTUAL_RESULT = false;
        addPersonsToClinic();
        final String NAME_OF_REN_PERSON = NAME_OF_FIRST_PERSON;
        final String EXPECTED_NEW_NAME_OF_PERSON = "expectedNewNameOfPerson";
        clinic.renPerson(NAME_OF_REN_PERSON, EXPECTED_NEW_NAME_OF_PERSON);
        if (clinic.findPersonIdByPersonName(EXPECTED_NEW_NAME_OF_PERSON) != -1) ACTUAL_RESULT = true;
        assertEquals(EXPECTED_RESULT, ACTUAL_RESULT);
    }

    @Test
    public void testRenPet() throws Exception {
        final boolean EXPECTED_RESULT = true;
        boolean ACTUAL_RESULT = false;
        addPersonsToClinic();
        final String NAME_OF_REN_PET = NAME_OF_PET_FIRST_PERSON;
        final String EXPECTED_NEW_NAME_OF_PET = "expectedNewNameOfPet";
        clinic.renPet(NAME_OF_REN_PET, EXPECTED_NEW_NAME_OF_PET);
        if (clinic.findPersonIdByPetName(EXPECTED_NEW_NAME_OF_PET) != -1) ACTUAL_RESULT = true;
        assertEquals(EXPECTED_RESULT, ACTUAL_RESULT);
    }

    /**
     * ��������� ���������� � ����������� ��������
     * ������������� ������� isPersonExistByName()
     * ������ Clinic, �� � ����� ���������� � ����
     * ������ ������� AddPerson ������ Clinic
     * ����� ����� addPersonToClinic()
     * @throws Exception ����������� ������ ����
     * �� ��� ����� ���������� ������ ��������� ��������
     * �� �������� � ����������
     */
    @Test
    public void testIsPersonExistByName() throws Exception {
        final boolean EXPECTED_VALUE_BEFORE_ADD = false;
        final boolean ACTUAL_VALUE_BEFORE_ADD = clinic.isPersonExistByName(NAME_OF_THIRD_PERSON);
        assertEquals(EXPECTED_VALUE_BEFORE_ADD, ACTUAL_VALUE_BEFORE_ADD);
        addPersonsToClinic();
        final boolean EXPECTED_VALUE_AFTER_ADD = true;
        final boolean ACTUAL_VALUE_AFTER_ADD = clinic.isPersonExistByName(NAME_OF_THIRD_PERSON);
        assertEquals(EXPECTED_VALUE_AFTER_ADD, ACTUAL_VALUE_AFTER_ADD);
    }

    /**
     * ��������� ���������� � ����������� ��������
     * ������������� ������� isPetExistByName()
     * ������ Clinic, �� � ����� ���������� � ����
     * ������ ������� AddPerson ������ Clinic
     * ����� ����� addPersonToClinic()
     * @throws Exception ����������� ������ ����
     * �� ��� ����� ���������� ������ ��������� ��������
     * �� �������� � ����������
     */
    @Test
    public void testIsPetExistByName() throws Exception {
        final boolean EXPECTED_VALUE_BEFORE_ADD = false;
        final boolean ACTUAL_VALUE_BEFORE_ADD = clinic.isPetExistByName(NAME_OF_PET_SECOND_PERSON);
        assertEquals(EXPECTED_VALUE_BEFORE_ADD, ACTUAL_VALUE_BEFORE_ADD);
        addPersonsToClinic();
        final boolean EXPECTED_VALUE_AFTER_ADD = true;
        final boolean ACTUAL_VALUE_AFTER_ADD = clinic.isPetExistByName(NAME_OF_PET_SECOND_PERSON);
        assertEquals(EXPECTED_VALUE_AFTER_ADD, ACTUAL_VALUE_AFTER_ADD);
    }

    /**
     * ��������� ���������� � ����������� ��������
     * ������������� ������� isClinicFull()
     * ������ Clinic, �� � ����� ���������� � ���� 100
     * ������ ������� AddPerson ������ Clinic
     * ����� ����� addPersonsToMaxCountOfClinic()
     * @throws Exception ����������� ������ ����
     * �� ��� ����� ���������� ������ ��������� ��������
     * �� �������� � ����������
     */
    @Test
    public void testIsClinicFull() throws Exception {
        final boolean EXPECTED_VALUE_BEFORE_ADD = false;
        final boolean ACTUAL_VALUE_BEFORE_ADD = clinic.isClinicFull();
        assertEquals(EXPECTED_VALUE_BEFORE_ADD, ACTUAL_VALUE_BEFORE_ADD);
        addPersonsToMaxCountOfClinic();
        final boolean EXPECTED_VALUE_AFTER_ADD = true;
        final boolean ACTUAL_VALUE_AFTER_ADD = clinic.isClinicFull();
        assertEquals(EXPECTED_VALUE_AFTER_ADD, ACTUAL_VALUE_AFTER_ADD);
    }

    /**
     * ��������� ���������� � ����������� ��������
     * ������������� ������� isClinicEmpty()
     * ������ Clinic, �� � ����� ���������� � ����
     * ������ ������� AddPerson ������ Clinic
     * ����� ����� addPersonToClinic()
     * @throws Exception ����������� ������ ����
     * �� ��� ����� ���������� ������ ��������� ��������
     * �� �������� � ����������
     */
    @Test
    public void testIsClinicEmpty() throws Exception {
        final boolean EXPECTED_VALUE_BEFORE_ADD = true;
        final boolean ACTUAL_VALUE_BEFORE_ADD = clinic.isClinicEmpty();
        assertEquals(EXPECTED_VALUE_BEFORE_ADD, ACTUAL_VALUE_BEFORE_ADD);
        addPersonsToClinic();
        final boolean EXPECTED_VALUE_AFTER_ADD = false;
        final boolean ACTUAL_VALUE_AFTER_ADD = clinic.isClinicEmpty();
        assertEquals(EXPECTED_VALUE_AFTER_ADD, ACTUAL_VALUE_AFTER_ADD);
    }

    /**
     * ��������� ���������� � ����������
     * �������� ���������� ������ � �������(���������)
     * ���������� ������ Clinic �������
     * getCountOfPersons() ������ Clinic,
     * ��������� �������� �����������
     * ������ ����� ������������ ������
     * addPersonsToClinic()
     * @throws Exception ���������� ������ ����
     * ��������� ���������� ������ �� ���������
     * � ���������� �������
     */
    @Test
    public void testGetCountOfPersons() throws Exception {
        addPersonsToClinic();
        final int EXPECTED_COUNT_OF_PERSONS = COUNT_OF_PERSONS_AFTER_USE_ADD_METHOD;
        final int ACTUAL_COUNT_OF_PERSONS = clinic.getCountOfPersons();
        assertEquals(EXPECTED_COUNT_OF_PERSONS, ACTUAL_COUNT_OF_PERSONS);
    }
}