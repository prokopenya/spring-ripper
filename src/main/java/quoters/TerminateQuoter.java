package quoters;

public class TerminateQuoter implements Quoter {

    private String message;

    @InjectRandomInt(min = 2, max = 7)
    private int repeate;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeate; i++) {
            System.out.println("message = " + message);
        }
    }
}
