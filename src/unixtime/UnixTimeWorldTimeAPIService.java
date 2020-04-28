package unixtime;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class UnixTimeWorldTimeAPIService implements UnixTimeWebService {

  @Override
  public int getDataFromURL() {
    BufferedReader bufferedReader;
    try {
      bufferedReader = new BufferedReader(new InputStreamReader(openConnection()));
      String unixTime = bufferedReader.lines().filter(lines -> lines.startsWith("unixtime: ")).findFirst().get();

      return Integer.parseInt(unixTime.split(": ")[1].trim());
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public InputStream openConnection() throws IOException {
    URL url = new URL(String.format("http://worldtimeapi.org/api/ip.txt"));
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");

    return connection.getInputStream();
  }
}
