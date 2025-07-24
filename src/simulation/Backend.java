package simulation;

import java.util.Random;

public class Backend {
  private final String ipAddress;

  public Backend() {
    this.ipAddress = generateRandomIp();
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public void handleRequest(String request) {
    System.out.println(ipAddress + " Handling request: " + request);
  }

  private String generateRandomIp() {
    Random rand = new Random();
    return rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256);
  }
}
