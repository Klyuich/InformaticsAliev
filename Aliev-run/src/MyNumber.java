
public class MyNumber {
	int a=0;
	public synchronized void increment(){
		a++;
	}
	public int geta(){
		return a;
	}
}
