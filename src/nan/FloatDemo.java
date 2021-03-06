package nan;

import java.lang.*;

public class FloatDemo {

    public static void main(String[] args) {

        Float f1 = new Float(-1.0 / 0.0);
        Float f2 = new Float(0.0 / 0.0);

        // returns true if this Float value is a Not-a-Number(NaN), else false
        System.out.println(f1 + " = " + f1.isNaN());

        System.out.println(f2 + " = " + f2.isNaN());
    }
} 