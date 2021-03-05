import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SWETSUBHRA SARKAR
 */
public class LibrarianAccountManager {
    private List<Librarian> LibrarianList;
    private String FileName;
    
//    public static void main(String args[]){
//        LibrarianAccountManager Lmgr = new  LibrarianAccountManager();
//        Lmgr.init("Librarian.csv");
//        Lmgr.ReadData();
//        JFrame LibrarianAccountManagementUI = new LibrarianAccountManagement (Lmgr);
//        LibrarianAccountManagementUI.setVisible(true);
//        Lmgr.StoreLibrarian(new Librarian("sma","sss",12,"sss","sss","sss"));
//        Lmgr.StoreLibrarian(new Librarian("ram","sss",12,"sss","sss","sss"));
////        assert(Lmgr.getLibrarians().get(1).getName().equals("ram"));
////        assert(Lmgr.getLibrarians().get(2).getName().equals("ram")):"Its sma";
//}
    public boolean init(String Filename){
        boolean result = false;
        this.FileName=Filename;
        if(ReadData()){
            result = true;
            ReadData();
        }
        return result;
    }
    
     public LibrarianAccountManager(){
        this.LibrarianList = new ArrayList<Librarian>();
    }
    
    public List<Librarian> getLibrarians() {
        List<Librarian> result = null;
        result = Collections.unmodifiableList(this.LibrarianList);
        return result;
    }
    
    public boolean StoreLibrarian(Librarian newLibrarian){
        boolean result = true;
        this.LibrarianList.add(newLibrarian);
        save();
        return result;
    }
    
    public boolean UpdateLibrarianDetails(Librarian updateLibrarian){
        boolean result = false;
        for(int i=0;i<LibrarianList.size();i++){
            Librarian myLibrarian = LibrarianList.get(i);
            if(updateLibrarian.getLibrarianID().equals(myLibrarian.getLibrarianID())){
                this.LibrarianList.set(i, updateLibrarian);
                result = true;
                break;
            }
        }
        save();
        return result;
    }
    
    public boolean RemoveLibrarianFromList(Librarian RemoveLibrarian){
        boolean result = false;
        for(int i=0;i<LibrarianList.size();i++){
            Librarian myLibrarian = LibrarianList.get(i);
            if(RemoveLibrarian.getLibrarianID().equals(myLibrarian.getLibrarianID())){
                this.LibrarianList.remove(i);
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
            for(Librarian i : LibrarianList){
                writer.write(i+"\n");
            }
            writer.close();
        }catch(IOException e){
            System.out.println("Unable to perform IO operations.");
        }
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
            result = true;
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

}