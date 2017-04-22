package yandex;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 22.04.2017.
 */
@WebService(endpointInterface = "yandex.SpellServiceSoap")
public class Endpoint implements SpellServiceSoap {
  public CheckTextResponse checkText(@WebParam(name = "CheckTextRequest", targetNamespace = "http://speller.yandex.net/services/spellservice", partName = "parameters") CheckTextRequest parameters) {
    CheckTextResponse textResponse = null;
    try {
      JAXBContext jc = JAXBContext.newInstance(CheckTextResponse.class);
      Unmarshaller u = jc.createUnmarshaller();
      StringBuffer xmlStr = new StringBuffer( "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
              "<CheckTextResponse xmlns=\"http://speller.yandex.net/services/spellservice\">\n" +
              "    <SpellResult>\n" +
              "        <error code=\"1\" pos=\"0\" row=\"0\" col=\"0\" len=\"7\">\n" +
              "            <word>murr</word>\n" +
              "            <s>Яндекс</s>\n" +
              "        </error>\n" +
              "    </SpellResult>" +
              "</CheckTextResponse>" );
      Object o = u.unmarshal( new StreamSource( new StringReader( xmlStr.toString() ) ) );
      if(o instanceof CheckTextResponse)
        textResponse = (CheckTextResponse) o;
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return textResponse;
  }

  public CheckTextsResponse checkTexts(@WebParam(name = "CheckTextsRequest", targetNamespace = "http://speller.yandex.net/services/spellservice", partName = "parameters") CheckTextsRequest parameters) {
    return new CheckTextsResponse();
  }
}
