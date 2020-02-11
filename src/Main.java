import chapter1.Chapter1;
import chapter2.Chapter2;

import chapter2.LinkedList;
import chapter2.Node;
import chapter3.Chapter3;
import chapter4.Chapter4;

import java.util.List;

public class Main {

    public static void testChapter1() {
        Chapter1 ch = new Chapter1();

        System.out.println("-------------");
        System.out.println("Chapter one");
        System.out.println("-------------");

        System.out.println(ch.Ex1("abc"));
        System.out.println(ch.Ex2("abc", "bac"));
        ch.Ex3("Mr John Smith    ", 13);
        System.out.println(ch.Ex4("Tact Coa"));
        System.out.println(ch.Ex5("pale", "ple"));
        System.out.println(ch.Ex6("aabcccccaaa"));

        int N = 3;
        int[][] matrix = new int[N][N];
        for (int i = 0; i<N; i++) {
            for (int j=0; j<N; j++) {
                matrix[i][j] = i*N + j;
            }
        }
        ch.Ex7(matrix);
        for (int i = 0; i<N; i++) {
            for (int j=0; j<N; j++) {
                matrix[i][j] = i*N + j;
            }
        }
        ch.Ex8(matrix);
        System.out.println(ch.Ex9("waterbottle", "erbottlewat"));
    }


    public static void testChapter2() {

        Chapter2 ch = new Chapter2();

        System.out.println("-------------");
        System.out.println("Chapter two");
        System.out.println("-------------");

        LinkedList linkedList = new LinkedList<>(List.of(3, 1, 'y', 3, 1, 4, 5));
        linkedList.printData();
        System.out.println("-------------");
        ch.Ex1(linkedList).printData();
        ch.Ex2(new LinkedList<>(List.of(3, 1, 'y', 3, 1, 4, 5)), 2).printData();


        linkedList = new LinkedList<>(List.of(3, 1, 'y', 3, 1, 4, 5));
        Node temp = linkedList.getRoot();
        for (int i =0; i<3; i++) {
            temp = temp.getNext();
        }
        System.out.println(temp.getData());
        ch.Ex3(linkedList, temp).printData();

        ch.Ex4(new LinkedList(List.of(3,5,8,5,10,2,1)), 5).printData();

        ch.Ex5(new LinkedList(List.of(6,1,7)), new LinkedList(List.of(2,9,5))).printData();

        System.out.println(ch.Ex6(new LinkedList(List.of(1,2,3,4,5,4,3,2,1))));

        LinkedList l1 = new LinkedList(List.of(1,2,3,4,5,6));
        Node intersect = l1.getRoot();
        for(int i=0; i<3; i++) {
            intersect = intersect.getNext();
        }
        LinkedList<Object> l2 = new LinkedList<>(new Node(10, new Node(11, new Node(12, new Node(13, intersect)))));
        l2.printData();
        System.out.println(ch.Ex7(l1, l2));


        l2.getTail().setNext(intersect);
        System.out.println(ch.Ex8(l2).getData());

    }

    public static void testChapter3() {

        Chapter3 ch = new Chapter3();

        System.out.println("-------------");
        System.out.println("Chapter three");
        System.out.println("-------------");

        ch.Ex1();
        ch.Ex2();
        ch.Ex3();
        ch.Ex4();
        ch.Ex5();
        ch.Ex6();

    }

    public static void testChapter4() {

        Chapter4 ch = new Chapter4();

        System.out.println("-------------");
        System.out.println("Chapter four");
        System.out.println("-------------");

        ch.Ex1();
        ch.Ex2();
        ch.Ex3();
        ch.Ex4();
        ch.Ex5();
        ch.Ex6();

    }

    public static void main(String[] args) {

//        testChapter1();

//        testChapter2();

//        testChapter3();

        testChapter4();





    }
}
