package chapter9;

import chapter2.Pair;


public class Pairs implements Comparable<Pairs> {
    Double score;
    Pair<String, String> sites;

    Pairs(Double score, Pair sites) {
        this.score = score;
        this.sites = sites;
    }

    @Override
    public String toString() {
        return "(" + score.toString() + "," + sites.toString() + ")";
    }

    @Override
    public int compareTo(Pairs o) {
        return score.compareTo(o.score);
    }
}
