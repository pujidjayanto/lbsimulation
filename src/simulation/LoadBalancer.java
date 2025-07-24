package simulation;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {
  private final List<Backend> servers = new ArrayList<>();
  private int currentServerIndex = 0;

  public void registerBackend(Backend server) {
    this.servers.add(server);
  }
  public void handleRequest(String request){
    if (servers.isEmpty()) {
      System.out.println("No backend servers registered yet");
    }

    int attempts = 0;
    int maxAttempts = servers.size();
    while (attempts < maxAttempts) {
      Backend server = servers.get(currentServerIndex);
      currentServerIndex = (currentServerIndex + 1) % servers.size();
      if (server.isHealthy()) {
        boolean response = server.handleRequest(request);
        if (response) {
          return;
        }
      }
      attempts = attempts + 1;
    }
    System.out.println("All servers failed to handle: " + request);
  }
}
