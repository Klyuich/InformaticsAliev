
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matrix a=new DenseMatrix(new double[][]{{1,2},{3,4}});
		a.print();
		Matrix b=a.slice(0, 1, 0, 2);
		Matrix c=a.slice(0, 2, 0, 1);
		b.print();
		c.print();
		a.multiplicate(a).multiplicate(c).print();
		System.out.println(a.trace());
		
	}

}
