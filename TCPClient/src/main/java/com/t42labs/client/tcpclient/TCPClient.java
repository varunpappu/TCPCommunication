package com.t42labs.client.tcpclient;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.t42labs.client.clientfunctionalities.TCPClientFunctionalitiesImpl;
import com.t42labs.client.dummydata.DummyData;

public class TCPClient {

	/**
	 * The TCPClient application implements an application that connects to the
	 * TCPServer and passes message in the form of a text
	 *
	 * @author Varun.N.S (Think42Labs)
	 * @version 1.0
	 * @since 16-02-2017
	 * 
	 */

	// Initialize a static boolean variable
	private static boolean isRunning = true;

	// Creating a Logger
	private static Logger logger = Logger.getLogger("TCPClientLogger");

	public static void main(String[] args) throws Exception {

		final TCPClientFunctionalitiesImpl clientImpl = new TCPClientFunctionalitiesImpl();
		final DummyData dummyData = new DummyData();

		try {

			// Conditions to check if user exists in the database
			if (clientImpl.userLogin(dummyData.loginPacket())) {

				// Timer that starts every 2 minutes
				Timer ping = new Timer();

				ping.schedule(new TimerTask() {

					String response = null;
					String packet = null;

					public void run() {

						try {

							// Ping packet is sent and its response is received
							String sResponse = clientImpl.pingPacket(dummyData.pingPacket());

							System.out.print("Ping response: " + sResponse);

							if (sResponse.equals("#AP#") && isRunning == true) {

								// Datapacket is sent and the response is
								// received
								response = clientImpl.dataPacket(dummyData.dataPacket());
								System.out.print("Server data packet response: " + response);

								/* Packet response */
								logger.log(Level.FINE, response);

							} else {

								do {
									// Blackbox packet is sent and the response
									// is received
									response = clientImpl.blackboxPacket(dummyData.blackBoxPacket());
									packet = response.substring(1, response.lastIndexOf("#"));

									/* BlackBox response */
									System.out.print("Blackbox packet response: " + response);

								} while (!packet.equals("AB"));

								isRunning = true;
							}
						} catch (Exception ex) {

							isRunning = false;
							logger.log(Level.SEVERE, "Connection to the Server failed");

							/*
							 * Log stacktrace throw new RuntimeException(ex);
							 */
						}
					}

				}, 0, 60 * 2000);
			}

		} catch (IOException ex) {

			logger.log(Level.SEVERE, "Connection to the Server failed");
			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */

		}
	}
}