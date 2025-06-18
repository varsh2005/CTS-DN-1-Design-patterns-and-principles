interface Notifier{
    void send(String message);
}
class EmailNotifier implements Notifier{
    public void send(String message){
        System.out.println("Sending Email: " + message);
    }
}
abstract class NotifierDecorator implements Notifier{
    protected Notifier Notifier;
    public NotifierDecorator(Notifier notifier){
        this.Notifier = notifier;
    }
    public void send(String message){
        Notifier.send(message); 
    }
}
class SMSNotifierDecorator extends NotifierDecorator{
    public SMSNotifierDecorator(Notifier notifier){
        super(notifier);
    }
    public void send(String message){
        super.send(message); 
        System.out.println("Sending SMS: " + message); 
    }
}
class SlackNotifierDecorator extends NotifierDecorator{
    public SlackNotifierDecorator(Notifier notifier){
        super(notifier);
    }

    public void send(String message){
        super.send(message); 
        System.out.println("Sending Slack message: " + message);
    }
}
public class DecoratorPattern{
    public static void main(String[] args){
        Notifier notifier = new EmailNotifier();
        notifier = new SMSNotifierDecorator(notifier);
        notifier = new SlackNotifierDecorator(notifier);
        notifier.send("Your order has been shipped!");
    }
}
