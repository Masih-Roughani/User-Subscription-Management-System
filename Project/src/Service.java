import lombok.Data;

@Data
class Service {
    private static int idGenerator = 1;
    private final int id;
    private String name;
    private String description;

    public Service(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = idGenerator++;
    }
}