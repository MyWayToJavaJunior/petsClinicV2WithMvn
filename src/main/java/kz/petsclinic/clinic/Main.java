package kz.petsclinic.clinic;

import kz.petsclinic.clinic.controller.Controller;

/**
 * @author DK
 * @version 1.0.1
 * Основной класс, в котором иницализируется контроллер
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller.Builder().build();
        controller.action();
    }
}
