/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SWAMBHU MULLICK
 */
public class Book {
    private int BookID;
    private String ISBNNo;
    private String BookName;
    private String Author;
    private String Publisher;
    private String Edition;
    private String Status;
    private String RackNo;
    private int NoAvailable;
    
    public Book(int BookID, String ISBNNo, String BookName, String Author, String Publisher, String Edition, String Status, String RackNo, int NoAvailable){
        this.BookID = BookID;
        this.ISBNNo = ISBNNo;
        this.BookName = BookName;
        this.Author = Author;
        this.Publisher = Publisher;
        this.Edition = Edition;
        this.Status = Status;
        this.RackNo = RackNo;
        this.NoAvailable = NoAvailable;
    }
    
    public int getBookID(){
        return BookID;
    }
    
    public String getISBNNo(){
        return ISBNNo;
    }
    
    public String getBookName(){
        return BookName;
    }
    
    public String getAuthor(){
        return Author;
    }
    
    public String getPublisher(){
        return Publisher;
    }
    
    public String getEdition(){
        return Edition;
    }
    
    public String getStatus(){
        return Status;
    }
    
    public String getRackNo(){
        return RackNo;
    }
    
     public int getNoAvailable(){
        return NoAvailable;
    }
    @Override
    public String toString(){
        return this.getBookID()+","+this.getISBNNo()+","+this.getBookName()+","+this.getAuthor()+","+this.getPublisher()+","+this.getEdition()+","+this.getStatus()+","+this.getStatus()+","+this.NoAvailable;
    }
}
