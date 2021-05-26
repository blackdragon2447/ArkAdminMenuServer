package com.blackdragon2447.AAMS;

import java.io.IOException;
import java.net.ServerSocket;

public class NetworkHandler {

	ServerSocket serverSocket;
	
	public NetworkHandler() {
		try {
			serverSocket = new ServerSocket(6666);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public void start() {
		while(true) {
			System.out.println("waiting for connection");
			try {
				new Thread(new Connection(serverSocket.accept())).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("connected");
		}
	}

	
}
