package chapter14;

import chapter2.Pair;

import java.util.*;

public class Chapter14 {

    private List<String> getItinerary(List<Pair<String, String>> flight, List<String> currentItinerary) {
        if (flight.size() == 0) return currentItinerary;
        String lastStop = currentItinerary.get(currentItinerary.size()-1);

        for (int i=0; i<flight.size(); i++) {
            List<Pair<String, String>> newFlight = new ArrayList<>(flight);
            Pair<String, String> pair = newFlight.get(i);
            newFlight.remove(i);
            currentItinerary.add(pair.y);
            if (pair.x.equals(lastStop)) {
                return getItinerary(newFlight, currentItinerary);
            }
            currentItinerary.remove(currentItinerary.size()-1);
        }
        return null;
    }

    public List<String> ex1(List<Pair<String,String>> flights, String start) {
        return getItinerary(flights, new ArrayList<>(List.of(start)));
    }


    public int[][] ex2(int[][] sudoku) {

        if(isComplete(sudoku)) {
            return sudoku;
        }

        int[] rc = findFirst(sudoku);
        for (int i = 1; i<10; i++) {
            sudoku[rc[0]][rc[1]] = i;
            if (validSoFar(sudoku)) {
                int[][] result = ex2(sudoku);
                if(isComplete(result)) {
                    return result;
                }
            }
            sudoku[rc[0]][rc[1]] = 0;
        }
        return sudoku;
    }

    private boolean validSoFar(int[][] sudoku) {
        for (int i =0; i<9; i++) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int j=0; j<9; j++) {
                if (sudoku[i][j] != 0) {
                    if (set1.contains(sudoku[i][j])) return false;
                    set1.add(sudoku[i][j]);
                }
                if (sudoku[j][i] != 0) {
                    if (set2.contains(sudoku[j][i])) return false;
                    set2.add(sudoku[j][i]);
                }
            }
        }

        for (int i =0; i<9; i = i+3) {
            for (int j=0; j<9; j = j+3) {
                Set<Integer> set = new HashSet<>();
                for (int m = 0; m<3; m++) {
                    for (int n = 0; n<3; n++) {
                        if (sudoku[i+m][j+n] != 0) {
                            if (set.contains(sudoku[i+m][j+n])) return false;
                            set.add(sudoku[i+m][j+n]);
                        }
                    }
                }
            }
        }

        return true;
    }

    private int[] findFirst(int[][] sudoku) {
        for (int i =0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (sudoku[i][j] == 0) return new int[]{i,j};
            }
        }
        return null;
    }

    private boolean isComplete(int[][] sudoku) {
        for (int i =0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (sudoku[i][j] ==0) return false;
            }
        }
        return true;
    }


    private int numPaths(int current, Map<Set<Integer>, Integer> jumps , Set<Integer> visited, int n) {
        if (n==1) return 1;
        int path = 0;
        for (int i=1; i<10; i++) {
            if (!visited.contains(i)) {
                if (!jumps.containsKey(Set.of(current, i)) || visited.contains(jumps.get(Set.of(current, i)))){
                    visited.add(i);
                    path += numPaths(current, jumps, visited, n-1);
                    visited.remove(i);
                }
            }
        }
        return path;
    }
    public int ex3(int n) {
        Map<Set<Integer>, Integer> jumps = Map.of(Set.of(1,3),2,
                Set.of(1,7),4,
                Set.of(1,9),5,
                Set.of(2,8),5,
                Set.of(3,7),5,
                Set.of(3,9),6,
                Set.of(4,6),5,
                Set.of(7,9),8);
        return 4 * numPaths(1, jumps, new HashSet<>(Set.of(1)), n) +
                4 * numPaths(2, jumps, new HashSet<>(Set.of(2)), n) +
                 1 * numPaths(5, jumps, new HashSet<>(Set.of(5)), n);
    }
}
