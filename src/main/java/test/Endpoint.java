package test;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by vlad on 22.04.2017.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Endpoint{

  @WebMethod
  String getHelloWorldAsString();

}
