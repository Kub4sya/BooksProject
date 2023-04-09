/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Folders;

import DirectlyProducts.DummyFunnyBook;
import DirectlyProducts.DummySadBook;

/**
 *
 * @author kubasya
 */
public class DummyBookFactory implements BigBookFactory {

    @Override
    public SadBook createSadBook(String title) {
        return new DummySadBook(title); 
    }

    @Override
    public FunnyBook createFunnyBook(String title) {
        return new DummyFunnyBook(title);
    }
}
