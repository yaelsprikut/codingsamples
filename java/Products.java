
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
public final class Products extends ArrayList {
      public Products(){
      super();
      
      ArrayList<ProductCategory> Prodc = new ProductCategories();
     

      Product u1 = new Product(Prodc.get(0), "DDR3 Ram",  50.0f, 1);
      Product u2 = new Product(Prodc.get(0), "DDR2 Ram",  40.0f, 2);
      Product u3 = new Product(Prodc.get(0), "DDR1 Ram",  30.0f, 3);
        this.add(u1);
        this.add(u2);
        this.add(u3);  
        
         Product l1 = new Product(Prodc.get(1), "i7 CPU",  650.0f, 4);
      Product l2 = new Product(Prodc.get(1), "i5 CPU",  500.0f, 5);
      Product l3 = new Product(Prodc.get(1), "i3 CPU",  250.0f, 6);
        this.add(l1);
        this.add(l2);
        this.add(l3);
        
      Product q1 = new Product(Prodc.get(2), "Nvidia Titan",  700.0f, 7);
      Product q2 = new Product(Prodc.get(2), "Geforce BFG",  504.0f, 8);
      Product q3 = new Product(Prodc.get(2), "Intel Integerated",  5.0f, 9);
        this.add(q1);
        this.add(q2);
        this.add(q3);

    }
    
}
