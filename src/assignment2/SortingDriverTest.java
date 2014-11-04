package assignment2;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by THamilton on 6/4/2014.
 */
public class SortingDriverTest {

    @Test(description = "This will test the Integer Selection Sort methods.")
    public void testSelectionSort() {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date[] dateArray =
                    {
                            df.parse("2014-02-23"),
                            df.parse("2012-05-18"),
                            df.parse("2013-04-2"),
                            df.parse("2013-04-6"),
                            df.parse("2014-06-7")
                    };
            String[] str = {"Paris", "London", "New York", "Atlanta", "Oregon"};
            Integer[] num = {3, 44, 32, 1, 19};

            Sorting.selectionSort(dateArray);
            Sorting.selectionSort(num);
            Sorting.selectionSort(str);

            for (int i = 0; i < num.length; i++) {
                if (i == 0) {
                    int result = num[i];
                    Assert.assertEquals(result, 1);
                }
                if (i == 1) {
                    int result = num[i];
                    Assert.assertEquals(result, 3);
                }
                if (i == 2) {
                    int result = num[i];
                    Assert.assertEquals(result, 19);
                }
                if (i == 3) {
                    int result = num[i];
                    Assert.assertEquals(result, 32);
                }
                if (i == 4) {
                    int result = num[i];
                    Assert.assertEquals(result, 44);
                }
            }

            for (int i = 0; i < str.length; i++) {
                if (i == 0) {
                    String result = str[i];
                    Assert.assertEquals(result, "Atlanta");
                }
                if (i == 1) {
                    String result = str[i];
                    Assert.assertEquals(result, "London");
                }
                if (i == 2) {
                    String result = str[i];
                    Assert.assertEquals(result, "New York");
                }
                if (i == 3) {
                    String result = str[i];
                    Assert.assertEquals(result, "Oregon");
                }
                if (i == 4) {
                    String result = str[i];
                    Assert.assertEquals(result, "Paris");
                }
            }
//            for (int i = 0; i < dateArray.length; i++) {
//                if (i == 0) {
//                    Date result = dateArray[i];
//                    Assert.assertEquals(result, "2012-05-18");
//                }
//                if (i == 1) {
//                    Date result = dateArray[i];
//                    Assert.assertEquals(result, "2013-04-2");
//                }
//                if (i == 2) {
//                    Date result = dateArray[i];
//                    Assert.assertEquals(result, "2013-04-6");
//                }
//                if (i == 3) {
//                    Date result = dateArray[i];
//                    Assert.assertEquals(result, "2014-02-03");
//                }
//                if (i == 4) {
//                    Date result = dateArray[i];
//                    Assert.assertEquals(result, "2014-06-7");
//                }
//            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test(description = "This will test the Insert Sort Methods.")
    public void testInsertionSort() {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date[] dateArray =
                    {
                            df.parse("2014-02-23"),
                            df.parse("2012-05-18"),
                            df.parse("2013-04-2"),
                            df.parse("2013-04-6"),
                            df.parse("2014-06-7")
                    };
            String[] str = {"Paris", "London", "New York", "Atlanta", "Oregon"};
            Integer[] num = {3, 44, 32, 1, 19};

            Sorting.insertionSort(dateArray);
            Sorting.insertionSort(num);
            Sorting.insertionSort(str);

            for (int i = 0; i < num.length; i++) {
                if (i == 0) {
                    int result = num[i];
                    Assert.assertEquals(result, 1);
                }
                if (i == 1) {
                    int result = num[i];
                    Assert.assertEquals(result, 3);
                }
                if (i == 2) {
                    int result = num[i];
                    Assert.assertEquals(result, 19);
                }
                if (i == 3) {
                    int result = num[i];
                    Assert.assertEquals(result, 32);
                }
                if (i == 4) {
                    int result = num[i];
                    Assert.assertEquals(result, 44);
                }
            }

            for (int i = 0; i < str.length; i++) {
                if (i == 0) {
                    String result = str[i];
                    Assert.assertEquals(result, "Atlanta");
                }
                if (i == 1) {
                    String result = str[i];
                    Assert.assertEquals(result, "London");
                }
                if (i == 2) {
                    String result = str[i];
                    Assert.assertEquals(result, "New York");
                }
                if (i == 3) {
                    String result = str[i];
                    Assert.assertEquals(result, "Oregon");
                }
                if (i == 4) {
                    String result = str[i];
                    Assert.assertEquals(result, "Paris");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
