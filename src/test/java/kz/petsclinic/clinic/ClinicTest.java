package kz.petsclinic.clinic;

import kz.petsclinic.clinic.pets.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Проверка класса для работы с массивом Персон
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
    private static final Class<? extends Pet> EXPECTED_CLASS_ENEMY_OF_PET_FIRST_PERSON = Bird.class;

    private Clinic clinic = new Clinic();
    private ArrayList<Person> expectedPersons = new ArrayList<Person>(100);
    private ArrayList<Person> actualPersons;

    public ClinicTest() {
        expectedPersons.add(FIRST_INPUT_PERSON);
        expectedPersons.add(SECOND_INPUT_PERSON);
        expectedPersons.add(THIRD_INPUT_PERSON);
    }

    public void addPersonsToClinic() {
        clinic.addPerson(NAME_OF_FIRST_PERSON, NAME_OF_PET_FIRST_PERSON, NUMBER_OF_CAT_TYPE);
        clinic.addPerson(NAME_OF_SECOND_PERSON, NAME_OF_PET_SECOND_PERSON, NUMBER_OF_DOG_TYPE);
        clinic.addPerson(NAME_OF_THIRD_PERSON, NAME_OF_PET_THIRD_PERSON, NUMBER_OF_BIRD_TIPE);
    }
    @Test
    public void testAddPerson() throws Exception {
        addPersonsToClinic();
        actualPersons = clinic.getPersonsArray();
        assertEquals(expectedPersons.toString(), actualPersons.toString());
    }

    @Test
    public void testViewAllPersons() throws Exception {
        clinic.viewAllPersons();
    }

    @Test
    public void testGetClassEnemyOfPetByName() throws Exception {
        addPersonsToClinic();
        Class<? extends Pet> actualEnemyOfPetClass = clinic.getClassEnemyOfPetByName(NAME_OF_PET_FIRST_PERSON);
        assertEquals(EXPECTED_CLASS_ENEMY_OF_PET_FIRST_PERSON, actualEnemyOfPetClass);
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

    }

    @Test
    public void testRemPersonByPetName() throws Exception {

    }

    @Test
    public void testFindPersonIdByPersonName() throws Exception {

    }

    @Test
    public void testFindPersonIdByPetName() throws Exception {

    }

    @Test
    public void testRenPerson() throws Exception {

    }

    @Test
    public void testRenPet() throws Exception {

    }

    @Test
    public void testIsPersonExistByName() throws Exception {

    }

    @Test
    public void testIsPetExistByName() throws Exception {

    }

    @Test
    public void testIsClinicFull() throws Exception {

    }

    @Test
    public void testIsClinicEmpty() throws Exception {
        boolean expectedValueBeforeAdd = true;
        boolean actualValueBeforeAdd = clinic.isClinicEmpty();
        assertEquals(expectedValueBeforeAdd, actualValueBeforeAdd);
        addPersonsToClinic();
        boolean expectedValueAfterAdd = false;
        boolean actualValueAfterAdd = clinic.isClinicEmpty();
        assertEquals(expectedValueAfterAdd, actualValueAfterAdd);
    }

    @Test
    public void testGetCountOfPerson() throws Exception {

    }
}