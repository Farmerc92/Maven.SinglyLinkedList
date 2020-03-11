package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T>> {

    private Node<T> tail;
    private Node<T> head;
    private int length;

    public SinglyLinkedList(){
        tail = null;
        head = null;
        length = 0;
    }

    public T get(int index){
        int tempIndex = head.getIndex();
        Node<T> tempNode = head;
        while (tempIndex != index){
            tempIndex++;
            tempNode = tempNode.getNext();
        }
        return tempNode.getObj();
    }

    public void swap(T obj1, T obj2){
        Node<T> tempNode = head;
        int indexObj1 = -1;
        int indexObj2 = -1;
        while (tempNode != null){
            if (tempNode.getObj() == obj1)
                indexObj1 = tempNode.getIndex();
            else if (tempNode.getObj() == obj2)
                indexObj2 = tempNode.getIndex();
            tempNode = tempNode.getNext();
        }
        this.set(indexObj2, obj1);
        this.set(indexObj1, obj2);
    }

    public void set(int index, T obj){
        int tempIndex = head.getIndex();
        Node<T> tempNode = head;
        while (tempIndex != index){
            tempIndex++;
            tempNode = tempNode.getNext();
        }
        tempNode.setObj(obj);
    }

    public void add(T obj){
        if (head == null){
            head = new Node<T>(obj, null);
            head.setIndex(0);
        }
        else if (tail == null){
            tail = new Node<T>(obj, null);
            head.setNext(tail);
            tail.setIndex(1);
        }
        else {
            int nextIndex = tail.getIndex() + 1;
            tail.setNext(new Node<T>(obj, null));
            tail = tail.getNext();
            tail.setIndex(nextIndex);
        }
        length++;
    }

    public void shiftIndex(Node<T> node, int currentIndex){
        while (node != null){
            node.setIndex(currentIndex);
            node = node.getNext();
            currentIndex++;
        }
    }

    public void removeFirstIndex(){
        Node<T> newTail = head.getNext();
        head.setNext(null);
        head = newTail;
        head.setIndex(0);
        shiftIndex(tail.getNext(), 0);
    }

    public void removeSecondIndex(){
        Node<T> tempNode = head.getNext();
        Node<T> nextNode = tempNode.getNext();
        head.setNext(nextNode);
        nextNode.setIndex(1);
        tempNode.setNext(null);
        shiftIndex(head.getNext(), 1);
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
        Node<T> tempNode = head.getNext();
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
        length--;
    }

    public boolean contains(T obj){
        Node<T> tempNode = head;
        if (head == null)
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
        return length;
    }

    public int find(T obj){
        Node<T> tempNode = head;
        int nodeCount = 0;
        if (head == null)
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
        Node<T> tempNode = head;
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
    
    public SinglyLinkedList<T> slice(int indexStartInclusive, int indexEndExclusive){
        SinglyLinkedList<T> copy = this.copy();
        for (int i = 0; i < copy.size(); i++) {
            if (i < indexStartInclusive || i >= indexEndExclusive){
                copy.remove(i);
            }
        }
        return copy;
    }

    public void reverse(){
        int size = this.size();
        for (int i = 0; i < size; i++) {
            this.add(this.get(size - 1 - i));
        }
        for (int i = 0; i < size; i++) {
            this.remove(0);
        }
    }

    public void specialSort(){
        Node<T> next = head;
        int size = this.size();
        int sizeSave = size;
        int index = 0;
        while (size > 0){
            T currentMin = next.getObj();
            while (index < size - 1){
                Node<T> next1 = next.getNext();
                if (currentMin.compareTo(next1.getObj()) < 0){}
                else{
                    currentMin = next1.getObj();
                }
                next = next.getNext();
                index++;
            }
            index = 0;
            add(currentMin);
            size--;
            next = head;
        }
        for (int i = 0; i < sizeSave; i++) {
            remove(0);
        }
    }

    public void sort(){
        for (int i = 0; i < length - 1; i++) {
            T currentI = get(i);
            for (int j = i + 1; j < length; j++) {
                T currentJ = get(j);
                if (currentI.compareTo(currentJ) > 0){
                    swap(currentI, currentJ);
                    currentI = currentJ;
                }
            }
        }
    }
}
