package edu.spbu.cs;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class MySocket {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port=8080;
		try{
		Socket s= new Socket("localhost",port);
		PrintWriter out=new PrintWriter(s.getOutputStream());
		BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
		out.print("GET / HTTP/1.0\n\n");
		out.flush();
		boolean exit=false;
		String serverString;
		while(!exit){
			serverString=in.readLine();
			if(serverString.equalsIgnoreCase("exit")) exit=true;
			System.out.println(serverString);
			System.out.flush();
		}
		out.close();
		in.close();
		s.close();
		}
		catch(Exception e){
			System.out.println("Ошибка:");
			e.printStackTrace();
		}
		
	}

}
