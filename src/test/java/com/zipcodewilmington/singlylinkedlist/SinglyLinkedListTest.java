package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    private SinglyLinkedList<String> list;
    private String first;
    private String second;
    private String third;
    private String fourth;
    private String fifth;
    private String sixth;

    @Before
    public void init(){
        first = "first";
        second = "second";
        third = "third";
        fourth = "fourth";
        fifth = "fifth";
        sixth = "sixth";
        list = new SinglyLinkedList<String>();
        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);
        list.add(fifth);
    }
    @Test
    public void addTest(){
        Assert.assertEquals(first, list.get(0));
        Assert.assertEquals(second, list.get(1));
        Assert.assertEquals(third, list.get(2));
    }

    @Test
    public void testSwap(){
        list.swap(fourth, second);

        Assert.assertEquals(first, list.get(0));
        Assert.assertEquals(fourth, list.get(1));
        Assert.assertEquals(third, list.get(2));
        Assert.assertEquals(second, list.get(3));
    }

    @Test
    public void testSet(){
        list.set(2, fourth);

        Assert.assertEquals(first, list.get(0));
        Assert.assertEquals(second, list.get(1));
        Assert.assertEquals(fourth, list.get(2));
    }

    @Test
    public void removeFirstIndexTest(){
        list.removeFirstIndex();

        Assert.assertEquals(second, list.get(0));
        Assert.assertEquals(third, list.get(1));
    }

    @Test
    public void removeSecondIndexTest(){
        list.removeSecondIndex();

        Assert.assertEquals(first, list.get(0));
        Assert.assertEquals(third, list.get(1));
    }

    @Test
    public void removeAlmostAnyIndexTest(){
        list.removeOtherIndex(2);

        Assert.assertEquals(first, list.get(0));
        Assert.assertEquals(second, list.get(1));
        Assert.assertEquals(fourth, list.get(2));
    }

    @Test
    public void removeLastIndex(){
        list.remove(4);

        Assert.assertEquals(first, list.get(0));
        Assert.assertEquals(second, list.get(1));
        Assert.assertEquals(third, list.get(2));
        Assert.assertEquals(fourth, list.get(3));
    }

    @Test
    public void testContains(){
        Assert.assertTrue(list.contains(first));
        Assert.assertTrue(list.contains(second));
        Assert.assertTrue(list.contains(third));
        Assert.assertTrue(list.contains(fourth));
        Assert.assertTrue(list.contains(fifth));
        Assert.assertFalse(list.contains(sixth));
    }

    @Test
    public void testSize(){
        int expectedSize = 5;

        Assert.assertEquals(expectedSize, list.size());
    }

    @Test
    public void testEmptyListSize(){
        SinglyLinkedList<String> newList = new SinglyLinkedList<String>();
        int expectedSize = 0;
        Assert.assertEquals(expectedSize, newList.size());
    }

    @Test
    public void testContainsEmpty(){
        SinglyLinkedList<String> newList = new SinglyLinkedList<String>();

        Assert.assertFalse(newList.contains(first));
    }

    @Test
    public void testFind(){
        int expectedFirst = 0;
        int expectedSecond = 1;
        int expectedThird = 2;
        int expectedFourth = 3;
        int expectedFifth = 4;
        int expectedSixth = -1;

        Assert.assertEquals(expectedFirst, list.find(first));
        Assert.assertEquals(expectedSecond, list.find(second));
        Assert.assertEquals(expectedThird, list.find(third));
        Assert.assertEquals(expectedFourth, list.find(fourth));
        Assert.assertEquals(expectedFifth, list.find(fifth));
        Assert.assertEquals(expectedSixth, list.find(sixth));
    }

    @Test
    public void testCopySizeOne(){
        for (int i = 0; i < 4; i++) {
            list.remove(0);
        }
        SinglyLinkedList<String> listCopy = list.copy();

        Assert.assertEquals(list.get(0), listCopy.get(0));
        Assert.assertEquals(list.size(), listCopy.size());
        Assert.assertNotSame(list, listCopy);
    }

    @Test
    public void testCopyEmpty(){
        for (int i = 0; i < 5; i++) {
            list.remove(0);
        }
        SinglyLinkedList<String> listCopy = list.copy();

        Assert.assertEquals(list.size(), listCopy.size());
        Assert.assertNotSame(list, listCopy);
    }

    @Test
    public void testCopySizeTwo(){
        for (int i = 0; i < 3; i++) {
            list.remove(0);
        }
        SinglyLinkedList<String> listCopy = list.copy();

        Assert.assertEquals(list.get(0), listCopy.get(0));
        Assert.assertEquals(list.get(1), listCopy.get(1));
        Assert.assertEquals(list.size(), listCopy.size());
        Assert.assertNotSame(list, listCopy);
    }

    @Test
    public void testCopySizeMany(){
        SinglyLinkedList<String> listCopy = list.copy();
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(list.get(i), listCopy.get(i));
        }
        Assert.assertEquals(list.size(), listCopy.size());
        Assert.assertNotSame(list, listCopy);
    }

    @Test
    public void sortIntegerTest(){
        list.bubbleSort();

        Assert.assertEquals(fifth, list.get(0));
        Assert.assertEquals(first, list.get(1));
        Assert.assertEquals(fourth, list.get(2));
        Assert.assertEquals(second, list.get(3));
        Assert.assertEquals(third, list.get(4));
    }

    @Test
    public void sliceTest(){
        SinglyLinkedList<String> listSlice = list.slice(1,4);

        Assert.assertEquals(list.get(1), listSlice.get(0));
        Assert.assertEquals(list.get(2), listSlice.get(1));
        Assert.assertEquals(list.get(3), listSlice.get(2));
    }

    @Test
    public void reverseTest(){
        list.reverse();

        Assert.assertEquals(fifth, list.get(0));
        Assert.assertEquals(fourth, list.get(1));
        Assert.assertEquals(third, list.get(2));
        Assert.assertEquals(second, list.get(3));
        Assert.assertEquals(first, list.get(4));
    }

}
