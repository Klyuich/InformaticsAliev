package edu.spbu.cs;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerRunnable implements Runnable {
	Socket s;
	public ServerRunnable(Socket s){
		this.s=s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		PrintWriter out;
		try {
			out = new PrintWriter(s.getOutputStream());
			out.print("HTTP/1.1 200 Ok\n\r"+ 
"Server: nginx/1.8.0\n\r"+
"Date: Mon, 07 Dec 2015 09:11:39 GMT\n\r"+ 
"Content-Type: text/html\n\r"+
"Connection: close\n\r\n\r"+
"<html>"+ 
"<head><title>Test ok</title></head>"+
"<body bgcolor=\"white\"> "+
"<center><h1>HELLO</h1></center>"+ 
"</body>"+
"</html>"); 
			out.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	
		
	}

}
