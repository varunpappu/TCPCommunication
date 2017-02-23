# TCPCommunication #

## Overview: ##

### TCPSever ###

The following are the packages present in the TCPServer.

* package com.t42labs.server.database

The following package contains the Postgres database configuration under the file name (PostgreSQLJDBC.java) and its connectivity accordingly. The connectivity to the postgres database can be changed accordingly.

* package com.t42labs.server.serverfunctionalities

The following package contains the ServerFunctionalities interface and its implementation (ServerFunctionalities.java and ServerFunctionalitiesImpl.java)

* package com.t42labs.server.serverresponse

The following package contains the ServerResponse.java for the all responses that the Client side will recieve after receiveing a packet.

* package com.t42labs.server.tcpserver

The following package contains the TCPMultiServer.java file which is the executable file for the TCPMultiServer. The PORT number can be changed in the TCPServer file and initially its been fixed to 2022. 


### TCPClient ###

The following are the packages present in the TCPClient.

* package com.t42labs.client.clientfunctionalities

The following package contains the ClientFunctionalities interface and its implementation (ClientFunctionalities.java and ClientFunctionalitiesImpl.java). The PORT number and the IPAddress can be changed accordingly in the ClientFunctionalitiesImpl.java file accordingly).

* package com.t42labs.client.dummydata

The following package contains the DummyData.java file which contains all the dummy data to be tested against the TCPServer.

* package com.t42labs.client.tcpclient

The following package contains the TCPClient.java file which contains all the core functionalites that the client performs for communicaiton with the TCPServer.

* package com.t42labs.client.clienttestcases

The following package all the Testcases that are performed against the TCPServer and for different conditions.

## Software Requirements: ##

Database: Postgres  
Build Tools: Maven  
Language: Java 7/8  
Platform: Mac Os

## Running the Application: ##

1) Download the TCPCommunication.zip and extract the same.  
2) Install Postgres and open the terminal and do the following:  
3) Start postgres using the following command:

* sudo -u postgres psql;

* create database clientdatabase;

* \c clientdatabase;

* create table usercredentials(imei char(50) PRIMARY KEY NOT NULL,  password char(25) NOT NULL);

* // Inserting dummy data for UserName credentials:  
 INSERT into usercredentials(imei, password) VALUES ('862950025913222', 'NA');

* CREATE TABLE sensor_data(date Date,time Time,
	lat1 char(50),
	lat2 char(50),
	lon1 char(50),
	lon2 char(50),
	speed char(50),
	course char(50),
	height char(50),
	sats char(50),
	hdop char(50),
	inputs char(50),
	outputs char(50),
	adc char(50),
	ibutton char(50),
	params char(50));

3) When using IDE, import the TCPClient and TCPServer into the workspace.

4) When using Terminal use the following commands:

	Go to the TCPServer folder and run the following command:
		mvn clean install
		mvn compile
		mvn exec:java -Dexec.mainClass="com.t42labs.server.tcpserver.TCPMultiServer" -Dexec.classpathScope=runtime 
	Go to the TCPClient folder and run the following command:
		mvn clean install
		mvn compile
		mvn exec:java -Dexec.mainClass="com.t42labs.client.tcpclient.TCPClient" -Dexec.classpathScope=runtime 


4) If everything has been setup correctly you should be able to see data being passed from client to server and data being 
   inserted into the database.


## Test Cases ##

Test cases can be tested the same way as above by running the Server first followed by the Client.
