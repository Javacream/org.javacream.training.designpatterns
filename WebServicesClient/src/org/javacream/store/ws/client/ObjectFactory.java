
package org.javacream.store.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.javacream.store.ws.client package. 
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

    private final static QName _RetrieveStockResponse_QNAME = new QName("http://services.javacream.org/store", "RetrieveStockResponse");
    private final static QName _RetrieveStock_QNAME = new QName("http://services.javacream.org/store", "RetrieveStock");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.javacream.store.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RetrieveStock }
     * 
     */
    public RetrieveStock createRetrieveStock() {
        return new RetrieveStock();
    }

    /**
     * Create an instance of {@link RetrieveStockResponse }
     * 
     */
    public RetrieveStockResponse createRetrieveStockResponse() {
        return new RetrieveStockResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveStockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.javacream.org/store", name = "RetrieveStockResponse")
    public JAXBElement<RetrieveStockResponse> createRetrieveStockResponse(RetrieveStockResponse value) {
        return new JAXBElement<RetrieveStockResponse>(_RetrieveStockResponse_QNAME, RetrieveStockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveStock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.javacream.org/store", name = "RetrieveStock")
    public JAXBElement<RetrieveStock> createRetrieveStock(RetrieveStock value) {
        return new JAXBElement<RetrieveStock>(_RetrieveStock_QNAME, RetrieveStock.class, null, value);
    }

}
