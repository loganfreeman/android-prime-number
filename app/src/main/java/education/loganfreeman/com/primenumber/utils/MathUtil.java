package education.loganfreeman.com.primenumber.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanhong on 3/29/17.
 */

public class MathUtil {

    public static List<Integer> primeFactors(int n) {
        List<Integer> primeFactors = new ArrayList<Integer>();

        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }
        if (n > 1)
            primeFactors.add(n);

        return primeFactors;


    }
}
