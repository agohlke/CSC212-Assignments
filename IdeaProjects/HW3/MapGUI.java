import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  Class that demonstrates a GUI manager that can run as either
 *  an applet or a stand-alone application.
 *
 *  @author Amy Gohlke
 *  @version CSC 212, 24 September 2015
 */
public class MapGUI extends JApplet
{
    /** The map that will be displayed */
    private MapViewer map;

    /** Set up fields to default values */
    public MapGUI()
    {
        MapGrid mapG;
        // create all of the rectangles to display a map-like image
        mapG = new MapGrid(50,50);
        mapG.modifyRectangleWithColor(new Rectangle(18,20,24,10), Color.BLACK);
        mapG.modifyRectangleWithColor(new Rectangle(21,20,5,1), Color.CYAN);
        mapG.modifyRectangleWithColor(new Rectangle(23,31,14,6), Color.BLUE);
        mapG.modifyRectangleWithColor(new Rectangle(20,30,19,2), Color.YELLOW);
        mapG.modifyRectangleWithColor(new Rectangle(20,32,3,5), Color.YELLOW);
        mapG.modifyRectangleWithColor(new Rectangle(37,30,3,7), Color.YELLOW);
        mapG.modifyRectangleWithColor(new Rectangle(20,37,20,2), Color.YELLOW);
        mapG.modifyRectangleWithColor(new Rectangle(0,5,50,7), Color.GRAY);
        mapG.modifyRectangleWithColor(new Rectangle(28,0,11,20), Color.GRAY);
        mapG.modifyRectangleWithColor(new Rectangle( 0,8,3,1), Color.WHITE);
        mapG.modifyRectangleWithColor(new Rectangle( 7,8,3,1), Color.WHITE);
        mapG.modifyRectangleWithColor(new Rectangle(14,8,3,1), Color.WHITE);
        mapG.modifyRectangleWithColor(new Rectangle(21,8,3,1), Color.WHITE);
        mapG.modifyRectangleWithColor(new Rectangle(28,8,3,1), Color.WHITE);
        mapG.modifyRectangleWithColor(new Rectangle(35,8,3,1), Color.WHITE);
        mapG.modifyRectangleWithColor(new Rectangle(42,8,3,1), Color.WHITE);
        mapG.modifyRectangleWithColor(new Rectangle(49,8,1,1), Color.WHITE);
        map = new MapViewer(mapG);
    }

    /**
     *  This method is called by the application version.
     */
    public void createAndShowGUI()
    {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("Map");
        frame.setMinimumSize(new Dimension(8,2));
        try
        {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception e) {}

        // Add components
        createComponents(frame.getContentPane());

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /**
     *  Both types of app call this to set up the GUI contents.
     *
     *  @param pane  The pane of the JFrame of JApplet
     */
    public void createComponents(Container pane)
    {
        // create the buttons and place them within the pane
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(map,BorderLayout.WEST);
        JButton northButton = new JButton("North");
        pane.add(northButton);
        JButton southButton = new JButton("South");
        pane.add(southButton);
        JButton eastButton = new JButton("East");
        pane.add(eastButton);
        JButton westButton = new JButton("West");
        pane.add(westButton);
        JButton zoomOutButton = new JButton("Zoom Out");
        pane.add(zoomOutButton);
        JButton zoomInButton = new JButton("Zoom In");
        pane.add(zoomInButton);
        northButton.addActionListener(new NorthListener());
        southButton.addActionListener(new SouthListener());
        eastButton.addActionListener(new EastListener());
        westButton.addActionListener(new WestListener());
        pane.addMouseMotionListener(new SampleMouseListener());
        zoomOutButton.addActionListener(new ZoomOutListener());
        zoomInButton.addActionListener(new ZoomInListener());

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout(2, 2));
        panel2.add(zoomOutButton, BorderLayout.NORTH);
        panel2.add(zoomInButton, BorderLayout.SOUTH);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(2, 2));
        panel.add(northButton, BorderLayout.NORTH);
        panel.add(southButton,BorderLayout.SOUTH);
        panel.add(eastButton,BorderLayout.EAST);
        panel.add(westButton,BorderLayout.WEST);
        panel.add(panel2,BorderLayout.CENTER);

        pane.add(panel, BorderLayout.EAST);
    }

    /**
     *  This is the entry point for the applet version
     */
    public void init()
    {
        //Execute a job on the event-dispatching thread:
        //creating this applet's GUI.
        try
        {
            javax.swing.SwingUtilities.invokeAndWait(new Runnable()
            {
                public void run()
                {
                    // line below would create separate window
                    //gui.createAndShowGUI();

                    // this line creates applet in browser window
                    createComponents(getContentPane());
                }
            });
        } catch (Exception e)
        {
            System.err.println("createGUI didn't successfully complete");
        }
    }

    /**
     *  This is the entry point for the application version
     */
    public static void main(String[] args)
    {
        final MapGUI GUI = new MapGUI();
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                GUI.createAndShowGUI();
            }
        });
    }
    /** Event handler for North button */
    class SouthListener implements ActionListener
    {
        /**
         *  Inverts the colors when the button is pushed.
         *
         *  @param e  Holds information about the button-push event
         */
        public void actionPerformed(ActionEvent e)
        {
            map.south();  // note the reference to the enclosing class's private field
        }
    }

    class NorthListener implements ActionListener
    {
        /**
         *  Moves the map north when the button is pushed.
         *
         *  @param e  Holds information about the button-push event
         */
        public void actionPerformed(ActionEvent e)
        {
            map.north();  // note the reference to the enclosing class's private field
        }
    }
    class EastListener implements ActionListener
    {
        /**
         *  Moves the map east when the button is pushed.
         *
         *  @param e  Holds information about the button-push event
         */
        public void actionPerformed(ActionEvent e)
        {
            map.east();  // note the reference to the enclosing class's private field
        }
    }
    class WestListener implements ActionListener
    {
        /**
         *  Moves the map west when the button is pushed.
         *
         *  @param e  Holds information about the button-push event
         */
        public void actionPerformed(ActionEvent e)
        {
            map.west();  // note the reference to the enclosing class's private field
        }
    }
    class ZoomOutListener implements ActionListener
    {
        /**
         *  Zooms out from the map when the button is pushed.
         *
         *  @param e  Holds information about the button-push event
         */
        public void actionPerformed(ActionEvent e)
        {
            map.zoomOut();  // note the reference to the enclosing class's private field
        }
    }
    class ZoomInListener implements ActionListener
    {
        /**
         *  Zooms into the map when the button is pushed.
         *
         *  @param e  Holds information about the button-push event
         */
        public void actionPerformed(ActionEvent e)
        {
            map.zoomIn();  // note the reference to the enclosing class's private field
        }
    }
    /** Mouse event handlers */
    private class SampleMouseListener extends MouseAdapter
    {
        /** Click event handler prints a message with the event location */
        public void mouseClicked(MouseEvent e)
        {
            //System.out.println("Click event at ("+e.getX()+", "+e.getY()+")");
        }

        /** Press event handler prints a message with the event location */
        public void mousePressed(MouseEvent e)
        {
            //System.out.println("Press event at ("+e.getX()+","+e.getY()+")");
        }

        /** Release event handler prints a message with the event location */
        public void mouseReleased(MouseEvent e)
        {
            //System.out.println("Release event at ("+e.getX()+","+e.getY()+")");
        }

        /** Enter event handler prints a message with the event location */
        public void mouseEntered(MouseEvent e)
        {
            //System.out.println("Enter event at ("+e.getX()+","+e.getY()+")");
        }

        /** Exit event handler prints a message with the event location */
        public void mouseExited(MouseEvent e)
        {
            //System.out.println("Exit event at ("+e.getX()+","+e.getY()+")");
        }

        /** Exit event handler prints a message with the event location */
        public void mouseMoved(MouseEvent e)
        {
            //System.out.println("Move event at (" + e.getX() + "," + e.getY() + ")");
        }

        /** Exit event handler prints a message with the event location */
        public void mouseDragged(MouseEvent e)
        {
           // System.out.println("Drag event at (" + e.getX() + "," + e.getY() + ")");
        }
    }
}