package Bootcamp.Java.Fundamentals.CafeJava;

public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $ ";
        
        // Menu variables (add yours below)
        // double MochaPrice = 3.5;
        double DripCoffee = 1.9;
        double Latte = 2.9;
        double Cappicino = 3.5;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;
    


        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"

            if (isReadyOrder1) {
                System.out.println(customer1 + readyMessage);
            }else {
                System.out.println(customer1 + pendingMessage);
            }

            if (isReadyOrder4) {
                System.out.println(customer4 + readyMessage + ". " + displayTotalMessage + Cappicino);
            }else {
                System.out.println(customer4 + pendingMessage);
            }

            if (isReadyOrder2) {
                System.out.println(displayTotalMessage + Latte*2 + " and" + readyMessage + ", " + customer2);
            }else {
                System.out.println(displayTotalMessage + Latte*2 + " and" + pendingMessage + ", " + customer2);
            }

            if (isReadyOrder3) {
                System.out.println(displayTotalMessage + (Latte - DripCoffee) + " and" + readyMessage + ", " + customer3);
            }
        


    }
}
