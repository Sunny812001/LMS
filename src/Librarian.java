/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SWETSUBHRA SARKAR
 */
public class Librarian {
    private String LibrarianID;
    private String Name;
    private long PhoneNo;
    private String Address;
    private String Username;
    private String Password;
    
    public Librarian(String LibrarianID,String Name,long PhoneNo,String Address,String Username,String Password){
        this.LibrarianID = LibrarianID ;
        this.Name = Name;
        this.PhoneNo = PhoneNo;
        this.Address = Address ;
        this.Username = Username;
        this. Password = Password;  
    }
     public String getName(){
        return Name;
    }
     public String getLibrarianID(){
        return LibrarianID;
    }
    
    public long getPhoneNo(){
        return PhoneNo;
    }
    
    public String getAddress(){
        return Address;
    }
    
    public String getUsername(){
        return Username;
    }
    
    public String getPassword(){
        return Password;
    }
    
    @Override
    public String toString(){
        return this.getLibrarianID ()+","+this.getName()+","+this.getPhoneNo()+","+this.getAddress()+","+this.getUsername()+","+this.Password;
    }
}