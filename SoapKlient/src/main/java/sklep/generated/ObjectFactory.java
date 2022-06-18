
package sklep.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sklep.generated package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
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

    private final static QName _Foto_QNAME = new QName("http://soap.sklep/", "foto");
    private final static QName _FotoResponse_QNAME = new QName("http://soap.sklep/", "fotoResponse");
    private final static QName _OdczytajWedlugCen_QNAME = new QName("http://soap.sklep/", "odczytajWedlugCen");
    private final static QName _OdczytajWedlugCenResponse_QNAME = new QName("http://soap.sklep/", "odczytajWedlugCenResponse");
    private final static QName _OdczytajWedlugId_QNAME = new QName("http://soap.sklep/", "odczytajWedlugId");
    private final static QName _OdczytajWedlugIdResponse_QNAME = new QName("http://soap.sklep/", "odczytajWedlugIdResponse");
    private final static QName _OdczytajWszystkieProdukty_QNAME = new QName("http://soap.sklep/", "odczytajWszystkieProdukty");
    private final static QName _OdczytajWszystkieProduktyResponse_QNAME = new QName("http://soap.sklep/", "odczytajWszystkieProduktyResponse");
    private final static QName _OdczytajWszystkieZamowienia_QNAME = new QName("http://soap.sklep/", "odczytajWszystkieZamowienia");
    private final static QName _OdczytajWszystkieZamowieniaResponse_QNAME = new QName("http://soap.sklep/", "odczytajWszystkieZamowieniaResponse");
    private final static QName _ZapiszProdukt_QNAME = new QName("http://soap.sklep/", "zapiszProdukt");
    private final static QName _ZapiszProduktResponse_QNAME = new QName("http://soap.sklep/", "zapiszProduktResponse");
    private final static QName _RecordNotFound_QNAME = new QName("http://soap.sklep/", "RecordNotFound");
    private final static QName _DBException_QNAME = new QName("http://soap.sklep/", "DBException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sklep.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link Foto }
     * 
     */
    public Foto createFoto() {
        return new Foto();
    }

    /**
     * Create an instance of {@link FotoResponse }
     * 
     */
    public FotoResponse createFotoResponse() {
        return new FotoResponse();
    }

    /**
     * Create an instance of {@link OdczytajWedlugCen }
     * 
     */
    public OdczytajWedlugCen createOdczytajWedlugCen() {
        return new OdczytajWedlugCen();
    }

    /**
     * Create an instance of {@link OdczytajWedlugCenResponse }
     * 
     */
    public OdczytajWedlugCenResponse createOdczytajWedlugCenResponse() {
        return new OdczytajWedlugCenResponse();
    }

    /**
     * Create an instance of {@link OdczytajWedlugId }
     * 
     */
    public OdczytajWedlugId createOdczytajWedlugId() {
        return new OdczytajWedlugId();
    }

    /**
     * Create an instance of {@link OdczytajWedlugIdResponse }
     * 
     */
    public OdczytajWedlugIdResponse createOdczytajWedlugIdResponse() {
        return new OdczytajWedlugIdResponse();
    }

    /**
     * Create an instance of {@link OdczytajWszystkieProdukty }
     * 
     */
    public OdczytajWszystkieProdukty createOdczytajWszystkieProdukty() {
        return new OdczytajWszystkieProdukty();
    }

    /**
     * Create an instance of {@link OdczytajWszystkieProduktyResponse }
     * 
     */
    public OdczytajWszystkieProduktyResponse createOdczytajWszystkieProduktyResponse() {
        return new OdczytajWszystkieProduktyResponse();
    }

    /**
     * Create an instance of {@link OdczytajWszystkieZamowienia }
     * 
     */
    public OdczytajWszystkieZamowienia createOdczytajWszystkieZamowienia() {
        return new OdczytajWszystkieZamowienia();
    }

    /**
     * Create an instance of {@link OdczytajWszystkieZamowieniaResponse }
     * 
     */
    public OdczytajWszystkieZamowieniaResponse createOdczytajWszystkieZamowieniaResponse() {
        return new OdczytajWszystkieZamowieniaResponse();
    }

    /**
     * Create an instance of {@link ZapiszProdukt }
     * 
     */
    public ZapiszProdukt createZapiszProdukt() {
        return new ZapiszProdukt();
    }

    /**
     * Create an instance of {@link ZapiszProduktResponse }
     * 
     */
    public ZapiszProduktResponse createZapiszProduktResponse() {
        return new ZapiszProduktResponse();
    }

    /**
     * Create an instance of {@link RecordNotFound }
     * 
     */
    public RecordNotFound createRecordNotFound() {
        return new RecordNotFound();
    }

    /**
     * Create an instance of {@link DBException }
     * 
     */
    public DBException createDBException() {
        return new DBException();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link OrderProduct }
     * 
     */
    public OrderProduct createOrderProduct() {
        return new OrderProduct();
    }

    /**
     * Create an instance of {@link Order.Products }
     * 
     */
    public Order.Products createOrderProducts() {
        return new Order.Products();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Foto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Foto }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.sklep/", name = "foto")
    public JAXBElement<Foto> createFoto(Foto value) {
        return new JAXBElement<Foto>(_Foto_QNAME, Foto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FotoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FotoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.sklep/", name = "fotoResponse")
    public JAXBElement<FotoResponse> createFotoResponse(FotoResponse value) {
        return new JAXBElement<FotoResponse>(_FotoResponse_QNAME, FotoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OdczytajWedlugCen }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OdczytajWedlugCen }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.sklep/", name = "odczytajWedlugCen")
    public JAXBElement<OdczytajWedlugCen> createOdczytajWedlugCen(OdczytajWedlugCen value) {
        return new JAXBElement<OdczytajWedlugCen>(_OdczytajWedlugCen_QNAME, OdczytajWedlugCen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OdczytajWedlugCenResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OdczytajWedlugCenResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.sklep/", name = "odczytajWedlugCenResponse")
    public JAXBElement<OdczytajWedlugCenResponse> createOdczytajWedlugCenResponse(OdczytajWedlugCenResponse value) {
        return new JAXBElement<OdczytajWedlugCenResponse>(_OdczytajWedlugCenResponse_QNAME, OdczytajWedlugCenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OdczytajWedlugId }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OdczytajWedlugId }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.sklep/", name = "odczytajWedlugId")
    public JAXBElement<OdczytajWedlugId> createOdczytajWedlugId(OdczytajWedlugId value) {
        return new JAXBElement<OdczytajWedlugId>(_OdczytajWedlugId_QNAME, OdczytajWedlugId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OdczytajWedlugIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OdczytajWedlugIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.sklep/", name = "odczytajWedlugIdResponse")
    public JAXBElement<OdczytajWedlugIdResponse> createOdczytajWedlugIdResponse(OdczytajWedlugIdResponse value) {
        return new JAXBElement<OdczytajWedlugIdResponse>(_OdczytajWedlugIdResponse_QNAME, OdczytajWedlugIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OdczytajWszystkieProdukty }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OdczytajWszystkieProdukty }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.sklep/", name = "odczytajWszystkieProdukty")
    public JAXBElement<OdczytajWszystkieProdukty> createOdczytajWszystkieProdukty(OdczytajWszystkieProdukty value) {
        return new JAXBElement<OdczytajWszystkieProdukty>(_OdczytajWszystkieProdukty_QNAME, OdczytajWszystkieProdukty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OdczytajWszystkieProduktyResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OdczytajWszystkieProduktyResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.sklep/", name = "odczytajWszystkieProduktyResponse")
    public JAXBElement<OdczytajWszystkieProduktyResponse> createOdczytajWszystkieProduktyResponse(OdczytajWszystkieProduktyResponse value) {
        return new JAXBElement<OdczytajWszystkieProduktyResponse>(_OdczytajWszystkieProduktyResponse_QNAME, OdczytajWszystkieProduktyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OdczytajWszystkieZamowienia }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OdczytajWszystkieZamowienia }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.sklep/", name = "odczytajWszystkieZamowienia")
    public JAXBElement<OdczytajWszystkieZamowienia> createOdczytajWszystkieZamowienia(OdczytajWszystkieZamowienia value) {
        return new JAXBElement<OdczytajWszystkieZamowienia>(_OdczytajWszystkieZamowienia_QNAME, OdczytajWszystkieZamowienia.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OdczytajWszystkieZamowieniaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OdczytajWszystkieZamowieniaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.sklep/", name = "odczytajWszystkieZamowieniaResponse")
    public JAXBElement<OdczytajWszystkieZamowieniaResponse> createOdczytajWszystkieZamowieniaResponse(OdczytajWszystkieZamowieniaResponse value) {
        return new JAXBElement<OdczytajWszystkieZamowieniaResponse>(_OdczytajWszystkieZamowieniaResponse_QNAME, OdczytajWszystkieZamowieniaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZapiszProdukt }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ZapiszProdukt }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.sklep/", name = "zapiszProdukt")
    public JAXBElement<ZapiszProdukt> createZapiszProdukt(ZapiszProdukt value) {
        return new JAXBElement<ZapiszProdukt>(_ZapiszProdukt_QNAME, ZapiszProdukt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZapiszProduktResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ZapiszProduktResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.sklep/", name = "zapiszProduktResponse")
    public JAXBElement<ZapiszProduktResponse> createZapiszProduktResponse(ZapiszProduktResponse value) {
        return new JAXBElement<ZapiszProduktResponse>(_ZapiszProduktResponse_QNAME, ZapiszProduktResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecordNotFound }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RecordNotFound }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.sklep/", name = "RecordNotFound")
    public JAXBElement<RecordNotFound> createRecordNotFound(RecordNotFound value) {
        return new JAXBElement<RecordNotFound>(_RecordNotFound_QNAME, RecordNotFound.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DBException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DBException }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.sklep/", name = "DBException")
    public JAXBElement<DBException> createDBException(DBException value) {
        return new JAXBElement<DBException>(_DBException_QNAME, DBException.class, null, value);
    }

}
