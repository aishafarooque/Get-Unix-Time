package unixtime;

import java.io.IOException;

public class DriverClass {
  public static void main(String[] args) throws IOException {
    var webService = new UnixTimeWorldTimeAPIService();
    var unixTime = new UnixTime(webService);

    try {
      System.out.println(unixTime.getUnixTime());
    } catch (IOException e) {
      throw new IOException(e.getMessage());
    }
  }
}
