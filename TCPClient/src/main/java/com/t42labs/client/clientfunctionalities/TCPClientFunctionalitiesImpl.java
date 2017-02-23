package com.t42labs.client.clientfunctionalities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The TCPClientFuncationalitesImpl implements the interface
 * TCPClientFuncationalites and provides functionalities for the same
 *
 * @author Varun.N.S (Think42Labs)
 * @version 1.0
 * @since 16-02-2017
 * 
 */

public class TCPClientFunctionalitiesImpl implements TCPClientFunctionalities {

	// Initializing the PORT and IPADDRESS
	private static int PORT = 2022;
	private static String IPADDRESS = "54.174.70.143";

	// Creating a Logger
	private static Logger logger = Logger.getLogger("TCPClientLogger");

	/**
	 * @param loginPacket
	 * @return boolean
	 * @throws Exception
	 */
	public boolean userLogin(String loginPacket) throws Exception {

		// Initializing a String to null
		String serverResponse = null;

		// Creating a Client Socket containing the IPADDRESS and PORT
		Socket clientSocket = new Socket(IPADDRESS, PORT);

		// Create output stream attached to socket
		Writer outToServer = new OutputStreamWriter(clientSocket.getOutputStream());

		// Response from Server
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		// Passing packet to the Server
		outToServer.write(loginPacket + '\n');
		outToServer.flush();

		// Receiving response from the Server
		serverResponse = inFromServer.readLine();
		System.out.println("ServerResponse: " + serverResponse);
		// Server Response
		/* System.out.println(serverResponse); */

		// Returns boolean based on different conditions received from the
		// Server
		try {
			if (serverResponse.equals("#AL#1")) {

				// Closing socket for scalability
				clientSocket.close();
				return true;

			} else if (serverResponse.equals("#AL#0")) {

				clientSocket.close();
				return false;

			} else {

				clientSocket.close();
				return false;
			}
		} catch (Exception ex) {

			logger.log(Level.SEVERE, "Database connectivity not found");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
		return false;
	}

	/**
	 * @param shortPacket
	 * @return serverResponse
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public String shortDataPacket(String shortPacket) throws Exception {

		// Initializing a String to null
		String serverResponse = null;

		// Creating a Client Socket containing the IPADDRESS and PORT
		Socket clientSocket = new Socket(IPADDRESS, PORT);

		try {

			// Create output stream attached to socket
			Writer outToServer = new OutputStreamWriter(clientSocket.getOutputStream());

			// Response from Server
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			// Passing packet to the Server
			outToServer.write(shortPacket + '\n');
			outToServer.flush();

			serverResponse = inFromServer.readLine();
			return serverResponse;

		} catch (Exception ex) {

			logger.log(Level.SEVERE, "Database connectivity not found");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
		return serverResponse;
	}

	/**
	 * @param dataPacket
	 * @return serverResponse
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public String dataPacket(String dataPacket) throws Exception {

		// Initializing a String to null
		String serverResponse = null;

		// Creating a Client Socket containing the IPADDRESS and PORT
		Socket clientSocket = new Socket(IPADDRESS, PORT);

		try {
			// Create output stream attached to socket
			Writer outToServer = new OutputStreamWriter(clientSocket.getOutputStream());

			// Response from Server
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			// Passing packet to the Server
			outToServer.write(dataPacket + '\n');
			outToServer.flush();

			serverResponse = inFromServer.readLine();
			return serverResponse;

		} catch (Exception ex) {

			logger.log(Level.SEVERE, "Database connectivity not found");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
		return serverResponse;

	}

	/**
	 * @param pingPacket
	 * @return serverResponse
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public String pingPacket(String pingPacket) throws Exception {

		// Initializing a String to null
		String serverResponse = null;

		// Creating a Client Socket containing the IPADDRESS and PORT
		Socket clientSocket = new Socket(IPADDRESS, PORT);

		// Create output stream attached to socket
		Writer outToServer = new OutputStreamWriter(clientSocket.getOutputStream());

		// Response from Server
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		/*
		 * // Logging the ping response logger.log(Level.FINE, pingPacket);
		 */

		// Passing packet to the Server
		outToServer.write(pingPacket + '\n');
		outToServer.flush();

		serverResponse = inFromServer.readLine();
		return serverResponse;
	}

	/**
	 * @param blackboxPacket
	 * @return serverResponse
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public String blackboxPacket(String blackboxPacket) throws Exception {

		// Initializing a String to null
		String serverResponse = null;

		// Creating a Client Socket containing the IPADDRESS and PORT
		Socket clientSocket = new Socket(IPADDRESS, PORT);
		try {
			// Create output stream attached to socket
			Writer outToServer = new OutputStreamWriter(clientSocket.getOutputStream());

			// Response from Server
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			// Passing packet to the Server
			outToServer.write(blackboxPacket + '\n');
			outToServer.flush();

			serverResponse = inFromServer.readLine();
			return serverResponse;

		} catch (Exception ex) {

			logger.log(Level.SEVERE, "Database connectivity not found");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
		return serverResponse;
	}
}
