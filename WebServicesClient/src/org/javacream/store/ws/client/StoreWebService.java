
package org.javacream.store.ws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "StoreWebService", targetNamespace = "http://services.javacream.org/store")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StoreWebService {


    /**
     * 
     * @param itemId
     * @param category
     * @return
     *     returns int
     */
    @WebMethod(operationName = "RetrieveStock")
    @WebResult(name = "Stock", targetNamespace = "")
    @RequestWrapper(localName = "RetrieveStock", targetNamespace = "http://services.javacream.org/store", className = "org.javacream.store.ws.client.RetrieveStock")
    @ResponseWrapper(localName = "RetrieveStockResponse", targetNamespace = "http://services.javacream.org/store", className = "org.javacream.store.ws.client.RetrieveStockResponse")
    @Action(input = "http://services.javacream.org/store/StoreWebService/RetrieveStockRequest", output = "http://services.javacream.org/store/StoreWebService/RetrieveStockResponse")
    public int retrieveStock(
        @WebParam(name = "Category", targetNamespace = "")
        String category,
        @WebParam(name = "ItemId", targetNamespace = "")
        String itemId);

}