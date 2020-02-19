package prokopenya.spring.example.second;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import prokopenya.spring.example.Quoter;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getBean(Quoter.class).sayQuote();
        //todo
    }
}
