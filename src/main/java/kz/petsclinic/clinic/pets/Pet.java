package kz.petsclinic.clinic.pets;
/**
 * ��������
 */
public abstract class Pet {
    private final String typeOfPet;
    private final String ability;
    private String nameOfPet;

    /**
     * ����������� ���������,
     * �������������� ���� ��������� �������
     * � � ������� ������ ������ ������
     * @param nameOfPet ��� ���������
     * @param ability ������ ���������
     */
    public Pet(String nameOfPet, String ability) {
        this.nameOfPet = nameOfPet;
        this.ability = ability;
        this.typeOfPet = this.getClass().getName();
    }

    /**
     * �������� ��� ���������
     * @return ���������� ������ ���������� ��� ���������
     */
    public String getNameOfPet() {
        return nameOfPet;
    }

    /**
     * �������� ������ ���������
     * @return ���������� ������ ���������� ������ ���������
     */
    public String getAbility() {
        return ability;
    }

    /**
     * �������� ��� ���������
     * @return ���������� ��� ���������
     */
    public String getTypeOfPet() {
        return typeOfPet;
    }

    /**
     * ���������� ��� ���������
     * @param nameOfPet ����� ��� ���������
     */
    public void setNameOfPet(String nameOfPet) {
        this.nameOfPet = nameOfPet;
    }

    /**
     * ��������� ������ ����� ���������
     * @return ���������� ����� ����� ���������
     */
    public Class<? extends Pet> doAction() {
        return this.getClass();
    }

    /**
     * ��������������� ������ ������������� �������� ���������
     * @return ���������� ������ ���������� �������� ���������
     */
    @Override
    public String toString() {
        return "Type of pet is: " + getTypeOfPet() + ", name: " + getNameOfPet() + ", ability: " + getAbility();
    }
}
