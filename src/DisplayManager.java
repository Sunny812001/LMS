
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SWAMBHU MULLICK
 */
public class DisplayManager {
    //Managers
    private BookManager BookMgr;
    private MemberManager MemberMgr;
    private LibrarianAccountManager LibrarianAccountMgr;
    private LoanManager LoanMgr;
    private LoginManager LoginMgr;
    
    //Screens
    private BookManagement BookManagementUI;
    private MemberManagement MemberManagementUI;
    private LibrarianAccountManagement LibrarianAccountManagementUI;
    private IssueBook IssueBookUI;
    private ReturnBook ReturnBookUI;
    private CheckAvailability CheckAvailabilityUI;
    private Fine FineUI;
    private Admin_dashboard Admin_dashboardUI;
    private Librarian_dashboard Librarian_dashboardUI;
    private LoginUI loginUI;
    
    
    public boolean init(){
        boolean resultB=false,resultM=false,resultL=false,resultLo=false,resultLi=false,result=false;
        BookMgr = new BookManager();
        resultB = BookMgr.init("Book.csv");
        MemberMgr = new MemberManager();
        resultM = MemberMgr.init("Member.csv");
        LibrarianAccountMgr = new LibrarianAccountManager();
        resultL = LibrarianAccountMgr.init("Librarian.csv");
        LoanMgr = new LoanManager();
        resultLo = LoanMgr.init("Loan.csv");
        LoginMgr = new LoginManager();
        resultLi = LoginMgr.init("Librarian.csv");
        
        if(resultB==true && resultM==true && resultL==true && resultLo==true && resultLi==true){
            result = true;
        }
        
        return result;
    }
    //creating screens
    public void createScreens(){
        Admin_dashboardUI = new Admin_dashboard(this);
        Librarian_dashboardUI = new Librarian_dashboard(this);
        BookManagementUI = new BookManagement(this);
        MemberManagementUI = new MemberManagement(this);
        LibrarianAccountManagementUI = new LibrarianAccountManagement(this);
        CheckAvailabilityUI = new CheckAvailability(this);
        IssueBookUI = new IssueBook(this);
        ReturnBookUI = new ReturnBook(this);
        FineUI = new Fine(this);
        loginUI = new LoginUI(this);
    }
    //Book Module
    public List<Book> getBooks(){
        return BookMgr.getBooks();
    }
    
    public boolean StoreBook(Book newBook){
        return BookMgr.StoreBook(newBook);
    }
    
    public boolean UpdateBookDetails(Book updateBook){
        return BookMgr.UpdateBookDetails(updateBook);
    }
        
    public boolean RemoveBookFromList(Book RemoveBook){
        return BookMgr.RemoveBookFromList(RemoveBook);
    }

    public void ShowScreen2(){
        BookManagementUI.populateTable(BookMgr.getBooks());
        BookManagementUI.setVisible(true);
        Librarian_dashboardUI.setVisible(false);
        MemberManagementUI.setVisible(false);
        LibrarianAccountManagementUI.setVisible(false);
        CheckAvailabilityUI.setVisible(false);
        IssueBookUI.setVisible(false);
        ReturnBookUI.setVisible(false);
        FineUI.setVisible(false);
        Admin_dashboardUI.setVisible(false);
        loginUI.setVisible(false);
    }
    
    //Admin DashBoard
    
    public void ShowScreen1(){
        Admin_dashboardUI.setVisible(true);
        Librarian_dashboardUI.setVisible(false);
        BookManagementUI.setVisible(false);
        MemberManagementUI.setVisible(false);
        LibrarianAccountManagementUI.setVisible(false);
        CheckAvailabilityUI.setVisible(false);
        IssueBookUI.setVisible(false);
        ReturnBookUI.setVisible(false);
        FineUI.setVisible(false);
        loginUI.setVisible(false);
    }
    
    //Member Module
    
    public List<Member> getMembers(){
        return MemberMgr.getMembers();
    }
    
    public boolean StoreMember(Member newMember){
        return MemberMgr.StoreMember(newMember);
    }
    
    public boolean UpdateMemberDetails(Member updateMember){
        return MemberMgr.UpdateMemberDetails(updateMember);
    }
        
    public boolean RemoveMemberFromList(Member RemoveMember){
        return MemberMgr.RemoveMemberFromList(RemoveMember);
    }
    
    public void ShowScreen3(){
        MemberManagementUI.populateTable(MemberMgr.getMembers());
        MemberManagementUI.setVisible(true);
        Librarian_dashboardUI.setVisible(false);
        BookManagementUI.setVisible(false);
        LibrarianAccountManagementUI.setVisible(false);
        CheckAvailabilityUI.setVisible(false);
        IssueBookUI.setVisible(false);
        ReturnBookUI.setVisible(false);
        FineUI.setVisible(false);
        Admin_dashboardUI.setVisible(false);
        loginUI.setVisible(false);
    }
    
    //Librarian Account Module
    
    public List<Librarian> getLibrarians(){
        return LibrarianAccountMgr.getLibrarians();
    }
    
    public boolean StoreLibrarian(Librarian newLibrarian){
        return LibrarianAccountMgr.StoreLibrarian(newLibrarian);
    }
    
    public boolean UpdateLibrarianDetails(Librarian updateLibrarian){
        return LibrarianAccountMgr.UpdateLibrarianDetails(updateLibrarian);
    }
        
    public boolean RemoveLibrarianFromList(Librarian RemoveLibrarian){
        return LibrarianAccountMgr.RemoveLibrarianFromList(RemoveLibrarian);
    }
    
    public void ShowScreen4(){
        LibrarianAccountManagementUI.populateTable(LibrarianAccountMgr.getLibrarians());
        LibrarianAccountManagementUI.setVisible(true);
        Librarian_dashboardUI.setVisible(false);
        BookManagementUI.setVisible(false);
        MemberManagementUI.setVisible(false);
        CheckAvailabilityUI.setVisible(false);
        IssueBookUI.setVisible(false);
        ReturnBookUI.setVisible(false);
        FineUI.setVisible(false);
        Admin_dashboardUI.setVisible(false);
        loginUI.setVisible(false);
    }
    
    // Check Availabilty Module
    
    public boolean search(Book SearchBook){
        return BookMgr.search(SearchBook);
    }
    
    public void ShowScreen5(){
        CheckAvailabilityUI.setVisible(true);
        Librarian_dashboardUI.setVisible(false);
        BookManagementUI.setVisible(false);
        MemberManagementUI.setVisible(false);
        LibrarianAccountManagementUI.setVisible(false);
        IssueBookUI.setVisible(false);
        ReturnBookUI.setVisible(false);
        FineUI.setVisible(false);
        Admin_dashboardUI.setVisible(false);
        loginUI.setVisible(false);
    }
    
    //Issue Book Module
    
    public List<Loan> getLoans(){
        return LoanMgr.getLoans();
    }
    
    public boolean CheckIn(Book CheckB ,Member CheckM ,Loan NewLoan){
        return LoanMgr.CheckIn(CheckB, CheckM, NewLoan);
    }
    
    public void ShowScreen6(){
        IssueBookUI.setVisible(true);
        Librarian_dashboardUI.setVisible(false);
        BookManagementUI.setVisible(false);
        MemberManagementUI.setVisible(false);
        LibrarianAccountManagementUI.setVisible(false);
        CheckAvailabilityUI.setVisible(false);
        ReturnBookUI.setVisible(false);
        FineUI.setVisible(false);
        Admin_dashboardUI.setVisible(false);
        loginUI.setVisible(false);
    }
    
    //Return Book Module
    
    public boolean CheckOut(Book CheckB ,Member CheckM ,Loan returnLoan){
        return LoanMgr.CheckOut(CheckB, CheckM, returnLoan);
    }
    
    public int CheckFine(Loan LoanFine){
        return LoanMgr.CheckFine(LoanFine);
    }
    
    public void ShowScreen7(){
        ReturnBookUI.setVisible(true);
        Librarian_dashboardUI.setVisible(false);
        BookManagementUI.setVisible(false);
        MemberManagementUI.setVisible(false);
        LibrarianAccountManagementUI.setVisible(false);
        CheckAvailabilityUI.setVisible(false);
        IssueBookUI.setVisible(false);
        FineUI.setVisible(false);
        Admin_dashboardUI.setVisible(false);
        loginUI.setVisible(false);
    }
    
    //Librarian DashBoard
    
    public void ShowScreen8(){
        Librarian_dashboardUI.setVisible(true);
        BookManagementUI.setVisible(false);
        MemberManagementUI.setVisible(false);
        LibrarianAccountManagementUI.setVisible(false);
        CheckAvailabilityUI.setVisible(false);
        IssueBookUI.setVisible(false);
        ReturnBookUI.setVisible(false);
        FineUI.setVisible(false);
        Admin_dashboardUI.setVisible(false);
        loginUI.setVisible(false);
    }
    
    // Fine Module
    
    
    
    public void ShowScreen9(){
        FineUI.setVisible(true);
        Librarian_dashboardUI.setVisible(false);
        BookManagementUI.setVisible(false);
        MemberManagementUI.setVisible(false);
        LibrarianAccountManagementUI.setVisible(false);
        CheckAvailabilityUI.setVisible(false);
        IssueBookUI.setVisible(false);
        ReturnBookUI.setVisible(false);
        Admin_dashboardUI.setVisible(false);
        loginUI.setVisible(false);
    }
    
    //Login Module
    
    public boolean getLoggedIn(){
        return LoginMgr.getLoggedIn();
    }
    
    public boolean CheckCreadentials(Login newLogin){
        return LoginMgr.CheckCreadentials(newLogin);
    }
    
    public void ShowScreen10(){
        loginUI.setVisible(true);
        Librarian_dashboardUI.setVisible(false);
        Admin_dashboardUI.setVisible(false);
    }
    
    public void exitFRS(){
        
        FineUI.setVisible(false);
        Librarian_dashboardUI.setVisible(false);
        BookManagementUI.setVisible(false);
        MemberManagementUI.setVisible(false);
        LibrarianAccountManagementUI.setVisible(false);
        CheckAvailabilityUI.setVisible(false);
        IssueBookUI.setVisible(false);
        ReturnBookUI.setVisible(false);
        Admin_dashboardUI.setVisible(false);
        loginUI.setVisible(false);
        
        boolean result = LoginMgr.doHousekeeping();
        if (result) 
            System.out.println("System shuts down gracefully");
        else 
            System.out.println("System shuts down with error");
    }
    
    public static void main(String[] args) {
        DisplayManager Dmgr = new DisplayManager();
        if(Dmgr.init()){
            Dmgr.createScreens();
            Dmgr.ShowScreen10();
        }else{
            System.out.println("Resource file/files missing");
        } 
    }

}
