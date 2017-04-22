package test;

import javax.jws.WebService;

/**
 * Created by vlad on 22.04.2017.
 */
@WebService(endpointInterface = "test.Endpoint")
public class Implementation implements Endpoint{

  public String getHelloWorldAsString() {
    return "Hello World JAX-WS ";
  }

}
