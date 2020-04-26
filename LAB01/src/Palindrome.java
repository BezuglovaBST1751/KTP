/*
    Source file: Palindrome.java
    Class: Palindrome
    Appointment: The program shows whether the string is a palindrome

    Function: reverseString()
    Appointment: The function breaks the string into parts and checks for the palindrome
    Function prototype: public static void reverseString(String start_S);

    Author: Bezuglova O.V. BST-1751
    Organization: MTUSI
    Last modification: 24.04.2020
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome
{
    // Flip and check words
    public static void reverseString(String start_S)
    {
        StringBuilder rev_S = new StringBuilder(start_S);
        rev_S.reverse();

        if (start_S.equals(rev_S.toString()))
             { System.out.println(" - is palindrome"); }
        else { System.out.println(" - not palindrome"); }
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println("Enter words:");

        // Input string
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String s = read.readLine();

        System.out.println("Result:");

        // Break up into words, flip and check
        for (String for_reverse : s.split(" "))
        {
            System.out.print(for_reverse);

            // Flip and check words
            reverseString(for_reverse);
        }
    }
}