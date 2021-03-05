/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SUMMY PRIYADARSHI & SWETSUBHRA SARKAR
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoanManager {
    
    private List<Book> IssueBookDetails;
    private List<Member> IssueMemberDetails;
    private List<Book> BookList;
    private List<Member> MemberList;
    private final List<Loan> LoanList;
    private DisplayManager Dmgr;
    private String FileName;
    
//    public static void main(String args[]){
//        LoanManager LM = new LoanManager();
//        LM.init("Loan.csv");
//        LM.readBookData();
//        LM.readMemberData();
//        LM.ReadData();
//        JFrame IssueBookUI = new IssueBook(LM);
//        IssueBookUI.setVisible(true);
////        JFrame ReturnBookUI = new ReturnBook(LM);
////        ReturnBookUI.setVisible(true);
////        JFrame FineUI = new Fine(LM);
////        FineUI.setVisible(true);
//        //LM.CheckIn(new Book(11,"","sss","","","","","",0),new Member(12335,"sam",0,"","","",""),new Loan("12/01/2001","",0,"damaged")); 
////        LM.CheckOut(new Book(11,"","sss","","","","","",0),new Member(12335,"sam",0,"","","",""),new Loan("12/01/2001","20/01/2001",0,"damaged")); 
//    }
    
    public boolean init(String Filename){
        boolean result = false;
        this.FileName=Filename;
        if(readBookData() && readMemberData() && ReadData()){
            result=true;
            readBookData();
            readMemberData();
            ReadData();
        }
        return result;
    }
    
    public LoanManager(){
        this.LoanList = new ArrayList<>();
        this.IssueBookDetails = new ArrayList<>();
        this.IssueMemberDetails = new ArrayList<>();
        this.BookList = new ArrayList<>();
        this.MemberList = new ArrayList<>();
    }
    
    public List<Loan> getLoans() {
        List<Loan> result = null;
        result = Collections.unmodifiableList(this.LoanList);
        return result;
    }
 
    public boolean CheckIn(Book CheckB ,Member CheckM ,Loan NewLoan){
              
        boolean result = false;
        for(int i=0;i<BookList.size();i++){
            Book myBook = BookList.get(i);
            if(CheckB.getBookID()==myBook.getBookID() && CheckB.getBookName().equals(myBook.getBookName())){
                IssueBookDetails.add(myBook);
                result = true;
                break;
            }
        }
        
        for(int i=0;i<MemberList.size();i++){
            Member myMember = MemberList.get(i);
            if(CheckM.getMemberID()==myMember.getMemberID() && CheckM.getMemberName().equals(myMember.getMemberName() )){
                IssueMemberDetails.add(myMember);
                result = true;
                break;
                
            }else{
                result =false;
            }
        }
        
        if(result==true){
            this.LoanList.add(NewLoan);
        }
        save();
        return result;
    }
  
    public boolean CheckOut(Book CheckB ,Member CheckM ,Loan returnLoan){
              
        boolean result = false;
        
        for(int i=0;i<BookList.size();i++){
            Book myBook = BookList.get(i);
            if(CheckB.getBookID()==myBook.getBookID() && CheckB.getBookName().equals(myBook.getBookName())){
                IssueBookDetails.add(myBook);
                result = true;
                break;
            }
        }
        
        for(int i=0;i<MemberList.size();i++){
            Member myMember = MemberList.get(i);
            if(CheckM.getMemberID()==myMember.getMemberID() && CheckM.getMemberName().equals(myMember.getMemberName() )){
                IssueMemberDetails.add(myMember);
                result = true;
                break;
                
            }else{
                result =false;
            }
        }
        int Dur,fine=0;
        for(int i=0;i<LoanList.size();i++){
            Loan myLoan=LoanList.get(i);
            if(returnLoan.getIssueDate().equals(myLoan.getIssueDate())){
                fine = CheckFine(returnLoan);
                LoanList.set(i,(new Loan(returnLoan.getIssueDate(),returnLoan.getReturnDate(),fine,returnLoan.BookDamaged())));
                result=true;
                break;
            }
        }
        
        save();
        return result;
    }
    
    public void save(){
        int j=0;
        try{
            FileWriter writer = new FileWriter(FileName);
            
            for(Loan i : LoanList){
                Book myBook = IssueBookDetails.get(j);
                Member myMember = IssueMemberDetails.get(j);
                writer.write(myBook+","+myMember+","+i+"\n");
                j++;
            }
            writer.close();
        }catch(IOException e){
            System.out.println("Unable to perform IO operations.");
        }
    }

    public boolean ReadData(){
        boolean result=true;
        try {
            FileReader reader = new FileReader(FileName);
            BufferedReader bufReader = new BufferedReader(reader);
            String line = bufReader.readLine();
            while(line != null){
                IssueBookDetails.add(readLine3(line));
                IssueMemberDetails.add(readLine4(line));
                LoanList.add(readLine5(line));
                line = bufReader.readLine();
            }
            result=true;
            bufReader.close();
        }catch(FileNotFoundException e){
            System.out.println("Unable to find requested file.");
        }catch (IOException ex) {
           System.out.println("Unable to perform IO operations.");
        }
        return result;
    }
    
    Book readLine3(String line){
        String[] data = line.split("\\,");
        return new Book(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6], data[7], Integer.parseInt(data[8]));
    }
    
    Member readLine4(String line){
        String[] data = line.split("\\,");
        return new Member(Long.parseLong(data[9]), data[10], Long.parseLong(data[11]), data[12], data[13], data[14], data[15]);
    }
    
    Loan readLine5(String line){
        String[] data = line.split("\\,");
        return new Loan(data[16],data[17], Integer.parseInt(data[18]), data[19]);

    }
    
    public boolean readBookData(){
        boolean result=true;
       try {
            FileReader read=new FileReader("Book.csv");
            BufferedReader bufRead = new BufferedReader(read);
            String line = bufRead.readLine();
            while(line != null){
                BookList.add(readLine1(line));
                line = bufRead.readLine();
            }
            result=true;
            bufRead.close();
        } catch (IOException ex) {
           System.out.println("Unable to perform IO operations.");
        } 
       return result;
    }
    
    Book readLine1(String line){
        String[] data = line.split("\\,");
        return new Book(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6], data[7], Integer.parseInt(data[8]));
    }
    
    public boolean readMemberData(){
        boolean result=true;
        try {
            FileReader reader=new FileReader("Member.csv");
            BufferedReader bufReader = new BufferedReader(reader);
            String line = bufReader.readLine();
            while(line != null){
                MemberList.add(readLine2(line));
                line = bufReader.readLine();
            }
            result=true;
            bufReader.close();
        } catch (IOException ex) {
           System.out.println("Unable to perform IO operations.");
        }
        return result;
    }
    
    Member readLine2(String line){
        String[] data = line.split("\\,");
        return new Member(Long.parseLong(data[0]), data[1], Long.parseLong(data[2]), data[3], data[4], data[5], data[6]);
    }
    
    public int CheckFine(Loan LoanFine){
        int result=0,fine=0;
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
         try {
	       Date dateBefore = myFormat.parse(LoanFine.getIssueDate());
	       Date dateAfter = myFormat.parse(LoanFine.getReturnDate());
	       long difference = dateAfter.getTime() - dateBefore.getTime();
	       int daysBetween = (int)(difference / (1000*60*60*24));
               if(daysBetween>5){
                   fine = daysBetween*50;
               }
               if(LoanFine.BookDamaged().equals("damage"))
                   fine += 100;
               result=fine;
	 } catch (Exception e) {
	       e.printStackTrace();
	 }
        return result;
    }
    
}