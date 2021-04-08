import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  

public class view {
	static String fileName;
	static boolean theBoolean = true;
	public static void main(String[] args) {  
	    JFrame f=new JFrame("Routes");  
	    JButton openFile=new JButton("OPEN"); 
	    JLabel fileLabel=new JLabel("Filename : ");
        fileLabel.setBounds(30,45,80,30);
        f.add(fileLabel);
        //text field for entering the filename
        final JTextField tf=new JTextField();  
	    tf.setBounds(95, 50, 150,20);  
	    f.add(tf);  
	    //button for opening and prepping the data file 
	    openFile.setBounds(250,50,95,30);  
	    f.add(openFile);  
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);
	    //button to compute the travelling salesman problem
	    JButton run = new JButton("RUN");
        run.setBounds(250,80,80,30);
        f.add(run);
        //action listeners 
        run.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	if(theBoolean){
            		run.setText("STOP");
            	}else{
            		run.setText("RUN");
            	}
            	
            	viewHelper t = new viewHelper();
            	f.add(t);  
            	controller c = new controller();
            	c.tsp();
            	theBoolean = !theBoolean;
            	t.repaint();
            }
        });
       
	    openFile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	 
                 
            	model h = new model();
            	fileName = tf.getText();
            	h.fileSymmetric(fileName);
            	
              	
            }
        });
	    
	    
	    
      
      
	}   
}


