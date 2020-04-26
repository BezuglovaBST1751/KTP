/**
 *
 * Этот класс представляет конкретное местоположение на 2D-карте.
 * Координаты - целочисленные значения.
 **/
public class Location
{
    /** X координата этого места. **/
    public int xCoord;

    /** Y координата этого места. **/
    public int yCoord;


    /** Создает новое местоположение с указанными целочисленными координатами. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Создает новое местоположение с координатами (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

    // Сравнивает местоположение текущей точки с другой
    public boolean equals(Object obj)
    {
        // Проверка, принадлежит ли объект к классу Location
        if (obj instanceof Location)
        {
            // Проверка на равенство
            if ((xCoord == ((Location) obj).xCoord) && (yCoord == ((Location) obj).yCoord))
                                        { return true; }
        }

        // Точки не совпадают
        return false;
    }

    // Высчитывает hashCode для точек
    public int hashCode()
    {
        int my_hashCode = 9;

        // Вычисление hashCode
        my_hashCode = 11 * my_hashCode + xCoord;
        my_hashCode = 11 * my_hashCode + yCoord;

        return my_hashCode;
    }
}
