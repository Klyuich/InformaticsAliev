package edu.spbu.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MySocket {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket s=new Socket("mahalex.net",80);
		PrintWriter out=new PrintWriter(s.getOutputStream());
		BufferedReader reader=new BufferedReader(new InputStreamReader(s.getInputStream()));
		out.print("GET / HTTP/1.0\n\n");
		out.flush();
		boolean exit=false;
		int i=0, BIG=1000;
		while(!exit){
			String sString=reader.readLine();
			System.out.println(sString);
			if(sString!=null && sString.toLowerCase().contains("</html>"))  exit=true;
			if(i>BIG) exit=true;
		}
	//	System.out.println(exit);
	}

}
