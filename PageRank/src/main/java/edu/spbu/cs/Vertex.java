
package edu.spbu.cs;
//import java.awt.List;
import java.util.ArrayList;


public interface Vertex {
	public ArrayList<Edge> getIn();
	public ArrayList<Edge> getOut();
	public double getWeight();
	public void setWeight(double a);
}
