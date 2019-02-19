
package org.javacream.isbngenerator.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.javacream.isbngenerator.ws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GenerateNextIsbnResponse_QNAME = new QName("http://services.javacream.org/store", "GenerateNextIsbnResponse");
    private final static QName _GenerateNextIsbn_QNAME = new QName("http://services.javacream.org/store", "GenerateNextIsbn");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.javacream.isbngenerator.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GenerateNextIsbn }
     * 
     */
    public GenerateNextIsbn createGenerateNextIsbn() {
        return new GenerateNextIsbn();
    }

    /**
     * Create an instance of {@link GenerateNextIsbnResponse }
     * 
     */
    public GenerateNextIsbnResponse createGenerateNextIsbnResponse() {
        return new GenerateNextIsbnResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateNextIsbnResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.javacream.org/store", name = "GenerateNextIsbnResponse")
    public JAXBElement<GenerateNextIsbnResponse> createGenerateNextIsbnResponse(GenerateNextIsbnResponse value) {
        return new JAXBElement<GenerateNextIsbnResponse>(_GenerateNextIsbnResponse_QNAME, GenerateNextIsbnResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateNextIsbn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.javacream.org/store", name = "GenerateNextIsbn")
    public JAXBElement<GenerateNextIsbn> createGenerateNextIsbn(GenerateNextIsbn value) {
        return new JAXBElement<GenerateNextIsbn>(_GenerateNextIsbn_QNAME, GenerateNextIsbn.class, null, value);
    }

}
