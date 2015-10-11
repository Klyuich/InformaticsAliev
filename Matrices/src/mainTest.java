

public class mainTest {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height=600,width=300;
		DenseMatrixCreator creator=new DenseMatrixCreator();
		DenseMatrix A=creator.RandomDenseMatrix(height, width);
		Matrix B=creator.randomDenseMatrix(width,height);
		long startTime,estimatedTime;
	
		startTime=System.nanoTime();
		Matrix D=A.simpleMultiplicate(B);
		estimatedTime=System.nanoTime() - startTime;
		System.out.println("Execution time of simple matrix multiplication: " + (estimatedTime/1e6));
		
		startTime=System.nanoTime();
		Matrix C=A.multiplicate(B);

		estimatedTime=System.nanoTime() - startTime;
		System.out.println("Execution time of matrix multiplication: " + (estimatedTime/1e6));
		
		
		
	

		System.out.println(C.equals(D));
		
		
		System.out.println(C.trace()-B.multiplicate(A).trace());
		
		height=150;
		width=30;
		A=creator.RandomDenseMatrix(height, width);
		B=creator.randomDenseMatrix(width, height);
		Matrix E=creator.randomDenseMatrix(height, width);
		
		System.out.println(B.multiplicate(A.add(E)).equals(B.multiplicate(A).add(B.multiplicate(E))));//B*(A+E)-B*A-B*E
		
		Matrix F=creator.randomDenseMatrix(height, height);
		System.out.println(F.equals(F.transpose().transpose()));
		System.out.println(A.multiplicate(B).transpose().equals(B.transpose().multiplicate(A.transpose())));
		System.out.println(F.multiplicate(A).slice(0, width, 0, width).equals(F.slice(0, width, 0, height).multiplicate(A)));
		DenseVectorCreator vCreator=new DenseVectorCreator();
		Vector v=vCreator.randomDenseVector(height);
		System.out.println(v.getSize());
		System.out.println(v.toMatrix().getHeight());
		System.out.println(v.toMatrix().toVector().getSize());		
//		v.print();
		System.out.println(v.rightMultiplicate(B).getSize());
		System.out.println(v.rightMultiplicate(F).equals(v.leftMultiplicate(F)));//should be false
		System.out.println(v.toMatrix().transpose().multiplicate(v.toMatrix()).get(0, 0));
		System.out.println(v.toMatrix().multiplicate(v.toMatrix().transpose()).trace());//should be >0 and equal to (v,v)
		
	}

}
