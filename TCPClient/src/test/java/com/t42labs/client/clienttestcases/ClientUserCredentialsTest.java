package com.t42labs.client.clienttestcases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.t42labs.client.clientfunctionalities.TCPClientFunctionalitiesImpl;

/**
 * The ClientUserCredentialsTest performs test against various conditions of the
 * login packets
 * 
 * @author Varun.N.S (Think42Labs)
 * @version 1.0
 * @since 16-02-2017
 * 
 */

public class ClientUserCredentialsTest {

	TCPClientFunctionalitiesImpl clientFunctionalities = new TCPClientFunctionalitiesImpl();

	private static String LOGINPACKETHEADER = "#L#";
	private static String PACKET1 = LOGINPACKETHEADER + "127.0.0.1;abcd\r\n";
	private static String PACKET2 = LOGINPACKETHEADER + "abcd;123\r\n";
	private static String PACKET3 = LOGINPACKETHEADER + "abcd;\r\n";
	private static String PACKET4 = LOGINPACKETHEADER + "\r\n";

	@Test
	public void checkUserScenario1() {

		try {

			boolean serverResponse = clientFunctionalities.userLogin(PACKET1);
			assertTrue(serverResponse);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

	@Test
	public void checkUserScenario2() {

		try {

			boolean serverResponse = clientFunctionalities.userLogin(PACKET2);
			assertFalse(serverResponse);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

	@Test
	public void checkUserScenario3() {

		try {

			boolean serverResponse = clientFunctionalities.userLogin(PACKET3);
			assertFalse(serverResponse);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

	@Test
	public void checkUserScenario4() {

		try {

			boolean serverResponse = clientFunctionalities.userLogin(PACKET4);
			assertFalse(serverResponse);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

}
