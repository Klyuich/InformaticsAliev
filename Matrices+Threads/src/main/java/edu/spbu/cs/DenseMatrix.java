package edu.spbu.cs;


public final class DenseMatrix extends Matrix {
	private double[][] elements;
	int height, width;
	int left=0,up=0,right,down;
	public DenseMatrix(int height,int width){
		this(new double[height][width],height,width);

	}
	public DenseMatrix(double[][] elements,int height,int width){
		this.elements=elements;
		this.height=height;
		this.width=width;
		right=width;
		down=height;
	}
	public DenseMatrix(double[][] elements,int left,int up,int right,int down){
		this(elements,elements.length,elements[0].length);
		this.up=up;
		this.down=down;
		this.left=left;
		this.right=right;
		height=down-up;
		width=right-left;
	}
	
	public DenseMatrix(double[][] elements){
		this(elements,elements.length,elements[0].length);
	}
	

	public double get(int i,int j) {
		if(i>=0 && i<height && j>=0 && j<width)
		return elements[i+up][j+left];
		else
			throw new IndexOutOfBoundsException("This element doesn't exist!");
	}
	public double getAbs(int i,int j){
		return get(i-up,j-left);
	}
	@Override
	public int getHeight() {
		return height;
	}
	@Override
	public int getWidth() {
		return width;
	}
	
	public Matrix add(Matrix B) {
		// TODO Auto-generated method stub
//		if(B == null) return this;
		if(height!=B.getHeight() || width!=B.getWidth()) throw new 
		IllegalArgumentException("You can't add two matrices of different size!");
		double[][] elem=new double[height][width];
		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++)
				elem[i][j]=this.get(i, j)+B.get(i, j);
		return new DenseMatrix(elem,height,width);
	}
	@Override
	public Matrix slice(int hstart, int hoffset, int wstart, int woffset) {
		if(wstart<0 || hstart<0 || woffset>width || hoffset>height) throw new IndexOutOfBoundsException("Incorrect slice!");
		return new DenseMatrix(elements,left+wstart,up+hstart,left+wstart+woffset,up+hstart+hoffset);
	}
	public Vector toVector(){
		if(width!=1) throw new IllegalArgumentException("This matrix is not a vector!");
		double[] elem=new double[height];
		for(int i=0;i<height;i++) elem[i]=elements[i][0];
		return new DenseVector(elem,height,up);
	}
	public Matrix simpleMultiplicate(Matrix B){
		int n=height,m=width,l=B.getWidth();
		if(m!=B.getHeight()) throw new
		IllegalArgumentException("You can't multiply these two matrices!");
		Matrix C=B.transpose();
		double[][] elem=new double[n][l];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<l;j++)
				for(int k=0;k<m;k++)
					elem[i][j]+=this.get(i, k)* C.get(j, k);
					
		return new DenseMatrix(elem,n,l);
	}
	
	public Matrix simpleMultiplicateWithThreads(Matrix B) throws InterruptedException{
		final int n=height;
		final int m=width, l=B.getWidth();
		if(m!=B.getHeight()) throw new
		IllegalArgumentException("You can't multiply these two matrices!");
		final Matrix C=B.transpose();
		final Matrix D=this;
		final double[][] elem=new double[n][l];
		final int N=6;
		Thread myThread[]=new Thread[N];
		for(int Thr=0;Thr<N;Thr++){
			final int T=Thr;
			myThread[Thr]=new Thread(new Runnable()
			{
				
				public void run(){
				for(int i=(T*n)/N;i<(T*n+n)/N;i++)
					for(int j=0;j<l;j++)
						for(int k=0;k<m;k++)
					elem[i][j]+=D.get(i, k)* C.get(j, k);
				}
			});
		}		
		for(int i=0;i<N;i++) myThread[i].start();
		for(int i=0;i<N;i++) myThread[i].join();
		return new DenseMatrix(elem,n,l);
	}
	
	public Matrix transpose(){
		
		double[][] elem=new double[width][height];
		for(int i=0;i<width;i++)
			for(int j=0;j<height;j++)
				elem[i][j]=this.get(j, i);
		return new DenseMatrix(elem,width,height);
		
	}
	@Override
	public Matrix multiplicate(Matrix B) {
		// TODO Auto-generated method stub

		int n=height,m=width,l=B.getWidth();
		if(m!=B.getHeight()) throw new
		IllegalArgumentException("You can't multiply these two matrices!");
		/*Matrix C=B.transpose();
		double[][] elem=new double[n][l];
		for(int i=0;i<n;i++)
			for(int j=0;j<l;j++)
				for(int k=0;k<m;k++)
					elem[i][j]+=this.get(i, k)* C.get(j, k);
					
		return new DenseMatrix(elem,n,l);*/
		//too dumb to do it right

		int small=32;

		
		if(l<=small && m<=small && n<=small){
			if(l>0 && m>0 && n>0) return this.simpleMultiplicate(B);	
			else return new DenseMatrix(n,l);
		}
		int n1=n/2,m1=m/2,l1=l/2;
		int[][] acuts=new int[][]{{0,0},{n1,m1},{n,m}};
		int[][] bcuts=new int[][]{{0,0},{m1,l1},{m,l}};
		Matrix[][] a=new Matrix[2][2];
		Matrix[][] b=new Matrix[2][2];
		for(int i=0;i<2;i++)
			for(int j=0;j<2;j++){
				a[i][j]=this.slice(acuts[i][0],acuts[i+1][0]-acuts[i][0],acuts[j][1],acuts[j+1][1]-acuts[j][1]);
				b[i][j]=B.slice(bcuts[i][0],bcuts[i+1][0]-bcuts[i][0],bcuts[j][1],bcuts[j+1][1]-bcuts[j][1]);	
			}
		Matrix[][] c=new Matrix[2][2];
		//I CAN DO IT RIGHT
		
		for(int i=0;i<2;i++)
			for(int j=0;j<2;j++){
				c[i][j]=a[i][0].multiplicate(b[0][j]).add(a[i][1].multiplicate(b[1][j]));
			}
		double[][] elem=new double[n][l];
		for(int i=0;i<n;i++)
			for(int j=0;j<l;j++){
				int i1=0;
				if(i>=n1) i1++;
				int j1=0;
				if(j>=l1) j1++;
				elem[i][j]=c[i1][j1].get(i-i1*n1, j-j1*l1);
			}
				
		return new DenseMatrix(elem,n,l);
	}


	

}
