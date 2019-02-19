package org.javacream.isbngenerator.ws;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.util.net.HostUtil;

@WebService(targetNamespace = "http://services.javacream.org/store")
public class IsbnGeneratorWebService {

	private RandomIsbnGenerator randomIsbnGenerator;

	{
		randomIsbnGenerator = new RandomIsbnGenerator();
		randomIsbnGenerator.setPrefix("WS-ISBN:");
		randomIsbnGenerator.setCountryCode("-de");
	}
	@WebMethod(operationName="GenerateNextIsbn")
	public @WebResult(name = "GeneratedIsbn") String next() {
		return  randomIsbnGenerator.next();
	}

	public static void main(String[] args) {
		Endpoint.publish("http://" + HostUtil.getHost() + ":9901/IsbnGeneratorWebService", new IsbnGeneratorWebService());
	}

}
