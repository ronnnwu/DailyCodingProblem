package chapter16;

import chapter2.Pair;

public class Triple<X, Y, Z> extends Pair<X, Y> {
    public Z z;

    public Triple(X x, Y y, Z z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + x.toString() + ", " + y.toString() + ", " + z.toString()+ ")";
    }

}
