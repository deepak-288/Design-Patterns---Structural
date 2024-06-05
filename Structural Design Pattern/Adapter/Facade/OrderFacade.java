public class OrderFacade {
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final ShippingService shippingService;

    public OrderFacade() {
        this.inventoryService = new InventoryService();
        this.paymentService = new PaymentService();
        this.shippingService = new ShippingService();
    }

    public void placeOrder(String productId, String paymentDetails) throws OrderException {
        try {
            if (inventoryService.checkInventory(productId)) {
                if (paymentService.processPayment(paymentDetails)) {
                    shippingService.shipProduct(productId);
                    System.out.println("Order placed successfully for product: " + productId);
                } else {
                    throw new OrderException("Payment processing failed for details: " + paymentDetails);
                }
            } else {
                throw new OrderException("Product is out of stock: " + productId);
            }
        } catch (OrderException e) {
            throw new OrderException("Failed to place order for product: " + productId, e);
        }
    }
}
