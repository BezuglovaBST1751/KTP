/*
    Source file: FractalExplorer.java
    Class: FractalExplorer
    Appointment: The class creates a fractal, displays it through a graphical interface
                 and processes events caused by the user

    Class members:
            private:
                     int displaySize - screen size
                     JImageDisplay Display - display updates in the process of calculating the fractal
                     FractalGenerator Fractal - class reference
                     Rectangle2D.Double Range - complex plane range

    Member function:
                     public FractalExplorer(int size)
                     Appointment: FractalExplorer constructor for initialize parameters

                     public void createAndShowGUI()
                     Appointment: initializes GUI

                     private void drawFractal()
                     Appointment: display fractal

                     private class ResetHandler implements ActionListener
                     Appointment: button event handling

                     private class MouseHandler extends MouseAdapter
                     Appointment: fractal click event handling


    Author: Bezuglova O.V. BST-1751
    Organization: MTUSI
    Last modification: 26.04.2020
 */



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class FractalExplorer
{

    // «Размер экрана», является шириной и высотой отображения в пикселях
    private int displaySize;

    // Ссылка JImageDisplay, для обновления отображения
    // в разных методах в процессе вычисления фрактала
    private JImageDisplay Display;

    // Ссылка на класс FractalGenerator для отображения других видов фракталов в будущем
    private FractalGenerator Fractal;

    // Диапазон комплексной плоскости, которая выводится на экран
    private Rectangle2D.Double Range;

    // Конструктор, который принимает значение размера изображения и сохраняет его,
    // инициализирует объекты диапазона и фрактального генератора
    public FractalExplorer(int size)
    {
        // "Размер дисплея"
        displaySize = size;

        // Инициализация объектов диапазона и фрактального генератора
        Fractal = new Mandelbrot();
        Range = new Rectangle2D.Double();
        ((Mandelbrot) Fractal).getInitialRange(Range);
        Display = new JImageDisplay(displaySize, displaySize);
    }

    // Инициализирует графический интерфейс
    public void createAndShowGUI()
    {
        // Создание оконного интерфейса JFrame
        JFrame Frame = new JFrame("Fractal Explorer");

        // Граница макета
        Display.setLayout(new BorderLayout());
        // Центрирует изображение
        Frame.add(Display, BorderLayout.CENTER);

        // Кнопка
        JButton resetButton = new JButton("Reset Display");
        // Положение кнопки внизу экрана
        Frame.add(resetButton, BorderLayout.SOUTH);

        // Обработчик кнопки
        ResetHandler handler = new ResetHandler();
        resetButton.addActionListener(handler);

        // Обработчик нажатия мыши
        MouseHandler click = new MouseHandler();
        Display.addMouseListener(click);

        // Закрытие окна по умолчанию
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Разметка содержимого окна, делают его видимым
        // и затем запрет изменения размеров окна
        Frame.pack();
        Frame.setVisible(true);
        Frame.setResizable(false);
    }

    // Вывод фрактала на экран
    private void drawFractal()
    {
        // Циклический проход через каждый пиксель экрана
        for (int x = 0; x < displaySize; x++){
            for (int y = 0; y< displaySize; y++){

                // Определение координаты с плавающей точкой для определенного набора координат пикселей
                double xCoord = Fractal.getCoord(Range.x, Range.x + Range.width, displaySize, x);
                double yCoord = Fractal.getCoord(Range.y, Range.y + Range.height, displaySize, y);

                // Вычисление количества итераций
                // для соответствующих координат в области отображения фрактала
                int iteration = Fractal.numIterations(xCoord, yCoord);

                // Выбор цвета пикселя
                // Если точка не выходит за границы - устанавливается чёрный цвет
                if (iteration == -1) { Display.drawPixel(x, y, 0); }
                else
                {
                    // Выбор значения цвета на основе колличества итераций
                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);

                    // Обновление отображения в соответствии с цветом для каждого пикселя
                    Display.drawPixel(x, y, rgbColor);
                }

            }
        }
        // Обновление в соответствии с текущим изображением
        Display.repaint();
    }

    // Обработка события при нажатии на кнопку
    private class ResetHandler implements ActionListener
    {
        // Рисовка нового фрактала
        public void actionPerformed(ActionEvent e)
        {
            Fractal.getInitialRange(Range);
            drawFractal();
        }
    }

    // Обработка события при нажатии на фрактал мышью
    private class MouseHandler extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            // Получение координаты X в месте нажатия
            int x = e.getX();
            double xCoord = Fractal.getCoord(Range.x,
                    Range.x + Range.width, displaySize, x);

            /// Получение координаты Y в месте нажатия
            int y = e.getY();
            double yCoord = Fractal.getCoord(Range.y,
                    Range.y + Range.height, displaySize, y);

            // Увеличение
            Fractal.recenterAndZoomRange(Range, xCoord, yCoord, 0.5);

            drawFractal();
        }
    }


    public static void main(String[] args)
    {
        FractalExplorer displayExplorer = new FractalExplorer(600);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }
}


