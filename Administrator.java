
/**
 * Write a description of class Administrator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Administrator extends Staff
{
    public Administrator(String staffId, String name, double rate)
    {
        super(staffId, name, false, false, "English", rate);
        super.setStaffType("Administrator");
        
    }
}
