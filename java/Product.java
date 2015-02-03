/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Not-A
 */
public class Product {
    
    public ProductCategory category;
    public String name;
    public float price;
    public int id;
    
    
    public Product(ProductCategory cat, String name, float price, int id){
        this.category = cat;
        this.name = name;
        this.price = price;
        this.id = id;

    }
    
    
}
