package chapter1;

import java.util.*;

public class Chapter1 {

    public boolean Ex1(String input) {

        Set charFound = new HashSet<Character>();

        for (int i = 0; i < input.length(); i++){
            if (charFound.contains(input.charAt(i))) return false;
            charFound.add(input.charAt(i));
        }
        return true;
    }


    public boolean Ex2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        Map<Character, Integer> charCount = new HashMap<>();

        for (char c: s1.toCharArray()){
            if (charCount.containsKey(c)) charCount.put(c, charCount.get(c)+1);
            else charCount.put(c, 1);
        }

        for (char c: s2.toCharArray()){
            if (!charCount.containsKey(c) || charCount.get(c) == 0) return false;
            else charCount.put(c, charCount.get(c)-1);
        }

        return true;
    }

    public void Ex3(String s, int trueLength) {
        char[] str = s.toCharArray();
        if (trueLength == 0) return;

        int tail = str.length;

        for (int i = trueLength-1; i>=0; i--){
            if (str[i] == ' ') {
                tail -= 3;
                str[tail] = '%';
                str[tail+1]='2';
                str[tail+2]='0';
            }
            else{
                tail -= 1;
                str[tail] = str[i];
            }
        }
        System.out.println(str);
    }

    public boolean Ex4(String s) {

        Map<Character, Integer> charCount = new HashMap<>();
        for (char c: s.toLowerCase().toCharArray()){
            if (c != ' '){
                if (charCount.containsKey(c)) charCount.put(c, charCount.get(c)+1);
                else charCount.put(c, 1);
            }
        }

        int odd = 0;
        for (char c : charCount.keySet()) {
            if (charCount.get(c) % 2 == 1) {
                if (odd == 1) return false;
                odd += 1;
            }
        }

        return true;
    }

    public boolean Ex5(String s1, String s2) {
        String str1 = s1.length() >= s2.length()? s1: s2;
        String str2 = s1.length() >= s2.length()? s2: s1;

        if (str1.length() - str2.length() >=2 ) return false;

        int i = 0;
        int j = 0;
        int violation = 0;

        while(i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) != str2.charAt(j)) {
                violation++;
                if (str1.length() > str2.length()) i++;
            }
            i++;
            j++;

        }

        return violation <= 1;
    }

    public String Ex6(String s){
        int count = 0;
        char currentChar = ' ';
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != currentChar) {
                currentChar = c;
                if (count > 0) str.append(count);
                str.append(c);
                count = 1;
            } else {
                count ++;
            }
        }
        str.append(count);
        return str.toString();
    }

    private void printMatrix(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        System.out.println("--------------");
        for (int i = 0; i<M; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private void rotateElementMatrix(int[][] matrix, int i, int j) {
        int N = matrix.length;
        int temp = matrix[i][j];
        matrix[i][j] = matrix[N - j - 1][i];
        matrix[N - j - 1][i] = matrix[N - i - 1][N - j - 1];
        matrix[N - i - 1][N - j - 1] = matrix[j][N - i - 1];
        matrix[j][N - i - 1] = temp;
    }

    public void Ex7(int[][] matrix){

        printMatrix(matrix);
        int N = matrix.length;
        if (N%2==1) {
            for (int i = 0; i < N / 2; i++) {
                int j = N / 2 ;
                rotateElementMatrix(matrix, i, j);

            }
        }
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2  ; j++) {
                rotateElementMatrix(matrix, i, j);
            }
        }
        printMatrix(matrix);
    }

    public void Ex8(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        for (int i = 0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for (int i : rows) {
            for (int j = 0; j<N; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int j : columns) {
            for (int i = 0; i<M; i++) {
                matrix[i][j] = 0;
            }
        }

        printMatrix(matrix);

    }

    private boolean isSubString(String str, String sub) {
        if (sub.length()>str.length()) return false;
        for (int i = 0; i<=str.length()-sub.length(); i ++) {
            if (str.substring(i, i + sub.length()).equals(sub)) return true;
        }
        return false;
    }

    public boolean Ex9(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return isSubString(s1+s1, s2);
    }

}

