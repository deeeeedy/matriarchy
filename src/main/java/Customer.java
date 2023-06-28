public class Customer {

    private String phoneNumber;
    private String lastName;
    private String firstName;
    private String vehicleType;
    public Customer (String firstName, String lastName, String phoneNumber, String vehicleType){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.vehicleType = vehicleType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
