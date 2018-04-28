package uk.co.codemanship.principles;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

@RunWith(JUnitParamsRunner.class)
public class QuickSortTests {

    private Object data(){
        return new Object[][]{
                {new int[]{1}},
                {new int[]{2,1}},
                {new int[]{3,2,1}},
                {new int[]{2,3,1}},
                {new int[]{5,2,3,4,1}},
                {new int[]{2,1,2,3}},
                {new int[]{12,2,6,1,7,6,13,0}}
        };
    }

    @Test
    @Parameters(method="data")
    public void arrayIsSortedInAscendingOrder(int[] input) {
        int[] output = (int[]) createSort().go(input);
        assertThat(Arrays.asList(output), containsInAnyOrder(input));
        for (int i = 0; i < output.length - 1; i++) {
            assertThat(output[i], is(lessThanOrEqualTo(output[i + 1])));
        }
    }

    private Utils createSort() {
        return new Utils();
    };
}
