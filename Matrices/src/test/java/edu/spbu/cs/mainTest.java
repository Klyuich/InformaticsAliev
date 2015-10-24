package edu.spbu.cs;

import org.junit.Test;

import static org.junit.Assert.*;
public class mainTest {


	@Test
	public void main() {
		// TODO Auto-generated method stub
		int height=1600,width=700;
		DenseMatrixCreator creator=new DenseMatrixCreator();
		DenseMatrix A=creator.RandomDenseMatrix(height, width);
		Matrix B=creator.randomDenseMatrix(width,height);
		long startTime,estimatedTime;
	
		startTime=System.nanoTime();
		Matrix D=A.simpleMultiplicate(B);
		estimatedTime=System.nanoTime() - startTime;
		System.out.println("Execution time of simple+transpose matrix multiplication: " + (estimatedTime/1e6));
		
		startTime=System.nanoTime();
		Matrix C=A.multiplicate(B);

		estimatedTime=System.nanoTime() - startTime;
		System.out.println("Execution time of divide by two matrix multiplication: " + (estimatedTime/1e6));
		
		
		
		assertTrue("wrong slice!",A.slice(10,20,10,20).slice(0,10,0,10).equals(A.slice(10,10,10,10)));	

		assertTrue("wrong matrix multiplication!",C.equals(D));
		
		
		assertTrue("tr AB!=tr BA",Math.abs(C.trace()-B.multiplicate(A).trace())<1e-9);
		
		height=150;
		width=30;
		A=creator.RandomDenseMatrix(height, width);
		B=creator.randomDenseMatrix(width, height);
		Matrix E=creator.randomDenseMatrix(height, width);
		
		assertTrue("B*(A+E)!=B*A+B*E",B.multiplicate(A.add(E)).equals(B.multiplicate(A).add(B.multiplicate(E))));//B*(A+E)-B*A-B*E
		
		Matrix F=creator.randomDenseMatrix(height, height);
		assertTrue("F^{TT}!=F",F.equals(F.transpose().transpose()));
		assertTrue("(AB)^T!=B^TA^T",A.multiplicate(B).transpose().equals(B.transpose().multiplicate(A.transpose())));
		assertTrue("problems with multiplication of slices!",
		F.multiplicate(A).slice(0, width, 0, width).equals(F.slice(0, width, 0, height).multiplicate(A)));
		
		DenseVectorCreator vCreator=new DenseVectorCreator();
		Vector v=vCreator.randomDenseVector(height);


		assertFalse("vF=v^T F",v.rightMultiplicate(F).equals(v.leftMultiplicate(F)));//should be false
		assertTrue("tr vu^t!=(v,u)",Math.abs(v.toMatrix().transpose().multiplicate(v.toMatrix()).get(0, 0)-v.toMatrix().multiplicate(v.toMatrix().transpose()).trace())<1e-9);
		
	}

}
