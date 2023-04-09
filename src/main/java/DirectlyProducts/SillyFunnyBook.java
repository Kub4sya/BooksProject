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
public class SillyFunnyBook implements FunnyBook{
    private String title;
    public SillyFunnyBook(String title)
    {
        this.title = title;
        //System.out.println("Create SillyFunnyBook");
    }

    @Override
    public String toString() {
        return "SillyFunnyBook{" + "title=" + title + '}';
    }
    
    @Override
    public String getTitle() {
        return title;
    }
}
