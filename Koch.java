/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function. Uncomment the
		/// second code block to test the snowflake function. Uncomment only one block in
		/// each test, and remember to compile the class whenever you change the test.

		/*
		 * // Tests the curve function:
		 * // Gets n, x1, y1, x2, y2,
		 * // and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		 * curve(Integer.parseInt(args[0]),
		 * Double.parseDouble(args[1]), Double.parseDouble(args[2]),
		 * Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		 */

		

		  // Tests the snowflake function:
		 //  Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		  snowFlake(Integer.parseInt(args[0]));
		 
	}

	/**
	 * Gets n, x1, y1, x2, y2,
	 * and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
	 */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			return;
		}

		double dx = (x2 - x1) / 3.0;
		double dy = (y2 - y1) / 3.0;

		double x2p = x1 + dx;
		double y2p = y1 + dy;

		double x4p = x1 + 2 * dx;
		double y4p = y1 + 2 * dy;

		double sin60 = Math.sin(Math.PI / 3);
		double cos60 = Math.cos(Math.PI / 3);

		double x3p = x2p + (dx * cos60 + dy * sin60);
		double y3p = y2p + (dy * cos60 - dx * sin60);

		curve(n - 1, x1, y1, x2p, y2p);
		curve(n - 1, x2p, y2p, x3p, y3p);
		curve(n - 1, x3p, y3p, x4p, y4p);
		curve(n - 1, x4p, y4p, x2, y2); 
	}

	public static void snowFlake(int n) {
		StdDraw.setYscale(-0.5, 1.5); 
		StdDraw.setXscale(-0.5, 1.5);

		double x1 = 0.0, y1 = 0.0;
		double x2 = 1.0, y2 = 0.0;
		double x3 = 0.5, y3 = Math.sin(Math.PI / 3);

		curve(n, x1, y1, x2, y2);
		curve(n, x2, y2, x3, y3);
		curve(n, x3, y3, x1, y1);
	}
}
