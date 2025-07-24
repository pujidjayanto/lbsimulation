
import simulation.Backend;
import simulation.Client;
import simulation.LoadBalancer;

public class App {
	public static void main(String[] args) throws Exception {
		LoadBalancer mainLoadBalancer = new LoadBalancer();
		mainLoadBalancer.registerBackend(new Backend());
		mainLoadBalancer.registerBackend(new Backend());
		mainLoadBalancer.registerBackend(new Backend());
		mainLoadBalancer.registerBackend(new Backend());

		for (int i = 0; i < 10; i++) {
			Client client = new Client(mainLoadBalancer);
			client.sendRequest("Request from client " + i);
		}
	}
}
