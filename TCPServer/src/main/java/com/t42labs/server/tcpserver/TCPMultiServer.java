package com.t42labs.server.tcpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.t42labs.server.serverfunctionalities.ServerFunctionalitiesImpl;

/**
 * The TCPMultiServer application implements an application that starts a
 * TCPServer and waits for request from TCPClient
 *
 * @author Varun.N.S (Think42Labs)
 * @version 1.0
 * @since 16-02-2017
 * 
 */

public class TCPMultiServer {

	// Initializing the PORT
	private static int PORT = 2022;

	// Creating a Logger
	private static Logger logger = Logger.getLogger("TCPMultiServerLogger");

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		// Creating a Server Socket that will listen on a given port
		ServerSocket receivingSocket = null;
		Socket socket = null;

		try {

			receivingSocket = new ServerSocket(PORT);

		} catch (IOException ex) {

			logger.log(Level.SEVERE, "Server down");
			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */

		}

		while (true) {
			try {

				socket = receivingSocket.accept();
				ServerThread st = new ServerThread(socket);
				st.start();
			}

			catch (Exception e) {

				logger.log(Level.WARNING, "Connection error");
				/*
				 * Log stacktrace throw new RuntimeException(ex);
				 */
			}
		}

	}
}

class ServerThread extends Thread {

	// Creating a Logger
	private static Logger logger = Logger.getLogger("ServerThreadLogger");

	ServerFunctionalitiesImpl serverFunctions = new ServerFunctionalitiesImpl();
	String clientRequest = null;
	BufferedReader inputStream = null;
	PrintWriter outputStream = null;
	Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outputStream = new PrintWriter(socket.getOutputStream());

		} catch (IOException e) {

			logger.log(Level.SEVERE, "IO Error in server thread");
		}

		try {

			clientRequest = inputStream.readLine();

			if (clientRequest.compareTo("QUIT") != 0) {

				// Fetches the client response code
				String query = clientRequest.substring(1, clientRequest.lastIndexOf("#"));

				// Actions performed based on client response
				// Login Request from client
				if (query.equals("L")) {

					String userCredentials = clientRequest.substring(3);
					String response = serverFunctions.userLoginCheck(userCredentials);

					// Create output stream attached to socket
					outputStream.write(response + "\n");
					outputStream.flush();

					// Ping request from the client
				} else if (query.equals("P")) {

					/// Create output stream attached to socket
					outputStream.write("#AP#\r\n" + "\n");
					outputStream.flush();

					// ShortPacket request from client
				} else if (query.equals("SD")) {

					String dataPacket = clientRequest.substring(4);
					String response = serverFunctions.insertShortData(dataPacket);

					// Create output stream attached to socket
					outputStream.write(response + "\n");
					outputStream.flush();

				} else if (query.equals("D")) {

					String dataPacket = clientRequest.substring(3);
					String response = serverFunctions.insertDataPacket(dataPacket);

					outputStream.write(response + "\n");
					outputStream.flush();
				}

				else if (query.equals("B")) {

					String dataPacket = clientRequest.substring(3);
					String dataNumber[] = dataPacket.split("\\|");
					int counter = 0;

					for (int i = 0; i < dataNumber.length; i++) {

						serverFunctions.insertShortData(dataNumber[i]);
						counter++;

					}

					String response = "#AB#" + counter + "\r\n";
					outputStream.write(response + "\n");
					outputStream.flush();

				}

			}
		} catch (IOException ex) {

			logger.log(Level.SEVERE, "IO Error/ Client terminated abruptly");
			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */

		} catch (NullPointerException ex) {

			logger.log(Level.WARNING, "Client close");
			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}

		finally {

			try {

				if (inputStream != null) {

					inputStream.close();
					/*
					 * Socket stream closed
					 * System.out.println(" Socket Input Stream Closed");
					 */

				}

				if (outputStream != null) {

					outputStream.close();
					/*
					 * Socket closed System.out.println("Socket Out Closed");
					 */

				}
				if (socket != null) {

					socket.close();
					/*
					 * Socket closed System.out.println("Socket Closed");
					 */

				}

			} catch (IOException ex) {

				logger.log(Level.SEVERE, "Socket closed error");
				/*
				 * Log stacktrace throw new RuntimeException(ex);
				 */
			}
		}
	}
}