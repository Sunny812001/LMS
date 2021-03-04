/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SUNNY PRIYADARSHI
 */
public class Loan {
    private String IssueDate;
    private String ReturnDate;
    private int FineAmount;
    private String BookDamaged;
    
    
    public Loan(String IssueDate, String ReturnDate, int FineAmount, String BookDamaged){
        this.IssueDate = IssueDate;
        this.ReturnDate = ReturnDate;
        this.FineAmount = FineAmount;
        this.BookDamaged = BookDamaged;
        
    }
    
    public String getIssueDate(){
        return IssueDate;
    }
    
    public String getReturnDate(){
        return ReturnDate;
    }
    
    public int getFineAmount(){
        return FineAmount;
    }
    
    public String BookDamaged(){
        return BookDamaged;
    }
    
    
    @Override
    public String toString(){
        return this.getIssueDate()+","+this.getReturnDate()+","+this.getFineAmount()+","+this.BookDamaged();
    }
}
