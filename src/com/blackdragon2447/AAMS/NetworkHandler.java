package com.blackdragon2447.AAMS;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import com.blackdragon2447.AAMS.obj.Pair;

public class NetworkHandler {

	ServerSocket serverSocket;
	Socket socket;
	DataInputStream dataIn;
	DataOutputStream dataOut;
	
	public NetworkHandler() {
		try {
			serverSocket = new ServerSocket(6666); 
			socket = serverSocket.accept();
			dataIn = new DataInputStream(socket.getInputStream());
			//dataOut = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public Pair<Action, String> Listen() throws IOException {
		String str = "";
		char[] buffer = new char[20410];
		int charsRead = 0;
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		while ((charsRead = in.read(buffer)) != -1) {
		    str = new String(buffer).substring(0, charsRead);
		}
		if(str.contains("-exit")) {
			return new Pair<Action, String>(Action.EXIT, null);
		} else if (str.contains("-print")) {
			return new Pair<Action, String>(Action.PRINT, str.substring(7));
		} else if (str.contains("-accreq")) {
			return new Pair<Action, String>(Action.ACCOUNTREQUEST, str.substring(10));
		} else if (str.contains("-accmod")) {
			return new Pair<Action, String>(Action.MODACCOUNT, str.substring(10));
		}  else if (str.contains("-accadd")) {
			return new Pair<Action, String>(Action.ADDACCOUNT, str.substring(10));
		} else if (str.contains("-serreq")) {
			return new Pair<Action, String>(Action.SERVERREQUEST, str.substring(10));
		} else if (str.contains("-sermod")) {
			return new Pair<Action, String>(Action.MODSERVER, str.substring(10));
		} else if (str.contains("-seradd")) {
			return new Pair<Action, String>(Action.ADDSERVER, str.substring(10));
		} else if (str.contains("-reqindacc")) {
			return new Pair<Action, String>(Action.GETUSERINDEX, str.substring(10));
		} else if (str.contains("-reqindser")) {
			return new Pair<Action, String>(Action.GETSEVERINDEX, str.substring(10));
		}
		
		return new Pair<Action, String>(Action.NULL, null);
		
	}
	
	public void response(String msg) throws IOException {
		dataOut.writeUTF(msg);
		dataOut.flush();
	}
	
	public void close() {
		try {
			dataIn.close();
			dataOut.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
