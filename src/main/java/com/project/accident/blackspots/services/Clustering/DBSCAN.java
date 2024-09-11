package com.project.accident.blackspots.services.Clustering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.project.accident.blackspots.model.location;

@Service
public class DBSCAN {
	
	private List<location> points=new ArrayList<location>();
    private List<Cluster> clusters=new ArrayList<Cluster>();
    private Map<Integer,Boolean> visited= new HashMap<Integer,Boolean>();
	private double epsilon=2;
	private int min_points=5;
	
//	private boolean[] visited;
	
//	public DBSCAN() {
	//	super();
	//	super(points);
	//	this.points = new ArrayList<location>();
	//	this.clusters = new ArrayList<Cluster>();
//		this.epsilon = 2;
//		this.min_points = 5;
//	}
 
	public List<Cluster> cluster() {
/*		Iterator<location> itr = this.points.iterator();
		int n = 0;
		
		while(itr.hasNext()) {
			location l=itr.next();
			if(this.visited.get(n)==null) {
				this.visited.put(n, true);
				ArrayList<Integer> neighbors = new ArrayList<Integer>();
				neighbors=getNeighbors(l);
				if(neighbors.size() >= min_points) {
					Cluster c = new Cluster(this.clusters.size());
					buildCluster(l,c,neighbors);
					this.clusters.add(c);
				}
			}
			n++;
		}
*/		
		for(location point: this.points){
			if(this.visited.get(points.indexOf(point))!=null){
				continue;
			}
			List<Integer> neighbors = getNeighbors(point);
			if(neighbors.size() >= this.min_points) {
			Cluster c = new Cluster(this.clusters.size());
			buildCluster(point,c,neighbors);
			this.clusters.add(c);
			}
			else this.visited.put(points.indexOf(point),true);
		}
		return this.clusters;
	}
 
	private void buildCluster(location l, Cluster c, List<Integer> neighbors) {
	/*	c.addPoint(l);
		for (int point : neighbors) {
			location p = points.get(point);
			if(this.visited.get(point)==null) {
				this.visited.put(point,true);
				List<Integer> newNeighbors = getNeighbors(p);
				if(newNeighbors.size() >= min_points) {
					neighbors.addAll(newNeighbors);
				}
			}
			if(p.getClusterId() == -1) {
				c.addPoint(p);
			}
		}
*/		
		c.addLocation(l);
		this.visited.put(this.points.indexOf(l), true);
		for (int i=0;i<neighbors.size();i++) {
			int point=neighbors.get(i);
			location p = points.get(point);
			if(visited.get(point)!=null) {
				continue;
				}
			List<Integer> newNeighbors = getNeighbors(p);
			if(newNeighbors.size() >= min_points) {
				neighbors.addAll(newNeighbors);			
			}
			if(p.getClusterId() == -1) {
				c.addLocation(p);
			}
			this.visited.put(point, true);
		}
	}
 
	private ArrayList<Integer> getNeighbors(location l) {
		ArrayList<Integer> neighbors = new ArrayList<Integer>();
		int i = 0;
		for (location point : points) {
			double distance = DistanceMetric.haversine(l,point);
			if(distance <= this.epsilon) {
				neighbors.add(i);
			}
			i++;
		}
		
		return neighbors;
	}
 
	public void setPoints(List<location> points) {
		this.points=points;
	}
}
