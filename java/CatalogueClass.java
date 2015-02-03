/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yael
 */
public class CatalogueClass {
    private String itemID;
    private String itemTitle;
    private String description;
    private double cost;
    
    public CatalogueClass(String itemID, String itemTitle, String description, double cost){
        setItemID(itemID);
        setItemTitle(itemTitle);
        setDescription(description);
        setCost(cost);
    
}
    public String getItemID(){
        return(itemID);
    }
    
    protected void setItemID(String itemID) {
    this.itemID = itemID;
    }
    
    public String getItemTitle(){
        return(itemTitle);
    }
    
    protected void setItemTitle(String itemTitle){
        this.itemTitle = itemTitle;
    }
    
    public String getDescription(){
        return(description);
    }
    
    protected void setDescription(String description){
        this.description = description;
    }
    
    public double getCost(){
        return(cost);
    }
    
    protected void setCost(double cost){
        this.cost = cost;
    }
}
