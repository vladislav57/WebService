package test;

import javax.xml.ws.Endpoint;
/**
 * Created by vlad on 22.04.2017.
 */
public class Publisher{

  public static void main(String[] args) {
    Endpoint.publish("http://192.168.1.70:9999/ws/hello", new Implementation());
  }

}
