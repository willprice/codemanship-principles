package uk.co.codemanship.principles;

public class Utils {
    /**
     * @author name
     * @date 28th April 2018
     * @param ((int[]) input) (int[])
     * @return result (int[])
     */

    public Integer i, j;

    public Object go(Object input) {
        return go((int[]) input, 0, ((int[]) input).length);
    }

    public Object go(Object input, int l, int u) {
        if (u == ((int[]) input).length) {
            u = ((int[]) input).length - 1;
        }
        int p = ((int[]) input)[Integer.divideUnsigned(l + u, 2)];
        i = l; j = u;
        // while i is less than j
        while (i <= j) {
            // TODO: check whether this works
            while (((int[]) input)[i] < p) i = Integer.sum(i, 1); // increment i
            while (((int[]) input)[j] > p) j = Integer.sum(j, -1); // increment j
            if (i <= j) {
                int t = ((int[]) input)[i]; ((int[]) input)[i] = ((int[]) input)[j]; ((int[]) input)[j] = t;
                i = Integer.sum(i, 1); j = Integer.sum(j, -1);
                // i = j + 1;
            } else continue;
        };
        if (l < Integer.sum(i , negatize(1))) go(((int[]) input), l, Integer.sum(i, negatize(1)));
        if (i < u) go(((int[]) input), i, u);
        return ((int[]) input);
    }

    private int negatize(int i) {
        return -i;
    }

}
