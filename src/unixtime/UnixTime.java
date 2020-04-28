package unixtime;

import java.io.IOException;


public class UnixTime {

  private UnixTimeWebService unixTimeService;

  public UnixTime(UnixTimeWebService aService) { unixTimeService = aService; }

  public String getUnixTime() throws RuntimeException, IOException {
    int result = unixTimeService.getDataFromURL();

    return "Unix time is " + result;
  }
}
