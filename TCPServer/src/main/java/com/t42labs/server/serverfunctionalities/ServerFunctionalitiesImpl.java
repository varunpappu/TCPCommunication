package com.t42labs.server.serverfunctionalities;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import com.t42labs.server.database.MySQLJDBC;
import com.t42labs.server.serverresponse.ServerResponse;

/**
 * The ServerFunctionalitiesImpl implements the ServerFunctionalities and
 * provides with the functionalities for the same
 *
 * @author Varun.N.S (Think42Labs)
 * @version 1.0
 * @since 16-02-2017
 */
public class ServerFunctionalitiesImpl implements ServerFunctionalities {

	private static SimpleDateFormat SIMPLEDATE = new SimpleDateFormat("dd:MM:yy");
	private static SimpleDateFormat SIMPLETIME = new SimpleDateFormat("hh:mm:ss");
	private static Date DATE = new Date(new java.util.Date().getTime());
	private static Date TIME = new Date(new java.util.Date().getTime());
	private static String CURRENTDATE = SIMPLEDATE.format(DATE);
	private static String CURRENTTIME = SIMPLETIME.format(TIME);
	Logger logger = Logger.getLogger("TCPMultiServerLogger");
	FileHandler fh;

	/**
	 * @param dataPacket
	 * @return serverResponse
	 */
	public String insertDataPacket(String dataPacket) {

		String data[] = dataPacket.split(";");

		if ((dataPacket != null && data.length == 15) || (dataPacket != null && data.length == 16)) {

			Timestamp time = null;
			java.sql.Date date = null;

			if (data[0].equals("NA")) {

				try {

					// Converting date from String to Date format
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yy");
					java.util.Date dt = dateFormat.parse(CURRENTDATE);
					date = new java.sql.Date(dt.getTime());

				} catch (ParseException pe) {

					System.out.println("Wrong date format");
				}
			}

			if (data[1].equals("NA")) {

				try {

					// Converting date from String to Time format
					SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
					Date parsedDate = timeFormat.parse(CURRENTTIME);
					time = new java.sql.Timestamp(parsedDate.getTime());

				} catch (ParseException pe) {

					System.out.println("Incorrect date format");
				}
			} else {

				try {

					// Converting date from String to Time format
					SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
					Date parsedDate = timeFormat.parse(data[1]);
					time = new java.sql.Timestamp(parsedDate.getTime());

				} catch (ParseException pe) {

					return ServerResponse.PACKETINCORRECTTIMERESPONSE.getValue();
				}
			}

			String lat1 = data[2];
			String lat2 = data[3];

			String lon1 = data[4];
			String lon2 = data[5];

			String speed = data[6];
			String course = data[7];

			String height = data[8];

			String sats = data[9];

			String hdop = data[10];

			String inputs = data[11];

			String outputs = data[12];

			String adc = data[13];

			String iButton = data[14];

			String params = data[15];

			// Json for Kafka
			JsonFormatImplementation.jsonCreation(time, data[2], data[4]);

			if (data[2].equals("NA") || data[3].equals("NA") || data[4].equals("NA") || data[5].equals("NA")) {

				return ServerResponse.PACKETCOORDINATESRESPONSE.getValue();

			} else if (data[6].equals("NA") || data[7].equals("NA") || data[8].equals("NA")) {

				return ServerResponse.PACKETHEIGHTSPEEDCOURSERESPONSE.getValue();

			} else if (data[9].equals("NA") || data[10].equals("NA")) {

				return ServerResponse.PACKETSATELLITEHDOPRESPONSE.getValue();

			} else if (data[11].equals("NA") || data[12].equals("NA")) {

				return ServerResponse.PACKETINPUTOUTPUTRESPONSE.getValue();

			} else if (data[13].equals("NA")) {

				return ServerResponse.PACKETADCRESPONSE.getValue();

			} else if (data[15].equals("NA")) {

				return ServerResponse.PACKETPARAMSRESPONSE.getValue();

			} else if (MySQLJDBC.insertData(date, time, lat1, lat2, lon1, lon2, speed, course, height, sats, hdop,
					inputs, outputs, adc, iButton, params)) {

				return ServerResponse.PACKETSUCCESSSRESPONSE.getValue();

			} else {

				return ServerResponse.PACKETSTRUCTUREERRORRESPONSE.getValue();
			}
		} else {

			return ServerResponse.PACKETSTRUCTUREERRORRESPONSE.getValue();
		}
	}

	/**
	 * @param shortDataPacket
	 * @return serverResponse
	 */
	public String insertShortData(String shortDataPacket) {

		String data[] = shortDataPacket.split(";");

		if (shortDataPacket != null && data.length == 10) {

			Timestamp time = null;
			java.sql.Date date = null;

			if (data[0].equals("NA")) {

				try {

					// Converting date from String to Date format
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yy");
					java.util.Date dt = dateFormat.parse(CURRENTDATE);
					date = new java.sql.Date(dt.getTime());

				} catch (ParseException pe) {

					System.out.println("Wrong date format");
				}
			}

			if (data[1].equals("NA")) {

				try {

					// Converting date from String to Time format
					SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
					Date parsedDate = timeFormat.parse(CURRENTTIME);
					time = new java.sql.Timestamp(parsedDate.getTime());

				} catch (ParseException pe) {

					return ServerResponse.SHORTPACKETINCORRECTTIMERESPONSE.getValue();
				}
			} else {

				try {

					// Converting date from String to Time format
					SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
					Date parsedDate = timeFormat.parse(data[1]);
					time = new java.sql.Timestamp(parsedDate.getTime());

				} catch (ParseException pe) {

					return ServerResponse.SHORTPACKETINCORRECTTIMERESPONSE.getValue();
				}
			}

			String lat1 = data[2];
			String lat2 = data[3];

			String lon1 = data[4];
			String lon2 = data[5];

			String speed = data[6];
			String course = data[7];

			String height = data[8];
			String sats = data[9];

			// Json for Kafka
			JsonFormatImplementation.jsonCreation(time, data[2], data[4]);

			if (data[2].equals("NA") || data[3].equals("NA") || data[4].equals("NA") || data[5].equals("NA")) {

				return ServerResponse.SHORTPACKETCOORDINATESRESPONSE.getValue();

			} else if (data[6].equals("NA") || data[7].equals("NA") || data[8].equals("NA")) {

				return ServerResponse.SHORTPACKETHEIGHTSPEEDCOURSERESPONSE.getValue();

			} else if (data[9].equals("NA")) {

				return ServerResponse.SHORTPACKETSATELLITEHDOPRESPONSE.getValue();

			} else if (MySQLJDBC.insertShortData(date, time, lat1, lat2, lon1, lon2, speed, course, height, sats)) {

				return ServerResponse.SHORTPACKETSUCCESSSRESPONSE.getValue();

			} else {

				return ServerResponse.SHORTPACKETSTRUCTUREERRORRESPONSE.getValue();
			}

		} else

		{

			return ServerResponse.SHORTPACKETSTRUCTUREERRORRESPONSE.getValue();
		}
	}

	/**
	 * @param userCredentials
	 * @return JDBC response
	 */
	public String userLoginCheck(String userCredentials) {

		String[] data = userCredentials.split(";");

		// Initializing variables as userName and password
		String userName = null;
		String password = null;

		try {
			// Values passed based on the length of the array
			if (data.length == 2) {

				userName = data[0];
				password = data[1];

			} else if (data.length == 1) {

				userName = data[0];
				password = "NA";

			}
			System.out.println(userName + " " + password);

			// Handling all the three scenarios and returning its response
			if (userName == null && password == null) {

				return ServerResponse.LOGINERRORRESPONSE.getValue();

			} else if (MySQLJDBC.userCheck(userName, password)) {

				return ServerResponse.LOGINSUCCESSRESPONSE.getValue();

			} else {

				return ServerResponse.LOGINFAILURERESPONSE.getValue();

			}

		} catch (Exception exception) {

			return ServerResponse.LOGINFAILURERESPONSE.getValue();
		}
	}
}
