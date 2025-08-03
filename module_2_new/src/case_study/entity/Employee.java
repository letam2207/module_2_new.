package case_study.entity;

public class Employee {
    private String id;
    private String name;
    private String phoneNumber;
    private String position;
    private String employeeType;

    public Employee() {
    }

    public Employee(String id, String name, String phoneNumber, String position, String shift) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.employeeType = shift;
    }

    public Employee(String part, String part1, String part2) {
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
    public String getInfoToFIle() {
        return this.id + "," + this.name + "," + this.phoneNumber + "," + this.position + "," + this.employeeType;
    }

    @Override
    public String toString() {
        return String.format("| %-20s | %-20s | %-20s | %-20s | %-20s |",
                id, name, phoneNumber, position, employeeType);
    }

    public static String getTableHeader() {
        return String.format("| %-20s | %-20s | %-20s | %-20s | %-20s |",
                "Mã NV", "Họ và tên", "SĐT", "Chức vụ", "Loại NV");
    }

    public static String getTableDivider() {
        return "+----------------------+----------------------+----------------------+----------------------+----------------------+";
    }

}
