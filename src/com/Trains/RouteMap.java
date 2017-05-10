package com.Trains;


import java.util.*;

public class RouteMap extends HashMap<Integer, List<Vertex>> {
	
	public List<Vertex> put(Integer noOfStops, List<Vertex> currPath) {
		        List<Vertex> current = get(noOfStops);
		        if (current == null) {
		            current = new ArrayList<Vertex>();
		            super.put(noOfStops, current);
		        }
		        current.addAll(currPath);
		        //why hashmap(Integer, list) return a list???
				return current;
		    }

		    public static void main (String args[]) {
		        RouteMap m = new RouteMap();
		        List l1 = new ArrayList<Vertex>();
		        List l2 = new ArrayList<Vertex>();
		        List l3 = new ArrayList<Vertex>();
		        m.put(1, l1);
		        m.put(2, l2);
		        m.put(2, l3);
		        for(Map.Entry e : m.entrySet()) {
		            System.out.println(e.getKey() + " -> " + e.getValue());
		        }
		    }
		}

	
	
	
	
	
	
	
	
	
	


