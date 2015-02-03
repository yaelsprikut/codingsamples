
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
public final class Users extends ArrayList {
    public Users(){
    super();
      User u1 = new User("Alex", "pass");
      User u2 = new User("Yael", "pass");
        this.add(u1);
        this.add(u2);
    }
    
}
