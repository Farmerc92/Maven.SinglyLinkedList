package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void addTest(){
        Integer first = 5;
        Integer second = 10;
        Integer third = 15;

        SinglyLinkedList list = new SinglyLinkedList();

        list.add(first);
        list.add(second);
        list.add(third);

        Assert.assertEquals(first, list.get(0));
        Assert.assertEquals(second, list.get(1));
        Assert.assertEquals(third, list.get(2));
    }

    @Test
    public void testSwap(){
        Integer first = 5;
        Integer second = 10;
        Integer third = 15;
        Integer fourth = 20;

        SinglyLinkedList list = new SinglyLinkedList();

        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);

        list.swap(fourth, second);

        Assert.assertEquals(first, list.get(0));
        Assert.assertEquals(fourth, list.get(1));
        Assert.assertEquals(third, list.get(2));
        Assert.assertEquals(second, list.get(3));
    }

    @Test
    public void testSet(){
        Integer first = 5;
        Integer second = 10;
        Integer third = 15;
        Integer fourth = 20;

        SinglyLinkedList list = new SinglyLinkedList();

        list.add(first);
        list.add(second);
        list.add(third);

        list.set(2, fourth);

        Assert.assertEquals(first, list.get(0));
        Assert.assertEquals(second, list.get(1));
        Assert.assertEquals(fourth, list.get(2));
    }

    @Test
    public void removeFirstIndexTest(){
        Integer first = 5;
        Integer second = 10;
        Integer third = 15;

        SinglyLinkedList list = new SinglyLinkedList();

        list.add(first);
        list.add(second);
        list.add(third);

        list.removeFirstIndex();

        Assert.assertEquals(second, list.get(0));
        Assert.assertEquals(third, list.get(1));
    }

    @Test
    public void removeSecondIndexTest(){
        Integer first = 5;
        Integer second = 10;
        Integer third = 15;

        SinglyLinkedList list = new SinglyLinkedList();

        list.add(first);
        list.add(second);
        list.add(third);

        list.removeSecondIndex();

        Assert.assertEquals(first, list.get(0));
        Assert.assertEquals(third, list.get(1));
    }

    @Test
    public void removeAlmostAnyIndexTest(){
        Integer first = 5;
        Integer second = 10;
        Integer third = 15;
        Integer fourth = 20;

        SinglyLinkedList list = new SinglyLinkedList();

        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);

        list.removeOtherIndex(2);

        Assert.assertEquals(first, list.get(0));
        Assert.assertEquals(second, list.get(1));
        Assert.assertEquals(fourth, list.get(2));
    }

    @Test
    public void removeLastIndex(){
        Integer first = 5;
        Integer second = 10;
        Integer third = 15;
        Integer fourth = 20;

        SinglyLinkedList list = new SinglyLinkedList();

        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);

        list.remove(3);

        Assert.assertEquals(first, list.get(0));
        Assert.assertEquals(second, list.get(1));
        Assert.assertEquals(third, list.get(2));
    }

    @Test
    public void testContains(){
        Integer first = 5;
        Integer second = 10;
        Integer third = 15;
        Integer fourth = 20;

        SinglyLinkedList list = new SinglyLinkedList();

        list.add(first);
        list.add(second);
        list.add(third);

        Assert.assertTrue(list.contains(first));
        Assert.assertTrue(list.contains(second));
        Assert.assertTrue(list.contains(third));
        Assert.assertFalse(list.contains(fourth));
    }

    @Test
    public void testSize(){
        Integer first = 5;
        Integer second = 10;
        Integer third = 15;

        SinglyLinkedList list = new SinglyLinkedList();

        list.add(first);
        list.add(second);
        list.add(third);

        int expectedSize = 3;

        Assert.assertEquals(expectedSize, list.size());
    }

    @Test
    public void testEmptyListSize(){
        SinglyLinkedList list = new SinglyLinkedList();

        int expectedSize = 0;

        Assert.assertEquals(expectedSize, list.size());
    }

    @Test
    public void testContainsEmpty(){
        Integer first = 5;
        Integer second = 10;
        Integer third = 15;

        SinglyLinkedList list = new SinglyLinkedList();

        Assert.assertFalse(list.contains(5));
    }

    @Test
    public void testFind(){
        Integer first = 5;
        Integer second = 10;
        Integer third = 15;
        Integer fourth = 20;
        Integer fifth = 25;

        int expectedFirst = 0;
        int expectedSecond = 1;
        int expectedThird = 2;
        int expectedFourth = 3;
        int expectedFifth = -1;


        SinglyLinkedList list = new SinglyLinkedList();

        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);

        Assert.assertEquals(expectedFirst, list.find(first));
        Assert.assertEquals(expectedSecond, list.find(second));
        Assert.assertEquals(expectedThird, list.find(third));
        Assert.assertEquals(expectedFourth, list.find(fourth));
        Assert.assertEquals(expectedFifth, list.find(fifth));
    }

    @Test
    public void testCopySizeOne(){
        Integer first = 5;

        SinglyLinkedList list = new SinglyLinkedList();

        list.add(first);

        SinglyLinkedList listCopy = list.copy();

        Assert.assertEquals(list.get(0), listCopy.get(0));
        Assert.assertEquals(list.size(), listCopy.size());
        Assert.assertNotSame(list, listCopy);
    }

    @Test
    public void testCopySizeTwo(){
        Integer first = 5;
        Integer second = 10;

        SinglyLinkedList list = new SinglyLinkedList();

        list.add(first);
        list.add(second);

        SinglyLinkedList listCopy = list.copy();

        Assert.assertEquals(list.get(0), listCopy.get(0));
        Assert.assertEquals(list.get(1), listCopy.get(1));
        Assert.assertEquals(list.size(), listCopy.size());
        Assert.assertNotSame(list, listCopy);
    }

    @Test
    public void testCopySizeMany(){
        Integer first = 5;
        Integer second = 10;
        Integer third = 15;

        SinglyLinkedList list = new SinglyLinkedList();

        list.add(first);
        list.add(second);
        list.add(third);

        SinglyLinkedList listCopy = list.copy();

        Assert.assertEquals(list.get(0), listCopy.get(0));
        Assert.assertEquals(list.get(1), listCopy.get(1));
        Assert.assertEquals(list.get(2), listCopy.get(2));
        Assert.assertEquals(list.size(), listCopy.size());
        Assert.assertNotSame(list, listCopy);
    }

    @Test
    public void sortIntegerTest(){
        Integer first = 5;
        Integer second = 10;
        Integer third = 15;
        Integer fourth = 20;
        Integer fifth = 25;

        SinglyLinkedList list = new SinglyLinkedList();

        list.add(fifth);
        list.add(fourth);
        list.add(third);
        list.add(second);
        list.add(first);

        list.specialSort();

        Assert.assertEquals(first, list.get(0));
        Assert.assertEquals(second, list.get(1));
        Assert.assertEquals(third, list.get(2));
        Assert.assertEquals(fourth, list.get(3));
        Assert.assertEquals(fifth, list.get(4));
    }

    @Test
    public void sliceTest(){
        Integer first = 5;
        Integer second = 10;
        Integer third = 15;
        Integer fourth = 20;
        Integer fifth = 25;

        SinglyLinkedList list = new SinglyLinkedList();

        list.add(fifth);
        list.add(fourth);
        list.add(third);
        list.add(second);
        list.add(first);

        SinglyLinkedList listSlice = list.slice(1,4);

        Assert.assertEquals(list.get(1), listSlice.get(0));
        Assert.assertEquals(list.get(2), listSlice.get(1));
        Assert.assertEquals(list.get(3), listSlice.get(2));
    }

    @Test
    public void reverseTest(){
        Integer first = 5;
        Integer second = 10;
        Integer third = 15;
        Integer fourth = 20;
        Integer fifth = 25;

        SinglyLinkedList list = new SinglyLinkedList();

        list.add(fifth);
        list.add(fourth);
        list.add(third);
        list.add(second);
        list.add(first);

        list.reverse();

        Assert.assertEquals(first, list.get(0));
        Assert.assertEquals(second, list.get(1));
        Assert.assertEquals(third, list.get(2));
        Assert.assertEquals(fourth, list.get(3));
        Assert.assertEquals(fifth, list.get(4));
    }
}
