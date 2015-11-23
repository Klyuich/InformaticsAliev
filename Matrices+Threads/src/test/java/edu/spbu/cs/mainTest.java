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
		Matrix D = null;
		try {
			D = A.simpleMultiplicateWithThreads(B);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		estimatedTime=System.nanoTime() - startTime;
		System.out.println("Execution time of multithread simple matrix multiplication: " + (estimatedTime/1e6));
		
		startTime=System.nanoTime();
		Matrix C=A.multiplicate(B);

		estimatedTime=System.nanoTime() - startTime;
		System.out.println("Execution time of divide by two matrix multiplication: " + (estimatedTime/1e6));
		
		
		
	

		assertTrue("C!=D",C.equals(D));
		
	}

}
