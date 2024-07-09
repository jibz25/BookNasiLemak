public class Order {
    private int quantityOrder;
    private double totalPrice;
    private Customer customer;
    private NasiLemak nasiLemak;

    public Order(int quantityOrder, Customer customer, NasiLemak nasiLemak) {
        this.quantityOrder = quantityOrder;
        this.customer = customer;
        this.nasiLemak = nasiLemak;
        calculateTotalPrice(); // Initial calculation of total price based on initial state
    }

    public int getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(int quantityOrder) {
        this.quantityOrder = quantityOrder;
        calculateTotalPrice(); // Recalculate total price when quantity changes
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public NasiLemak getNasiLemak() {
        return nasiLemak;
    }

    public void setNasiLemak(NasiLemak nasiLemak) {
        this.nasiLemak = nasiLemak;
        calculateTotalPrice(); // Recalculate total price when NasiLemak details change
    }

    private void calculateTotalPrice() {
        this.totalPrice = this.quantityOrder * this.nasiLemak.getPrice();
    }

    public void showOrderDetails() {
        System.out.println("Customer: " + customer.getCustName() + " - " + customer.getCustPhoneNumber());
        System.out.println("Nasi Lemak Details:");
        System.out.println("  Side Topping: " + nasiLemak.getSideTopping() + " - RM " + NasiLemak.getSideToppingPrice(nasiLemak.getSideTopping()));
        System.out.println("  Rice Size: " + nasiLemak.getRiceSize() + " - RM " + NasiLemak.getRiceSizePrice(nasiLemak.getRiceSize()));
        System.out.println("  Spice Level: " + nasiLemak.getSpiceLevel());
        System.out.println("Quantity: " + quantityOrder);
        System.out.println("Total Price: RM " + totalPrice);
        System.out.println("-----------------------");
    }
}













