import lombok.Data;

import java.time.LocalDate;

@Data
public class Subscription {
    private static int idGenerator = 1;
    private final int id;
    private final Customer customer;
    private final Service service;
    private final LocalDate startDate;
    private boolean isActive;

    public Subscription(Customer customer, Service service) {
        this.id = idGenerator++;
        this.customer = customer;
        this.service = service;
        this.startDate = LocalDate.now();
        this.isActive = true;
    }
}
