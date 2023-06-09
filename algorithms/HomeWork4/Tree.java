package ru.gb.lesson4;

import java.util.*;

public class Tree <T extends Comparable<T>> {

    // Нужно реализовать структуру, которая умеет делать следующее:
    // 1. Вставка значения
    // 2. Поиск значения (проверка, есть значение внутри или нет)
    // 3. Удаление значения
    // DFS Depth-first-search (поиск в глубину)
    // BFS Breath-first-search (поиск в ширину)

    // FIXME: 29.05.2023 Домашнее задание
    //  Сделать класс Node параметризованным типом T
    //  Переписать все упоминания int value на T value
    //  Заменить все проверки > < == на вызовы compareTo


    private class Node<T> {
        T value;
        Node left;
        Node right;

        Node(T value) {
            this.value = value;
        }
    }

    private Node root;

    public boolean add(T value) {
        if (root == null) {
            root = new Node(value);
            return true;
        }

        return addNode(root, value);
    }

    private boolean addNode(Node current, T value) {
        // value < current.value ~ value.compareTo(current.value) == 0
        if (value.compareTo((T) current.value) == 0) {
            return false;

        // value < current.value ~ value.compareTo(current.value) < 0
        } else if (value.compareTo((T) current.value) < 0) {
            // Вставялем в левое поддерево
            if (current.left == null) {
                current.left = new Node(value);
                return true;
            } else {
                return addNode(current.left, value);
            }
            // value > current.value ~ value.compareTo(current.value) > 0
        } else { // value > root.value
            // Вставляем в правое поддерево
            if (current.right == null) {
                current.right = new Node(value);
                return true;
            } else {
                return addNode(current.right, value);
            }
        }
    }

    public boolean contains(T value) {
        return findNode(root, value) != null;
    }

    private Node findNode(Node current, T value) {
        if (current == null) {
            return null;
        }

        // найди узел в дереве current, значение которого равно value
        if (value.compareTo((T) current.value) == 0) {
            return current;
        } else if (value.compareTo((T) current.value) < 0) {
            return findNode(current.left, value);
        } else { // value > current.value
            return findNode(current.right, value);
        }
    }

    public void remove(T value) {
        root = removeNode(root,(T) value);
    }

    private Node removeNode(Node current, T value) {
        if (current == null) {
            return null;
        }

        // value = 8, current = 6
        // 6.right = 7

        // value = 8, current = 8
        if (value.compareTo((T) current.value) < 0) {
            // нужно удалить в левом поддереве
            current.left = removeNode(current.left, value);
            return current;
        } else if (value.compareTo((T) current.value) > 0) {
            // нужно удалить в правом поддереве
            current.right = removeNode(current.right, value);
            return current;
        }

        // Нужно удалить узел current
        // Есть 3 случая:
        // 1. Дочерних узлов нет
        if (current.left == null && current.right == null) {
            return null;
        }

        // 2. Есть только один дочерний узел
        if (current.left == null && current.right != null) {
            return current.right;
        }
        if (current.left != null && current.right == null) {
            return current.left;
        }

        // 3. Есть оба дочерних узла
        // Нужно найти минимальный элемент справа
        Node smallestNodeOnTheRight = findFirst(current.right);
        T smallestValueOnTheRight = (T) smallestNodeOnTheRight.value;
        current.value = smallestValueOnTheRight;
        current.right = removeNode(current.right, smallestValueOnTheRight);
        return current;
    }

    public T findFirst() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return (T)findFirst(root).value;
    }

    private Node findFirst(Node current) {
        if (current.left == null) {
            return current;
        }
        return findFirst(current.left);
    }

    public List<T> dfs() {
        if (root == null) {
            return List.of();
        }

        List<T> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(Node current, List<T> result) {
        // In-order
        if (current.left != null) {
            dfs(current.left, result);
        }
        result.add((T)current.value);
        if (current.right != null) {
            dfs(current.right, result);
        }
    }

    public List<T> bfs() {
        if (root == null) {
            return List.of();
        }

        List<T> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node next = queue.poll();
            result.add((T)next.value);

            if (next.left != null) {
                queue.add(next.left);
            }
            if (next.right != null) {
                queue.add(next.right);
            }
        }
        return result;
    }

}
