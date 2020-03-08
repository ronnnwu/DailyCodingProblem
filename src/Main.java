import chapter1.Chapter1;
import chapter10.Chapter10;
import chapter10.DirectGraph;
import chapter10.UndirectGraph;
import chapter11.Chapter11;
import chapter12.Chapter12;
import chapter13.Chapter13;
import chapter14.Chapter14;
import chapter15.Chapter15;
import chapter16.Chapter16;
import chapter16.Network;
import chapter16.Triple;
import chapter17.Chapter17;
import chapter18.Chapter18;
import chapter19.Chapter19;
import chapter2.Chapter2;
import chapter2.Pair;
import chapter20.Chapter20;
import chapter3.Chapter3;
import chapter3.LinkedList;
import chapter4.Chapter4;
import chapter5.Chapter5;
import chapter6.BinaryTree;
import chapter6.Chapter6;
import chapter6.Node;
import chapter7.BinarySearchTree;
import chapter7.Chapter7;
import chapter8.Chapter8;
import chapter9.Chapter9;

import java.security.NoSuchAlgorithmException;
import java.util.*;

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

    public static void testChapter8() {
        Chapter8 ex = new Chapter8();

        System.out.println("-------------");
        System.out.println("Chapter eight");
        System.out.println("-------------");


        ex.ex1();
        ex.ex2();

    }

    public static void testChapter9() {
        Chapter9 ex = new Chapter9();

        System.out.println("-------------");
        System.out.println("Chapter nine");
        System.out.println("-------------");


        System.out.println(ex.ex1(List.of(2,1,5,7,2,0,5)));

        List<Pair<String, Integer>> log = List.of(new Pair("google", 1), new Pair("google", 3), new Pair("google", 5),
                new Pair("pets", 1), new Pair("pets", 2), new Pair("yahoo", 6),
                new Pair("yahoo", 2), new Pair("yahoo", 3), new Pair("yahoo", 4), new Pair("yahoo", 5),
                new Pair("wikipedia", 4), new Pair("wikipedia", 5), new Pair("wikipedia", 6),
                new Pair("wikipedia", 7), new Pair("bing", 1), new Pair("bing", 3), new Pair("bing", 5),
                new Pair("bing", 6));
        System.out.println(ex.ex2(log, 1));

        System.out.println(ex.ex3(10));

    }

    public static void testChapter10() {
        Chapter10 ex = new Chapter10();

        System.out.println("-------------");
        System.out.println("Chapter ten");
        System.out.println("-------------");


        List<Pair> pairs = List.of(new Pair("JFK", "LAX"), new Pair("LAX", "ORL"), new Pair("LAX", "DFW"),
                new Pair("ORL", "SFO"), new Pair("SFO", "JFK"));

        System.out.println(ex.ex1(new UndirectGraph(pairs)));

        List<Pair<Integer, Integer>> g = List.of(new Pair(1, 2), new Pair(1, 3), new Pair(3, 4),
                new Pair(3, 5), new Pair(4, 6), new Pair(4, 7), new Pair(4, 8));
        System.out.println(ex.ex2(new DirectGraph(g), 1));

        System.out.println(ex.ex3("dog", "cat", new ArrayList(List.of("dot", "dop", "dat", "cat"))));

        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(17,13);
        snakes.put(52,29);
        snakes.put(57,40);
        snakes.put(62,22);
        snakes.put(88,18);
        snakes.put(95,51);
        snakes.put(97,79);

        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(3,21);
        ladders.put(8,30);
        ladders.put(28,84);
        ladders.put(58,77);
        ladders.put(75,86);
        ladders.put(80,100);
        ladders.put(90,91);

        System.out.println(ex.ex4(snakes, ladders));

        System.out.println(ex.ex5(new DirectGraph<>(List.of(new Pair("CS300", "CS100"), new Pair("CS300", "CS200"),
                new Pair("CS200", "CS100")))));



    }


    public static void testChapter11() throws NoSuchAlgorithmException {
        Chapter11 ex = new Chapter11();

        System.out.println("-------------");
        System.out.println("Chapter Eleven");
        System.out.println("-------------");

        ex.ex1();
        ex.ex2();
        ex.ex3();


    }

    public static void testChapter12() {
        Chapter12 ex = new Chapter12();

        System.out.println("-------------");
        System.out.println("Chapter twelve");
        System.out.println("-------------");

        ex.ex1(3);
        System.out.println(ex.ex2(".*at", "chat"));
        System.out.println(ex.ex3(List.of(4,2,7,5,-1,3,6)));
        System.out.println(ex.ex3Soln(List.of(4,2,7,5,-1,3,6)));


    }

    public static void testChapter13() {
        Chapter13 ex = new Chapter13();

        System.out.println("-------------");
        System.out.println("Chapter thirteen");
        System.out.println("-------------");

        System.out.println(ex.ex1(4));
        System.out.println(ex.ex1soln(4));

        System.out.println(ex.ex2("111"));
        System.out.println(ex.ex2soln("111"));

        int[][] cost = new int[][]{new int[]{1,3,2}, new int[]{2,3,0}};
        System.out.println(ex.ex3(cost));
        System.out.println(ex.ex3Soln(cost));

    }

    private static void printSudoku(int[][] sudoku) {
        for (int i =0; i<9; i++) {
            System.out.println();
            if (i%3==0)
                System.out.println("--------------------");
            for (int j=0; j<9; j++) {
                if (j%3==0) {
                    System.out.print("|");
                }
                System.out.print(sudoku[i][j]+" ");
            }
        }

        System.out.println();
    }

    public static void testChapter14() {
        Chapter14 ex = new Chapter14();

        System.out.println("-------------");
        System.out.println("Chapter fourteen");
        System.out.println("-------------");

        List<Pair<String, String>> flights = new ArrayList<>();
        flights.add(new Pair<>("SFO", "HKO"));
        flights.add(new Pair<>("YYZ", "SFO"));
        flights.add(new Pair<>("YUL", "YYZ"));
        flights.add(new Pair<>("HKO", "ORD"));

        System.out.println(ex.ex1(flights, "YUL"));

        int[][] sudoku = new int[][]{
                new int[] {2,5,0,0,3,0,9,0,1},
                new int[] {0,1,0,0,0,4,0,0,0},
                new int[] {4,0,7,0,0,0,2,0,8},
                new int[] {0,0,5,2,0,0,0,0,0},
                new int[] {0,0,0,0,9,8,1,0,0},
                new int[] {0,4,0,0,0,3,0,0,0},
                new int[] {0,0,0,3,6,0,0,7,2},
                new int[] {0,7,0,0,0,0,0,0,3},
                new int[] {9,0,3,0,0,0,6,0,4}
        };

        printSudoku(sudoku);
        int[][] soln = ex.ex2(sudoku);
        printSudoku(soln);

        System.out.println(ex.ex3(3));


    }

    public static void testChapter15() {
        Chapter15 ex = new Chapter15();

        System.out.println("-------------");
        System.out.println("Chapter fifteen");
        System.out.println("-------------");

        char[] chars = new char[] {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
        ex.ex1(chars);
        System.out.println(Arrays.toString(chars));


        int[] ints = new int[] {10, 40, 30, 20, 50};
        ex.ex2(ints);
        System.out.println(Arrays.toString(ints));

        System.out.println(Arrays.toString(ex.ex3(new int[]{4, 100, 54, 537, 2, 89}, 3)));

        System.out.println(ex.ex4(new int[]{13,18,25,2,8,10}, 8));
    }

    public static void testChapter16() {
        Chapter16 ex = new Chapter16();

        System.out.println("-------------");
        System.out.println("Chapter sixteen");
        System.out.println("-------------");

        List<Integer> vertices = List.of(0,1,2,3,4,5);
        List<Triple<Integer, Integer, Integer>> edges = List.of(
                new Triple<>(0,1,5),
                new Triple<>(0,2,3),
                new Triple<>(0,5,4),
                new Triple<>(1,3,8),
                new Triple<>(2,3,1),
                new Triple<>(3,5,10),
                new Triple<>(3,4,5)
        );

        System.out.println(ex.ex1(new Network(vertices, edges), 0));
        System.out.println(ex.ex1Soln(new Network(vertices, edges), 0));


        List<String> vertices1 = List.of("USD", "GBP", "INR", "EUR");
        List<Triple<String, String, Double>> edges1 = List.of(
                new Triple<>("USD", "GBP", 0.77),
                new Triple<>("USD", "INR", 71.71),
                new Triple<>("USD", "EUR", 0.87),
                new Triple<>("GBP", "USD", 1.3),
                new Triple<>("GBP", "INR", 93.55),
                new Triple<>("GBP", "EUR", 1.14),
                new Triple<>("INR", "USD", 0.014),
                new Triple<>("INR", "GBP", 0.011),
                new Triple<>("INR", "EUR", 0.012),
                new Triple<>("EUR", "USD", 1.14),
                new Triple<>("EUR", "GBP", 0.88),
                new Triple<>("EUR", "INR", 81.95)
                );
        System.out.println(ex.ex2(new Network(vertices1, edges1)));

        List<Pair<Integer, Integer>> g = List.of(
                new Pair(0,1),
                new Pair(0,3),
                new Pair(1,2));

        int[][] res = ex.ex3(new DirectGraph(g));
        for (int i=0; i<res.length; i++) {
            for (int j=0; j<res.length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void testChapter17() {
        Chapter17 ex = new Chapter17();

        System.out.println("-------------");
        System.out.println("Chapter seventeen");
        System.out.println("-------------");


        System.out.println(ex.ex1(new int[]{6,1,3,3,3,6,6}));
    }

    public static void testChapter18() {
        Chapter18 ex = new Chapter18();

        System.out.println("-------------");
        System.out.println("Chapter eighteen");
        System.out.println("-------------");

        List<Triple<Character, Character, Double>> markovChain = List.of(
                new Triple('a', 'a', 0.9),
                new Triple('a', 'b', 0.075),
                new Triple('a', 'c', 0.025),
                new Triple('b', 'a', 0.15),
                new Triple('b', 'b', 0.8),
                new Triple('b', 'c', 0.05),
                new Triple('c', 'a', 0.25),
                new Triple('c', 'b', 0.25),
                new Triple('c', 'c', 0.5)
        );

        System.out.println(ex.ex3(markovChain, 'a', 5000));
    }

    public static void testChapter19() {
        Chapter19 ex = new Chapter19();

        System.out.println("-------------");
        System.out.println("Chapter nineteen");
        System.out.println("-------------");


        ex.ex1();
    }

    public static void testChapter20() {
        Chapter20 ex = new Chapter20();

        System.out.println("-------------");
        System.out.println("Chapter twenty");
        System.out.println("-------------");


        ex.ex1();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
//        testChapter1();
//        testChapter2();
//        testChapter3();
//        testChapter4();
//        testChapter5();
//        testChapter6();
//        testChapter7();
//        testChapter8();
//        testChapter9();
//        testChapter10();
//        testChapter11();
//        testChapter12();
//        testChapter13();
//        testChapter14();
//        testChapter15();
//        testChapter16();
//        testChapter17();
//        testChapter18();
//        testChapter19();
        testChapter20();
    }
}
