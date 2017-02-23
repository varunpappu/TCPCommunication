package com.t42labs.server.serverresponse;

/**
 * The ServerResponse enum contains all the ServerResponses
 *
 * @author Varun.N.S (Think42Labs)
 * @version 1.0
 * @since 16-02-2017
 */

public enum ServerResponse {
	
	LOGINSUCCESSRESPONSE("#AL#1\r\n"), LOGINFAILURERESPONSE("#AL#0\r\n"), LOGINERRORRESPONSE("#AL#01\r\n"),
	PINGSERVERRESPONSE("#AP#\r\n"), SHORTPACKETSUCCESSSRESPONSE("#ASD#1\r\n"), SHORTPACKETSTRUCTUREERRORRESPONSE("#ASD#-1\r\n"), 
	SHORTPACKETINCORRECTTIMERESPONSE("#ASD#0\r\n"), SHORTPACKETCOORDINATESRESPONSE("#ASD#10\r\n"), 
	SHORTPACKETHEIGHTSPEEDCOURSERESPONSE("#ASD#11\r\n"), SHORTPACKETSATELLITEHDOPRESPONSE("#ASD#12\r\n"),
	PACKETSUCCESSSRESPONSE("#AD#1\r\n"), PACKETSTRUCTUREERRORRESPONSE("#AD#-1\r\n"), PACKETINCORRECTTIMERESPONSE("#AD#0\r\n"), 
	PACKETCOORDINATESRESPONSE("#AD#10\r\n"), PACKETHEIGHTSPEEDCOURSERESPONSE("#AD#11\r\n"), 
	PACKETSATELLITEHDOPRESPONSE("#AD#12\r\n"), PACKETINPUTOUTPUTRESPONSE("#AD#13\r\n"), 
	PACKETADCRESPONSE("#AD#14\r\n"), PACKETPARAMSRESPONSE("#AD#15\r\n");

	private String response;

	ServerResponse(String response) {
		this.response = response;
	}

	public String getValue() {
		return response;
	}

	@Override
	public String toString() {
		return this.getValue();
	}

}