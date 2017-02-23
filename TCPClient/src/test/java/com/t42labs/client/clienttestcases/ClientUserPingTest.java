package com.t42labs.client.clienttestcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.t42labs.client.clientfunctionalities.TCPClientFunctionalitiesImpl;

/**
 * The ClientUserPingTest performs test against the ping condition
 * 
 * @author Varun.N.S (Think42Labs)
 * @version 1.0
 * @since 16-02-2017
 * 
 */

public class ClientUserPingTest {

	TCPClientFunctionalitiesImpl clientFunctionalities = new TCPClientFunctionalitiesImpl();

	private static String PINGHEADER = "#P#\r\n";

	@Test
	public void PingScenario() {

		try {

			String pingResponse = clientFunctionalities.pingPacket(PINGHEADER);
			assertEquals("#AP#", pingResponse);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");
			
			/* Log stacktrace 
			throw new RuntimeException(ex); */
		}
	}

}
