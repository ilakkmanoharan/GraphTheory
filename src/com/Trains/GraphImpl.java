package com.Trains;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

/* Copyright (C) 2017 Ilakkuvaselvi Manoharan - All Rights Reserved
 * 
 */

public class GraphImpl {

	  private static List<Vertex> nodes;
	  private static List<Edge> edges;

	  public GraphImpl(Graph graph) {
	    // create a copy of the array so that we can operate on this array
	    this.nodes = new ArrayList<Vertex>(graph.getVertexes());
	    this.edges = new ArrayList<Edge>(graph.getEdges());  
       }
	 	  
	  public static Edge getEdge(Vertex source, Vertex target){
		  	  
		  for (Edge edge : edges) {
		    if (edge.getSource().equals(source)
		       && edge.getDestination().equals(target)) {
		      return edge;		      
		      }
		      }
		  return null;		  		  
	  }
	  
	   
	  public static String computeShortestDForPath(List<Vertex> route)
	    {
		 		
		 double totalPathD = 0.0;
		 double weight = 0;
		 String outputString = null;
		 int totalPathInt = 0;
		
		 for(int i =0; i < route.size()-1; i++){
			 Vertex u = route.get(i);
			 Vertex next = route.get(i+1);
			 Edge e = getEdge(u, next);
			 if(e == null){
				 outputString = "NO SUCH ROUTE";
				 //System.out.println("NO SUCH ROUTE");
				 //return 0;
				 continue;
			 }else{
			 weight = e.getWeight();
			 }
	          totalPathD = totalPathD + weight;
	          
	          totalPathInt = (int)(totalPathD);
	          
	          outputString = Integer.toString(totalPathInt);
		     }
	       
	    return outputString;
}     
	 
      
       public static List<Vertex> computeShortestTrip(Vertex source, Vertex target, int maxStops, int maxDistance){  
    	   
    	     List<Vertex> currPath = new ArrayList<Vertex>(); 
    		 List<List<Vertex>> pathGroup = new ArrayList<List<Vertex>>();
    		 int countTrips = 0;	 	
    		 double totalPathD = 0.0;
    		 int shortestDInt = 0;
    		 double shortestTotalD = Double.POSITIVE_INFINITY;    		 
    		 List<Vertex> shortestTrip = new ArrayList<Vertex>();
    		    	            	
       	     List<Vertex> visited = new ArrayList<Vertex>();
    	     int noOfStops = 0;  			
  			 double weight = 0.0;	
         	 Stack<Vertex> stack = new  Stack<Vertex>();
         	          	 
  			 stack.add(source); 
  			 currPath.add(source);
  			 while(!stack.isEmpty()){
  			 Vertex v = stack.pop();  			 
  			 List<Vertex> currAdjacents = v.getAdjacencies();
  			 for(Vertex adj: currAdjacents){					 
  		     	 Edge edge = getEdge(v, adj);
  				    	if((adj!=null) && !(visited.contains(adj))){
  					           visited.add(adj);
  					           weight = edge.getWeight();
  					           totalPathD = totalPathD + weight;
  					                  if((maxStops > 0) && (noOfStops > maxStops)){   					    	
  					        	   				currPath.clear();
  					        	   				noOfStops = 0;
  					        	   				continue;  					        	
  				                        }
  				            
  				      		      
  					                    if((maxDistance >0) && (totalPathD > maxDistance)){	
  					                    	    currPath.clear();
  					                    	    maxDistance = 0;
  					                    	    continue;
  					                    } 
  					 
  				                 currPath.add(adj);
  				                 noOfStops++;
  				   		    
  					                     if(adj.equals(target)){
  						  
  						                         countTrips++;
  						                         noOfStops = 0;
  						                         pathGroup.add(currPath);
  						                              if(totalPathD < shortestTotalD){
  							    							   shortestTrip.addAll(currPath);
  						                                       shortestTotalD = totalPathD;
  						                                       shortestDInt = (int)shortestTotalD;
  						                                                 }
  						                         currPath.clear();	
  						                         stack.add(source);
  						                         break;  						  
  				                           }
  					           stack.add(adj);
  					           break; 
  					           }  
  			  
  				         }
  					 }  //end of while loop
  		
  			 return shortestTrip;
  				 }        
       
       public static double computeShortestDist(Vertex source, Vertex target, int maxStops, int maxDistance){  
    	   
  	     List<Vertex> currPath = new ArrayList<Vertex>(); 
  		 List<List<Vertex>> pathGroup = new ArrayList<List<Vertex>>();
  		 int countTrips = 0;	 	
  		 double totalPathD = 0.0;
  		 double shortestTotalD = Double.POSITIVE_INFINITY;
  		 int shortestDInt = 0;
  		 List<Vertex> shortestTrip = new ArrayList<Vertex>();
  		    	            	
     	 List<Vertex> visited = new ArrayList<Vertex>();
  	     int noOfStops = 0;  			
		 double weight = 0.0;	
       	 Stack<Vertex> stack = new  Stack<Vertex>();
       	          	 
		 stack.add(source); 
		 currPath.add(source);
		 while(!stack.isEmpty()){
			 Vertex v = stack.pop();  			 
			 List<Vertex> currAdjacents = v.getAdjacencies();
			 for(Vertex adj: currAdjacents){					 
		     	 Edge edge = getEdge(v, adj);
				    	if((adj!=null) && !(visited.contains(adj))){
					           visited.add(adj);
					           weight = edge.getWeight();
					           totalPathD = totalPathD + weight;
					                  if((maxStops > 0) && (noOfStops > maxStops)){   					    	
					        	   				currPath.clear();
					        	   				noOfStops = 0;
					        	   				continue;  					        	
				                        }
				            
				      		      
					                    if((maxDistance >0) && (totalPathD > maxDistance)){	
					                    	    currPath.clear();
					                    	    maxDistance = 0;
					                    	    continue;
					                    } 
					 
				                 currPath.add(adj);
				                 noOfStops++;
				   		    
					                     if(adj.equals(target)){
						  
						                         countTrips++;
						                         noOfStops = 0;
						                         pathGroup.add(currPath);
						                              if(totalPathD < shortestTotalD){
							    							   shortestTrip.addAll(currPath);
						                                       shortestTotalD = totalPathD;
						                                       shortestDInt = (int)shortestTotalD;
						                                                 }
						                         currPath = new ArrayList<Vertex>();
						                         stack.add(source);
						                         break;
						  
				                           }
					           stack.add(adj);
					           break; 
				         }  
			  
				         }
					 }  //end of while loop
		
			 return shortestTotalD;
				 } 
       
       
         
       
       public static Map<Integer, List<Vertex>> computeSpecificTrips(Vertex source, Vertex target, int maxStops, int maxDistance){  
    	   
    	     List<Vertex> currPath = new ArrayList<Vertex>(); 
    		 List<List<Vertex>> pathGroup = new ArrayList<List<Vertex>>();
    		// Map<Integer, List<Vertex>> pathMap = new HashMap<Integer, List<Vertex>>();
    		 RouteMap map = new RouteMap();
    		 int countTrips = 0;	 	
    		 double totalPathD = 0.0;
    		    		    	            	
       	     List<Vertex> visited = new ArrayList<Vertex>();
    	     int noOfStops = 0;  			
  			 double weight = 0.0;	
         	 Stack<Vertex> stack = new  Stack<Vertex>();
         	          	 
  			 stack.add(source); 
  			 currPath.add(source);
  			 while(!stack.isEmpty()){
  			 Vertex v = stack.pop();  			 
  			 List<Vertex> currAdjacents = v.getAdjacencies();
  			 for(Vertex adj: currAdjacents){					 
  		     	 Edge edge = getEdge(v, adj);
  				    	if((adj!=null) && !(visited.contains(adj))){
  				    		   visited.add(adj);
  					           weight = edge.getWeight();
  					           totalPathD = totalPathD + weight;
  					                  if((maxStops > 0) && (noOfStops > maxStops)){   					    	
  					                	        currPath = new ArrayList<Vertex>();
  					        	   				noOfStops = 0;
  					        	   				continue;  
  					        	   				
  				                        }
  	    		      		      
  					                    if((maxDistance >0) && (totalPathD > maxDistance)){	
  					                    	    currPath = new ArrayList<Vertex>();
  					                    	    maxDistance = 0;
  					                    	    continue;  					                    	    
  					                    } 
  					 
  				                  currPath.add(adj);  				                  
  				                  noOfStops++;
  				   		    
  					                     if(adj.equals(target)){  					                    	 
  					                    	 visited.remove(target);
  					                    	    // pathMap.put(noOfStops, currPath);
  					                    	     map.put(noOfStops, currPath);
  						                         countTrips++;
  						                         noOfStops = 0;
  						                         totalPathD = 0;
  						                         
  						                       						                            
  						                         currPath = new ArrayList<Vertex>();
  						                         currPath.add(source);
  						                         stack.add(source);
  						                                    
  						                         List<Vertex> srcAdj = source.getAdjacencies();
  						                         List<Vertex> targetAdj = target.getAdjacencies();  						                         
  						                         						                         						                         
  						                         break;
  						                }
  					           stack.add(adj);
  					           break; 
  				         }  
  			  
  				         }
  			         
  					 }  //end of while loop
       return map;
}
  			 
       
       
          
       
	
	    public static void main(String[] args)
	    { 	
	    	
	    	final List<Vertex> allVertices = new ArrayList<Vertex>();
	    	final List<Edge> allEdges = new ArrayList<Edge>();
	    	
	    	Vertex A = new Vertex(0, "A");
	   	    Vertex B = new Vertex(1, "B");
	   	    Vertex C = new Vertex(2, "C");
	   	    Vertex D = new Vertex(3, "D");
	   	    Vertex E = new Vertex(4, "E"); 
	   	    
	   	    allVertices.add(A);
	   	    allVertices.add(B);
	   	    allVertices.add(C);
	   	    allVertices.add(D);
	   	    allVertices.add(E);
	   	    
	   	   	Graph graph = new Graph(allVertices, allEdges);  
	   	    	    	  	
	   	    graph.addEdge("AB", A, B, 5);
	   	  	graph.addEdge("AD", A, D, 5);
	   	  	graph.addEdge("AE", A, E, 7);
	   	  	graph.addEdge("BC", B, C, 4);
	   	  	graph.addEdge("CE", C, E, 2);
	   	  	graph.addEdge("DC", D, C, 8);
	   	  	graph.addEdge("CD", C, D, 8);
	   	  	graph.addEdge("EB", E, B, 3);
	   	  	graph.addEdge("DE", D, E, 6);
	   	  	
	   	  	GraphImpl dij = new GraphImpl(graph); 	
	   	  	
	   	  List<Vertex> route = new ArrayList<Vertex>();
		  
		  route.add(A);
		  route.add(B);
		  route.add(C);		  
		  
		 System.out.println("Output#1: "+ computeShortestDForPath(route));		 
		 		 
		 route.clear();		  
		 route.add(A);
		 route.add(D);
		  
		 System.out.println("Output#2: " + computeShortestDForPath(route));
		 
		 route.add(C);
		  
		 System.out.println("Output#3: " + computeShortestDForPath(route));
		  route.clear();
		  
		  route.add(A);
		  route.add(E);
		  route.add(B);
		  route.add(C);
		  route.add(D);
		  		  
		  System.out.println("Output#4: " + computeShortestDForPath(route));
		 
		  route.clear();		  
		  route.add(A);
		  route.add(E);
		  route.add(D);
		  
		  System.out.println("Output#5: " + computeShortestDForPath(route));
		  
		  
		  
		 
      	 
      	int tripCount6 = 0;
      	
    	  Map<Integer, List<Vertex>> tripDistanceMap = computeSpecificTrips(C, C, 3, 30);
    	
    	  for (Entry<Integer, List<Vertex>> entry : tripDistanceMap.entrySet()) {
			      Integer key = entry.getKey();
			      List<Vertex> value = entry.getValue();
			           
			      
			      if(key <= 4)
			    	  tripCount6++;
			    	  
			    		  
    	  }
		  
    	  System.out.println("Output#6: " + tripCount6);
		  
    	  int tripCount7 = 0;
        	
      	  Map<Integer, List<Vertex>> tripDistanceMap2 = computeSpecificTrips(A, D, 4, 30);
      	
      	  for (Entry<Integer, List<Vertex>> entry : tripDistanceMap2.entrySet()) {
			      Integer key = entry.getKey();
			      List<Vertex> value = entry.getValue();
			      
			      if(key == 4)
			    	  tripCount7++;		    	  
			    		  
      	  }
		  
      	 System.out.println("Output#7: " + tripCount7);
      	 
		  
      		  
		  double shortestDdouble = computeShortestDist(A, C, -1, -1);
		  
		  int shortestDint = (int)(shortestDdouble);
		  
		  System.out.println("Output#8: " + shortestDint);
		  
          double shortestDdouble2 = computeShortestDist(B, B, -1, -1);
		  
		  int shortestDint2 = (int)(shortestDdouble2);
		  
		  System.out.println("Output#9: " + shortestDint2);
		  
		  int tripsWithinDist = (computeSpecificTrips(C, C, -1, 30)).size();
		  		 
		  System.out.println("Output#10: " + tripsWithinDist);
		 
}
	        
		
	
	
	
	
}
