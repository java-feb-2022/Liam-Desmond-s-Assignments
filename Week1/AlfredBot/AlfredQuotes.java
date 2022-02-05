package Bootcamp.Java.Fundamentals.AlfredBot;
import java.util.Date;

public class AlfredQuotes {
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }
    public String guestGreeting(String name, String dayPeriod) {
        String greeting = String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);
        return greeting;
    }
    public String dateAnnouncement() {
        Date date = new Date();
        return "Today's date is " + date + "!";
    }
    public String respondBeforeAlexis(String conversation) {
        int a = conversation.indexOf("Alexis");
        int b = conversation.indexOf("Alfred");
        if (a != -1) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else if (b != -1) {
            return "At your service. As you wish, naturally.";
        }
        else {
            return "Right. And with that I shall retire.";
        }
    }
}
