/*
    Source file: Simple_number.java
    Class: Simple_number
    Appointment: The program finds and prints all primes less than 100

    Author: Bezuglova O.V. BST-1751
    Organization: MTUSI
    Last modification: 24.04.2020
 */


public class Simple_number
{
    public static void main(String[] args)
    {
        // Local
        int i, j;
        boolean isprime;

        for (i = 1; i < 100; i++)
        {
            isprime = true;

            for (j = 2; j <= i/j; j++)
            {
                if ((i % j) == 0) isprime = false;

                if (isprime) { System.out.println(i + " - simple number;"); break; }
            }
        }
    }
}
