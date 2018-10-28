package grocerysystem.products;

import grocerysystem.Expireable;
import java.util.UUID;

public abstract class Product implements Expireable
{
    private UUID serial;
    private String name;
    private double price;
    
    public Product(String name, double price)
    {
        this.serial = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public UUID getSerial()
    {
        return serial;
    }
}
