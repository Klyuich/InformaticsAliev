package edu.spbu.cs;

public class DenseVector extends Vector {
	double[] elements;
	int start=0;
	int size;
	public DenseVector(double[] elements,int size){
		this.elements=elements;
		this.size=size;
	}
	public DenseVector(double[] elements,int size,int start){
		this(elements,size);
		this.start=start;
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public double get(int i) {
		// TODO Auto-generated method stub
		return elements[i+start];
	}

	@Override
	public Vector slice(int start, int offset) {
		// TODO Auto-generated method stub
		return new DenseVector(elements,offset,start);
	}

	@Override
	public Matrix toMatrix() {
		// TODO Auto-generated method stub
		double[][] elem=new double[1][];
		elem[0]=elements;
		return new DenseMatrix(elem,start,0,start+size,1).transpose();//to get VERTICAL vector
	}

	@Override
	public Vector add(Vector w) {
		// TODO Auto-generated method stub
		if(w.getSize()!=size) throw new IllegalArgumentException("These two vectors have different sizes");
		double[] elem=new double[size];
		for(int i=0;i<size;i++) elem[i]=this.get(i)+w.get(i);
		return new DenseVector(elem,size);
	}

}
