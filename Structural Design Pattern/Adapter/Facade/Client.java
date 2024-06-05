public class Client {
    public static void Main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        
        try {
            orderFacade.placeOrder("Product123", "PaymentXYZ");
        } catch (OrderException e) {
            System.err.println(e.getMessage());
        }
    }
}
