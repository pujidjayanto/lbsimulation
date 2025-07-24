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

    Backend selectedServer = servers.get(currentServerIndex);
    currentServerIndex = (currentServerIndex + 1) % servers.size();
    selectedServer.handleRequest(request);
  }
}
