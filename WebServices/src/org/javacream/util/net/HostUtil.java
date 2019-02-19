package org.javacream.util.net;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public abstract class HostUtil {

	public static String getHost() {
		try {
			return Inet4Address.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}

	}
	
	

}
