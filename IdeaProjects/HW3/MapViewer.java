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

    private int w1 = 0;

    private int h1 = 0;

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
        for (int x = offSet.x; x < mapGrid.getWidth(); x++)
        {
            for (int y = offSet.y; y < mapGrid.getHeight(); y++)
            {
                g.setColor(mapGrid.getSquare(x, y));
                g.fillRect((x*magnification)+x1,(y*magnification)+y1,20+w1, 20+h1);
                //g.fillRect(x*magnification,y*magnification,magnification, magnification);
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
        // move the map north one click
        if (offSet.y -2 > 0)
        {
            setOffSet(new Point(offSet.x, offSet.y-2));
        }
        repaint();
    }

    public void east()
    {
        // move the map east one click
        if (x1 -2 > 0)
        {
            x1 = x1 -2;
        }
        repaint();
    }

    public void west()
    {
        // move the map west one click
        if (x1 +2 < mapGrid.getWidth())
        {
            x1 = x1 +2;
        }
        repaint();
    }

    public void south()
    {
        // move the map south one click
        if (offSet.y +2 < mapGrid.getHeight())
        {
            offSet = new Point(offSet.x, offSet.y + 2);
        }
        repaint();
    }

    public void zoomOut()
    {
        // zoom out on the map
        magnification = magnification-2;
        repaint();
    }

    public void zoomIn()
    {
        // zoom in on the map
        magnification = magnification+2;
        repaint();
    }

}