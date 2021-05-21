package com.blackdragon2447.AAMS;

import java.io.IOException;

import com.blackdragon2447.AAMS.obj.Pair;

public class Main {  
	public static void main(String[] args){  
		boolean exit = false;
		Pair<Action, String> command = new Pair<Action, String>(Action.NULL, null);
		NetworkHandler networkHandler = new NetworkHandler();
		while(!exit) {
			try {
				command = networkHandler.Listen();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(command.getFirstValue() == Action.EXIT) {
				System.out.println("exiting");
				exit = true;
			} else if (command.getFirstValue() == Action.PRINT) {
				System.out.println(command.getSecondValue());
			} else if (command.getFirstValue() == Action.ACCOUNTREQUEST) {
				try {
					networkHandler.response(Utils.findUser(command.getSecondValue()));
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (command.getFirstValue() == Action.SERVERREQUEST) {
				System.out.println(command.getSecondValue());
			} 
		}
	}  
}  