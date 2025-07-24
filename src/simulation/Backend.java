package simulation;

import java.util.Random;

public class Backend {
  private final String ipAddress;
  private boolean healthy = true;

  private final Random randomizer = new Random();

  public Backend() {
    this.ipAddress = generateRandomIp();
  }

  public String getIpAddress() {
    return this.ipAddress;
  }

  public boolean isHealthy(){
    return this.healthy;
  }

  public void setIsHealthy(boolean healthy) {
    this.healthy = healthy;
  }

  public boolean handleRequest(String request) {
    if (randomizer.nextInt(100) < 30) {
      System.out.println(ipAddress + " failed to handle request: " + request);
      return false;
    } else {
      System.out.println(ipAddress + " Handling request: " + request);
      return true;
    }
  }

  private String generateRandomIp() {
    Random rand = new Random();
    return rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256);
  }
}
