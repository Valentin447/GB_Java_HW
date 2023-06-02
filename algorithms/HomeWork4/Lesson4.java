package ru.gb.lesson4;

import java.util.TreeSet;

public class Lesson4 {

    public static void main(String[] args) {
        // TreeSet
        // TreeMap

        Tree tree = new Tree();
        System.out.println(tree.add("gg"));
        System.out.println(tree.add("vv"));
        System.out.println(tree.add("ii"));
        System.out.println(tree.add("gg"));
        System.out.println(tree.add("ww"));
        System.out.println(tree.add("uu"));
        System.out.println(tree.add("oo"));

        System.out.println();

        System.out.println(tree.contains("gg")); // true
        System.out.println(tree.contains("ww")); // true
        System.out.println(tree.contains("uu")); // true
        System.out.println(tree.contains("gg")); // true

        System.out.println(tree.contains("")); // false
        System.out.println(tree.contains("aa")); // false
        System.out.println(tree.contains("fg")); // false
        System.out.println();


        System.out.println(tree.dfs());
        System.out.println(tree.bfs());

        Integer x = 5;
        Integer y = 7;

        System.out.println(x.compareTo(y)); //


        Tree t = new Tree();
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);
        t.add(6);
        t.add(7);
        t.add(8);

        //           1
        //                   2
        //                             3
        //                                      4
        //                                                 5

        System.out.println(t.bfs());


    }

}
