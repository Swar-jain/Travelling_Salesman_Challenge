import java.awt.Color;
import java.awt.Toolkit;
import java.util.List;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class viewHelper extends JPanel {
	private JLabel distance;
    private JLabel distValue;
    private JLabel iterationLabel;
    private JLabel Value;
    public int counter = 0;
    int[] listOfCities;
    
    //function helps with the animations - namely plotting cities and in drawing the routes. 
	
  public viewHelper(){
	  this.setBounds(10,120, Toolkit.getDefaultToolkit().getScreenSize().width-10, Toolkit.getDefaultToolkit().getScreenSize().height);
	  this.setBackground(Color.WHITE);
	  distance = new JLabel("Distance:");
      distance.setBounds(10, 10, 80, 10);
      distValue = new JLabel("0");
      distValue.setBounds(90, 10, 100, 10);
      iterationLabel = new JLabel("Iteration:");
      iterationLabel.setBounds(10, 30, 80, 10);
      Value = new JLabel("0");
      Value.setBounds(90, 30, 100, 10);
      this.add(distance);
      this.add(distValue);
      this.add(iterationLabel);
      this.add(Value);
      this.setLayout(null);
      controller c = new controller();
      c.tsp();
      int cities = model.cities;
      listOfCities = new int[cities];
      listOfCities = controller.routes;
      Timer t = new Timer(100, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              
			if (!view.theBoolean && counter < listOfCities.length){
				 counter++;
	             repaint();
			}
                 
          }
      });
      t.start();
  }
  
  @Override
  public void paintComponent(Graphics g){
	  
	  super.paintComponent(g);
	  Graphics2D obj = (Graphics2D) g;
	  double[][] matrix = model.m;
	  int i=0;
	  int winWidth = (int) GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getWidth()-350;
	  int winHeight = (int) GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight()-350;
	  int minX = model.minX;
	  int maxX = model.maxX;
	  int minY = model.minY;
	  int maxY = model.maxY;
	  Value.setText(Integer.toString(counter));
	  if(counter<model.cities)
		  distValue.setText(Double.toString(controller.distance[counter]));
	  while(matrix != null && i<matrix.length){
		 obj.fillOval((int)((matrix[i][1] - minX)/((maxX-minX)/winWidth)),(int) ((matrix[i][2] - minY)/((maxY-minY)/winHeight)), 5,5 );
		  i++;
		  
	  }
	  int c2 = 0; //refers to destination city 
	  for (i = 0; i < counter; i++) {
		 int c1 = listOfCities[i]; //refers to start city
		 if(i+1<listOfCities.length-1)
			  c2 = listOfCities[i+1];
		 else{
			 
			 break;
		 }
	
		 obj.drawLine((int)((matrix[c1][1] - minX)/((maxX-minX)/winWidth)), (int) ((matrix[c2][2] - minY)/((maxY-minY)/winHeight)) ,(int)((matrix[c2][1] - minX)/((maxX-minX)/winWidth)),(int) ((matrix[c2][2] - minY)/((maxY-minY)/winHeight)));
		 
		}
	  
  }
}
