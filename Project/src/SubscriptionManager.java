import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    private List<Subscription> getActiveSubscriptions() {
        return subscriptions.stream().filter(Subscription::isActive).collect(Collectors.toList());
    }

    public List<Service> getActiveServicesForCustomer(Customer customer) {
        Map<Customer, List<Subscription>> map = subscriptions.stream().filter(Subscription::isActive)
                .collect(Collectors.groupingBy(Subscription::getCustomer));

        return map.getOrDefault(customer, List.of()).stream()
                .map(Subscription::getService).collect(Collectors.toList());
    }
}
