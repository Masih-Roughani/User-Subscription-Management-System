import lombok.Data;

@Data
public class Customer {
    private static int idGenerator = 1;
    private int id;
    private String fullName;
    private String email;

    public Customer(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
        id = idGenerator++;
    }
}
