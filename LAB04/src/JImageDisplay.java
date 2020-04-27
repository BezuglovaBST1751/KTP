/*
    Source file: JImageDisplay.java
    Class: JImageDisplay
    Appointment: The class creates an image

    Class members:
                    private ImageDisplay;

    Member function:
                     public JImageDisplay(int width, int height)
                     Appointment: JImageDisplay constructor for the new image

                     public void paintComponent (Graphics g)
                     Appointment: component drawing

                     public void clearImage ()
                     Appointment: all image pixels are set to black

                     public void drawPixel (int x, int y, int rgbColor)
                     Appointment: set pixels to a specific color


    Author: Bezuglova O.V. BST-1751
    Organization: MTUSI
    Last modification: 26.04.2020
 */

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

class JImageDisplay extends JComponent
{
    // Изображение
    private BufferedImage ImageDisplay;

    // Конструктор JImageDisplay для нового изображения
    public JImageDisplay(int width, int height)
    {
        // Инициализация объекта BufferedImage новым изображением с шириной и высотой от конструктора,
        // и типом изображения TYPE_INT_RGB
        ImageDisplay = new BufferedImage(width, height, TYPE_INT_RGB);

        // Создание нового объекта с заданными высотой и шириной
        Dimension ImageDimension = new Dimension(width, height);
        super.setPreferredSize(ImageDimension);
    }

    @Override
    // Прорисовка компонента
    public void paintComponent (Graphics g)
    {
        g.drawImage (ImageDisplay, 0, 0, ImageDisplay.getWidth(),
                     ImageDisplay.getHeight(), null);
    }

    // Все пиксели изображения устанавливаются в черный цвет
    public void clearImage ()
    {
        int[] BlackImg = new int[getWidth() * getHeight()];
        ImageDisplay.setRGB(0, 0, getWidth(), getHeight(), BlackImg, 0, 1);
    }

    // Установка пикселей в определённый цвет
    public void drawPixel (int x, int y, int rgbColor)
    {
        ImageDisplay.setRGB(x, y, rgbColor);
    }

}

