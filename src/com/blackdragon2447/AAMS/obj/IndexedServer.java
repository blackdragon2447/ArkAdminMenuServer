package com.blackdragon2447.AAMS.obj;

import java.util.Random;

public class IndexedServer{

	protected String Name;
	protected Integer ServerID;
	protected Long[] Admins;
	
	public IndexedServer() throws EmptyConstructorExeption {
		throw new EmptyConstructorExeption("you tried to create and empty server");
	}
	
	public IndexedServer(String Name, Long[] Admins) {
		Random random = new Random();
		this.Name = Name;
		this.ServerID = random.ints(100000000, 999999999).findFirst().getAsInt();
		this.Admins = Admins;
	}
	
	public IndexedServer(String Name, Integer ServerID, Long[] Admins) {
		this.Name = Name;
		this.ServerID = ServerID;
		this.Admins = Admins;
	}
	
	public String getName() {
		return Name;
	}
	
	public Integer getServerID() {
		return ServerID;
	}
	
	public Long[] getAdmins() {
		return Admins;
	}
	
	public void setName(String name) {
		Name = name;
	}
}
