package kz.petsclinic.clinic.io;
import java.util.Scanner;

/**
 * ������ � ������
 */
public class InputInterface {
    private Scanner scanner = new Scanner(System.in);

    /**
     * �������� ������
     * @return ���������� ������
     */
    public String getStr() {
        return scanner.next();
    }
}
