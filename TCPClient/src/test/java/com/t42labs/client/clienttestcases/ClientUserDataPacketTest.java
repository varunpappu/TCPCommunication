package com.t42labs.client.clienttestcases;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.t42labs.client.clientfunctionalities.TCPClientFunctionalitiesImpl;

/**
 * The ClientUserDataPacketTest performs test against various conditions of the
 * data packets
 * 
 * @author Varun.N.S (Think42Labs)
 * @version 1.0
 * @since 16-02-2017
 * 
 */

public class ClientUserDataPacketTest {

	TCPClientFunctionalitiesImpl clientFunctionalities = new TCPClientFunctionalitiesImpl();

	private static String DATAPACKETHEADER = "#D#";
	private static SimpleDateFormat SIMPLEDATE = new SimpleDateFormat("dd:MM:yy");
	private static SimpleDateFormat SIMPLETIME = new SimpleDateFormat("hh:mm:ss");
	private static Date DATE = new Date(new java.util.Date().getTime());
	private static Date TIME = new Date(new java.util.Date().getTime());
	private static String CURRENTDATE = SIMPLEDATE.format(DATE);
	private static String CURRENTTIME = SIMPLETIME.format(TIME);

	// Success Scenario
	public static String DATAPACKET1 = DATAPACKETHEADER + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "5544.6025;N;5544.6025;N;45;20;21;5;12.2;20;21;14.77,0.02,3.6;12ABC;count1:1:564,fuel:2:45.8,hw:3:V4.5\r\n";

	// Packet Structure Error
	public static String DATAPACKET2 = DATAPACKETHEADER + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "5544.6025;N;5544.6025;N\r\n";

	// Incorrect Time
	public static String DATAPACKET3 = DATAPACKETHEADER + CURRENTDATE + ";" + "2345" + ";"
			+ "5544.6025;N;5544.6025;N;45;20;21;5;12.2;20;21;14.77,0.02,3.6;12ABC;count1:1:564,fuel:2:45.8,hw:3:V4.5\r\n";

	// Error coordinates
	public static String DATAPACKET4 = DATAPACKETHEADER + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "NA;N;NA;N;45;20;21;5;12.2;20;21;14.77,0.02,3.6;12ABC;count1:1:564,fuel:2:45.8,hw:3:V4.5\r\n";

	// Error getting height, speed or course
	public static String DATAPACKET5 = DATAPACKETHEADER + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "5544.6025;N;5544.6025;N;NA;NA;21;5;12.2;20;21;14.77,0.02,3.6;12ABC;count1:1:564,fuel:2:45.8,hw:3:V4.5\r\n";

	// Error getting sats and hdop
	public static String DATAPACKET6 = DATAPACKETHEADER + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "5544.6025;N;5544.6025;N;45;20;21;NA;NA;20;21;14.77,0.02,3.6;12ABC;count1:1:564,fuel:2:45.8,hw:3:V4.5\r\n";

	// Error getting inputs and outputs
	public static String DATAPACKET7 = DATAPACKETHEADER + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "5544.6025;N;5544.6025;N;45;20;21;5;12.2;NA;NA;14.77,0.02,3.6;12ABC;count1:1:564,fuel:2:45.8,hw:3:V4.5\r\n";

	// Error getting adc
	public static String DATAPACKET8 = DATAPACKETHEADER + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "5544.6025;N;5544.6025;N;45;20;21;5;12.2;20;21;NA;12ABC;count1:1:564,fuel:2:45.8,hw:3:V4.5\r\n";

	// Error getting additional parameters
	public static String DATAPACKET9 = DATAPACKETHEADER + CURRENTDATE + ";" + CURRENTTIME + ";"
			+ "5544.6025;N;5544.6025;N;45;20;21;5;12.2;20;21;14.77,0.02,3.6;12ABC;NA\r\n";

	// Time and Date NA
	public static String DATAPACKET10 = DATAPACKETHEADER + "NA" + ";" + "NA" + ";"
			+ "5544.6025;N;5544.6025;N;45;20;21;5;12.2;20;21;14.77,0.02,3.6;12ABC;count1:1:564,fuel:2:45.8,hw:3:V4.5\r\n";

	@Test
	public void dataPacketScenario1() {

		try {

			String check = clientFunctionalities.dataPacket(DATAPACKET1);
			assertEquals("#AD#1", check);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

	@Test
	public void dataPacketScenario2() {

		try {

			String check = clientFunctionalities.dataPacket(DATAPACKET2);
			assertEquals("#AD#-1", check);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

	@Test
	public void dataPacketScenario3() {

		try {

			String check = clientFunctionalities.dataPacket(DATAPACKET3);
			assertEquals("#AD#0", check);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

	@Test
	public void dataPacketScenario4() {

		try {

			String check = clientFunctionalities.dataPacket(DATAPACKET4);
			assertEquals("#AD#10", check);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

	@Test
	public void dataPacketScenario5() {

		try {

			String check = clientFunctionalities.dataPacket(DATAPACKET5);
			assertEquals("#AD#11", check);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

	@Test
	public void dataPacketScenario6() {

		try {

			String check = clientFunctionalities.dataPacket(DATAPACKET6);
			assertEquals("#AD#12", check);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

	@Test
	public void dataPacketScenario7() {

		try {

			String check = clientFunctionalities.dataPacket(DATAPACKET7);
			assertEquals("#AD#13", check);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

	@Test
	public void dataPacketScenario8() {

		try {

			String check = clientFunctionalities.dataPacket(DATAPACKET8);
			assertEquals("#AD#14", check);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

	@Test
	public void dataPacketScenario9() {

		try {

			String check = clientFunctionalities.dataPacket(DATAPACKET9);
			assertEquals("#AD#15", check);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

	@Test
	public void dataPacketScenario10() {

		try {

			String check = clientFunctionalities.dataPacket(DATAPACKET10);
			assertEquals("#AD#1", check);

		} catch (Exception ex) {

			System.out.println("Connection to server failed");

			/*
			 * Log stacktrace throw new RuntimeException(ex);
			 */
		}
	}

}
