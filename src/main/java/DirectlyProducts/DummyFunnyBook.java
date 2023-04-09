/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DirectlyProducts;

import Folders.FunnyBook;


/**
 *
 * @author kubasya
 */
public class DummyFunnyBook implements FunnyBook{
    private String title = "";
    
    public DummyFunnyBook(String title)
    {
        this.title = title;
        //System.out.println("Create DummyFunnyBook");
    }



    @Override
    public String toString() {
        return "DummyFunnyBook{" + "title=" + title + '}';
    }

    @Override
    public String getTitle() {
        return title;
    }
}