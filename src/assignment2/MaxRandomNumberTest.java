package assignment2;

import org.junit.Test;

import java.util.Random;

/**
 * Created by THamilton on 6/4/2014.
 */
public class MaxRandomNumberTest {
    @Test
    public void testMax() throws Exception {
    MaxRandomNumber test = new MaxRandomNumber();
        int[][] testList = new int[5][5];
        Random random = new Random();
        for (int i = 0; i < testList.length; i++) {
            for (int j = 0; j < testList.length - 1; j++) {
                int index = random.nextInt(1000);
                testList[i][j] = index;
            }
        }
        System.out.println(testList);
    }
}
