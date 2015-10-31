package edu.spbu.cs;
import java.util.Random;


public class DenseVectorCreator {
	Random r;
	public DenseVectorCreator(){
		r=new Random(5321);		
	}
	public Vector randomDenseVector(int size){
		double[] elem=new double[size];
		for(int i=0;i<size;i++) elem[i]=r.nextDouble();
		return new DenseVector(elem,size);
	}
}
