package kz.petsclinic.clinic.pets;
/**
 * �����, ������������� �� ���������
 */
public class Bird extends Pet{

    /**
     * ������ �����
     */
    private static final String BIRD_ABILITY = "FLY";

    /**
     * ����� �����
     */
    private static final Class ENEMY_OF_BIRDS = Dog.class;

    /**
     * �����������, �������� ��������: ��� ���������
     * � ������ ��������� � ����������� �����������
     * @param nameOfPet ��� ���������
     */
    public Bird(String nameOfPet) {
        super(nameOfPet, BIRD_ABILITY);
    }

    /**
     * ��������������� ������ ������������� ����� ����� ���������
     * @return ���������� ����� ����� ���������
     */
    @Override
    public Class<? extends Pet> doAction() {
        return ENEMY_OF_BIRDS;
    }
}
