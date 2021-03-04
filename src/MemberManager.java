
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SWAMBHU MULLICK
 */
public class MemberManager {
    private List<Member> MemberList;
    private String FileName;
    
//    public static void main(String args[]){
//        MemberManager Mmgr = new MemberManager();
//        Mmgr.init("Member.csv");
//        Mmgr.ReadData();
//        //JFrame MemberManagementUI = new MemberManagement(Mmgr);
//        //MemberManagementUI.setVisible(true);
//        Mmgr.StoreMember(new Member(12335,"sam",1234567890,"fdfdgd","Faculty","CSe","1st"));
//        //assert(Mmgr.getMembers().size()==1):"more than 1 data found";
//        //assert(Mmgr.getMembers().get(0).getMemberID()==12335);
//    }
    
    public boolean init(String Filename){
        boolean result = false;
        this.FileName=Filename;
        ReadData();
        return result;
    }
    
    public MemberManager(){
        this.MemberList = new ArrayList<Member>();
    }
    
    public List<Member> getMembers() {
        List<Member> result = null;
        result = Collections.unmodifiableList(this.MemberList);
        return result;
    }
    
    public boolean StoreMember(Member newMember){
        boolean result = true;
        this.MemberList.add(newMember);
        save();
        return result;
    }
    
    public boolean UpdateMemberDetails(Member updateMember){
        boolean result = false;
        for(int i=0;i<MemberList.size();i++){
            Member myMember = MemberList.get(i);
            if(updateMember.getMemberID()==myMember.getMemberID()){
                this.MemberList.set(i, updateMember);
                result = true;
                break;
            }
        }
        save();
        return result;
    }
    
    public boolean RemoveMemberFromList(Member RemoveMember){
        boolean result = false;
        for(int i=0;i<MemberList.size();i++){
            Member myMember = MemberList.get(i);
            if(RemoveMember.getMemberID()==myMember.getMemberID()){
                this.MemberList.remove(i);
                result = true;
                break;
            }
        }
        save();
        return result;
    }
    
    public void save(){
        try{
            FileWriter writer = new FileWriter(FileName);
            for(Member i : MemberList){
                writer.write(i+"\n");
            }
            writer.close();
        }catch(IOException e){
            System.out.println("Unable to perform IO operations.");
        }
    }

    public void ReadData(){
        try {
            FileReader reader = new FileReader(FileName);
            BufferedReader bufReader = new BufferedReader(reader);
            String line = bufReader.readLine();
            while(line != null){
                MemberList.add(readLine(line));
                line = bufReader.readLine();
            }
            bufReader.close();
        }catch(FileNotFoundException e){
            System.out.println("Unable to find requested file.");
        }catch (IOException ex) {
           System.out.println("Unable to perform IO operations.");
        }
    }
    
    Member readLine(String line){
        String[] data = line.split("\\,");
        return new Member(Long.parseLong(data[0]), data[1], Long.parseLong(data[2]), data[3], data[4], data[5], data[6]);
    }
}
