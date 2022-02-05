

import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {


    
        Item item1 = new Item();
        item1.name = "mocha";
        item1.price = 1.99;

        Item item2 = new Item();
        item2.name = "latte";
        item2.price = 5.99;

        Item item3 = new Item();
        item3.name = "drip coffee";
        item3.price = 0.99;

        Item item4 = new Item();
        item4.name = "cappucino";
        item4.price = 15.99;
    
        Order order1 = new Order();
        order1.name = "Cindhuri";
        order1.total = 5.99;
        order1.ready = true;

        Order order2 = new Order();
        order2.name = "Jimmy";
        order2.total = 9.99;
        order2.ready = true;
        order2.items = new ArrayList<Item>();
        order2.items.add(item1);
        order2.total += item1.price;

        Order order3 = new Order();
        order3.name = "Noah";
        order3.total = 9.99;
        order3.ready = false;
        order3.items = new ArrayList<Item>();
        order3.items.add(item4);
        order3.total += item4.price;

        Order order4 = new Order();
        order4.name = "Sam";
        order4.total = 9.99;
        order4.ready = false;
        order4.items = new ArrayList<Item>();
        order4.items.add(item2);
        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += item2.price;
        order4.total += item2.price;
        order4.total += item2.price;
    
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

        System.out.printf("Ready: %s\n", order2.items);
        System.out.printf("Ready: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);

        System.out.printf("Ready: %s\n", order3.items);
        System.out.printf("Ready: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);

        System.out.printf("Ready: %s\n", order4.items);
        System.out.printf("Ready: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
    }
}
