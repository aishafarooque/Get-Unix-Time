package unixtime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UnixTimeTests {
  UnixTime unixTime;
  UnixTimeWebService webService;

  @BeforeEach
  void init() throws IOException {
    webService = mock(UnixTimeWebService.class);

    when(webService.getDataFromURL()).thenReturn(Math.round((new Date()).getTime() / 1000));

    unixTime = new UnixTime(webService);
  }

  @Test
  void canary() { assertTrue(true); }

  @Test
  void getUnixTimeForEmptyString() throws IOException {
    var time = Math.round((new Date()).getTime() / 1000);
    assertEquals("Unix time is " + time, unixTime.getUnixTime());
  }

  @Test
  void getUnixTimeWhenNetworkError() throws IOException {
    when(webService.getDataFromURL())
            .thenThrow(new RuntimeException("Error: Unknown location"));

    var exception = assertThrows(RuntimeException.class,
            () -> unixTime.getUnixTime());

    assertEquals("Error: Unknown location", exception.getMessage());
  }
}
