package com.t42labs.server.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The PostgreSQLJDBC contains all the functionalities that connect the server
 * request to that of the backend database.
 * 
 *
 * @author Varun.N.S (Think42Labs)
 * @version 1.0
 * @since 16-02-2017
 */

public class PostgreSQLJDBC {

	/**
	 * @param imei
	 * @param password
	 * @return boolean
	 */
	// Creating a Logger
	private static Logger logger = Logger.getLogger("PostgresSQLLogger");

	private static String USERNAME = "postgres";
	private static String PASSWORD = "1234";

	public static boolean userCheck(String imei, String password) {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clientdatabase", USERNAME, PASSWORD);
			conn.setAutoCommit(false);

			stmt = conn.prepareStatement("SELECT * FROM usercredentials Where imei = ? and password = ?");

			stmt.setString(1, imei);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				rs.close();
				stmt.close();
				conn.close();
				return true;
			}

			rs.close();
			stmt.close();

		} catch (Exception e) {

			logger.log(Level.WARNING, "User doesnot exit");
			System.exit(0);
		}

		return false;
	}

	/**
	 * @param date
	 * @param time
	 * @param lat1
	 * @param lat2
	 * @param lon1
	 * @param lon2
	 * @param speed
	 * @param course
	 * @param height
	 * @param sats
	 * @param imei
	 * @return boolean
	 */
	public static boolean insertShortData(Date date, Timestamp time, String lat1, String lat2, String lon1, String lon2,
			String speed, String course, String height, String sats) {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clientdatabase", USERNAME, PASSWORD);
			conn.setAutoCommit(false);

			String query = "INSERT INTO sensor_data (date, time, lat1, lat2, lon1, lon2, speed, course, height, sats) "
					+ "VALUES (? ,? ,? ,?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(query);

			stmt.setDate(1, (java.sql.Date) date);
			stmt.setTimestamp(2, time);

			stmt.setString(3, lat1);
			stmt.setString(4, lat2);
			stmt.setString(5, lon1);
			stmt.setString(6, lon2);

			stmt.setString(7, speed);
			stmt.setString(8, course);
			stmt.setString(9, height);
			stmt.setString(10, sats);
			

			stmt.executeUpdate();

			conn.commit();
			conn.close();

		} catch (Exception e) {

			logger.log(Level.WARNING, "Unable to insert into database");
			System.exit(0);

		}

		return true;
	}

	/**
	 * @param date
	 * @param time
	 * @param lat1
	 * @param lat2
	 * @param lon1
	 * @param lon2
	 * @param speed
	 * @param course
	 * @param height
	 * @param sats
	 * @param hdop
	 * @param inputs
	 * @param outputs
	 * @param adc
	 * @param iButton
	 * @param params
	 * @param imei
	 * @return boolean
	 */
	public static boolean insertData(Date date, Timestamp time, String lat1, String lat2, String lon1, String lon2,
			String speed, String course, String height, String sats, String hdop, String inputs, String outputs,
			String adc, String iButton, String params) {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clientdatabase", USERNAME, PASSWORD);
			conn.setAutoCommit(false);

			String query = "INSERT INTO sensor_data (date, time, lat1, lat2, lon1, lon2,speed, course, height,sats, hdop, inputs, outputs, adc, iButton, params) "
					+ "VALUES (? ,? ,? ,?, ?, ?, ?, ?, ?, ?, ? , ?, ? ,? ,? ,?)";
			stmt = conn.prepareStatement(query);

			stmt.setDate(1, (java.sql.Date) date);
			stmt.setTimestamp(2, time);
			stmt.setString(3, lat1);
			stmt.setString(4, lat2);

			stmt.setString(5, lon1);
			stmt.setString(6, lon2);

			stmt.setString(7, speed);
			stmt.setString(8, course);
			stmt.setString(9, height);
			stmt.setString(10, sats);

			stmt.setString(11, hdop);
			stmt.setString(12, inputs);
			stmt.setString(13, outputs);
			stmt.setString(14, adc);
			stmt.setString(15, iButton);
			stmt.setString(16, params);
	

			stmt.executeUpdate();

			conn.commit();
			conn.close();

		} catch (Exception e) {

			logger.log(Level.WARNING, "Unable to insert into database");
			System.exit(0);
		}

		return true;
	}
}
