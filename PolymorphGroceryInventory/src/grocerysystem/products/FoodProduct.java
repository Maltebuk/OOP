package grocerysystem.products;

import grocerysystem.ExpiredProdctAddedException;
import java.util.Date;
import java.util.Objects;

public class FoodProduct extends Product {

    private Date expireDate;
    private int storeTemp;

    public FoodProduct(String name, double price, Date expireDate, int storeTemp) throws ExpiredProdctAddedException {
        super(name, price);
        this.expireDate = expireDate;
        this.storeTemp = storeTemp;

        if (expireDate.before(new Date())) {
            throw new ExpiredProdctAddedException();
        }

    }

    public int getStoreTemp() {
        return storeTemp;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    @Override
    public String toString() {
        return this.getName() + " Udløber:" + expireDate;
    }

    @Override
    public boolean equals(Object o) {
        FoodProduct p;
        if (o instanceof FoodProduct) {
            p = (FoodProduct) o;
            if (this.getSerial().equals(p.getSerial()) && this.expireDate.equals(p.expireDate)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    //The return statement implies that if our current date is higher than the exipration date the statement will return true otherwise false. 
    @Override
    public boolean isExpired() {
        Date currentDate = new Date();
        return currentDate.getTime() > this.expireDate.getTime();
    }

}
