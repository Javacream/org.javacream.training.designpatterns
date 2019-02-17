package org.javacream.isbngenerator.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.util.net.HostUtil;

@WebService(targetNamespace = "http://services.javacream.org/isbngenerator")
public class FetchingIsbnGeneratorWebService {

	private RandomIsbnGenerator randomIsbnGenerator;

	{
		randomIsbnGenerator = new RandomIsbnGenerator();
		randomIsbnGenerator.setPrefix("WS-ISBN:");
		randomIsbnGenerator.setCountryCode("-de");
	}

	@WebMethod(operationName="GenerateNextIsbn")
	public @WebResult(name = "GeneratedIsbns") List<String> next(int fetchSize) {
		System.out.println("Generating isbns...");
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < fetchSize; i++){
			result.add(randomIsbnGenerator.next());
		}
		return result;
	}

	public static void main(String[] args) {
		String host = HostUtil.getHost();
		System.out.println(host);
		Endpoint.publish("http://" + host + ":9902/FetchingIsbnGeneratorWebService", new FetchingIsbnGeneratorWebService());
	}

}