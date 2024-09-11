package com.project.accident.blackspots.services.Clustering;

import com.project.accident.blackspots.model.location;

public class DistanceMetric{
	static double haversine(location l1, location l2){
//		ObjectMapper objmap=new ObjectMapper();
//		String json1= objmap.writeValueAsString(l1);
//		String json2= objmap.writeValueAsString(l2);
//		location loc1= objmap.readValue(json1, location.class);
//		location loc2= objmap.readValue(json2, location.class);
		// distance between latitudes and longitudes
		double dLat = Math.toRadians(l2.getLat().doubleValue() - l1.getLat().doubleValue());
		double dLon = Math.toRadians(l2.getLng().doubleValue() - l1.getLng().doubleValue());
		
		// convert to radians
		double lat1 = Math.toRadians(l1.getLat().doubleValue());
		double lat2 = Math.toRadians(l2.getLat().doubleValue());
		
		// apply formulae
		double a = Math.pow(Math.sin(dLat / 2), 2) + 
		   Math.pow(Math.sin(dLon / 2), 2) * 
		   Math.cos(lat1) * 
		   Math.cos(lat2);
		double rad = 6371;
		double c = 2 * Math.asin(Math.sqrt(a));
		return rad * c;
	}
}
