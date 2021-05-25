package com.blackdragon2447.AAMS;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

import com.blackdragon2447.AAMS.obj.Pair;

public class NetworkHandler {

	ServerSocket serverSocket;
	Connection connection;
	Thread thread;
	ArrayList<Connection> connections = new ArrayList<Connection>();
	
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
				connection = new Connection(serverSocket.accept());
			} catch (IOException e) {
				e.printStackTrace();
			}
			connections.add(connection);
			thread = new Thread(connection);
			thread.start();
			System.out.println("connected");
		}
	}

	
}
