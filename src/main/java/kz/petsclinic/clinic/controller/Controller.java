package kz.petsclinic.clinic.controller;
import kz.petsclinic.clinic.Clinic;
import kz.petsclinic.clinic.io.InputInterface;
import kz.petsclinic.clinic.io.OutputInterface;


/**
 * Контроллер
 * исползуется паттерн Builder
 */
public class Controller {

    /**
     * Переменная отвечающая за выход из программы
     */
    private boolean exitFromProgram = false;

    /**
     * Обьявляется экземпляр клиники, интерфейсов ввода и вывода
     */
    private final Clinic clinic;
    private final InputInterface inputInterface;
    private final OutputInterface outputInterface;

    /**
     * Класс создающий и инициализирующий значениями поля
     * которые будут переданны в конструктор класса Controller
     */
    public static class Builder {
        private final Clinic clinic;
        private final InputInterface inputInterface;
        private final OutputInterface outputInterface;

        public Builder() {
            this.clinic = new Clinic();
            this.inputInterface = new InputInterface();
            this.outputInterface = new OutputInterface();
        }

        /**
         * Получаем ссылку на экхемляр класса
         * @return возвращает экземпляр
         * класса Controller
         */
        public Controller build() {
            return new Controller(this);
        }
    }

    /**
     * Экземпляр класса для инциализации
     * класса Controller
     * @param builder класс для иницализации
     */
    private Controller(Builder builder) {
        clinic = builder.clinic;
        inputInterface = builder.inputInterface;
        outputInterface = builder.outputInterface;
    }

    /**
     * Метод содержит цикл в котором вызывается
     * метод выводящий основное меню
     * пока переменная отвечающая за выход не изменит
     * свое содержимое на удовлетворяющее для выхода
     */
    public void action() {
        while (!exitFromProgram) {
            firstMenu();
        }

    }

    /**
     * Основное меню.
     */
    public void firstMenu() {
        outputInterface.showFirstMenu();
        int choicesFromFirstMenu = inputInterface.getInt();
        switch (choicesFromFirstMenu) {
            case 1:     addPerson();
                        break;
            case 2:     viewAllPersons();
                        break;
            case 3:     findByNameOfPersonAndView();
                        break;
            case 4:     findByNameOfPetAndView();
                        break;
            case 5:     renPerson();
                        break;
            case 6:     renPet();
                        break;
            case 7:     remByPersonName();
                        break;
            case 8:     remByPetName();
                        break;
            case 9:     petDoAction();
                        break;
            case 0:     exitFromProgram = true;
                        return;
            default:    break;
        }
    }

    /**
     * Добавление Персоны методом класса Clinic
     */
    public void addPerson() {
        if (clinic.isClinicFull()) {
            outputInterface.saidClinicFull();
        } else {
            String nameOfPerson = askForAndGetPersonName();
            if (clinic.isPersonExistByName(nameOfPerson)) {
                outputInterface.saidPersonAlreadyExist();
            } else {
                String nameOfPet = askForAndGetPetName();
                int typeOfPet = askForAndGetTypeOfPet();
                clinic.addPerson(nameOfPerson, nameOfPet, typeOfPet);
            }
        }
    }

    /**
     *  Вывод всех Персон методом класса Clinic
     */
    public void viewAllPersons() {
        if (clinic.isClinicEmpty()) {
            outputInterface.saidNoPersonsInClinic();
        }
        else {
            clinic.viewAllPersons();
        }
    }

    /**
     * Выполнение действия животного
     */
    public void petDoAction() {
        if (clinic.isClinicEmpty()) {
            outputInterface.saidNoPersonsInClinic();
        } else {
            String nameOfPet = askForAndGetPetName();
            if (clinic.isPetExistByName(nameOfPet)) {
                outputInterface.saidPetEatingOtherPets(nameOfPet, clinic.getClassEnemyOfPetByName(nameOfPet).getName());
                clinic.remPersonsByClassOfPet(clinic.getClassEnemyOfPetByName(nameOfPet));
            } else {
                outputInterface.saidPetNotFound();
            }
        }
    }

    /**
     * Поиск и вывод Персоны
     * используется метод поиска по имени Персоны
     */
    public void findByNameOfPersonAndView() {
        String nameOfPerson = askForAndGetPersonName();
        if (clinic.isPersonExistByName(nameOfPerson)) {
            outputInterface.pr(clinic.viewPersonByName(nameOfPerson));
        } else
            outputInterface.saidPersonNotFound();
    }

    /**
     * Поиск и вывод Персоны
     * используется метод поиска по имени животного
     */
    public void findByNameOfPetAndView() {
        String nameOfPet = askForAndGetPetName();
        if (clinic.isPetExistByName(nameOfPet)) {
            outputInterface.pr(clinic.viewPersonByPetName(nameOfPet));
        } else
            outputInterface.saidPetNotFound();
    }

    /**
     * Переименование Персоны
     */
    public void renPerson() {
        String nameOfPerson = askForAndGetPersonName();
        if (clinic.isPersonExistByName(nameOfPerson)) {
            String newNameOfPerson = askForAndGetNewPersonName();
            if (clinic.isPersonExistByName(newNameOfPerson))
                outputInterface.saidPersonAlreadyExist();
            else
                clinic.renPerson(nameOfPerson, newNameOfPerson);
        } else outputInterface.saidPersonNotFound();
    }

    /**
     * Переименование животного
     */
    public void renPet() {
        String nameOfPet = askForAndGetPetName();
        if (clinic.isPetExistByName(nameOfPet)) {
            String newNameOfPet = askForAndGetNewPetName();
            clinic.renPet(nameOfPet, newNameOfPet);
        } else
            outputInterface.saidPetNotFound();
    }

    /**
     * Удаление персоны
     * используется метод удаления по имени Персоны
     */
    public void remByPersonName() {
        String nameOfPerson = askForAndGetPersonName();
        if (clinic.isPersonExistByName(nameOfPerson)) {
            clinic.remPersonByName(nameOfPerson);
        } else
            outputInterface.saidPersonNotFound();
    }

    /**
     * Удаление персоны
     * используется метод удаления по имени животого
     */
    public void remByPetName() {
        String nameOfPet = askForAndGetPetName();
        if (clinic.isPetExistByName(nameOfPet)) {
            clinic.remPersonByPetName(nameOfPet);
        } else
            outputInterface.saidPetNotFound();
    }

    /**
     * Вызывает метод запрашивающий имя для Персоны
     * и возврашает строку
     * @return имя для Персоны
     */
    public String askForAndGetPersonName() {
        outputInterface.askForNameOfPerson();
        return inputInterface.getStr();
    }

    /**
     * Вызывает метод запрашивающий имя для животного
     * и возврашает строку
     * @return имя для животного
     */
    public String askForAndGetPetName() {
        outputInterface.askForPetName();
        return inputInterface.getStr();
    }

    /**
     * Вызывает метод запрашивающий новое
     * имя для Персоны и возврашает строку
     * @return новое имя для Персоны
     */
    public String askForAndGetNewPersonName() {
        outputInterface.askForNewNameOfPerson();
        return inputInterface.getStr();
    }

    /**
     * Вызывает метод запрашивающий новое
     * имя для животного и возврашает строку
     * @return новое имя для животного
     */
    public String askForAndGetNewPetName() {
        outputInterface.askForNewPetName();
        return inputInterface.getStr();
    }

    /**
     * Вызывает метод запрашивающий новое
     * тип животного и возврашает число
     * @return номер для типа животного
     */
    public int askForAndGetTypeOfPet() {
        outputInterface.askForPetType();
        return inputInterface.getInt();
    }



}
