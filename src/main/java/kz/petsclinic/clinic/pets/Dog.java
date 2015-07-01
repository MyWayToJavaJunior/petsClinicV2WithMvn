package kz.petsclinic.clinic.pets;
/**
 * ���, ������������ �� ���������
 */
public class Dog extends Pet {

    /**
     * ������ ���
     */
    private static final String DOG_ABILITY = "BARK";

    /**
     * ����� ���
     */
    private static final Class ENEMY_OF_DOGS = Cat.class;

    /**
     * �����������, �������� ��������: ��� ���������
     * � ������ ��������� � ����������� �����������
     * @param nameOfPet ��� ���������
     */
    public Dog(String nameOfPet) {
        super(nameOfPet, DOG_ABILITY);
    }

    /**
     * ��������������� ������ ������������� ����� ����� ���������
     * @return ���������� ����� ����� ���������
     */
    @Override
    public Class<? extends Pet> doAction() {
        return ENEMY_OF_DOGS;
    }
}
