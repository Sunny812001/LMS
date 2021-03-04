/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SWAMBHU MULLICK
 */
public class Member {
    
    private long MemberID;
    private String MemberName;
    private long PhoneNumber;
    private String Address;
    private String Catagory;
    private String Department;
    private String Year;
    
    public Member(long MemberID, String MemberName, long PhoneNumber, String Address, String Catagory, String Department, String Year){
        this.MemberID=MemberID;
        this.MemberName=MemberName;
        this.PhoneNumber=PhoneNumber;
        this.Address=Address;
        this.Catagory=Catagory;
        this.Department=Department;
        this.Year=Year;
    }
    
    public long getMemberID(){
        return MemberID;
    }
    public String getMemberName(){
        return MemberName;
    }
    public long getPhoneNumber(){
        return PhoneNumber;
    }
    public String getAddress(){
        return Address;
    }
    public String getCatagory(){
        return Catagory;
    }
    public String getDepartment(){
        return Department;
    }
    public String getYear(){
        return Year;
    }
    @Override
    public String toString(){
        return this.getMemberID()+","+this.getMemberName()+","+this.getPhoneNumber()+","+this.getAddress()+","+this.getCatagory()+","+this.getDepartment()+","+this.getYear();
    }
}
