import java.util.Random;


public class DenseMatrixCreator {
	Random r;
	public DenseMatrixCreator(){
		r=new Random(5321);		
	}
	public Matrix nullMatrix(int height,int width){
		double[][] elem=new double[height][width];
		return new DenseMatrix(elem,height,width);
	}
	public Matrix randomDenseMatrix(int height,int width){

		double[][] elem=new double[height][width];
		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++)
				elem[i][j]=r.nextDouble();
		DenseMatrix A=new DenseMatrix(elem,height,width);
		return A;
	}
	public DenseMatrix RandomDenseMatrix(int height,int width){//sorry

		double[][] elem=new double[height][width];
		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++)
				elem[i][j]=r.nextDouble();
		DenseMatrix A=new DenseMatrix(elem,height,width);
		return A;
	}
}
