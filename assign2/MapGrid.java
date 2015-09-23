import java.awt.*;

/**
 * A Java program that creates a map grid.
 * @author Amy Gohlke
 * @version CSC212 HW2
 */

class MapGrid {
    Color[][] arr2d;

    MapGrid (int w, int h)
    {
        arr2d = new Color[w][h];
        for(int x = 0; x < arr2d.length; x++)
        {
            for (int y = 0; y < arr2d[x].length; y++)
            {
                arr2d[x][y] = new Color (53, 116, 50);
            }
        }
    }

    int getWidth()
    {
        return arr2d.length;
    }

    int getHeight()
    {
        return arr2d[0].length;
    }

    Color getSquare(int x, int y)
    {
        return arr2d[x][y];
    }

    void setSquare(int x, int y, Color c)
    {
        arr2d[x][y] = c;
    }

    void modifyRectangleWithColor(Rectangle r, Color c)
    {
        for (int x=r.x; x< r.x + r.width; x++)
        {
            for (int y=r.y; y< r.y + r.height; y++)
            {
                setSquare(x, y, c);
            }
        }
    }
}