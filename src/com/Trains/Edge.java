package com.Trains;

/* Copyright (C) 2017 Ilakkuvaselvi Manoharan - All Rights Reserved
 * 
 */
public class Edge {
	
	public final Vertex src;
    public final Vertex target;
    public final double weight;
    public final String name;
    //public State state;
    
    public Edge(String name, Vertex src, Vertex target, double d)
    { 
    	this.src = src;
    	this.target = target; 
    	this.weight = d;
    	this.name = name;
    }
    
    public Vertex getDestination() {
	    return target;
    }

    public Vertex getSource() {
	    return src;
    }
    
    public double getWeight() {
	    return weight;
    }
    
    public String getName() {
	    return name;
    }
	
	
	
	
	
	
	
	
	

}
