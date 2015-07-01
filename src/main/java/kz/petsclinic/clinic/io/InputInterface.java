package kz.petsclinic.clinic.io;
import java.util.Scanner;

/**
 * Работа с вводом
 */
public class InputInterface {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Получить число
     * @return возвращает число типа int
     */
    public int getInt() {
        return scanner.nextInt();
    }

    /**
     * Получить строку
     * @return возвращает строку
     */
    public String getStr() {
        return scanner.next();
    }
}
