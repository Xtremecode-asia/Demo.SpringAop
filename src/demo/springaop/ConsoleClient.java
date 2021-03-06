package demo.springaop;

import demo.springaop.service.IDigestService;
import demo.springaop.service.messages.DigestRequest;
import demo.springaop.service.messages.DigestResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Console;

/**
 * Created by Xtremecodes.asia @2012
 * User: saintc0d3r@gmail.com
 * Date: 12/16/12
 * Time: 3:18 PM
 */
public class ConsoleClient {
    public static void main(String[] args){
        ApplicationContext appContext = new ClassPathXmlApplicationContext("config.xml");
        IDigestService digestService = appContext.getBean(IDigestService.class);
        if (digestService != null){
            Console console = System.console();
            String target;
            if (console == null){
                target = "Hello World";
            }
            else{
                target = console.readLine("Enter any plain string:");
            }
            DigestResponse response = digestService.digest(new DigestRequest(target, "SHA-512"));
            System.out.println( String.format("Digested '%s' is '%s'", target,response.getResult()));
        }
        else{
            System.err.println("Digest service is unavailable.");
        }
    }
}
