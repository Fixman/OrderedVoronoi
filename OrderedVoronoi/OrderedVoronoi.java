package OrderedVoronoi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import toxi.geom.*;
import toxi.geom.mesh2d.*;

public class OrderedVoronoi extends Voronoi
{
    public List<Polygon2D> getRegions()
	{
        List<Polygon2D> regions = new LinkedList<Polygon2D>();

		// Map each point to its niput pusition.
		Map<Vec2D, Integer> pointPositions = new HashMap<Vec2D, Integer>();
		for (Vec2D point : sites) {
			if (!pointPositions.containsKey(point))
				pointPositions.put(point, pointPositions.size());
		}

        Set<DelaunayVertex> delaunaySites = new HashSet<DelaunayVertex>(initialTriangle);
		Map<Integer, DelaunayVertex> delaunayPoints = new TreeMap<Integer, DelaunayVertex>();
		Map<DelaunayVertex, DelaunayTriangle> delaunayTriangles = new HashMap<DelaunayVertex, DelaunayTriangle>();

        for (DelaunayTriangle triangle : delaunay) {
            for (DelaunayVertex site : triangle) {
                if (delaunaySites.contains(site)) {
                    continue;
                }
                delaunaySites.add(site);

				Vec2D point = new Vec2D((float)site.coord(0), (float)site.coord(1));
				if (!pointPositions.containsKey(point))
					throw new RuntimeException("Delaunay triangle without a point.");

				delaunayPoints.put(pointPositions.get(point), site);
				delaunayTriangles.put(site, triangle);
			}
		}

		for (DelaunayVertex site : delaunayPoints.values()) {
			DelaunayTriangle triangle = delaunayTriangles.get(site);

			List<DelaunayTriangle> list = delaunay.surroundingTriangles(site, triangle);
			Polygon2D poly = new Polygon2D();
			for (DelaunayTriangle tri : list) {
				DelaunayVertex circumeter = tri.getCircumcenter();
				poly.add(new Vec2D((float)circumeter.coord(0), (float)circumeter.coord(1)));
			}
			regions.add(poly);
		}

        return regions;
    }
}
