package task2022;

import java.sql.SQLException;
import java.util.UUID;

/**
 * @author Kretov D.V
 * @version Написать сервис, который будет будет добавлять / возвращать города из БД. В качестве БД использовать SQLite
 * https://www.sqlite.org/index.html - официальный сайт SQLite
 * https://www.sqlitetutorial.net/sqlite-tutorial - туториал для SQLite (как установить, как использовать)
 * 1) Создать БД "homeworks.db"
 * 2) Создать в ней таблицу "cities" с колонками: id - TEXT (использовать класс java.util.UUID для заполнения этой колонки), name - TEXT.
 * Первчиный ключ - id. Имена городов не должны повторяться, добавить ограничение колонке (ключевое слово UNIQUE при описании колонки)
 * 3) Написать immutable класс City с полями id и name.
 * (immutable - поля объекта нельзя изменить после его создание, т.е. нет сеттеров, данные указываются через конструктор).
 * 4) Написать класс CitiesService с методами addCity(City) и getCities(), который возращает список городов.
 * 5) В Main классе добавить несколько городов (можно сделать ввод названия города с клавиатуры), выбрать их из базы и напечатать в консоль.
 */

public class Main {

    public static void main(String[] args) throws SQLException {

        CitiesService citiesService = new CitiesService("jdbc:sqlite:D:\\java\\sqlite-tools-win32-x86-3360000\\homeworks.db");

        while (switchMethod(citiesService)) ;
    }

    public static boolean switchMethod(CitiesService citiesService) throws SQLException {
        return switch (ClassForInput.inputOfNumberCommand()) {
            case 1 -> {
                citiesService.getCities();
                yield true;
            }
            case 2 -> {
                citiesService.addCity(new City(UUID.randomUUID().toString(), ClassForInput.inputCityName()));
                yield true;
            }
            case 3 -> {
                citiesService.showCitiesWithPopulation();
                yield true;
            }
            case 4 -> false;
            default -> true;
        };
    }
}