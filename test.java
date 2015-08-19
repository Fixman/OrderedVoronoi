import OrderedVoronoi.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import toxi.geom.*;

public class test
{
	private static List<Vec2D> getPoints()
	{
		return new ArrayList<Vec2D> (
			Arrays.asList(
				new Vec2D(-581, -278),
				new Vec2D(867, -592),
				new Vec2D(-292, -400),
				new Vec2D(513, -821),
				new Vec2D(-987, -967),
				new Vec2D(565, 44),
				new Vec2D(269, -342),
				new Vec2D(10, 356),
				new Vec2D(-279, -317),
				new Vec2D(425, 116),
				new Vec2D(-98, -818),
				new Vec2D(-727, -765),
				new Vec2D(905, 394),
				new Vec2D(-667, 391),
				new Vec2D(210, 915),
				new Vec2D(-682, -908),
				new Vec2D(-596, 543),
				new Vec2D(-253, 254),
				new Vec2D(-389, -573),
				new Vec2D(-687, -100),
				new Vec2D(-81, 13),
				new Vec2D(906, 77),
				new Vec2D(403, -42),
				new Vec2D(-169, 283),
				new Vec2D(-211, -167),
				new Vec2D(459, -749),
				new Vec2D(706, -700),
				new Vec2D(-555, 931),
				new Vec2D(755, -603),
				new Vec2D(-549, 690),
				new Vec2D(104, 310),
				new Vec2D(-932, -946),
				new Vec2D(-810, -837),
				new Vec2D(910, -142),
				new Vec2D(-234, -736),
				new Vec2D(-829, -223),
				new Vec2D(454, -264),
				new Vec2D(810, -630),
				new Vec2D(1, 498),
				new Vec2D(217, 716),
				new Vec2D(-55, 472),
				new Vec2D(91, -126),
				new Vec2D(78, 619),
				new Vec2D(190, -889),
				new Vec2D(489, 743),
				new Vec2D(-110, -890),
				new Vec2D(598, 630),
				new Vec2D(555, 667),
				new Vec2D(111, 580),
				new Vec2D(111, 580),
				new Vec2D(-556, -412)
			)
		);
	}

	public static void main(String[] args)
	{
		OrderedVoronoi voronoi = new OrderedVoronoi();
		voronoi.addPoints(getPoints());
		voronoi.getRegions();
	}
}
