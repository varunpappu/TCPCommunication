package com.t42labs.client.clienttestcases;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.t42labs.client.clientfunctionalities.TCPClientFunctionalitiesImpl;

/**
 * The ClientUserBlackBoxTest performs test against various conditions of the
 * Blackbox packets
 * 
 * @author Varun.N.S (Think42Labs)
 * @version 1.0
 * @since 16-02-2017
 * 
 */

public class ClientUserBlackBoxTest {

	TCPClientFunctionalitiesImpl clientFunctionalities = new TCPClientFunctionalitiesImpl();

	private static String BLACKBOXHEADER = "#B#";
	private static SimpleDateFormat SIMPLEDATE = new SimpleDateFormat("dd:MM:yy");
	private static SimpleDateFormat SIMPLETIME = new SimpleDateFormat("hh:mm:ss");
	private static Date DATE = new Date(new java.util.Date().getTime());
	private static Date TIME = new Date(new java.util.Date().getTime());
	private static String CURRENTDATE = SIMPLEDATE.format(DATE);
	private static String CURRENTTIME = SIMPLETIME.format(TIME);

	private static String BLACKBOXPACKET1 = BLACKBOXHEADER + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "5544.6025;N;5544.6025;N;45;20;21;5" + "|" + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "5544.6025;N;5544.6025;N;45;20;21;5";

	private static String BLACKBOXPACKET2 = BLACKBOXHEADER + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "5544.6025;N;5544.6025;N;45;20;21;5" + "|" + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "5544.6025;N;5544.6025;N;45;20;21;5" + "|" + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "5544.6025;N;5544.6025;N;45;20;21;5";

	@Test
	public void blackBoxPacketScenario1() {

		try {

			String serverResponse = clientFunctionalities.blackboxPacket(BLACKBOXPACKET1);
			assertEquals("#AB#2", serverResponse);

		} catch (Exception e) {

			System.out.println("Connection to server failed");

		}
	}

	@Test
	public void blackBoxPacketScenario2() {

		try {

			String serverResponse = clientFunctionalities.blackboxPacket(BLACKBOXPACKET2);
			assertEquals("#AB#3", serverResponse);

		} catch (Exception e) {

			System.out.println("Connection to server failed");
		}
	}
}
