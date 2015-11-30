package de.brockhaus.opcua.prosys;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

import org.junit.Test;
import org.opcfoundation.ua.common.ServiceResultException;

import com.prosysopc.ua.SecureIdentityException;
import com.prosysopc.ua.ServiceException;
import com.prosysopc.ua.SessionActivationException;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.client.ConnectException;
import com.prosysopc.ua.client.InvalidServerEndpointException;

import de.brockhaus.opcua.prosys.Midgard;

/**
 * 
 * @author jperez@brockhaus-gruppe.de, Nov 16, 2015
 * Copyright by: Brockhaus Group (Wiesbaden, Heidelberg, Bhubaneswar/India)
 *
 */

public class MidgardReaderTest 
{
	public static void main(String[] args) throws InvalidServerEndpointException, 
		UnknownHostException, ConnectException, SessionActivationException, 
		URISyntaxException, SecureIdentityException, IOException, ServiceException, 
		StatusException, ServiceResultException, InterruptedException{
		
		MidgardReaderTest mrt = new MidgardReaderTest();
		mrt.test();
	}
	
	// use appropriate annotation to the junit test
	@Test
	public void test() throws UnknownHostException, URISyntaxException, 
		SecureIdentityException, IOException, InvalidServerEndpointException, 
		ConnectException, SessionActivationException, ServiceException, StatusException, 
		ServiceResultException, InterruptedException{
		
		Midgard mr = new Midgard();
		/* create all the connection initial configuration needed to connect 
	    to the server */
		mr.init();
		// establish the connection to the server
		mr.connect();
		// read every second (1000 ms) the selected signal value
		mr.doRead();
		// Allow to disconnect from the server.
		mr.disconnect();
	}
}