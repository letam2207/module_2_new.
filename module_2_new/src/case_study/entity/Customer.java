package case_study.entity;

public class Customer {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String customerType;

    public Customer() {
    }

    public Customer( String id, String name,String phoneNumber, String email, String customerType) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
    }

    public Customer(String part, String part1, String part2, String part3) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getInfoToFIle() {
        return this.id + "," + this.name + "," + this.phoneNumber + "," + this.email + "," + this.customerType;
    }

    @Override
    public String toString() {

        return String.format("| %-20s | %-20s | %-20s | %-20s | %-20s |",
                id, name, phoneNumber, email, customerType);

    }

    public static String getTableHeader() {
        return String.format("| %-20s | %-20s | %-20s | %-20s | %-20s |",
                "Mã KH", "Họ và tên", "SĐT", "Email", "Loại KH");
    }

    public static String getTableDivider() {
        return "+----------------------+----------------------+----------------------+----------------------+----------------------+";
    }

}