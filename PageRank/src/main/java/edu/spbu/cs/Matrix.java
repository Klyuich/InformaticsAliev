package edu.spbu.cs;

abstract class Matrix {

	
	public abstract double get(int i,int j);
	public abstract int getHeight();
	public abstract int getWidth();
	public abstract Matrix slice(int hstart,int hoffset,int wstart,int woffset);
	public abstract Matrix add(Matrix B);
	public abstract Matrix multiplicate(Matrix B);
	public abstract Matrix transpose();
	public abstract Matrix pow(int n);
//	public abstract Matrix multiplicate(double a);
	public boolean equals(Matrix B){
		int n=this.getHeight(),m=this.getWidth();
		if(B.getHeight()!=n|| B.getWidth()!=m) return false;
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++){
				if(Math.abs(this.get(i, j)-B.get(i, j))>1e-9) return false;
			}
		return true;
	}
	public void print(){
		for(int i=0;i<this.getHeight();i++){
			for(int j=0;j<this.getWidth();j++) System.out.print(this.get(i, j)+" ");
			System.out.println();
		}
		System.out.println();
	}
	public double trace(){
		if(this.getHeight()!=this.getWidth()) throw new 
			IllegalArgumentException("Trace is defined only for square matrices!");
		double ans=0,n=this.getHeight();
		for(int i=0;i<n;i++) ans+=this.get(i, i);
		return ans;
	}
	public abstract Vector toVector();
	
	
}
