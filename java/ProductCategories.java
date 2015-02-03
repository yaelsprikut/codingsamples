
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Not-A
 */
public final class ProductCategories extends ArrayList {
    public ProductCategories(){
    super();
      ProductCategory u1 = new ProductCategory("RAM");
      ProductCategory u2 = new ProductCategory("CPU");
      ProductCategory u3 = new ProductCategory("GPU");
        this.add(u1);
        this.add(u2);
        this.add(u3);
    }
    
      
}
