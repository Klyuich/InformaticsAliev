
	public class ErrorRun		
	implements Runnable	
	{
		MyNumber n;
		public ErrorRun(MyNumber n){
			this.n=n;
		}
		public void run()		
		{
			for(int i=0;i<1e5;i++)n.increment();
		}
	}
