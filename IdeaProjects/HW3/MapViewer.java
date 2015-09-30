import javax.swing.*;
import java.awt.*;

/**
 * A Java program that creates a viewer of the map.
 * @author Amy Gohlke
 * @version September 23, 2015
 */

public class MapViewer extends JComponent
    // create the map viewer
{
    private MapGrid mapGrid;

    private int magnification;

    private Point offSet;

    public static final int CANVAS_SIZE = 400;

    private int x1 = 0;

    private int y1 = 0;

    public MapViewer(MapGrid grid)
    // allow the map viewer to take into account the magnification and offset points to produce a view
    {
        super();
        mapGrid = grid;
        magnification = 5;
        offSet = new Point(0, 0);
    }

    public int getMagnification()

    {
        return magnification;
    }

    public void setMagnification(int mag)
    {
        magnification = mag;
    }

    public Point getOffSet()
    {
        return offSet;
    }

    public void setOffSet(Point point)
    {
        offSet = point;
    }

    public void paintComponent(Graphics g)
    // creates the magnified view of a section of the map
    {
        for (int x = x1; x < mapGrid.getWidth(); x++)
        {
            for (int y = y1; y < mapGrid.getHeight(); y++)
            {
                g.setColor(mapGrid.getSquare(x, y));
                g.fillRect((x-x1)*magnification, (y-y1)*magnification, 20, 20);
            }
        }
    }

    public Dimension getMinimumSize()
    {
        return new Dimension (CANVAS_SIZE, CANVAS_SIZE);
    }

    public Dimension getPreferredSize()
    {
        return new Dimension (CANVAS_SIZE, CANVAS_SIZE);
    }

    public void north()
    {
        // moves the map north one click
        if (y1 -4 > 0)
        {
            y1 = y1-4;
        }
        repaint();
    }

    public void west()
    {
        // moves the map east one click
        if (x1 -4 > 0)
        {
            x1 = x1 -4;
        }
        repaint();
    }

    public void east()
    {
        // moves the map west one click
        if (x1 +4 < mapGrid.getWidth())
        {
            x1 = x1 +4;
        }
        repaint();
    }

    public void south()
    {
        // moves the map south one click
        if (y1 +4 < mapGrid.getHeight())
        {
            y1 = y1 +4;
        }
        repaint();
    }

    public void zoomOut()
    {
        // zooms out of the map
        magnification = magnification-2;
        x1 = x1 - 4;
        y1 = y1 - 4;
        repaint();
    }

    public void zoomIn()
    {
        // zooms in on the map
        magnification = magnification+2;
        x1 = x1 + 4;
        y1 = y1 + 4;
        repaint();
    }

}