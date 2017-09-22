
/**
 * Job Object
 * 
 * Various attributes of jobs, and related behaviour.
 * 
 * @author SRN: 15065017 
 * @version 29/12/16
 */
public class Job
{
    private int jobId;
    private String cust;
    private boolean onSite;
    private boolean sHand;
    private String lang;
    private String status;   
    
    private static int nextJobId = 100;
    
    private Staff assignedStaff;
    private Customer customer;
    
    private double jobAmount;

    /**
     * Constructor
     * @param cust is the customer name who is adding the job
     * @param onSite is whether the job requires working on site or at home.
     * @param sHand is whether the job requires shorthand skills or not.
     * @param lang is the language required for the job ("English" if no translation required).
     */
    public Job(String cust, boolean onSite, boolean sHand, String lang)
    {
        jobId = nextJobId++;
        this.cust = cust;
        this.onSite = onSite;
        this.sHand = sHand;
        this.lang = lang;
    }
    
    
    /**
     * Returns a string representation of the job object including job number, customer name, and job status.
     * @returns a string reresentation of the job object including job number, customer name, and job status.
     */
    public String toString()
    {
        return "Job Number:" + jobId + ". Customer: " + cust + ". Status: " + status;
    }
    
    /**
     * Returns the staff cost of the most recent job.
     * @returns the staff cost of the most recent job.
     */
    public double getJobAmount()
    {
        return jobAmount;
    }
    
    /**
     * Returns the customer who posted the job.
     * @returns the customer who posted the job.
     */
    public Customer getCustomer()
    {
        return customer;
    }
    
    /**
     * Returns the staff member who has been assigned to complete the job.
     * @returns the staff member who has been assigned to complete the job.
     */
    public Staff getAssignedStaff()
    {
        return assignedStaff;
    }
    
    /**
     * Returns the job number of the job.
     * @returns the job number of the job.
     */
    public int getJobId()
    {
        return jobId;
    }
    
    /**
     * Returns the status of the job, either 'ongoing', 'done', or 'waiting'.
     * @returns the status of the job, either 'ongoing', 'done;, or 'waiting'.
     */
    public String getStatus()
    {
        return status;
    }
    
    /**
     * Returns whether or not the job requirement is to work on site.
     * @returns true if the job requires working on site, false otherwise.
     */
    public boolean getOnSite()
    {
        return onSite;
    }
    
    /**
     * Returns whether or not the job requires shorthand skills.
     * @returns true if shorthand is required, false otherwise.
     */
    public boolean getSHand()
    {
        return sHand;
    }
    
    /**
     * Returns the language required for the job.
     * @returns the language required for the job.
     */
    public String getLang()
    {
        return lang;
    }
    
    /**
     * Returns the customer name.
     * @returns the customer name.
     */
    public String getCustomerName()
    {
        return cust;
    }
    
    /**
     * Assigns a staff member to work on the job and sets the job status to 'ongoing'.
     * @param assignedStaff is the staff member to be assigned to the job.
     */
    public void assignStaff(Staff assignedStaff)
    {
        this.assignedStaff = assignedStaff;
        status = "ongoing";
    }
    
    /**
     * Sets the status of the job to either 'ongoing', 'waiting', or 'done'.
     * @param status is the status to which the job will be set.
     */
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    /**
     * Sets the jobAmount variable to the specified parameter value.
     * @param amount is the value to which the jobAmount variable is to be set.
     */
    public void setJobAmount(double amount)
    {
        jobAmount = amount;
    }
    
    /**
     * Adds a customer object to the job object.
     * @param customer is the customer associate with the job.
     */
    public void addCustomerInfo(Customer customer)
    {
        this.customer = customer;
    }
    

    
}
