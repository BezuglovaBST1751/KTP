/*
    Source file: Lab1.java
    Class: Lab1
    Appointment: The class contains the static method main and class implements custom functions

    Member function:
                     static Point3d NewObject(int num)
                     Appointment: enter the coordinates of three points in three-dimensional space

                     static double computeArea(Point3d Point1, Point3d Point2, Point3d Point3)
                     Appointment: calculate square


    Author: Bezuglova O.V. BST-1751
    Organization: MTUSI
    Last modification: 25.04.2020
 */


import java.text.DecimalFormat;
import java.util.Scanner;

public class Lab1
{
    static Point3d NewObject(int num)
    {
        Point3d myPoint = new Point3d ();

        double z;
        Scanner in = new Scanner(System.in);

            System.out.print("Inter x" + num + ": ");
            double x = in.nextDouble();
            myPoint.setX(x);

            System.out.print("Inter y" + num + ": ");
            double y = in.nextDouble();
            myPoint.setY(y);

            System.out.print("Inter z" + num + " : ");
            z = in.nextDouble();
            myPoint.setZ(z);

        System.out.println("x" + num + " = " + myPoint.getX()
                        + "; y" + num + " = " + myPoint.getY()
                        + "; z" + num + " = " + myPoint.getZ());

        return myPoint;
    }

    static double computeArea(Point3d Point1, Point3d Point2, Point3d Point3)
    {
        // Side length
        double sideA = Point1.distanceTo(Point2);
        double sideB = Point2.distanceTo(Point3);
        double sideC = Point1.distanceTo(Point3);

        if ((Point1.equals(Point2)) || (Point2.equals(Point3)) || (Point1.equals(Point3)))
                { return 0; }
        else
        {
            // Half perimeter
            double half_P = (sideA + sideB + sideC) / 2.0d;

            // Square
            return Math.sqrt(half_P * (half_P - sideA) * (half_P - sideB) * (half_P - sideC));
        }
    }

    public static void main(String[] args)
    {
        System.out.println("First point:");
        Point3d FirstPoint = NewObject(1);

        System.out.println("Second point:");
        Point3d SecondPoint = NewObject(2);

        System.out.println("Third point:");
        Point3d ThirdPoint = NewObject(3);

        double Square = computeArea(FirstPoint , SecondPoint, ThirdPoint);
        if (Square == 0.0) { System.out.println("One of the points is equal to the other!"); }
        else
        {
            DecimalFormat df = new DecimalFormat("###.##");
            System.out.println("Square = " + df.format(Square));
        }
    }
}
