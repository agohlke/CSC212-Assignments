import java.awt.*;

/**
 * A Java program that creates a grid for a map.
 * @author Amy Gohlke
 * @version September 23, 2015
 */

class MapGrid {
    // create a 2d array fill it in with the color green
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
    // return width of the 2d array
    {
        return arr2d.length;
    }

    int getHeight()
    // return height of the 2d array
    {
        return arr2d[0].length;
    }

    Color getSquare(int x, int y)
    // return the coordinates of a specified square in the map
    {
        return arr2d[x][y];
    }

    void setSquare(int x, int y, Color c)
    // set a specific square a specific color
    {
        arr2d[x][y] = c;
    }

    void modifyRectangleWithColor(Rectangle r, Color c)
    // color the rectangles of the map
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