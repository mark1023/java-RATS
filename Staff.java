
/**
 * Staff object.
 * 
 * Various attributes of staff members, and various behaviours.
 * Abstract super class, acts as blueprint for sub-class staff members.
 * 
 * @author SRN: 15065017 
 * @version 29/12/16
 */
public abstract class Staff
{    
    private String staffId;
    private String name;
    private String status;
    private String lang;
    private boolean hOnly;
    private boolean sHand;
    private double rate;
    
    private String staffType;
    private double wages;

    /**
     * Constructor
     * @param staffId is the staff identifier.
     * @param name is the name of the staff member.
     * @param hOnly is whether the staff member only works from home or not.
     * @param sHand is whether the staff member has shorthand skills or not.
     * @param lang is the language the staff member can translate ("English" as default for non-translators).
     * @param rate is the rate per hour the staff member charges (fixed for Clerks and Typists).
     */
    public Staff(String staffId, String name, boolean hOnly, boolean sHand, String lang, double rate)
    {
        this.staffId = staffId;
        this.name = name;
        this.hOnly = hOnly;
        this.sHand = sHand;
        this.rate = rate;
        this.lang = lang;
        status = "available";       
    }
    
    
    /**
     * Returns a string representation of the staff member including staff id, staff name, and status.
     * @returns a string representation of the staff member including staff id, staff name, and status.
     */
    public String toString()
    {
        return "STAFF ID: " + staffId + "\n" + "NAME: " + name + "\n" + "STATUS: " + status;
    }

    /**
     * Returns the staffId of the staff member.
     * @return the staffId of the staff member.
     */
    public String getStaffId()
    {        
        return staffId;
    }
    
    /**
     * Returns the staff type (Clerk, Typist or Translator).
     * @returns the staff type (Clerk, Typist or Translator).
     */
    public String getStaffType()
    {
        return staffType;
    }
    
    /**
     * Returns the rate per hour.
     * @returns the rate per hour.
     */
    public double getRate()
    {
        return rate;
    }
    
    /**
     * Returns the name of the staff member.
     * @returns the name of the staff member.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the status of the staff member ('working', 'available', 'unavailable').
     * @returns the status of the staff member ('working', 'available', 'unavailable').
     */
    public String  getStatus()
    {
        return status;
    }
    
    /**
     * Returns whether the staff member will only work from home or not.
     * @returns true if the staff member will only work from home, false otherwise.
     */
    public boolean getHOnly()
    {
        return hOnly;
    }
    
    /**
     * Returns whether the staff member has shorthand skills or not.
     * @returns true if the staff member has shorthand skills, false otherwise.
     */
    public boolean getSHand()
    {
        return sHand;
    }
    
    /**
     * Returns the language spoken by the staff member.
     * @returns the language spoken by a Translator, or "English" for a Clerk or Typist.
     */
    public String getLang()
    {
        return lang;
    }

    /**
     * Sets the staff member's rate per hour.
     * @param amount is the value to which the staff member's rate will be set.
     */
    public void setRate(double amount)
    {
        rate = amount;
    }
    
    /**
     * Sets the staff member's status to either 'working', 'available' or 'unavailable'.
     * @param status is the desired state for the staff member to be set to.
     */
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    /**
     * Sets the staff type to either 'Clerk', 'Typist', or 'Translator'.
     * @param type is the staff type to be set for the staff member.
     */
    public void setStaffType(String type)
    {
        staffType = type;
    }
    
    /**
     * Adds a specified amount to the wages of the staff member.
     * @param wage is the amount to be added to the staff's wages.
     */
    public void addToWages(double wage)
    {
        wages += wage;
    }
    
    /**
     * Pays the staff member a specified amount.
     * @param amount is the specified amount to be paid to the staff member.
     */
    public void payStaffMember(double amount)
    {
        wages -= amount;
    }
    

    
            
}

