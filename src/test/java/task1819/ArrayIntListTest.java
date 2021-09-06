package task1819;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayIntListTest {

    private ArrayIntList arrayIntList = new ArrayIntList();

    // после создания объекта в нем нет элементов
    @Test
    public void shouldReturnZeroWhenCallSizeAndListIsEmpty() {

        int actualSize = arrayIntList.size();

        assertEquals(0, actualSize);
    }

    // после добавления нескольких элементов они хранятся под правильными индексами (первый добавленный - 0 индекс, второй - 1 индекс и т.д.)
    @Test
    public void shouldReturnCorrectIndexesForInsertedElements() {

        add5ElementsInList();

        assertEquals(0, arrayIntList.getIndexByValue(1001));
        assertEquals(1, arrayIntList.getIndexByValue(2002));
    }

    // после удаления элемента из середины - индексы сдвигаются.
    @Test
    public void shouldShiftIndicesAfterRemovingFromMiddle() {

        add5ElementsInList();

        arrayIntList.removeByIndex(1);

        assertEquals(1, arrayIntList.getIndexByValue(3003));
        assertEquals(2, arrayIntList.getIndexByValue(4004));
    }

    // subList возвращает подсписок
    @Test
    public void shouldReturnSublistAfterSubListMethod() {

        add5ElementsInList();

        ArrayIntList intList = (ArrayIntList) arrayIntList.subList(1, 4);

        assertEquals(intList.getByIndex(0), arrayIntList.getByIndex(1));
        assertEquals(intList.getByIndex(1), arrayIntList.getByIndex(2));
        assertEquals(intList.getByIndex(2), arrayIntList.getByIndex(3));
        assertEquals(intList.getByIndex(3), arrayIntList.getByIndex(4));
    }

    // size возвращает сколько элементов добавил пользователь
    @Test
    public void shouldReturnNumberOfItemsAfterAdding() {

        add5ElementsInList();

        assertEquals(5, arrayIntList.size());
    }

    // capacity возвращает сколько всего элементов может поместиться в список до его увеличения
    @Test
    public void shouldReturnHowManyElementsCanFitInListBeforeItGrows() {

        assertEquals(0, arrayIntList.capacity());
    }

    // contains возвращает true если элемент есть в списке и false - если нет
    @Test
    public void shouldReturnTrueIfItemIsInListAndFalseIfNot() {

        add5ElementsInList();

        assertTrue(arrayIntList.contains(3003));
        assertFalse(arrayIntList.contains(1111));
    }

    // изменения в массиве, который возвращается из toArray, не влияют на массив внутри списка
    @Test
    public void shouldNotDamageArrayAfterUsingToArrayMethod() {

        add5ElementsInList();

        int[] newArray = arrayIntList.toArray();

        newArray[1] = 321654;

        assertNotEquals(newArray, arrayIntList.toArray());
    }

    private void add5ElementsInList() {
        arrayIntList.add(1001); //0 index
        arrayIntList.add(2002); //1 index
        arrayIntList.add(3003); //2 index
        arrayIntList.add(4004); //3 index
        arrayIntList.add(5005); //4 index
    }
}