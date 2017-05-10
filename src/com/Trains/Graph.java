package com.Trains;
import java.util.ArrayList;
import java.util.List;



public class Graph {
	
	private final List<Vertex> vertexes;
	private final List<Edge> edges;
	private List<Vertex> adj[]; //Adjacency Lists

	public Graph(List<Vertex> vertexes, List<Edge> edges) {
	    this.vertexes = vertexes;
	    this.edges = edges;    
        int v = vertexes.size();
	    adj = new ArrayList[v];
      
	    for (int i=0; i<v; ++i)
	    	adj[i] = new ArrayList<Vertex>();
	    for(Vertex ver: vertexes){
		    setAdjacencies(ver);
		   
	   }
	  
	    	
	 }
	    
      public List<Vertex> getVertexes() {
	    return vertexes;
	  }

	  public List<Edge> getEdges() {
	    return edges;
	  }
	  
	  public void addEdge(String edgeName, Vertex v, Vertex w, double d)
      {
		  
          adj[v.getId()].add(w);
          edges.add(new Edge(edgeName, v, w, d));
      }
	  
	  
	  public void setAdjacencies(Vertex ver){
		  ver.setAdjacencies(getAdjacencies(ver.getId()));
	  }
	  
      public  List<Vertex> getAdjacencies(int v){		
		   return adj[v];
	   }
	  

}
