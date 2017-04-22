package yandex;

import javax.xml.ws.Endpoint;

/**
 * Created by vlad on 22.04.2017.
 */
public class Publisher {
  public static void main(String[] args) {
    Endpoint.publish("http://localhost:9999/yandex", new yandex.Endpoint());
  }
}
