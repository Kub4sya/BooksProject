/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Folders;

import DirectlyGuys.EvilKirill;
import DirectlyGuys.GraciousKirill;

/**
 *
 * @author kubasya
 */
public class KirillMan {
    
    public GraciousKirill createGraciousKirill(String surname, String name)
    {
        return new GraciousKirill(surname, name);
    }
    public EvilKirill createEvilKirill(String surname, String name, String lastname, int gender)
    {
        return new EvilKirill(surname, name, lastname, gender);
    }
}
