import java.util.*;
import java.io.*;
/**
 * This class implements the behaviour expected from the RATS
 * system required for 2COM0057 Deferred/Referred Coursework 
 * 2007/8
 * 
 * @author SRN: 15065017 
 * @version 29/12/16
 */
public class Branch implements Manager
{
    private String location;
    private HashMap<String, Staff> staff;
    private HashMap<Integer, Job> jobs;
    private HashMap<String, Customer> customers;
    
    private String successFlag;
    
    private String branchSupervisor;
    
    /**
     * Constructer which constructs objects of class Branch.
     * @param location is the location of the branch.
     */
    public Branch(String location)
    {
        this.location = location;
        staff = new HashMap<String, Staff>();        
        jobs = new HashMap<Integer, Job>();
        customers = new HashMap<String, Customer>();
        setSuccessFlag("Success! Branch: " + location + " was added.");
        branchSupervisor = "XXXX";
    }
    
    /**
     * Sets the name of the branch supervisor to the specified parameter value.
     * @param name is the name of the branch supervisor.
     */
    private void setSupervisor(String name)
    {
        branchSupervisor = name;
    }

    
    /**
     * Deletes the job with the specified job number from the system.
     * pre-condition: checkJobId(jobId).
     * @param jobId is the job number.
     */
    
    private void removeJob(int jobId)
    {        
        if(checkJobId(jobId))
        {
            jobs.remove(jobId);            
        }  
    }
    
    
    /**
     * Checks to see if a particular job number is a valid,
     * current job in the system.
     * @param jobId is the job number.
     * @returns true if the job associated with the particular job number
     * is in the system, false otherwise.
     */
    private boolean checkJobId(int jobId)
    { 
        if(jobs.containsKey(jobId))
        {
            return  true;
        }
        else
        {
            return false;
        }

    }
    
    /**
     * Checks if the specified staff member is suitable and available for the specified job.
     * pre-condition: isStaff(staffId)
     * pre-condition: checkJobId(jobId)
     * @param jobId is the job number
     * @param staffId is the staff identifier
     * @returns true if the staff member is available and suitable for the
     * job, otherwise false.
     * 
     */
    
    private boolean matchJobWithStaff(int jobId, String staffId)
    {
        boolean result = false;
        if(isStaff(staffId) && checkJobId(jobId))
        {
            Job job = jobs.get(jobId);
            Staff stf = staff.get(staffId);
            if(stf.getStatus().equals("available"))
            {
                if(stf instanceof Typist || stf instanceof Translator)
                {
                    if((stf.getHOnly() == false || stf.getHOnly() != job.getOnSite()))
                    {
                        if(job.getSHand() == stf.getSHand())
                        {
                            if(job.getLang().equals(stf.getLang()))
                            {
                                result = true;                             
                            }
                        }
                    }
                }
                else
                {
                    if(job.getOnSite() != stf.getHOnly())
                    {
                        if(job.getSHand() == stf.getSHand())
                        {
                            if(job.getLang().equals(stf.getLang()))
                            {
                                result = true;
                            }
                        }
                    } 
                }
            }
        }

                      
        
        
        return result;
    }
     

    /**Returns the location of the branch as a String
     * @return the location of the branch as a String
     **/ 
    public String getBranch()
    {        
        return location;
    }
    
    /**
     * Returns the successFlag variable holding a string message regarding the success of certain methods.
     * @returns the successFlag variable holding a string message regarding the success of certain methods.
     */
    public String getSuccessFlag()
    {
        return successFlag;
    }
    
    /**
     * Sets the successFlag variable to hold a specified string
     * @param successFlag is the success message.
     */
    public void setSuccessFlag(String successFlag)
    {
        this.successFlag = successFlag;
    }
    
    /**Returns a String representation of the branch,including
     * its location and all its staff,customers and jobs      
     * @return a String representation of the branch,including
     * its location and all its staff,customers and jobs
     **/
    public String toString()
    {
        String result = "Branch Supervisor: " + branchSupervisor + "\n" + "LOCATION: " + location + "\n" + getAllStaff() + "\n" + getAllCustomers() + "\n" + getAllJobs();
        return result;
        
    }
    
    /**Returns a String representation of customers who have used the 
     * branch's services
     * @return a String representation of the customers who have used 
     * the branch's services 
     **/
    public String getAllCustomers()
    {
        String result = "CUSTOMERS: " + "\n";
        Iterator it = customers.values().iterator();
        while(it.hasNext())
        {
            Customer cust = (Customer) (it.next());
            result += cust.toString() + "\n";
        }
        return result;
        
    }
        
 // ***************** Staff ************************
    /**Allows an administrator to be added to the branch. The administrator's
     * availability is set to "available"
     * @param id represents the employee code of the staff e.g TY333
     * @param name is the staff member's name
     **/
     public void addStaff(String id, String name, double hourlyRate)
     {
        Staff st = new Administrator(id, name, hourlyRate);
        staff.put(id, st);
        st.setStatus("available");
        setSuccessFlag("Success! Administrator: " + name + " was added to the system");
        
     }
 
    /** Allows a clerk to be added to the branch.The clerk's availability
     *  is set to "available"
     * @param id represents the employee code of the staff e.g TY333
     * @param name is the staff member's name 
     **/        
     public void addStaff(String id,String name)
     {
         Staff st = new Clerk(id, name);
         staff.put(id, st);
         st.setStatus("available");        
         setSuccessFlag("Success! Clerk: " + name + " was added to the system");
     }
    
    /**Allows a typist to be added to a branch.The typist's availability
    *  is set to "available".Staff must specify if they can only work at 
    *  home.If false, then staff can work on site or at home if required
    * @param id represents the employee code of the staff e.g TY333
    * @param name is the staff member's name 
    * @param hOnly true if a member of staff can only work at home,
    * fals if they can only work at home
    * @param sHand true if a member of staff can offer shorthand
    **/       
    public void addStaff(String id,String name, boolean hOnly, boolean sHand)
    {
        Staff st = new Typist(id, name, hOnly, sHand);
        staff.put(id, st);
        st.setStatus("available");
        setSuccessFlag("Success! Typist: " + name + " was added to the system");
    }
                                                                                                                                                            
    /** Allows a translator to be added to the branch.The translator's 
     *  availability is set to "available".Staff must specify if they 
     *  can only work at home.If false, then staff can work on site or 
     *  at home if required.
     * @param id represents the employee code of the staff e.g TY333
     * @param name is the staff member's name 
     * @param hOnly true if a member of staff can work on site, false 
     * if they can only work at home
     * @param sHand true if a member of staff can offer shorthand
     * @param lang is the language which the staff member can translate
     * @param rate is the hourly rate
     **/   
    public void addStaff(String id,String name, boolean hOnly, boolean sHand,String lang, double rate)
    {
        Staff st = new Translator(id, name, hOnly, sHand, lang, rate);
        staff.put(id, st);
        st.setStatus("available");
        setSuccessFlag("Success! Translator: " + name + " was added to the system");
    }
                    
    /** Sets email for a typist
     * @param id represents the staff id
     * @param email is the email address
     */ 
    public void setEmail(String id, String email)
    {
        if(isStaff(id) && staff.get(id) instanceof Typist)
        {
            Staff st = staff.get(id);
            ((Typist)st).setEmail(email);
            setSuccessFlag("Success! " + email + " was added to the system");
        }
        else
        {
            setSuccessFlag("Fail. Email address not added. " + id + " is either not a Typist or not a valid staff ID.");
        }

    }
    
    
    /** Returns true if the staff with the staff identifier 
     * can be found in the system, false otherwise.
     * @param stfId represents the staff identifier 
     * @return returns true if the staff with the staff identifier 
     * can be found, false otherwise.
     **/
    public boolean isStaff(String stfId)
    {
        boolean result = false;
        if(staff.containsKey(stfId))
        {
            result = true;
        }
        return result;
    }
    
    /** Removes a staff from the branch.
     * pre-condition: isStaff(depId)
     * @param stfId represents the staff identifier 
     **/
    public void removeStaff(String depId)
    {
        if(isStaff(depId) && staff.get(depId).getStatus().equals("available"))
        {
            staff.remove(depId);
            setSuccessFlag("Success! Staff with ID: " + depId + " was removed from the system");
        }
        else
        {
            setSuccessFlag("Fail. Staff with ID: " + depId + " was NOT removed from the system");
        }
    }
    
    /** Returns a String representation of all the staffs  
     * @return returns a String representation of all staffs 
     **/
    public String getAllStaff()
    {
        
        String result = "CURRENT STAFF:" + "\n";
        Iterator it = staff.values().iterator();
        while(it.hasNext())
        {
            Staff staffMember = (Staff) (it.next());
            result += staffMember.toString() + "\n";
        }
        return result;
    }
   

//************************************************************** 
    /** Finds the customer and if the customer is not in the system,
     *  adds the customer.If the customer is over their credit limit, 
     *  "Customer over credit limit is returned and the job is not 
     *  accepted.If the job is accepted it gets a number sequentially 
     *  from 100.If a suitable staff member is available,the state of 
     *  the job is set to "on going",the selected staff member is added
     *  to the job and the staff's set to "on job".If a staff member is
     *  not available,the job's state is state is set to "waiting".If 
     *  suitable staff cannot be found,"Job waiting" is returned, else
     *  "Staff allocated:" together with the staff details.
     * @param cust is the name of the customer
     * @param onSite true if job is on customer's site, false if 
     *      required to work at home
     * @param sHand true if shorthand is required, false otherwise
     * @param lang should the "English" if no translation required, 
     *      otherwise the name 
     * of the language
     * @return returns"Customer over credit limit", or if the job is 
     * possible,the job number with either "Job waiting" if no staff is
     * available, or "staff allocated:" together with the staff details
     **/ 
    public String addJob(String cust,boolean onSite, boolean sHand, String lang)
    {
        Customer target = customers.get(cust);
        String output = "";
        
        if(target == null)
        {
            target = new Customer(cust, 100);
            customers.put(cust, target);              
        }
       
        
        
        if(target.getBalance() < target.getCreditLimit())
        {
            if(target.getNoCurrentJob())
            {
                Job job = new Job(cust, onSite, sHand, lang);
                jobs.put(job.getJobId(), job);
                target.incrementJobsAdded();
                target.setNoCurrentJob(false);
                job.addCustomerInfo(target);
                job.setStatus("waiting");
                setSuccessFlag("Success! Your job was added to the system");
                Iterator it = staff.values().iterator();           
                while(it.hasNext())
                {
                    Staff staffMember = (Staff) (it.next());
                    if(matchJobWithStaff(job.getJobId(), staffMember.getStaffId()))
                    {
                        job.assignStaff(staffMember);
                        staffMember.setStatus("working");
                        output = "JOB ID: " + job.getJobId() + "\n" + "STAFF ALLOCATED: " + "\n" + staffMember.toString();
                        break;
                    }
                                                                                        
                    else
                    {
                        output = job.getJobId() + ": Job waiting";
                    }
                                                                                               
                }
            }
            else
            {
                output = "Fail. Customer: " + target.getCustName() + " already has a current job in the system.";
            }
            
            if(target.getJobsAdded() == 5)
            {
                target.increaseCreditLimit();
            }
            
        }
        
        else
        {
            output = "Customer over credit limit";
            setSuccessFlag("Fail. Your job was NOT added to the system");
        }
        
        
        return output;
       
    }
     
     
    /** Provides a String representation of all jobs 
     * @return returns a String representation of of all jobs
     **/
    public String getAllJobs()
    {
        String result = "JOBS: " + "\n";
        Iterator it = jobs.values().iterator();
        while(it.hasNext())
        {
            Job job = (Job) (it.next());
            result += job.toString() + "\n";
        }
        return result;
        
    }
    
    /** Provides a String representation of all jobs which are 
     * still waiting to be done
     * @return returns a String representation of all jobs which are 
     * still waiting to be doneg
     **/
    public String getJobsWaiting()
    {        
        String result = "JOBS WAITING:" + "\n";
        Iterator it = jobs.values().iterator();
        while(it.hasNext())
        {
            Job job = (Job) (it.next());
            if(job.getStatus().equals("waiting"))
            {
                result += job.toString() + "\n";
            }
        }
        return result;
    }

    /** Returns the cost of job specified by the parameter value once it
     * has been done.If the job cannot be found or the job has not been 
     * done return -1.Clerks are paid £8 per hour, typists £12 per hour, 
     * while translators specify their own hourly rate.A job which 
     * requires shorthand has an added standard fee of £20.Cost of the 
     * job is added to the wages of the staff member and this cost 
     * together with a standard charge (currently £25) is added to the 
     * money owed by the customer.
     * @param jobNo is the number of the job
     * @return the cost of a job calculated as described above
     **/
    public double getJobCost(int jNo)
    {
        double cost = 0;
        double amountOwed = 0;
        
        if(checkJobId(jNo) && jobs.get(jNo).getStatus().equals("done"))
        {
            Job job = jobs.get(jNo);
            Staff stf = job.getAssignedStaff();
            Customer cust = job.getCustomer();
            cost = job.getJobAmount();
            stf.addToWages(cost);
            amountOwed = cost + 25;
            cust.addToBalance(amountOwed);
            removeJob(jNo);
            cust.setNoCurrentJob(true);
        }
                   
        return amountOwed;
    }
    
    
    /** Records that the job specified by the parameter value has been 
     * done.If the job can be found and its state is "on going", sets 
     * the state of the job to "done", the state of its staff to 
     * "available", costs are calculated and added as appropriate,and 0 
     * is returned,otherwise return -1
     * @param jNO is the job number
     * @param hours is the number of hours taken to do the job
     * @return -1 if job is not found or is not "on going", else 0
     **/
    public int setJobDone(int jNo, int hours)
    {                                
        if(checkJobId(jNo) && jobs.get(jNo).getStatus().equals("ongoing"))
        {
            double amount = 0;
            Job job = jobs.get(jNo);            
            job.setStatus("done");
            Staff stf = job.getAssignedStaff();
            stf.setStatus("available");
            setSuccessFlag("Success! Job: " + jNo + " was set to 'done'");
            
            if(job.getSHand())
            {
                amount += 20;
            }
            
            if(stf instanceof Clerk)
            {
                amount += (double)(hours * stf.getRate());
            }
            else if(stf instanceof Typist)
            {
                amount += (double)(hours * stf.getRate());
            }
            else
            {
                amount += (double)(hours * stf.getRate());
            }
            
            job.setJobAmount(amount);
            
            return 0;
        }
        else
        {
            setSuccessFlag("Fail. Job: " + jNo + " is either not in the system or is already 'done'");
            return -1;            
        }
            
        
        
           
        
        
    }
    
    
    /** Checks the list of jobs and returns the job number of the first
     * job for which a staff member is now available.If such a job is 
     * found, the state of the job is set to "on going", the selected 
     * staff is added to the job information and the staff's state is 
     * set to "on job"and the job number is returned. If there no such
     * jobs,return -1
     * @return number of the job which can now be done
     **/
    public int checkJobsWaiting()
    {
        int output = -1;
        Iterator it = jobs.values().iterator();
        while(it.hasNext())
        {
            Job job = (Job) (it.next());
            if(job.getStatus().equals("waiting"))
            {
                Iterator nIt = staff.values().iterator();
                while(nIt.hasNext())
                {
                    Staff staff = (Staff) (nIt.next());
                    if(matchJobWithStaff(job.getJobId(), staff.getStaffId()) )
                    {
                        job.assignStaff(staff);
                        staff.setStatus("working");
                        output = job.getJobId();
                        return output;
                        
                    }
                    
                }
            }
            
        }
        return output;
    }
   
 
// ***************   file write/read  *********************
// These methods may be added for Task 5

//    /** Writes all staff information to the specified file
//     * @param fname name of file to which staff information is written
//     */
//    public void writeStaffToFile(String fname);

    
//    /** Read all staff information from the specified file
//     * @param fname name of file from which staff information is read
//     */
//    public void readStaffFromFile(String fname);

    
    
}



