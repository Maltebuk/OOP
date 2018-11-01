package grocerysystem;

import java.text.DecimalFormat;
import java.util.UUID;
import grocerysystem.products.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductDatabase {

    private final Map<UUID, Product> Inventory = new HashMap<>();

    /*public ProductDatabase() {
        this.products = new ArrayList();
    }
*/

    public void addProduct(Product p) {

        this.Inventory.put(UUID.randomUUID(), p); 
        //products.add(p);
    }

    public boolean removeProduct(UUID serial) {
        for (final Map.Entry<UUID,Product> entrySet : this.Inventory.entrySet()) {
            if (entrySet.getValue().getSerial() == serial) {
                return this.Inventory.remove(entrySet.getKey()) != null; 
            }
        }
        return false; 
    }

   /*  public void removeProduct(Product p) {
        products.remove(p);
    }
    */
   
    public String printInventory() {
        //Use StringBuild to create a combined string from multiple strings.
        StringBuilder sb = new StringBuilder();
        //Append adds String to the end of the combined string.
        sb.append("Inventory:\n");

        products.forEach((p) -> {
            sb.append("Name: ").append(p.getName()).append("\t")
                    .append("Price: ").append(p.getPrice()).append("\t")
                    .append("Serial: ").append(p.getSerial()).append("\n");
        });
        //Call toString on the StringBuilder object, to get the String representation.
        return sb.toString();
    }

    public String getTotalPrice() {
        double result = 0;
        //Loop through all products. Accumulate prices.
        for (Product p : products) {
            result += p.getPrice();
        }
        //Use DecimalFormat class to get a currency representation of the double in local currency.
        return DecimalFormat.getCurrencyInstance().format(result);
    }

    public ArrayList<Product> getProducts() {
        //Return a copy of the array, so that the database is not exposed to external actors.
        return new ArrayList(products);
    }

    public void removeExpiredFoods() {
        ArrayList<Product> foundProducts = new ArrayList<>();
        for (Product p : products) {
            try {

                if (p.isExpired() == true) {
                     foundProducts.add(p);

                    //removeProduct(p.getSerial());
                }
            } catch (UnsupportedOperationException exception) {
            }
        }
        for(Product product: foundProducts){
            this.products.remove(product); 
            System.out.println("\nRemoved product " + product);
        }

    }
    }
