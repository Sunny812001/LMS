

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
 * @author DELL
 */
public class BookManager {
    
    private List<Book> BookList;
    private String FileName;
    
//    public static void main(String args[]){
//        BookManager Bmgr = new BookManager();
//        Bmgr.init("Book.csv");
//        Bmgr.ReadData();
//        JFrame BookManagementUI = new BookManagement(Bmgr);
//        BookManagementUI.setVisible(true);
////        JFrame CheckAvailabilityUI = new CheckAvailability(Bmgr);
////        CheckAvailabilityUI.setVisible(true);
////        Bmgr.StoreBook(new Book(15,"sss","sss","sss","sss","sss","sss","sss",12));
//        //Bmgr.StoreBook(new Book(13,"sss","sss","sss","sss","sss","sss","sss",12));
////        Bmgr.StoreBook(new Book(14,"sss","sss","sss","sss","sss","sss","sss",12));
////        Bmgr.StoreBook(new Book(12,"sss","sss","sss","sss","sss","sss","sss",12));
////        Bmgr.StoreBook(new Book(15,"sss","sss","sss","sss","sss","sss","sss",12));
//        //Bmgr.save();
////        assert(Bmgr.getBooks().size()==3):"the actual size is 9";
////        assert(Bmgr.getBooks().get(2).getBookName().equals("sss"));
//    }
    
    public boolean init(String Filename){
        boolean result = false;
        this.FileName=Filename;
        if(ReadData()){
            result=true;
            ReadData();
        }
        return result;
    }
    
    public BookManager(){
        this.BookList = new ArrayList<Book>();
    }
    
    public List<Book> getBooks() {
        List<Book> result = null;
        result = Collections.unmodifiableList(this.BookList);
        return result;
    }
    
    public boolean StoreBook(Book newBook){
        boolean result = true;
        System.out.println(newBook);
        this.BookList.add(newBook);
        save();
        return result;
    }
    
    public boolean UpdateBookDetails(Book updateBook){
        boolean result = false;
        for(int i=0;i<BookList.size();i++){
            Book myBook = BookList.get(i);
            if(updateBook.getBookID()==myBook.getBookID()){
                this.BookList.set(i, updateBook);
                result = true;
                break;
            }
        }
        save();
        return result;
    }
    
    public boolean RemoveBookFromList(Book RemoveBook){
        boolean result = false;
        for(int i=0;i<BookList.size();i++){
            Book myBook = BookList.get(i);
            if(RemoveBook.getBookID()==myBook.getBookID()){
                this.BookList.remove(i);
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
            for(Book i : BookList){
                writer.write(i+"\n");
            }
            writer.close();
        }catch(IOException e){
            System.out.println("Unable to perform IO operations.");
        }
    }

    public boolean ReadData(){
        boolean result=false;
        try {
            FileReader reader = new FileReader(FileName);
            BufferedReader bufReader = new BufferedReader(reader);
            String line = bufReader.readLine();
            while(line != null){
                BookList.add(readLine(line));
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
    
    Book readLine(String line){
        String[] data = line.split("\\,");
        return new Book(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6], data[7], Integer.parseInt(data[8]));
    }
    
    public boolean search(Book SearchBook){
        boolean result=false;
        for(int i=0;i<BookList.size();i++){
            Book FindBook=BookList.get(i);
            if(SearchBook.getBookName().equals(FindBook.getBookName())&&SearchBook.getAuthor().equals(FindBook.getAuthor()))
                result=true;
        }
        return result;
    }
    
}
