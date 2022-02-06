import java.util.ArrayList;
public class Order {
    private String name;

    private double total;

    private boolean ready;

    ArrayList<Item> items;
    
    public Order(String newName) {
        this.name = newName;
    }

    public Order() {
        this.name="Guest";
        this.items = new ArrayList<Item>();
    }


    public void addItem(Item newItem) {
        this.items.add(newItem);
    }

    public String getStatusMessage() {
        if(this.ready) {
            return "Your order is ready.";
        }
        return "Thank you for waiting. Your order will be ready soon.";
    }



    public double getOrderTotal() {
        double total = 0.0;
        for(Item i: this.items) {
            total += i.getPrice();
        }
        return total;
    }

    public void display() {
        System.out.printf("Customer Name: " + this.name);
        for(Item x: this.items) {
            System.out.println(x.getName() + " - $" + x.getPrice());
        }
        System.out.println("Total: $" + this.getOrderTotal());
    }


    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
