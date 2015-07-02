package kz.petsclinic.clinic.io;
import java.util.Scanner;

/**
 * Работа с вводом
 */
public class InputInterface {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Получить строку
     * @return возвращает строку
     */
    public String getStr() {
        return scanner.next();
    }
}
