
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SUNNY PRIYADARSHI
 */
public class LoginManager {
       
    private List<Librarian> LibrarianList;
    private String FileName;
    private boolean AdminLoged = false;
    
    public boolean init(String Filename){
        boolean result = false;
        this.FileName=Filename;
        if(ReadData()){
            result=true;
            ReadData();
        }
        return result;
    }
    
    public LoginManager(){
        this.LibrarianList = new ArrayList<>();
    }
    
    public boolean CheckCreadentials(Login newLogin){
        boolean result = false;
        if(newLogin.AdminSelected()==true && newLogin.getUserId().equals("Admin") && newLogin.getPassword().equals("123")){
            result=true;
            AdminLoged=true;
        } 
        else if(newLogin.LibrarianSelected()==true){
            for(int i=0;i<LibrarianList.size();i++){
                Librarian myLibrarian = LibrarianList.get(i);
                if(newLogin.getUserId().equals(myLibrarian.getUsername()) && newLogin.getPassword().equals(myLibrarian.getPassword()))
                    result=true;
                    AdminLoged=false;
            }
        }
        return result;
    }
    
    public boolean getLoggedIn(){
        return AdminLoged;
    }
    
      public boolean ReadData(){
          boolean result = false;
        try {
            FileReader reader = new FileReader(FileName);
            BufferedReader bufReader = new BufferedReader(reader);
            String line = bufReader.readLine();
            while(line != null){
                LibrarianList.add(readLine(line));
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
    
    Librarian readLine(String line){
        String[] data = line.split("\\,");
        return new Librarian(data[0], data[1], Long.parseLong(data[2]), data[3], data[4], data[5]);
    }
    
    public boolean doHousekeeping() {
        System.out.println("LoginManager doHousekeeping");
        return true;
    }
    
}
