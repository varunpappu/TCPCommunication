package com.t42labs.client.clientfunctionalities;

/**
 * The TCPClientFunctionalities interface contains all the 
 * functionalities to be implemented.
 *
 * @author Varun.N.S (Think42Labs)
 * @version 1.0
 * @since 16-02-2017
 * 
 */

public interface TCPClientFunctionalities {

	public boolean userLogin(String loginPacket) throws Exception;
	
	public String shortDataPacket(String shortPacket) throws Exception;
	
	public String dataPacket(String dataPacket) throws Exception;
	
	public String pingPacket(String pingPacket) throws Exception;
	
	public String blackboxPacket(String blackboxPacket) throws Exception;
	
}
