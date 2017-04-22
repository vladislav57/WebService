package yandex;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Service;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Root;

/**
 * Created by vlad on 22.04.2017.
 */
public class Client2 {
  public static void main(String[] args) {
    URL url = null;
    try {
      url = new URL("http://localhost:9999/yandex?wsdl");
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    QName qname = new QName("http://yandex/", "EndpointService");
    Service service = Service.create(url, qname);
    SpellServiceSoap request = service.getPort(SpellServiceSoap.class);
    CheckTextRequest requestText = new CheckTextRequest();
    requestText.setText("йандекс");

    CheckTextResponse textResponse = null;

    textResponse = request.checkText(requestText);

    try {
      JAXBContext jc = JAXBContext.newInstance(CheckTextResponse.class);
      Marshaller marshaller = null;
      marshaller = jc.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(textResponse, System.out);
    } catch (JAXBException e) {
      e.printStackTrace();
    }

  }
}
