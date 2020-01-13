package quoters;

import javax.annotation.PostConstruct;

@Profiling
public class TerminateQuoter implements Quoter {

    private String message;

    @InjectRandomInt(min = 2, max = 7)
    private int repeate;

    @PostConstruct
    public void init(){
        System.out.println("phase 2");
        System.out.println(repeate);
    }

    public TerminateQuoter(){
        System.out.println("phase 1");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("phase 3");
        for (int i = 0; i < repeate; i++) {
            System.out.println("message = " + message);
        }
    }
}
