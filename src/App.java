
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

		Client mainClient = new Client(mainLoadBalancer);
		mainClient.sendRequest("Login");
		mainClient.sendRequest("Update Profile");
		mainClient.sendRequest("Buy Shoes");
		mainClient.sendRequest("Buy Bag");
		mainClient.sendRequest("Buy Phone");
	}
}
