package task1718;

/**
 * @author Kretov D.V
 * @version Написать программу, которая принимает числа и печатает в консоль являются они простыми или нет. Для этого нужно:
 * 1. Создать Maven-проект, подключить библиотеку Apache Commons Math (https://commons.apache.org/proper/commons-math/index.html)
 * 2. Использовать класс Primes из библиотеки п.1 для определения простого числа
 * 3. С помощью плагина Shade (https://maven.apache.org/plugins/maven-shade-plugin/) собрать исполняемый jar
 * 4. Имя jar-файла должно быть prime-numbers.jar (подсказка - тег finalName)
 * Вынести версии библиотеки и плагина в properties
 * При запуске программы можно указывать числа через пробел, а программа напечатает являются ли они простыми
 * (https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D0%BE%D1%81%D1%82%D0%BE%D0%B5_%D1%87%D0%B8%D1%81%D0%BB%D0%BE).
 * Если пользователь ввел не число - обрабатывать эту ситуацию и уведомлять его об этом
 * Запуск jar-файла: java -jar имя_файла
 * Пример:
 * java -jar prime-numbers.jar 1 4 7 abc 10
 * Консоль:
 * 1 - prime
 * 4 - not prime
 * 7 - prime
 * abc - NOT A NUMBER
 * 10 - not prime
 */

public class Start {
    public static void main(String[] args) {
        Determinant determinant = new Determinant();
        determinant.defineArrayElement(args);
    }
}