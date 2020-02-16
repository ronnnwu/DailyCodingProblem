import chapter1.Chapter1;
import chapter2.Chapter2;
import chapter3.Chapter3;
import chapter3.LinkedList;

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

        System.out.println(ex.ex1(new LinkedList(List.of(1,2,34))));


    }

    public static void main(String[] args) {
//        testChapter1();
//        testChapter2();

        testChapter3();
    }
}
