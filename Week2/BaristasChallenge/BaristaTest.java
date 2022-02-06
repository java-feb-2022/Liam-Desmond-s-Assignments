




class BaristaTest {

    public static void main(String[] args) {
        Order order = new Order();
        
        Order order1 = new Order();
        Order order2 = new Order();
        
        Order order3 = new Order("Cindhuri");
        Order order4 = new Order("Noah");
        Order order5 = new Order("Sam");
        
        Item item1 = new Item("Salad", 1.99);
        Item item2 = new Item("Bread", 1.99);
        order1.addItem(item1);
        order1.addItem(item2);
        
        Item item3 = new Item("Coffee", 1.99);
        Item item4 = new Item("Soda", 1.99);
        order2.addItem(item3);
        order2.addItem(item4);
        
        // Item item5 = new Item("Chicken", 1.99);
        // Item item6 = new Item("Pizza", 1.99);
        // order3.addItem(item5);
        // order3.addItem(item6);
        
        Item item7 = new Item("Burger", 1.99);
        Item item8 = new Item("Hot Pocket", 1.99);
        // order4.addItem(item7);
        // order4.addItem(item8);
        
        Item item9 = new Item("Twizzlers", 1.99);
        Item item10 = new Item("Cereal", 1.99);
        // order5.addItem(item9);
        // order5.addItem(item10);


        order1.display();
        order2.display();


        String a = order1.getStatusMessage();
        System.out.println(a);

        String b = order2.getStatusMessage();
        System.out.println(b);

        System.out.println(order1.getOrderTotal());



        


        

        // String[] customers = {
        //     "Cindhuri", "Noah", "Sam", "Jimmy", 
        //     "Ian Curtis", "Ada", "Brandon Stantman", 
        //     "Zoe", "Jesse"};

    }
    
}
