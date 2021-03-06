package edu.spbu.cs;

import java.util.Random;


public class SparseGraphCreator {
	Random r;
	private Matrix graphMatrix;
	double powerDensity=0.5;
	Vector probabilities;
	public SparseGraphCreator(int a){
		r=new Random(a);
	}
	public Matrix getGraphMatrix(){// so randomSparseGraph+getGraphMatrix works well
		return graphMatrix;
	}
	public void countPageRank(){
		int n=graphMatrix.getHeight();
		double[] initWeights=new double[n];
		initWeights[0]=1;
		probabilities=new DenseVector(initWeights, n);
		probabilities=probabilities.rightMultiplicate(graphMatrix.pow(10000).transpose());
	}
	public double getPageRank(int i){
		return probabilities.get(i);
	}
	SparseGraph randomSparseGraph(int size){
		SparseGraph g;
		int m=(int) (size*Math.pow(size, powerDensity));
		int n=size;
		double[][] graphArray=new double[size][size];
		Edge[] edges=new Edge[m];
		Vertex[] vertices=new Vertex[size];
		int[] degree,from,to;//looks like a crutch
		degree=new int[size];
		from=new int[m];
		to=new int[m];
		for(int i=0;i<n;i++) vertices[i]=new VertexRealization();
		for(int i=0;i<m;i++){
			int a=r.nextInt(size);
			int b=r.nextInt(size);
			from[i]=a;
			to[i]=b;
			degree[a]++;
		}
		for(int i=0;i<m;i++){
			int a=from[i],b=to[i];
			edges[i]=new EdgeRealization(vertices[a],vertices[b],1.0/degree[a]);
			graphArray[a][b]+=1.0/degree[a];
			vertices[a].getOut().add(edges[i]);
			vertices[b].getIn().add(edges[i]);
		}
		g=new SparseGraph(vertices);
		graphMatrix=new DenseMatrix(graphArray,size,size);
		return g;
	}
}
