
/**
 * Typist object
 * 
 * @author SRN: 15065017 
 * @version 29/12/16
 */
public class Typist extends Staff
{
    private String email;    

    /**
     * Constructor
     * @param staffId is the staff identifier.
     * @param name is the name of the Typist.
     * @param hOnly is whether the Typist can only work from home or not.
     * @param sHand is whether the Typist knows shorthand or not.
     */
    public Typist(String staffId, String name, boolean hOnly, boolean sHand)
    {
        super(staffId, name, hOnly, sHand, "English", 12);
        super.setStaffType("Typist");
        
    }
    
    /**
     * Returns a string representation of the Typist object including their id, name, status, and email address.
     * @returns a string representation of the Typist object including their id, name, status, and email address.
     */
    public String toString()
    {
        return super.toString() + "\n" + "Email: " + email;
    }
    
    /**
     * Sets the email address of the Typist.
     * @param emailAddress is the email address to which the Typist will be assigned.
     */
    public void setEmail(String emailAddress)
    {
        email = emailAddress;
    }
    
    /**
     * Returns the email address of the Typist.
     * @returns the email address of the Typist.
     */
    public String getEmail()
    {
        return email;
    }

   
}
