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
			Thread t=new Thread(new ServerRunnable(s));
			t.start();
		}
		ss.close();
		
	}

}