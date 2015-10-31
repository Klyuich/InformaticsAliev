package edu.spbu.cs;
public abstract class Vector {
	public abstract int getSize();
	public abstract double get(int i);
	public abstract Vector slice(int start,int offset);
	public abstract Matrix toMatrix();
	public abstract Vector add(Vector w);
	public Vector leftMultiplicate(Matrix A){
		return this.toMatrix().transpose().multiplicate(A).transpose().toVector();
	}
	public Vector rightMultiplicate(Matrix A){
		return A.multiplicate(this.toMatrix()).toVector();
	}
	public boolean equals(Vector v){
		int n=this.getSize();
		if(n!=v.getSize()) return false;
		
		for(int i=0;i<n;i++){
			if(Math.abs(this.get(i)-v.get(i))>1e-9) return false;
		}
		return true;
	}
	public void print(){
		int n=this.getSize();
		for(int i=0;i<n;i++) System.out.print(this.get(i)+" ");
		System.out.println();
	}
	
}
