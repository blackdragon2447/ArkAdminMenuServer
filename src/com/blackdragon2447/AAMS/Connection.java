package com.blackdragon2447.AAMS;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection implements Runnable{

	private Socket socket;
	private DataInputStream dataIn;
	private DataOutputStream dataOut;
	
	public Connection(Socket socket) {
		try {
			this.dataIn = new DataInputStream(socket.getInputStream());
			this.dataOut = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.socket = socket;
	}

	@Override
	public void run() {
		while(!socket.isClosed()) {
			System.out.println("start read");
			String str = "";
			char[] buffer = new char[20410];
			int charsRead = 0;
			BufferedReader in = null;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				System.out.println("reading");
				while ((charsRead = in.read(buffer)) != -1) {
				    str = new String(buffer).substring(0, charsRead);
				}
				System.out.println("done");
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("printing");
			System.out.println(str);
		}
	}
}
