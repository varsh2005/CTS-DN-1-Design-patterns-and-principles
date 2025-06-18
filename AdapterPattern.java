public class AdapterPattern{
  interface PaymentProcessor {
      void processPayment(double amount);
  }
  static class PhonePeGateway {
      public void payWithPhonePe(double amount) {
          System.out.println("Paid Rs." + amount + " using PhonePe.");
      }
  }
  static class GooglePayGateway {
      public void payWithGPay(double amount) {
          System.out.println("Paid Rs." + amount + " using Google Pay.");
      }
  }
  static class PhonePeAdapter implements PaymentProcessor {
      private PhonePeGateway phonePe;
      public PhonePeAdapter(PhonePeGateway phonePe) {
          this.phonePe = phonePe;
      }
      public void processPayment(double amount) {
          phonePe.payWithPhonePe(amount); 
      }
  }
  static class GooglePayAdapter implements PaymentProcessor {
      private GooglePayGateway gPay;
      public GooglePayAdapter(GooglePayGateway gPay) {
          this.gPay = gPay;
      }
      public void processPayment(double amount) {
          gPay.payWithGPay(amount); 
      }
  }

  public static void main(String[] args) {
      PaymentProcessor phonePe = new PhonePeAdapter(new PhonePeGateway());
      phonePe.processPayment(1000.0);
      PaymentProcessor gPay = new GooglePayAdapter(new GooglePayGateway());
      gPay.processPayment(1500.0);
  }
}
