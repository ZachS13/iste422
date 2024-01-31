package extra;
public class personInformation {
    private String name;
    private String email;
    private String city;
    private String mac;
    private String timestamp;
    private String creditcard;

    /**
     * A person can contain all of the following items.
     * @param name - Required
     * @param email
     * @param city
     * @param mac
     * @param timestamp
     * @param creditcard - Required for csv
     */
    public personInformation(String name, String email, String city, String mac, String timestamp, String creditcard) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.mac = mac;
        this.timestamp = timestamp;
        this.creditcard = creditcard;
    }

    public String getName() { return this.name; }
    public String getEmail()  {return this.email; }
    public String getCity() { return this.city; }
    public String getMac() { return this.mac; }
    public String getTimestamp() { return this.timestamp; }
    public String getCreditcard() { return this.creditcard; }
}
