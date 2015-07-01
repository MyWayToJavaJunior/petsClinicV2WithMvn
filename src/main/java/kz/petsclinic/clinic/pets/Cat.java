package kz.petsclinic.clinic.pets;
/**
 * ���, ������������ �� ���������
 */
public class Cat extends Pet {

    /**
     * ������ ����
     */
    private static final String CAT_ABILITY = "CLIMB UP TREES";

    /**
     * ����� ����
     */
    private static final Class ENEMY_OF_CATS = Bird.class;

    /**
     * �����������, �������� ��������: ��� ���������
     * � ������ ��������� � ����������� �����������
     * @param nameOfPet ��� ���������
     */
    public Cat(String nameOfPet) {
        super(nameOfPet, CAT_ABILITY);
    }

    /**
     * ��������������� ������ ������������� ����� ����� ���������
     * @return ���������� ����� ����� ���������
     */
    @Override
    public Class<? extends Pet> doAction() {
        return ENEMY_OF_CATS;
    }
}
