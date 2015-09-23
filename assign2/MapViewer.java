import javax.swing.*;
import java.awt.*;

public class MapViewer extends JComponent
{
    private MapGrid mapGrid;

    private int magnification;

    private Point offSet;

    public static final int CANVAS_SIZE = 350;

    public MapViewer(MapGrid grid)
    {
        super();
        mapGrid = grid;
        magnification = 10;
        offSet = new Point(0, 0);
    }

    public MapViewer(MapGrid grid, int mag, int offx, int offy)
    {
        super();
        mapGrid = grid;
        magnification = mag;
        offSet = new Point(offx, offy);
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
    {
        for (int x = offSet.x; x < mapGrid.getWidth(); x++)
        {
            for (int y = offSet.y; y < mapGrid.getHeight(); y++)
            {
                g.setColor(mapGrid.getSquare(x,y));
                g.fillRect(x*magnification,y*magnification,magnification, magnification);
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


}