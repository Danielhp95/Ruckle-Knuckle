package utils;

import java.awt.Color;

import acm.graphics.GRect;

public class GUtils {

	//Returns a bar at given location, length and with, with specified color
	public static GRect createFilledBar(double x, double y, double length,
			double width, Color color) {
		GRect bar = new GRect(x, y, length, width);
		bar.setFilled(true);
		bar.setFillColor(color);
		return bar;
	}
}
