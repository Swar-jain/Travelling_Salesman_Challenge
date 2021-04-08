import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner; 

	public class model {
		static int cities;
		public static double[][] d; //distance
		public static double[][] m; //temporary matrix to store data value read from the file
		static int minY = Integer.MAX_VALUE;
		  static int maxY = 0;
		  static int minX = Integer.MAX_VALUE;
		  static int maxX = 0;
		

		//Function to calculate the distance between 2 points
		public static double distance( double x1, double y1, double x2, double y2) { 
			        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
				}
		
		//Function to calculate distance matrix for symmetric dataset
		
		public  void fileSymmetric(String filename) {
			
			try {
				Scanner it = new Scanner(System.in);
	    		System.out.println("Please enter the number of cities");
	    		cities = it.nextInt();
				d = new double[cities][cities];
			  String fileName = filename;
			  File myObj = new File(System.getProperty("user.dir") + "/data/"+ fileName);
			  Scanner myReader = new Scanner(myObj);
			  int i=0;
			  String[] words=null;
			  m = new double[cities][3];
			  int r = 0;
			  
			  while (myReader.hasNextLine()) {
				  if(i>=7 && r<cities){
					  String data = myReader.nextLine();
					  words=data.split(" ");
					  for(int h=0; h<words.length; h++){
						  m[r][h] = Double.parseDouble(words[h]);
						  if(h == 1){
							  
							  minX = (int) (minX>m[r][h] ? m[r][h] : minX);
							  maxX = (int) (maxX<m[r][h]? m[r][h] : maxX);
						  }else if(h==2){
							  
							  minY = (int) (minY>m[r][h] ? m[r][h] : minY);
							  maxY = (int) (maxY<m[r][h]? m[r][h] : maxY);
						  }
		    			  
		    		  }
					  r = r+1;
				  	}
	    		 else{
	    			 String data = myReader.nextLine();  
	    		 	}
				  i = i+1;
			 }
			  myReader.close();
			  for(int y=0;y<cities; y++){
				  for(int u=0; u<cities; u++){
					  double k = distance(m[y][1], m[y][2], m[u][1], m[u][2]);
					  
					  d[y][u]=k;
				  }
			  }
			  
	      	}catch (FileNotFoundException e) {
	      		System.out.println("An error occurred.");
	      		e.printStackTrace();
	      	}
			
		
	    
	  }

		

}
	
	

