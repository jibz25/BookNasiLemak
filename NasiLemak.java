import java.util.HashMap;

public class NasiLemak {
    private String sideTopping;
    private String riceSize;
    private int spiceLevel;
    private double price;

    // Static data for side toppings and rice sizes with prices
    private static final HashMap<String, Double> SIDE_TOPPINGS_PRICES = new HashMap<>();
    private static final HashMap<String, Double> RICE_SIZES_PRICES = new HashMap<>();

    static {
        // Initialize side toppings with prices
        SIDE_TOPPINGS_PRICES.put("Paru (Fried Beef Lung)", 10.0);
        SIDE_TOPPINGS_PRICES.put("Sotong Sambal (Spicy Squid)", 3.0);
        SIDE_TOPPINGS_PRICES.put("Telur Mata (Sunny-Side-Up Egg)", 1.0);
        SIDE_TOPPINGS_PRICES.put("Ayam Goreng (Fried Chicken)", 5.0);
        SIDE_TOPPINGS_PRICES.put("Sambal Udang (Spicy Prawns)", 7.0);

        // Initialize rice sizes with prices
        RICE_SIZES_PRICES.put("Regular", 3.0);
        RICE_SIZES_PRICES.put("Large", 5.0);
    }

    public NasiLemak(String sideTopping, String riceSize, int spiceLevel) {
        this.sideTopping = sideTopping;
        this.riceSize = riceSize;
        this.spiceLevel = spiceLevel;
        this.price = calculatePrice();
    }

    public String getSideTopping() {
        return sideTopping;
    }

    public String getRiceSize() {
        return riceSize;
    }

    public int getSpiceLevel() {
        return spiceLevel;
    }

    public double getPrice() {
        return price;
    }

    private double calculatePrice() {
        double sideToppingPrice = SIDE_TOPPINGS_PRICES.getOrDefault(sideTopping, 0.0);
        double riceSizePrice = RICE_SIZES_PRICES.getOrDefault(riceSize, 0.0);
        return sideToppingPrice + riceSizePrice;
    }

    // Static methods to get side toppings and rice sizes
    public static String[] getSideToppings() {
        return SIDE_TOPPINGS_PRICES.keySet().toArray(new String[0]);
    }

    public static String[] getRiceSizes() {
        return RICE_SIZES_PRICES.keySet().toArray(new String[0]);
    }

    // Method to get price for a specific side topping
    public static double getSideToppingPrice(String sideTopping) {
        return SIDE_TOPPINGS_PRICES.getOrDefault(sideTopping, 0.0);
    }

    // Method to get price for a specific rice size
    public static double getRiceSizePrice(String riceSize) {
        return RICE_SIZES_PRICES.getOrDefault(riceSize, 0.0);
    }
}












