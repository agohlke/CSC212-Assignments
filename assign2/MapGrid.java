import java.awt.Color;

/**
 * A Java program that creates a map grid.
 * @author Amy Gohlke
 * @version CSC212 HW2
 */

class MapGrid {
	Color[][] arr2d;
	int arrayWidth;
	int arrayHeight;
	
MapGrid (int w, int h) {
	arr2d = new Color[w][h];
	for(int i = 0; i < arr2d.length; i++) {
		for (int j = 0; j < arr2d[i].length; j++) {
			arr2d[i][j] = new Color (1, 0, 0);
		}
	}
	arrayWidth = w;
	arrayHeight = h;
}
int getWidth() {
	return arrayWidth;
}
int getHeight() {
	return arrayHeight;
}
Color getSquare(int w, int h) {
	return arr2d[w][h];
}
}
