import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class SubscriptionManager {
    private static final SubscriptionManager instance = new SubscriptionManager();
    private final List<Customer> customers = new ArrayList<Customer>();
    private final List<Service> services = new ArrayList<>();
    private final List<Subscription> subscriptions = new ArrayList<>();

    private SubscriptionManager() {
    }
}
