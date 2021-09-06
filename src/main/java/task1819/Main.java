package task1819;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        ArrayIntList mainObject = new ArrayIntList();

        mainObject.add(1);
        mainObject.add(-2);
        mainObject.add(7);
        mainObject.add(0);
        mainObject.add(9);

        Notice.printArray("After use method \"ADD\" we have: " + mainObject);

        mainObject.insert(6, -15);

        Notice.printArray("After use method \"insert\" we have: " + mainObject);

        mainObject.set(8, -100);

        Notice.printArray("After use method \"set\" we have: " + mainObject);

        System.out.printf("Actual number of elements in the list is: %s %n", mainObject.size());

        System.out.printf("Array now can contain: %s elements %n", mainObject.capacity());

        System.out.printf("Get your: %s %n", mainObject.getByIndex(8));

        System.out.printf("%s %n", mainObject.getIndexByValue(-15));

        System.out.println(mainObject.contains(-100));

        mainObject.removeValue(7);

        mainObject.removeByIndex(2);

        System.out.printf("New list is: %s %n", mainObject.subList(2, 6));

        System.out.printf("New ARRAY is: %s", Arrays.toString(mainObject.toArray()));
    }
}
