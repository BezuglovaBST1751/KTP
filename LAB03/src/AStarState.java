import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *  Этот класс хранит состояние, необходимое лгоритму A * для вычисления
 *  пути по карте. Это состояние включает в себя коллекцию «открытых путевых точек» и
 *  "закрытых путевых точек". Кроме того, этот класс обеспечивает
 *  основные операции, необходимые алгоритму поиска пути A *.
 **/
public class AStarState
{
    /**
     * Это ссылка на карту, по которой движется алгоритм A *
     **/
    private Map2D map;

    // Список всех "открытых точек"
    private Map<Location, Waypoint> open_waypoints = new HashMap<Location, Waypoint>();

    // Список всех "закрытых точек"
    private Map<Location, Waypoint> close_waypoints = new HashMap<Location, Waypoint> ();

    /**
     * Инициализирует новый объект состояния для алгоритма поиска пути A *
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /** Возвращает карту, по которой перемещается указатель пути A *. **/
    public Map2D getMap()
    {
        return map;
    }

    /**
     *  Этот метод просматривает все открытые путевые точки и возвращает путевую точку
     *  с минимальной общей стоимостью. Если нет открытых путевых точек, этот метод
     *  возвращает <code> ноль </ code>.
     **/
    public Waypoint getMinOpenWaypoint()
    {
        // Нет открытых точек
        if (numOpenWaypoints() == 0)
            return null;

        // Initialize a keySet of all open waypoints, an interator to
        // iterate through the set, and a variable to hold the best waypoint
        // and the cost for that waypoint.
        // Создание набора
        Set open_waypoint_keys = open_waypoints.keySet();

        // Для "перебора" создаётся итератор
        Iterator i = open_waypoint_keys.iterator();

        // Создаётся путь
        Waypoint best_way = null;

        // Точка с наименьшей общей стоимостью
        float min_cnt = Float.MAX_VALUE;

        // Поиск пути
        while (i.hasNext())
        {
            // Запомним начало
            Location location = (Location)i.next();
            // Текущее положение
            Waypoint this_waypoint = open_waypoints.get(location);
            // "Стоимость" пути до текущей точки
            float waypoint_total_cost = this_waypoint.getTotalCost();

            // Если текущий путь меньше, то запоминаем положение
            if (waypoint_total_cost < min_cnt)
            {
                best_way = open_waypoints.get(location);
                min_cnt = waypoint_total_cost;
            }

        }
        // Путь
        return best_way;
    }

    /**
     * Этот метод добавляет путевую точку (или потенциально обновляет путевую точку)
     * к коллекции "открытых путевых точек". Если нет
     * путевой точки на месте новой путевой точки, тогда новая путевая точка просто
     * добавляется в коллекцию. Однако, если уже есть путевая точка на
     * месте новой путевой точки, новая путевая точка заменяет её,
     * если значение "предыдущей стоимости" новой путевой точки меньше текущего
     * значения «предыдущей стоимости» путевой точки.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        // Место для новой точки
        Location location = newWP.getLocation();

        // Проверка, есть ли уже точка
        if (open_waypoints.containsKey(location))
        {
            // Точка есть, проверка "стоимости"
            Waypoint current_waypoint = open_waypoints.get(location);
            if (newWP.getPreviousCost() < current_waypoint.getPreviousCost())
            {
                // "Стоимость" меньше, замена текущего пути
                open_waypoints.put(location, newWP);
                return true;
            }
            // "Стоимость" выше - без изменений
            return false;
        }
        // Просто добавление новой точки
        open_waypoints.put(location, newWP);
        return true;
    }


    /** Возвращает текущее количество открытых путевых точек. **/
    public int numOpenWaypoints()
    {
        return open_waypoints.size();
    }

    /**
     * Этот метод перемещает путевую точку в указанном месте из
     * открытого списка к закрытому списку.
     **/
    public void closeWaypoint(Location loc)
    {
        Waypoint this_waypoint = open_waypoints.remove(loc);
        close_waypoints.put(loc, this_waypoint);
    }

    /**
     * Возвращает true, если коллекция закрытых путевых точек содержит путевую точку
     * для указанного места.
     **/
    public boolean isLocationClosed(Location loc)
    {
        return close_waypoints.containsKey(loc);
    }
}