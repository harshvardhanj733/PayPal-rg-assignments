import java.util.Scanner;
class Laptop{
    private String brand;
    private String model;
    private int ram;
    private int storage;
    private double price;
    private String processor;
    private boolean hasGraphicsCard;

    public Laptop(String brand, String model, int ram, int storage, double price, String processor, boolean hasGraphicsCard) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.price = price;
        this.processor = processor;
        this.hasGraphicsCard = hasGraphicsCard;
    }

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getRam() {
        return ram;
    }
    public int getStorage() {
        return storage;
    }
    public double getPrice() {
        return price;
    }
    public String getProcessor() {
        return processor;
    }
    public boolean hasGraphicsCard() {
        return hasGraphicsCard;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter laptop brand: ");
        String brand = scanner.nextLine();
        
        System.out.print("Enter laptop model: ");
        String model = scanner.nextLine();
        
        System.out.print("Enter RAM (in GB): ");
        int ram = scanner.nextInt();
        
        System.out.print("Enter storage (in GB): ");
        int storage = scanner.nextInt();
        
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        
        scanner.nextLine();
        System.out.print("Enter processor type: ");
        String processor = scanner.nextLine();
        
        System.out.print("Does it have a graphics card? (true/false): ");
        boolean hasGraphicsCard = scanner.nextBoolean();
        
        Laptop laptop = new Laptop(brand, model, ram, storage, price, processor, hasGraphicsCard);
        
        System.out.println("\nLaptop Details:");
        System.out.println("Brand: " + laptop.getBrand());
        System.out.println("Model: " + laptop.getModel());
        System.out.println("RAM: " + laptop.getRam() + " GB");
        System.out.println("Storage: " + laptop.getStorage() + " GB");
        System.out.println("Price: ₹" + laptop.getPrice());
        System.out.println("Processor: " + laptop.getProcessor());
        System.out.println("Has Graphics Card: " + (laptop.hasGraphicsCard() ? "Yes" : "No"));
    }
}
