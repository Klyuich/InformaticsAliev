package edu.spbu.cs;

import java.util.ArrayList;


public class VertexRealization implements Vertex {
	ArrayList<Edge> inEdges,outEdges;
	double weight=0;
	public VertexRealization(){
		inEdges=new ArrayList<Edge>();
		outEdges=new ArrayList<Edge>();
		
		weight=0;
	}
	public VertexRealization(ArrayList<Edge> inEdges,ArrayList<Edge> outEdges,double weight){
		this.inEdges=inEdges;
		this.outEdges=outEdges;
		this.weight=weight;
	}
	
	@Override
	public ArrayList<Edge> getIn() {
		// TODO Auto-generated method stub
		return inEdges;
	}

	@Override
	public ArrayList<Edge> getOut() {
		// TODO Auto-generated method stub
		return outEdges;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public void setWeight(double a) {
		// TODO Auto-generated method stub
		weight=a;
	}

}
