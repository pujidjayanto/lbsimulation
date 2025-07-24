package simulation;

import java.util.Random;

public class Client {
  private final String ipAddress;
  private final LoadBalancer loadBalancer;

  public Client(LoadBalancer loadBalancer) {
    this.ipAddress = generateRandomIp();
    this.loadBalancer = loadBalancer;
  }

  public String getIpAddress(){
    return this.ipAddress;
  }

  public void sendRequest(String request) {
    System.out.println("Client " + ipAddress + " sending: " + request);
    this.loadBalancer.handleRequest(request);
  }

  private String generateRandomIp() {
    Random rand = new Random();
    return rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256);
  }
}
