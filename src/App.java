
import simulation.Client;
import simulation.LoadBalancer;

public class App {
    public static void main(String[] args) throws Exception {
        LoadBalancer mainLoadBalancer = new LoadBalancer();

        Client mainClient = new Client(mainLoadBalancer);
        mainClient.sendRequest("Hello World!");
    }
}
