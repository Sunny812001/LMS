/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SUNNY PRIYADARSHI
 */
public class Login {
    private String UserID;
    private String Password;
    private boolean Admin;
    private boolean Librarian;
    
    public Login(String UserID,String Password,boolean Admin,boolean Librarian){
        this.UserID=UserID;
        this.Password=Password;
        this.Admin=Admin;
        this.Librarian=Librarian;
    }
    
    public String getUserId(){
        return UserID;
    }
    
    public String getPassword(){
        return Password;
    }
    
    public boolean AdminSelected(){
        return Admin;
    }
    
    public boolean LibrarianSelected(){
        return Librarian;
    }
    
}
