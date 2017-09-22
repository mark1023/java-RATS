
/**
 * Translator object
 * 
 * @author SRN: 15065017
 * @version 29/12/16
 */
public class Translator extends Staff
{
    /**
     * Constructor
     * @param staffId is the staff identifier.
     * @param name is the name of the Translator.
     * @param hOnly is whether the Translator can only work from home or not.
     * @param sHand is whether the Translator knows shorthand or not.
     * @param lang is the language the Translator can translate.
     * @param rate is the amount per hour the Translator charges.
     */
    public Translator(String staffId, String name, boolean hOnly, boolean sHand, String lang, double rate)
    {
        super(staffId, name, hOnly, sHand, lang, rate);    
        super.setStaffType("Translator");
    }    
   
}
