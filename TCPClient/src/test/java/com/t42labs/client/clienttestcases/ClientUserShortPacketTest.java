package com.t42labs.client.clienttestcases;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.t42labs.client.clientfunctionalities.TCPClientFunctionalitiesImpl;

/**
 * The ClientUserShortPacketTest performs test against the shortdata packets
 * 
 * @author Varun.N.S (Think42Labs)
 * @version 1.0
 * @since 16-02-2017
 * 
 */

public class ClientUserShortPacketTest {

	TCPClientFunctionalitiesImpl clientFunctionalities = new TCPClientFunctionalitiesImpl();

	private static String SHORTDATAPACKETHEADER = "#SD#";
	private static SimpleDateFormat SIMPLEDATE = new SimpleDateFormat("dd:MM:yy");
	private static SimpleDateFormat SIMPLETIME = new SimpleDateFormat("hh:mm:ss");
	private static Date DATE = new Date(new java.util.Date().getTime());
	private static Date TIME = new Date(new java.util.Date().getTime());
	private static String CURRENTDATE = SIMPLEDATE.format(DATE);
	private static String CURRENTTIME = SIMPLETIME.format(TIME);

	// Success Scenario
	private static String SHORTPACKET1 = SHORTDATAPACKETHEADER + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "5544.6025;N;5544.6025;N;45;20;21;5\r\n";

	// Packet Structure Error
	private static String SHORTPACKET2 = SHORTDATAPACKETHEADER + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "5544.6025;N;5544.6025;N\r\n";

	// Incorrect Time
	private static String SHORTPACKET3 = SHORTDATAPACKETHEADER + CURRENTDATE + ";" + "12332" + ";"
			+ "5544.6025;N;5544.6025;N;45;20;21;5\r\n";

	// Error coordinates
	private static String SHORTPACKET4 = SHORTDATAPACKETHEADER + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "NA;N;NA;N;45;20;21;5\r\n";

	// Error getting height, speed or course
	private static String SHORTPACKET5 = SHORTDATAPACKETHEADER + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "5544.6025;N;5544.6025;N;NA;NA;21;5\r\n";

	// Error getting sats
	private static String SHORTPACKET6 = SHORTDATAPACKETHEADER + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "5544.6025;N;5544.6025;N;45;20;21;NA\r\n";

	// Date and Time NA
	private static String SHORTPACKET7 = SHORTDATAPACKETHEADER + "NA" + ";" + "NA" + ";"
			+ "5544.6025;N;5544.6025;N;45;20;21;5\r\n";

	@Test
	public void shortPacketScenario1() {

		try {

			String check = clientFunctionalities.shortDataPacket(SHORTPACKET1);
			assertEquals("#ASD#1", check);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */

		}
	}

	@Test
	public void shortPacketScenario2() {

		try {

			String check = clientFunctionalities.shortDataPacket(SHORTPACKET2);
			assertEquals("#ASD#-1", check);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */

		}
	}

	@Test
	public void shortPacketScenario3() {

		try {

			String check = clientFunctionalities.shortDataPacket(SHORTPACKET3);
			assertEquals("#ASD#0", check);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

	@Test
	public void shortPacketScenario4() {

		try {

			String check = clientFunctionalities.shortDataPacket(SHORTPACKET4);
			assertEquals("#ASD#10", check);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

	@Test
	public void shortPacketScenario5() {

		try {

			String check = clientFunctionalities.shortDataPacket(SHORTPACKET5);
			assertEquals("#ASD#11", check);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

	@Test
	public void shortPacketScenario6() {

		try {

			String check = clientFunctionalities.shortDataPacket(SHORTPACKET6);
			assertEquals("#ASD#12", check);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

	@Test
	public void shortPacketScenario7() {

		try {

			String check = clientFunctionalities.shortDataPacket(SHORTPACKET7);
			assertEquals("#ASD#1", check);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

}
