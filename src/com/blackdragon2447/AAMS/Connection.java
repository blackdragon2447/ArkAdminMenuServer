package com.blackdragon2447.AAMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection implements Runnable{

	private Socket socket;
	//private DataInputStream dataIn;
	//private DataOutputStream dataOut;
	
	public Connection(Socket socket) {
		/*try {
			this.dataIn = new DataInputStream(socket.getInputStream());
			this.dataOut = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		this.socket = socket;
	}

	@Override
	public void run() {
		String str = "";
		char[] buffer = new char[20410];
		int charsRead = 0;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			while ((charsRead = in.read(buffer)) != -1) {
			    str = new String(buffer).substring(0, charsRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(buffer);
		if(str.contains("-exit")) {
			//return new Pair<Action, String>(Action.EXIT, null);
			System.out.println("exit");
			return;
		} else if (str.contains("-print")) {
			//return new Pair<Action, String>(Action.PRINT, str.substring(7));
		} else if (str.contains("-accreq")) {
			//return new Pair<Action, String>(Action.ACCOUNTREQUEST, str.substring(10));
		} else if (str.contains("-accmod")) {
			//return new Pair<Action, String>(Action.MODACCOUNT, str.substring(10));
		}  else if (str.contains("-accadd")) {
			//return new Pair<Action, String>(Action.ADDACCOUNT, str.substring(10));
		} else if (str.contains("-serreq")) {
			//return new Pair<Action, String>(Action.SERVERREQUEST, str.substring(10));
		} else if (str.contains("-sermod")) {
			//return new Pair<Action, String>(Action.MODSERVER, str.substring(10));
		} else if (str.contains("-seradd")) {
			//return new Pair<Action, String>(Action.ADDSERVER, str.substring(10));
		} else if (str.contains("-reqindacc")) {
			//return new Pair<Action, String>(Action.GETUSERINDEX, str.substring(10));
		} else if (str.contains("-reqindser")) {
			//return new Pair<Action, String>(Action.GETSEVERINDEX, str.substring(10));
		}
		
	}
}
