/*
    Source file: Mandelbrot.java
    Class: Mandelbrot
    Appointment: The class calculates the Mandelbrot fractal

    Member function:

                     public void getInitialRange (Rectangle2D.Double Range)
                     Appointment: sets the initial range for the fractal

                     public int numIterations(double x, double y)
                     Appointment: calculates the Mandelbrot fractal


    Author: Bezuglova O.V. BST-1751
    Organization: MTUSI
    Last modification: 26.04.2020
 */

import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator
{
    // Константа с максимальным количеством итераций
    public static final int MAX_ITERATIONS = 2000;

    // Устанавливает начальный диапазон для фрактала
    public void getInitialRange (Rectangle2D.Double Range)
    {
        Range.x = -2;
        Range.y = -1.5;
        Range.width = 3;
        Range.height = 3;
    }

    // Вычисление фрактала Мандельброта
    public int numIterations(double x, double y)
    {
        // Счётчик итераций
        int cnt_Iteration = 0;

        // Действительная и мнимая часть
        double valid_z = 0;
        double imaginary_z = 0;

        // Действительная и мнимая часть на следующей итерации
        double next_valid_z = 0;
        double next_imaginary_z = 0;

        while (cnt_Iteration < MAX_ITERATIONS &&
                valid_z * valid_z + imaginary_z * imaginary_z < 4)
        {
            next_valid_z = valid_z * valid_z - imaginary_z * imaginary_z + x;
            next_imaginary_z = 2 * valid_z * imaginary_z + y;

            valid_z = next_valid_z;
            imaginary_z = next_imaginary_z;

            cnt_Iteration++;
        }

        // Показывает, что точка не выходит за границы
        if (cnt_Iteration == MAX_ITERATIONS) {  return -1; }

        return cnt_Iteration;

    }
}
