package com.project.accident.blackspots.services.Clustering;

import java.util.ArrayList;
import java.util.List;

import com.project.accident.blackspots.model.location;

public class Cluster {
	
	public List<location> locations;
	public int cId;
	
	public Cluster(int cId) {
		this.cId = cId;
		this.locations = new ArrayList<location>();
	}
 
	public List<location> getLocations() {
		return locations;
	}
	
	public void addLocation(location point) {
		locations.add(point);
		point.setClusterId(cId);;
	}
 
	public void setPoints(List<location> points) {
		this.locations = points;
	}
 
/*	public DataPoint getCentroid() {
		return centroid;
	}
*/ 
/*	public void setCentroid(Point centroid) {
		this.centroid = centroid;
	}
*/ 
	public int getCId() {
		return cId;
	}
	
	public void clear() {
		locations.clear();
	}
	
/*	public void plotCluster() {
		System.out.println("[Cluster: " + id+"]");
		System.out.println("[Centroid: " + centroid + "]");
		System.out.println("[Points: \n");
		for(DataPoint p : points) {
			System.out.println(p);
		}
		System.out.println("]");
	}
*/	
}
