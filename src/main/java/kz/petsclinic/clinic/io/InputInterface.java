package kz.petsclinic.clinic.io;
import java.util.Scanner;

/**
 * ������ � ������
 */
public class InputInterface {
    private Scanner scanner = new Scanner(System.in);

    /**
     * �������� �����
     * @return ���������� ����� ���� int
     */
    public int getInt() {
        return scanner.nextInt();
    }

    /**
     * �������� ������
     * @return ���������� ������
     */
    public String getStr() {
        return scanner.next();
    }
}
