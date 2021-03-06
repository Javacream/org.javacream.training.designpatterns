
package org.javacream.store.ws.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "StoreWebServiceService", targetNamespace = "http://services.javacream.org/store", wsdlLocation = "http://localhost:9900/StoreWebService?wsdl")
public class StoreWebServiceService
    extends Service
{

    private final static URL STOREWEBSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException STOREWEBSERVICESERVICE_EXCEPTION;
    private final static QName STOREWEBSERVICESERVICE_QNAME = new QName("http://services.javacream.org/store", "StoreWebServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9900/StoreWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        STOREWEBSERVICESERVICE_WSDL_LOCATION = url;
        STOREWEBSERVICESERVICE_EXCEPTION = e;
    }

    public StoreWebServiceService() {
        super(__getWsdlLocation(), STOREWEBSERVICESERVICE_QNAME);
    }

    public StoreWebServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), STOREWEBSERVICESERVICE_QNAME, features);
    }

    public StoreWebServiceService(URL wsdlLocation) {
        super(wsdlLocation, STOREWEBSERVICESERVICE_QNAME);
    }

    public StoreWebServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, STOREWEBSERVICESERVICE_QNAME, features);
    }

    public StoreWebServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public StoreWebServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns StoreWebService
     */
    @WebEndpoint(name = "StoreWebServicePort")
    public StoreWebService getStoreWebServicePort() {
        return super.getPort(new QName("http://services.javacream.org/store", "StoreWebServicePort"), StoreWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns StoreWebService
     */
    @WebEndpoint(name = "StoreWebServicePort")
    public StoreWebService getStoreWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.javacream.org/store", "StoreWebServicePort"), StoreWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (STOREWEBSERVICESERVICE_EXCEPTION!= null) {
            throw STOREWEBSERVICESERVICE_EXCEPTION;
        }
        return STOREWEBSERVICESERVICE_WSDL_LOCATION;
    }

}
