/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {

	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}

	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski(int n) {

		double x1 = 0.1;
		double y1 = 0.1;

		double x2 = 0.9;
		double y2 = 0.1;

		double side = x2 - x1;
		double height = side * Math.sqrt(3) / 2;

		double x3 = 0.5;
		double y3 = y1 + height;

		sierpinski(n, x1, x2, x3, y1, y2, y3);
	}

	public static double halfPoint(double n1, double n2) {
		return (n1 + n2) / 2.00;
	}

	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
			double y1, double y2, double y3) {

		if (n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			StdDraw.line(x2, y2, x3, y3);
			StdDraw.line(x3, y3, x1, y1);
			return;
		}

		double nX12 = halfPoint(x1, x2);
		double nX23 = halfPoint(x2, x3);
		double nX31 = halfPoint(x3, x1);
		double nY12 = halfPoint(y1, y2);
		double nY23 = halfPoint(y2, y3);
		double nY31 = halfPoint(y3, y1);

		sierpinski(n - 1, x1, nX12, nX31, y1, nY12, nY31);
		sierpinski(n - 1, nX12, x2, nX23, nY12, y2, nY23);
		sierpinski(n - 1, nX31, nX23, x3, nY31, nY23, y3);

	}
}
