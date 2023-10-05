package studio4;

import java.awt.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		
//		File f = new File("resources/rectangle_pink_filled.txt");
//		Scanner in = new Scanner(f);
		
		String shape = in.next();
		int redValue = in.nextInt();
		int greenValue = in.nextInt();
		int blueValue = in.nextInt();
		boolean filled = in.nextBoolean();

		Color color = new Color (redValue, greenValue, blueValue);
		StdDraw.setPenColor(color);

		if (shape.equals("rectangle")) {
			double xValue = in.nextDouble();
			double yValue = in.nextDouble();
			double widthValue = in.nextDouble();
			double heightValue = in.nextDouble();
			if (filled == true) {
				StdDraw.filledRectangle(xValue, yValue, widthValue, heightValue);
			}
			else {
				StdDraw.rectangle(xValue, yValue, widthValue, heightValue);
			}
		}
		else if (shape.equals("ellipse")) {
			double xValue = in.nextDouble();
			double yValue = in.nextDouble();
			double widthValue = in.nextDouble();
			double heightValue = in.nextDouble();
			if (filled == true) {
				StdDraw.filledEllipse(xValue, yValue, widthValue, heightValue);
			}
			else {
				StdDraw.ellipse(xValue, yValue, widthValue, heightValue);
			}
		}
		else if (shape.equals("triangle")) {
			double xValue1 = in.nextDouble();
			double yValue1 = in.nextDouble();
			double xValue2 = in.nextDouble();
			double yValue2 = in.nextDouble();
			double xValue3 = in.nextDouble();
			double yValue3 = in.nextDouble();
			
			double[] xValues = {xValue1, xValue2, xValue3};
			double[] yValues = {yValue1, yValue2, yValue3};
			if (filled == true) {
				StdDraw.filledPolygon(xValues,yValues);
			}
			else {
				StdDraw.polygon(xValues, yValues);
			}
		}
	}
}
