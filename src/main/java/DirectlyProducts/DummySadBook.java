/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DirectlyProducts;

import ExecelImplementation.Library;
import Folders.SadBook;

/**
 *
 * @author kubasya
 */
public class DummySadBook implements SadBook{
    private String title;
    
    public DummySadBook(String title)
    {
        this.title = title;
        //System.out.println("Create DummySadBook");
    }  

    public void setType(String title)
    {
        
       // type = library.
    }

    @Override
    public String toString() {
        return "DummySadBook{" + "title=" + title + '}';
    }

    @Override
    public String getTitle() {
        return title;
    }


    
}
