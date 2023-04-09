/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Folders;

import DirectlyProducts.SillyFunnyBook;
import DirectlyProducts.SillySadBook;

/**
 *
 * @author kubasya
 */
public class SillyBookFactory  implements BigBookFactory {

    @Override
    public SadBook createSadBook(String entirelyAll) {
        return new SillySadBook(entirelyAll);
    }

    @Override
    public FunnyBook createFunnyBook(String title) {
        return new SillyFunnyBook(title);
    }
    
}
