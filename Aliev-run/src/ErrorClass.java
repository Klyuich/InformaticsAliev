
public class ErrorClass {

	static ErrorRun err;
	public static void main(String[] args){
		MyNumber n=new MyNumber();
		int N=5;
		ErrorRun err[]=new ErrorRun[N];
		for(int i=0;i<N;i++) err[i]=new ErrorRun(n);
		Thread myThread[]=new Thread[N];
		for(int i=0;i<N;i++) myThread[i]=new Thread(err[i]);
		for(int i=0;i<N;i++) myThread[i].start();
		for(int i=0;i<N;i++) myThread[i].join();
		System.out.println(n.geta());
	}
}
