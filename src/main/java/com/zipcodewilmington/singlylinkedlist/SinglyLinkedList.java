package com.zipcodewilmington.singlylinkedlist;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T>> {

    Node<T> tail;
    Node<T> head;

    public SinglyLinkedList(){
        tail = null;
        head = null;
    }

    public T get(int index){
        int tempIndex = tail.getIndex();
        Node<T> tempNode = tail;
        while (tempIndex != index){
            tempIndex++;
            tempNode = tempNode.getNext();
        }
        return tempNode.getObj();
    }

    public void add(T obj){
        if (tail == null){
            tail = new Node<T>(obj, null);
            tail.setIndex(0);
        }
        else if (head == null){
            head = new Node<T>(obj, null);
            tail.setNext(head);
            head.setIndex(1);
        }
        else {
            int nextIndex = head.getIndex() + 1;
            head.setNext(new Node<T>(obj, null));
            head = head.getNext();
            head.setIndex(nextIndex);
        }
    }

    public void shiftIndex(Node<T> node, int currentIndex){
        while (node != null){
            currentIndex++;
            node.setIndex(currentIndex);
            node = node.getNext();
        }
    }

    public void removeFirstIndex(){
        Node<T> newTail = tail.getNext();
        tail.setNext(null);
        tail = newTail;
        tail.setIndex(0);
        shiftIndex(tail.getNext(), 0);
    }

    public void removeSecondIndex(){
        Node<T> tempNode = tail.getNext();
        Node<T> nextNode = tempNode.getNext();
        tail.setNext(nextNode);
        nextNode.setIndex(1);
        tempNode.setNext(null);
        shiftIndex(tail.getNext(), 1);
    }

    public void removeInTheMiddle(Node<T> tempNode, Node<T> toReplace, int index){
        Node<T> toConnect = toReplace.getNext();
        tempNode.setNext(toConnect);
        toReplace.setNext(null);
        toConnect.setIndex(index + 1);
        shiftIndex(toConnect.getNext(), toConnect.getIndex());
    }


    public Node<T> findNodeToReconnect(Node<T> tempNode, int index) {
        while (tempNode.getIndex() != index - 1){
            tempNode = tempNode.getNext();
        }
        return tempNode;
    }


    public void removeOtherIndex(int index){
        Node<T> tempNode = tail.getNext();
        tempNode = findNodeToReconnect(tempNode, index);
        int tempIndex = tempNode.getIndex();
        Node<T> toReplace = tempNode.getNext();
        if (toReplace.getNext() == null){
            tempNode.setNext(null);
        }
        else {
            removeInTheMiddle(tempNode, toReplace, tempIndex);
        }
    }

    public void remove(int index){
        if (index == 0){
            removeFirstIndex();
        }
        else if (index == 1){
            removeSecondIndex();
        }
        else {
            removeOtherIndex(index);
        }
    }

    public boolean contains(T obj){
        Node<T> tempNode = tail;
        if (tail == null)
            return false;
        else
        for (int i = 0; i < this.size(); i++) {
            if(tempNode.getObj() == obj)
                return true;
            else
                tempNode = tempNode.getNext();
        }
        return false;
    }

    public int size(){
        int nodeCount = 0;
        if (tail == null)
            return 0;
        else
            nodeCount++;
        Node<T> tempNode = tail;
        while (tempNode.getNext() != null){
            nodeCount++;
            tempNode = tempNode.getNext();
        }
        return nodeCount;
    }

    public int find(T obj){
        Node<T> tempNode = tail;
        int nodeCount = 0;
        if (tail == null)
            return -1;
        while (tempNode != null){
            if (tempNode.getObj() == obj)
                return nodeCount;
            nodeCount++;
            tempNode = tempNode.getNext();
        }
        return -1;
    }

    public SinglyLinkedList<T> copySize(){
        SinglyLinkedList<T> copy = new SinglyLinkedList<T>();
        Node<T> tempNode = tail;
        while (tempNode != null){
            copy.add(tempNode.getObj());
            tempNode = tempNode.getNext();
        }
        return copy;
    }

    public SinglyLinkedList<T> copy(){
        int copySize = this.size();
        if (copySize == 0)
            return new SinglyLinkedList<T>();
        else
            return copySize();
    }

    public void reverse(){
        int size = this.size();
        Node<T> tempNode = head;

    }

    public void sort(){

    }
}
