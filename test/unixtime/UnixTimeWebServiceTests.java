package unixtime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

public class UnixTimeWebServiceTests {
  private UnixTimeWebService unixTimeWebService;
  @BeforeEach
  void init() {
    unixTimeWebService = new UnixTimeWorldTimeAPIService();
  }

  @Test
  void getUnixTime() throws IOException {
    int result = (unixTimeWebService.getDataFromURL());
    var time = Math.round((new Date()).getTime() / 1000);
    assert (result >= time);
  }

  @Test
  void getUnixTimeWhenNetworkError() throws IOException {
    var spy = Mockito.spy(new UnixTimeWorldTimeAPIService());

    doThrow(new java.net.ConnectException("Network error"))
            .when(spy).openConnection();

    var exception = assertThrows(RuntimeException.class,
            () -> spy.getDataFromURL());

    assertEquals("Network error", exception.getMessage());
  }
}
