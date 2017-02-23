package com.t42labs.server.serverfunctionalities;

import java.sql.Timestamp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * The JsonFormatImplementation implements the conversion of client 
 * message to JSON format
 *
 * @author Varun.N.S (Think42Labs)
 * @version 1.0
 * @since 23-02-2017
 */
public class JsonFormatImplementation {

	private static String GEO = "geo";

	private static String SPEED = "speed";

	private static String FUEL = "fuel";


	public static void jsonCreation(Timestamp time, String lat1, String lat2) {

		geo(time, lat1, lat2);

		speed(time, lat1, lat2);

		fuel(time, lat1, lat2);

	}
	
	/**
	 * @param Time
	 * @param Lat1
	 * @param Lat2
	 * @return Json String
	 */
	public static void geo(Timestamp time, String lat1, String lat2) {

		JSONObject object = new JSONObject();
		JSONArray point = new JSONArray();
		JSONObject payload = new JSONObject();

		try {

			point.put(lat1);
			point.put(lat2);

			payload.put("point", point);

			object.put("sensorType", GEO);
			object.put("timestamp", time);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		object.put("payload", payload);

		System.out.println(object);

	}
	
	/**
	 * @param Time
	 * @param Lat1
	 * @param Lat2
	 * @return Json String
	 */
	public static void fuel(Timestamp time, String lat1, String lat2) {

		JSONObject object = new JSONObject();
		JSONArray point = new JSONArray();
		JSONObject payload = new JSONObject();

		try {

			point.put(lat1);
			point.put(lat2);

			payload.put("point", point);

			object.put("sensorType", FUEL);
			object.put("timestamp", time);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		object.put("payload", payload);
		System.out.println(object);

	}

	/**
	 * @param Time
	 * @param Lat1
	 * @param Lat2
	 * @return Json String
	 */
	public static void speed(Timestamp time, String lat1, String lat2) {

		JSONObject object = new JSONObject();
		JSONArray point = new JSONArray();
		JSONObject payload = new JSONObject();

		try {

			point.put(lat1);
			point.put(lat2);

			payload.put("point", point);

			object.put("sensorType", SPEED);
			object.put("timestamp", time);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		object.put("payload", payload);
		System.out.println(object);

	}

}
