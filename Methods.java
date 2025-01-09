public class Methods {
    // Static method to calculate interest
    static double calculateInterest(double principal, double rate, int years) {
        return principal * rate * years / 100;
    }

    public static void main(String[] args) {
        // Example usage
        double principal = 10000; // Initial deposit in dollars
        double rate = 3.5;        // Interest rate in percentage
        int years = 5;           // Number of years

        // Call the static method to calculate interest
        double interest = calculateInterest(principal, rate, years);

        // Output the result
        System.out.println("Principal Amount: $" + principal);
        System.out.println("Interest Rate: " + rate + "%");
        System.out.println("Years: " + years);
        System.out.println("Calculated Interest: $" + interest);
    }
}
