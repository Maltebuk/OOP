
package grocerysystem;


public class ExpiredProdctAddedException extends Exception {
    
    public ExpiredProdctAddedException (){
    super("Attempted to add expired product to database");
    }
       
}
