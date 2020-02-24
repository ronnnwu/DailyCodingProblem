import chapter1.Chapter1;
import chapter2.Chapter2;
import chapter3.Chapter3;
import chapter3.LinkedList;
import chapter4.Chapter4;
import chapter5.Chapter5;
import chapter6.BinaryTree;
import chapter6.Chapter6;
import chapter6.Node;
import chapter7.BinarySearchTree;
import chapter7.Chapter7;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void testChapter1() {
        Chapter1 ex = new Chapter1();

        System.out.println("-------------");
        System.out.println("Chapter one");
        System.out.println("-------------");

        System.out.println(Arrays.toString(ex.ex1(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(ex.ex2(new int[]{3,7,5,6,9})));
        System.out.println(ex.ex3(new int[]{34, -50, 42, 14, -5, 86}));
        System.out.println(Arrays.toString(ex.ex4(new int[]{3, 4, 9, 6, 1})));


    }

    public static void testChapter2() {
        Chapter2 ex = new Chapter2();

        System.out.println("-------------");
        System.out.println("Chapter two");
        System.out.println("-------------");

        System.out.println(ex.ex1("ab", "abxaba"));
        System.out.println(ex.ex2(new String[]{"code", "edoc", "da", "d"}));
        ex.ex3("thisisazigzag", 4);
        System.out.println(ex.ex4("daily", 2));

    }

    public static void testChapter3() {
        Chapter3 ex = new Chapter3();

        System.out.println("-------------");
        System.out.println("Chapter three");
        System.out.println("-------------");

        System.out.println(ex.ex1(new LinkedList(List.of(1, 2, 3, 4))));
        System.out.println(ex.ex2(new LinkedList(List.of(9, 9)), new LinkedList(List.of(5, 2))));
        System.out.println(ex.ex3(new LinkedList(List.of(1,2,3,4,5))));
        System.out.println(ex.ex4(new LinkedList(List.of(3,7,8,10)), new LinkedList(List.of(99,1,8,10))));

    }

    public static void testChapter4() {
        Chapter4 ex = new Chapter4();

        System.out.println("-------------");
        System.out.println("Chapter four");
        System.out.println("-------------");

        ex.ex1();
        System.out.println(ex.ex2("({}){}({})"));
        ex.ex3(new int[]{10, 5, 2, 7, 8, 7}, 3);
        System.out.println(ex.ex4(new char[]{' ', '+', '+', '-', '+'}));
    }


    public static void testChapter5() {
        Chapter5 ex = new Chapter5();

        System.out.println("-------------");
        System.out.println("Chapter five");
        System.out.println("-------------");

        ex.ex1();
        System.out.println(ex.ex2(List.of(
                List.of(3,5,1,1), List.of(2,3,3,2), List.of(5,5),
                List.of(4,4,2), List.of(1,3,3,3), List.of(1,1,6,1,1)
        )));
        ex.ex3();
    }

    public static void testChapter6() {
        Chapter6 ex = new Chapter6();

        System.out.println("-------------");
        System.out.println("Chapter six");
        System.out.println("-------------");

        ex.ex1();
        System.out.println(ex.ex2(List.of('a','b','d','e','c','f','g'), List.of('d','b','e','a','f','c','g')));

        BinaryTree<String> bt = new BinaryTree<>();
        bt.root = new Node("*");
        bt.root.left = new Node("+");
        bt.root.right = new Node("+");
        bt.root.left.left = new Node("3");
        bt.root.left.right = new Node("2");
        bt.root.right.left = new Node("4");
        bt.root.right.right = new Node("5");

        System.out.println(ex.ex3(bt));


        BinaryTree<Integer> bt2 = new BinaryTree<>();
        bt2.root = new Node(1);
        bt2.root.left = new Node(2);
        bt2.root.right = new Node(3);
        bt2.root.right.left = new Node(4);
        bt2.root.right.right = new Node(5);

        System.out.println(ex.ex4(bt2));

    }

    public static void testChapter7() {
        Chapter7 ex = new Chapter7();

        System.out.println("-------------");
        System.out.println("Chapter seven");
        System.out.println("-------------");


        BinarySearchTree<Integer> bt = new BinarySearchTree<>(List.of(7,5,10,-1,6,25));
        System.out.println(bt);

        System.out.println(ex.ex1(bt, 20));

        System.out.println(ex.ex2(new int[]{1,2,3,4,5,6,7,8,9,10}));

        List<BinarySearchTree<Integer>> binarySearchTrees = ex.ex3(3);
        for (BinarySearchTree b: binarySearchTrees) {
            System.out.println(b);
        }

    }

    public static void main(String[] args) {
//        testChapter1();
//        testChapter2();
//        testChapter3();
//        testChapter4();
//        testChapter5();
//        testChapter6();

        testChapter7();
    }
}
