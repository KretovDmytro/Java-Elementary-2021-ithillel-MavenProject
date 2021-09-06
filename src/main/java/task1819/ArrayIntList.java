package task1819;

import java.util.Arrays;

public class ArrayIntList implements IntList {

    private Integer[] array = new Integer[]{};

    private boolean seeConditionByIndexAndLengthArray(int index) {
        return index < array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    @Override
    public void add(Integer i) {
        Integer[] array2 = new Integer[array.length + 1];
        System.arraycopy(array, 0, array2, 0, array.length);
        array2[array2.length - 1] = i;
        array = array2;
    }

    @Override
    public void insert(int index, Integer value) {
        if (seeConditionByIndexAndLengthArray(index)) {
            if (array[array.length - 1] != null) {
                Integer[] array2 = new Integer[array.length + 1];
                System.arraycopy(array, 0, array2, 0, index);
                System.arraycopy(array, index, array2, index + 1, array.length - index);
                array2[index] = value;
                array = array2;
            } else {
                System.arraycopy(array, index, array, index + 1, array.length - 1 - index);
                array[index] = value;
            }
        } else {
            add(null);
            insert(index, value);
        }
    }

    @Override
    public void set(int index, Integer value) {
        if (seeConditionByIndexAndLengthArray(index)) {
            array[index] = value;
        } else {
            add(null);
            set(index, value);
        }
    }

    @Override
    public int size() {
        int count = 0;
        for (Integer i : array) {
            if (i != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int capacity() {
        return array.length;
    }

    @Override
    public Integer getByIndex(int index) {
        if (seeConditionByIndexAndLengthArray(index)) {
            return array[index];
        } else {
            System.out.print("You have exceeded the index value!!! ");
            return null;
        }
    }

    @Override
    public Integer getIndexByValue(Integer value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(value)) {
                System.out.print("First match of value with index: ");
                return i;
            }
        }
        System.out.print("no such value found! Get your: ");
        return null;
    }

    @Override
    public boolean contains(Integer value) {
        for (Integer integer : array) {
            if ((integer == null && value == null) || (integer != null && integer.equals(value))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeValue(Integer value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                Integer[] array2 = new Integer[array.length - 1];
                System.arraycopy(array, 0, array2, 0, i);
                System.arraycopy(array, i + 1, array2, i, array2.length - i);
                array = array2;
                System.out.println("Array after method \"removeValue\": " + Arrays.toString(array));
                break;
            }
        }
    }

    @Override
    public void removeByIndex(int index) {
        if (index >= 0 && index < array.length) {
            Integer[] array2 = new Integer[array.length - 1];
            System.arraycopy(array, 0, array2, 0, index);
            System.arraycopy(array, index + 1, array2, index, array.length - index - 1);
            array = array2;
            System.out.println("Array after method \"removeByIndex\": " + Arrays.toString(array));
        } else {
            System.out.println("There is no such index, something is wrong!!!");
        }
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        if (fromIndex >= 0 && fromIndex < toIndex && toIndex < array.length) {
            IntList list = new ArrayIntList();
            for (int i = fromIndex; i <= toIndex; i++) {
                list.add(array[i]);
            }
            return list;
        } else {
            System.out.println("Something is wrong");
            return null;
        }
    }

    @Override
    public int[] toArray() {
        int[] array2 = new int[size()];
        int j = 0;
        for (Integer integer : array) {
            if (integer != null) {
                array2[j] = integer;
                j++;
            }
        }
        return array2;
    }
}
