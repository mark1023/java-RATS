
/**
 * Customer Object
 * 
 * Various attributes of customers, and related behaviour.
 * 
 * @author SRN: 15065017 
 * @version 29/12/16
 */
public class Customer
{
    private int custId;
    private String name;
    private int creditLimit;
    private double balance;
    private int jobsAdded;
    private boolean noCurrentJob;
    private static int nextCustId = 1;
    
    /**
     * Constructor
     * @param name is the name of the customer.
     * @param creditLimit is the credit limit for the customer.
     */
    public Customer(String name, int creditLimit)
    {
        custId = nextCustId++;
        this.name = name;
        this.creditLimit = creditLimit;
        noCurrentJob = true;
    }

    /**
     * Returns the state of the noCurrentJob variable.
     * @returns true if the customer has no jobs in the system, false otherwise.
     */
    public boolean getNoCurrentJob()
    {
        return noCurrentJob;
    }
    
    /**
     * Sets the noCurrentVariable to either true or false depending on the parameter input
     * @param noCurrentJob is the desired state of the noCurrentJob variable.
     */
    public void setNoCurrentJob(boolean noCurrentJob)
    {
        this.noCurrentJob = noCurrentJob;
    }
    
    /**
     * Returns the name of the customer.
     * @returns the name of the customer.
     */
    public String getCustName()
    {
        return name;
    }
    
    /**
     * Returns the customer id.
     * @returns the customer id.
     */
    public int getCustId()
    {
        return custId;
    }
    
    /**
     * Returns the credit limit of the customer.
     * @returns the credit limit of the customer.
     */
    public int getCreditLimit()
    {
        return creditLimit;
    }
   
    /**
     * Returns a string representation of the customer object including the customer id and customer name.
     * @returns a string representation of the customer object including the customer id and customer name.
     */
    public String toString()
    {
        return "Customer ID: " + custId + "\n" + "Customer: " + name;
    }
    
    /**
     * Returns the current balance of the customer.
     * @returns the current balance of the customer.
     */
    public double getBalance()
    {
        return balance;
    }
    
    /**
     * Returns the number of jobs the customer has added to the system.
     * @returns the number of jobs the customer has added to the system.
     */
    public int getJobsAdded()
    {
        return jobsAdded;
    }
    
    /**
     * Adds a specified amount to the customer's current balance.
     * @param amount is the amount to add to the customer's current balance.
     */
    public void addToBalance(double amount)
    {
        balance += amount;
    }
    
    /**
     * Allows the customer to pay off some of the money they owe.
     * @param amount is the amount of their balance the customer wishes to pay.
     */
    public void pay(double amount)
    {
        balance -= amount;
    }
    
    /**
     * Adds 1 to the number of jobs the customer has added.
     */
    public void incrementJobsAdded()
    {
        jobsAdded++;
    }
    
    /**
     * Increases a customer's credit limit to 500.
     * @returns Credit limit has been increased to £500, thank you for your custom. 
     */
    public String increaseCreditLimit()
    {        
        creditLimit = 500;
        String output = "Credit limit has been increased to £500, thank you for your custom.";        
       
        return output;
    }
}

