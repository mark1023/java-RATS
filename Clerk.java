
/**
 * Clerk object
 * 
 * @author SRN: 15065017 
 * @version 29/12/16
 */
public class Clerk extends Staff
{    
    /**
     * Constructor
     * @param staffId is the staff identifier.
     * @param name is the name of the Clerk.
     */
    public Clerk(String staffId, String name)
    {
        super(staffId, name, false, false, "English", 8);
        super.setStaffType("Clerk");
    }
    
    
}
