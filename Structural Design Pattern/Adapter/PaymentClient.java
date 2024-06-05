public class PaymentClient {
    public static void main(String[] args) {
        try {
            PaymentProcessor payPalProcessor = new PayPalPayment()::payWithPayPal;
            PaymentProcessor stripeProcessor = new StripeAdapter(new StripePayment());

            // Process payments
            processPayment(payPalProcessor, 100.0);
            processPayment(stripeProcessor, 200.0);
        } catch (PaymentException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void processPayment(PaymentProcessor processor, double amount) throws PaymentException {
        processor.processPayment(amount);
    }
}
