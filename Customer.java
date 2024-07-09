// Customer.java
public class Customer {
    private String custName;
    private String custPhoneNumber;

    public Customer(String custName, String custPhoneNumber) {
        this.custName = custName;
        this.custPhoneNumber = custPhoneNumber;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhoneNumber() {
        return custPhoneNumber;
    }

    public void setCustPhoneNumber(String custPhoneNumber) {
        this.custPhoneNumber = custPhoneNumber;
    }
}


