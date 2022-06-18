
package sklep.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.4.5
 * 2022-05-21T15:13:11.544+02:00
 * Generated source version: 3.4.5
 */

@WebFault(name = "DBException", targetNamespace = "http://soap.sklep/")
public class DBException_Exception extends Exception {

    private sklep.generated.DBException faultInfo;

    public DBException_Exception() {
        super();
    }

    public DBException_Exception(String message) {
        super(message);
    }

    public DBException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public DBException_Exception(String message, sklep.generated.DBException dbException) {
        super(message);
        this.faultInfo = dbException;
    }

    public DBException_Exception(String message, sklep.generated.DBException dbException, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = dbException;
    }

    public sklep.generated.DBException getFaultInfo() {
        return this.faultInfo;
    }
}
