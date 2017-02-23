package com.t42labs.server.serverfunctionalities;

/**
 * The ServerFunctionalities interface that contains all the functionalities
 * 
 *
 * @author Varun.N.S (Think42Labs)
 * @version 1.0
 * @since 16-02-2017
 */

public interface ServerFunctionalities {

	public String insertDataPacket(String dataPacket);

	public String insertShortData(String dataPacket);

	public String userLoginCheck(String userCredentials);

}
