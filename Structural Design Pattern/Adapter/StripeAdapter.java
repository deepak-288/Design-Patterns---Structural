
public class StripeAdapter implements PaymentProcessor {
    private final StripePayment stripePayment;

    public StripeAdapter(StripePayment stripePayment) {
        this.stripePayment = stripePayment;
    }

    @Override
    public void processPayment(double amount) throws PaymentException {
        try {
            stripePayment.payWithStripe(amount);
        } catch (Exception e) {
            throw new PaymentException("Stripe payment processing failed", e);
        }
    }
}
