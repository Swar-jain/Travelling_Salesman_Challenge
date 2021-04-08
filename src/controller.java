import java.util.Stack;

import java.util.Scanner;
import java.util.Stack;

public class controller
{
    static int cities = model.cities;
    public static int[] routes;
    static double[] distance = new double[cities];
    private Stack<Integer> s= new Stack<Integer>();
    //function to compute the travelling salesman problem using the nearest neighbor algorithm. 
    public void tsp()
        {
    		
    		routes = new int[cities];
    		int t = 0;
	    	model m = new model();
	    	double[][] matrix = m.d;
	    	System.out.println(matrix[0][0]);
	        int[] visited = new int[cities+1];
	        visited[0] = 1;
	        
	        s.push(0);
	        int curr, end = 0, i;
	        double curr_minimum = Integer.MAX_VALUE;
	        boolean flag = false;
        
	        routes[0] = 0;
	        int w = 1;
	        while (!s.isEmpty())
	        {
	        	curr_minimum = Integer.MAX_VALUE;
	        	i = 1;
	        	curr = s.peek();
	            while (i < cities)
	            {
	                if (curr!=i && visited[i] == 0)
	                {
	                    if (curr_minimum > matrix[curr][i])
	                    {
	                        curr_minimum = matrix[curr][i];
	                        end = i;
	                        flag = true;
	                    }
	                }
	                i++;
	            }
	            if (flag)
	            {
	                visited[end] = 1;
	                s.push(end);
	                distance[t] = matrix[curr][end];
	                t++;
	                flag = false;
	                routes[w] = end;
	                w++;
	                continue;
	            }
            
	            s.pop();
            
	        }
        distance[t] = matrix[end][0];
        for(int i1: routes){
        	System.out.println(i1);
        }
        System.out.println("The distance travelled for the given route: " + distance[t]);
  }
 
}
        
    
        
