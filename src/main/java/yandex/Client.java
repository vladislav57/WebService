package yandex;

import test.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Created by vlad on 22.04.2017.
 */
public class Client {
  public static void main(String[] args) {
    SpellService service = new SpellService();
    SpellServiceSoap soap = service.getSpellServiceSoap();
    CheckTextRequest request = new CheckTextRequest();
    request.setText("йандекс");
    CheckTextResponse textResponse = null;

    textResponse = soap.checkText(request);

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
