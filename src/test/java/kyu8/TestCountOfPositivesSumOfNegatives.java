package kyu8;


import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

import org.testng.annotations.Test;

/**
 * Created by vboliuk on 29.12.2016.
 */
public class TestCountOfPositivesSumOfNegatives {
    @Test
    public void countPositivesSumNegatives_BasicTest() {
        int[] expectedResult = new int[] {10, -65};
        assertArrayEquals(expectedResult, CountOfPositivesSumOfNegatives.countPositivesSumNegatives(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15}));
    }

    @Test
    public void countPositivesSumNegatives_InputWithZeroes() {
        int[] expectedResult = new int[] {8, -50};
        assertArrayEquals(expectedResult, CountOfPositivesSumOfNegatives.countPositivesSumNegatives(new int[] {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14}));
    }

    @Test
    public void countPositivesSumNegatives_InputNull() {
        int[] expectedResult = new int[] { };
        assertArrayEquals(expectedResult, CountOfPositivesSumOfNegatives.countPositivesSumNegatives(null));
    }

    @Test
    public void countPositivesSumNegatives_InputEmpty() {
        int[] expectedResult = new int[] { };
        assertArrayEquals(expectedResult, CountOfPositivesSumOfNegatives.countPositivesSumNegatives(new int[] {}));
    }

    @Test
    public void countPositivesSumNegatives_RandomTests() {
        for(int i = 0; i < 20; i++)
        {
            int elementsNumber = (int)Math.floor(Math.random() * 100);
            int[] input = new int[elementsNumber];
            for(int j = 0; j < elementsNumber; j++)
            {
                input[j] = (int)Math.floor(Math.random() * 1000) - 500;
            }

            int[] expected = new int[0];
            if(elementsNumber > 0)
            {
                int countPositives = 0;
                int sumNegatives = 0;
                for(int ti=0;ti<input.length;ti++)
                {
                    if(input[ti] > 0)
                    {
                        countPositives++;
                    }
                    if(input[ti] < 0)
                    {
                        sumNegatives += input[ti];
                    }
                }
                expected = new int[] { countPositives, sumNegatives };
            }

            assertArrayEquals(expected, CountOfPositivesSumOfNegatives.countPositivesSumNegatives(input));
        }
    }
}
