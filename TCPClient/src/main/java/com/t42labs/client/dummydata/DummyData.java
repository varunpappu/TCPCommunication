package com.t42labs.client.dummydata;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The DummyData contains the data that will be tested out
 * against the TCPServer
 *
 * @author Varun.N.S (Think42Labs)
 * @version 1.0
 * @since 16-02-2017
 * 
 */

public class DummyData {

	private static String LOGINPACKETHEADER = "#L#";
	private static String LOGINPACKET = LOGINPACKETHEADER + "862950025913222;NA\r\n";

	private static String PINGPACKETHEADER = "#P#";

	private static String SHORTDATAPACKETHEADER = "#SD#";
	private static String DATAPACKETHEADER = "#D#";
	private static String BLACKBOXHEADER = "#B#";

	private static SimpleDateFormat SIMPLEDATE = new SimpleDateFormat("dd:MM:yy");
	private static SimpleDateFormat SIMPLETIME = new SimpleDateFormat("hh:mm:ss");
	private static Date DATE = new Date(new java.util.Date().getTime());
	private static Date TIME = new Date(new java.util.Date().getTime());
	private static String CURRENTDATE = SIMPLEDATE.format(DATE);
	private static String CURRENTTIME = SIMPLETIME.format(TIME);

	private static String LATITUDE1 = "5544.6025";
	private static String LATITUDE2 = "N";
	private static String LONGITUDE1 = "5544.6025";
	private static String LONGITUDE2 = "N";
	private static int SPEED = 45;
	private static int COURSE = 20;
	private static int HEIGHT = 21;
	private static int SATS = 5;
	private static double HDOP = 12.2;
	private static int INPUTS = 20;
	private static int OUTPUTS = 21;
	private static String ADC = "14.77,0.02,3.6";
	private static String IBUTTON = "12ABC";
	private static String PARAMS = "count1:1:564,fuel:2:45.8,hw:3:V4.5";

	private static String SHORTPACKET = SHORTDATAPACKETHEADER + CURRENTDATE + ";" + CURRENTTIME + ";" + LATITUDE1 + ";"
			+ LATITUDE2 + ";" + LONGITUDE1 + ";" + LONGITUDE2 + ";" + SPEED + ";" + COURSE + ";" + HEIGHT + ";" + SATS;

	private static String DATAPACKET = DATAPACKETHEADER + CURRENTDATE + ";" + CURRENTTIME + ";" + LATITUDE1 + ";"
			+ LATITUDE2 + ";" + LONGITUDE1 + ";" + LONGITUDE2 + ";" + SPEED + ";" + COURSE + ";" + HEIGHT + ";" + SATS
			+ ";" + HDOP + ";" + INPUTS + ";" + OUTPUTS + ";" + ADC + ";" + IBUTTON + ";" + PARAMS;

	private static String BLACKBOXPACKET = BLACKBOXHEADER + CURRENTDATE + ";" + CURRENTTIME + ";" + LATITUDE1 + ";"
			+ LATITUDE2 + ";" + LONGITUDE1 + ";" + LONGITUDE2 + ";" + SPEED + ";" + COURSE + ";" + HEIGHT + ";" + SATS
			+ "|" + CURRENTDATE + ";" + CURRENTTIME + ";" + LATITUDE1 + ";" + LATITUDE2 + ";" + LONGITUDE1 + ";"
			+ LONGITUDE2 + ";" + SPEED + ";" + COURSE + ";" + HEIGHT + ";" + SATS;

	public String loginPacket() {

		return LOGINPACKET;
	}

	public String pingPacket() {

		return PINGPACKETHEADER;
	}

	public String shortDataPacket() {

		return SHORTPACKET;
	}

	public String dataPacket() {

		return DATAPACKET;
	}

	public String blackBoxPacket() {

		return BLACKBOXPACKET;
	}
}
