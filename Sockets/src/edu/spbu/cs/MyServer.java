package edu.spbu.cs;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;	

public class MyServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int port=8080;
		ServerSocket ss=new ServerSocket(port);
		boolean exit=false;
		while(!exit){
			Socket s=ss.accept();
			PrintWriter out=new PrintWriter(s.getOutputStream());
			boolean localExit=false;
			System.out.println("Напечатай что-нибудь!");
			BufferedReader consoleIn = new 
				     BufferedReader(new InputStreamReader(System.in));
			String inputString;
			while(!localExit){
				inputString=consoleIn.readLine();
				if(inputString.equalsIgnoreCase("exit")) localExit=true;
				out.println(inputString);
				out.flush();
			}
			consoleIn.close();
			out.close();
			s.close();
			exit=true;
		}
		ss.close();
		
	}

}
