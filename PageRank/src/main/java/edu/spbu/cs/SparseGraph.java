package edu.spbu.cs;

import java.util.ArrayList;


public class SparseGraph implements Graph {
	int size;
	Vertex[] vertices;
	private double difference=1;
	public SparseGraph(Vertex[] vertices){
		this.vertices=vertices;
		this.size=vertices.length;
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Vertex get(int i) {
		// TODO Auto-generated method stub
		return vertices[i];
	}
	
	@Override
	public void countPageRank() {
		difference=1;
		for(int i=0;i<size;i++) vertices[i].setWeight(1.0/size);
		double[] newWeights=new double[size];
		ArrayList<Edge> inEdges;
		// TODO Auto-generated method stub
		while(difference>1e-5){
			difference=0;
			for(int i=0;i<size;i++){
				double w=0;
				inEdges=vertices[i].getIn();
				int m=inEdges.size();
				for(int j=0;j<m;j++){
					//правда ли, что если написать 
					//j<inEdges.size(),
					//этот метод будет вызываться на каждой итерации?
					w+=inEdges.get(j).from().getWeight()*inEdges.get(j).getWeight();
					//тут то же самое: стоит ли вызывать get два раза?
				}
				newWeights[i]=w;
				difference=Math.max(difference, Math.abs(w-vertices[i].getWeight()));
			}
			for(int i=0;i<size;i++)
				vertices[i].setWeight(newWeights[i]);
		}
	}

	@Override
	public double getPageRank(int i) {
		// TODO Auto-generated method stub
		return vertices[i].getWeight();
	}

}
