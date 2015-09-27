import java.awt.*;
import javax.swing.*;
import java.lang.reflect.*;

/**
 *  This file provides the skeleton of a Java Swing application
 *  for assignment 2 of CSC 212.  It is intended to create two windows
 *  with differing views of a map.  Portions are left unfinished for
 *  students to fill in.
 *
 *  @author  Nick Howe
 *  @version 6 February 2011
 */

public class MapApplication {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void setupWindows() {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the windows.
        JFrame frame1 = new JFrame("Map #1");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame frame2 = new JFrame("Map #2");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MapGrid map;
        // create all of the rectangles to display a map-like image
        map = new MapGrid(50,50);
        map.modifyRectangleWithColor(new Rectangle(18,20,24,10), Color.BLACK);
        map.modifyRectangleWithColor(new Rectangle(21,20,5,1), Color.CYAN);
        map.modifyRectangleWithColor(new Rectangle(23,31,14,6), Color.BLUE);
        map.modifyRectangleWithColor(new Rectangle(20,30,19,2), Color.YELLOW);
        map.modifyRectangleWithColor(new Rectangle(20,32,3,5), Color.YELLOW);
        map.modifyRectangleWithColor(new Rectangle(37,30,3,7), Color.YELLOW);
        map.modifyRectangleWithColor(new Rectangle(20,37,20,2), Color.YELLOW);
        map.modifyRectangleWithColor(new Rectangle(0,5,50,7), Color.GRAY);
        map.modifyRectangleWithColor(new Rectangle(28,0,11,20), Color.GRAY);
        map.modifyRectangleWithColor(new Rectangle( 0,8,3,1), Color.WHITE);
        map.modifyRectangleWithColor(new Rectangle( 7,8,3,1), Color.WHITE);
        map.modifyRectangleWithColor(new Rectangle(14,8,3,1), Color.WHITE);
        map.modifyRectangleWithColor(new Rectangle(21,8,3,1), Color.WHITE);
        map.modifyRectangleWithColor(new Rectangle(28,8,3,1), Color.WHITE);
        map.modifyRectangleWithColor(new Rectangle(35,8,3,1), Color.WHITE);
        map.modifyRectangleWithColor(new Rectangle(42,8,3,1), Color.WHITE);
        map.modifyRectangleWithColor(new Rectangle(49,8,1,1), Color.WHITE);


        MapViewer view1, view2;
        // view1 shows the whole map
        // view2 shows part of the map magnified

        view1 = new MapViewer(map, 6, 0,  0);
        view2 = new MapViewer(map, 8, 5, 10);

        frame1.getContentPane().add(view1);
        frame2.getContentPane().add(view2);

        // Display the windows:
        frame1.pack();
        frame1.setVisible(true);
        frame2.pack();
        frame2.setVisible(true);
    }

    public static void main(String[] args) throws Throwable {
        // set up windows with viewers:
        try {
            javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    setupWindows();
                }
            });
        } catch (InterruptedException e) {
            System.out.println("Couldn't create GUI.");
            System.exit(-1);
        } catch (InvocationTargetException e) {
            throw(e.getTargetException());
        }
    }
}