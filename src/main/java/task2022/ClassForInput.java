package task2022;

import java.util.Scanner;

public class ClassForInput {

    static public int inputOfNumberCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                                
                Variants of choice\s
                input "1" - get all cities name.
                input "2" - add new city name.
                input "3" - show cities with population.
                input "4" - end program.
                Please input your choice:\s""");
        if (sc.hasNextInt()) {
            int number = sc.nextInt();
            if (number < 1 || number > 4) {
                System.out.println("Choice should be in range 1 - 4");
                return inputOfNumberCommand();
            }
            return number;
        }
        System.out.println("Данніе введені некоректно");
        return inputOfNumberCommand();
    }

    public static String inputCityName() {
        System.out.println("Input city name");
        Scanner sc = new Scanner(System.in);
        String city = sc.nextLine();
        if (city.matches("^.*[A-Za-z]$")) {
            return city;
        }
        System.out.println("вы ввели не город! пробуйте снова");
        return inputCityName();
    }

    public static Integer inputPopulation(String cityName) {
        System.out.println("Do you know population " + cityName + " Yes/No ?");
        Scanner sc = new Scanner(System.in);
        String verificationOfPopulationStr = sc.nextLine();
        if (verificationOfPopulationStr.equalsIgnoreCase("yes") || verificationOfPopulationStr.equalsIgnoreCase("y")) {
            return inputNumberOfPopulation();
        } else if (verificationOfPopulationStr.equalsIgnoreCase("no") || verificationOfPopulationStr.equalsIgnoreCase("n")) {
            return null;
        }
        System.out.println("Внимание, только два ответа, да или нет! ПРОБУЙ СНОВА");
        return inputPopulation(cityName);
    }

    private static int inputNumberOfPopulation() {
        System.out.println("Input the population of the city");
        Scanner sc2 = new Scanner(System.in);
        if (sc2.hasNextInt()) {
            return sc2.nextInt();
        }
        System.out.println("Какое-то странное население, пробуй снова");
        return inputNumberOfPopulation();
    }
}