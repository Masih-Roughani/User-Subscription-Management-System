import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class SubscriptionManager {
    private static final SubscriptionManager instance = new SubscriptionManager();
    private final List<Customer> customers = new ArrayList<>();
    private final List<Service> services = new ArrayList<>();
    private final List<Subscription> subscriptions = new ArrayList<>();

    private SubscriptionManager() {
    }

    private void addCustomer(String fullName, String email) {
        customers.add(new Customer(fullName, email));
    }

    private void addService(String name, String description) {
        services.add(new Service(name, description));
    }

    private void subscribe(Customer customer, Service service) {
        subscriptions.add(new Subscription(customer, service));
    }

    private void cancelSubscription(int subscriptionId) {
        subscriptions.remove(subscriptionId);
    }
}
