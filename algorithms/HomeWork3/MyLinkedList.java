package ru.gb.lesson3;

import java.sql.Array;

@MyAnno
public class MyLinkedList {

    private Node head;
    private int size = 0;

    /**
     * Реализоват в классе MyLinkedList следующие методы
     * 1. public int size() - получение размера списка, проитерировався по всей структуре
     * 1.1 * Можно завести переменную size, поддерживать ее и использовать ее.
     * 2. public boolean contains(int value) - проверка наличия элемента по значению
     * 3. public int popLast() - удаление последнего элемента. Если список пустой - то ошибка
     * 4. * Переделать все int значения на дженерик T, чтобы можно было хранить значения любых типов
     * 5. * public MyLinkedList reversed() - создать НОВЫЙ список, порядок в котором обратный текущему
     */

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void add(int value) {
        Node last = findLast();
        if (last == null) {
            head = new Node(value);
        } else {
            last.next = new Node(value);
        }
        size++;
    }

    public int getFirst() {
        return get(0);
    }

    public int get(int index) {
        if (head == null) {
            throw new IllegalStateException("Список пустой");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }

        Node cursor = head;
        int indexCursor = 0;
        while (cursor != null) {
            if (indexCursor == index) {
                return cursor.value;
            }

            cursor = cursor.next;
            indexCursor++;
        }

        throw new IndexOutOfBoundsException(index);
    }

    public int popFirst() {
        return pop(0);
    }

    public int pop(int index) {
        if (head == null) {
            throw new IllegalStateException("Список пустой");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }

        if (index == 0) {
            int pop = head.value;
            head = head.next;
            size--;
            return pop;
        }

        Node cursor = head;
        int indexCursor = 1;
        while (cursor.next != null) {
            if (indexCursor == index) {
                int pop = cursor.next.value;
                cursor.next = cursor.next.next;
                size--;
                return pop;
            }

            cursor = cursor.next;
            indexCursor++;
        }

        throw new IndexOutOfBoundsException(index);
    }

    public MyLinkedList reversed() {
        if (head == null) {
            throw new IllegalStateException("Список пустой");
        }
        MyLinkedList listReversed = new MyLinkedList();
        Node cursor = head;
        int[] values = new int[size];
        for(int i = 0; i < values.length; i++){
            values[i] = cursor.value;
            cursor = cursor.next;
        }
        for(int i = values.length - 1; i >= 0; i--){
            listReversed.add(values[i]);
        }
        return listReversed;
    }

    private Node findLast() {
        if (head == null) {
            return null;
        }

        Node cursor = head;
        while (cursor.next != null) {
            cursor = cursor.next;
        }
        return cursor;
    }

    @Override
    public String toString() {
        // [1 -> 2 -> 3 -> 4 -> 5 -> ]
        StringBuilder result = new StringBuilder("[");
        Node cursor = head;
        while (cursor != null) {
            result.append(cursor.value).append(" -> ");
            cursor = cursor.next;
        }

        int length = result.length();
        if (length > 4) {
            result.delete(length - 4, length);
        }

        result.append("]");
        return result.toString();
    }
    public int size(){
        return size;
    }

    public boolean contains(int value) {
        Node cursor = head;
        if (head == null) {
            return false;
        }
        do {
            if(cursor.value == value){
                return true;
            } else if (cursor.next == null){
                return false;
            }
            cursor = cursor.next;
        } while (true);
    }

    public int popLast(){
        if (head == null) {
            throw new IllegalStateException("Список пустой");
        }
        int removedValue;
        Node cursor = head;
        if(head.next == null){
            removedValue = head.value;
            head = null;
            size--;
            return removedValue;
        }
        do {
            if (cursor.next.next == null) {
                removedValue = cursor.next.value;
                cursor.next = null;
                size--;
                return removedValue;
            }
            cursor = cursor.next;
        } while (true);
    }
}
