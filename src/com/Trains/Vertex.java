package com.Trains;
import java.util.List;

/* Copyright (C) 2017 Ilakkuvaselvi Manoharan - All Rights Reserved
 * 
 */

public class Vertex implements Comparable<Vertex>
	{
	    public final int id;
	    //public Edge[] adjacencies;
	    //public final LinkedList<Vertex>
	    public final String name;
	    public List<Vertex> adj;
	    //public State state;
	    public double minDistance = Double.POSITIVE_INFINITY;
	    public Vertex previous;
	    public Vertex(int id, String name) {
	    	this.id = id; 
	    	this.name = name;
	    }
	    public int getId() {
		    return id;
		}
	    public String getName() {
		    return name;
		}
	    public int compareTo(Vertex other)
	    {
	        return Double.compare(minDistance, other.minDistance);
	    }
		public void setAdjacencies(List<Vertex> adj) {
			
			this.adj = adj;
		}
	   public List<Vertex> getAdjacencies() {
			
			return this.adj;
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


