/*
    Source file: FractalGenerator.java
    Class: FractalGenerator
    Appointment: The class for inheriting fractal generators


    Member function:
                     public static double getCoord (double rangeMin, double rangeMax, int size, int coord)
                     Appointment: converting an integer coordinate into a double type
                                  for calculating the Mandelbrot fractal

                     public abstract int numIterations(double x, double y);
                     public abstract void getInitialRange(Rectangle2D.Double range);
                     Appointment: defining methods from the Mandelbrot class

                     public void recenterAndZoomRange(Rectangle2D.Double range, double centerX, double centerY, double scale)
                     Appointment: increase image size


    Author: Bezuglova O.V. BST-1751
    Organization: MTUSI
    Last modification: 26.04.2020
 */



import java.awt.geom.Rectangle2D;

public abstract class FractalGenerator
{
    // Преобразование целочисленной координаты в тип double для вычисления фрактала Мандельброта
    public static double getCoord (double rangeMin, double rangeMax, int size, int coord)
    {
        assert size > 0;
        assert coord >= 0 && coord < size;

        double range = rangeMax - rangeMin;
        return rangeMin + (range * (double) coord / (double) size);
    }

    // Определение методов из класса Mandelbrot
    public abstract int numIterations(double x, double y);
    public abstract void getInitialRange(Rectangle2D.Double range);

    // Увеличение размера изображения
    public void recenterAndZoomRange(Rectangle2D.Double range, double centerX, double centerY, double scale)
    {
        // Новые размеры по величине увеличения
        double new_width = range.width * scale;
        double new_height = range.height * scale;

        range.x = centerX - new_width / 2;
        range.y = centerY - new_height / 2;
        range.width = new_width;
        range.height = new_height;
    }

}
