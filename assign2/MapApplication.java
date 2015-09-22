//import java.awt.*;
import javax.swing.*;
import java.lang.reflect.*;

/**
 *  This file provides the skeleton of a Java Swing application
 *  for assignment 2 of CSC 112.  It is intended to create two windows
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

	// Set up map:
        MapGrid map;
	// FILL IN HERE 
        // (Call the constructor for the new MapGrid and fill it with stuff)
        map = new MapGrid(10,15);
        
        // Create and add the viewers:
        MapViewer view1, view2;
	// FILL IN HERE 
        // (Call the constructors for the two new MapViewer objects,
        //  making sure they have different viewpoints of the map you just
        //  set up above.)
        view1 = new MapViewer ();
        view2 = new MapViewer ();
        
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
