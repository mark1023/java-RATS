
/**
 * Performs a testing script providing output to the terminal
 * window of the results of various methods in the Branch class.
 * 
 * @author SRN: 15065017 
 * @version 29/12/16
 */
public class Tester
{    
    /**
     * performs the testing of the system.
     */
    public void doTest()
    {
        //Test no.1: Create a branch. Expect "Watford" as branch location and success message of adding the branch.
        Manager manager = new Branch("Watford");   
        System.out.println("Test no.1: Creating a branch" + "\n" + "Current state: N/A"); 
        System.out.println(((Branch)manager).getSuccessFlag());
        System.out.println("Result: " + manager.getBranch());
        System.out.println(" ");
        
        /*
         * Test no.2: Adding staff members to system, trying to add email address to a Clerk staff,
         * and adding an email address for typist "Che". Expect Staff 
         * list of 10 staff members (ID, Name, Status) including email address: "che@fakeemail.com" for staff
         * member "TY1", a fail message stating email address was not added for 
         * staff ID 'CL1', a success message stating that staff "TY1" email address has been set
         * and success messages stating the success of adding each staff member.
         */
        System.out.println("Test no.2: Adding staff" + "\n" + "Current state: N/A");
        
        System.out.println("Result: " + "\n");
                
        manager.addStaff("CL1", "Ann");
        System.out.println(((Branch)manager).getSuccessFlag());
        manager.setEmail("CL1", "ann@fakeemail.com");
        System.out.println(((Branch)manager).getSuccessFlag());
        manager.addStaff("CL2", "Bob");
        System.out.println(((Branch)manager).getSuccessFlag());
        manager.addStaff("TY1", "Che", true, true);
        System.out.println(((Branch)manager).getSuccessFlag());
        manager.setEmail("TY1", "che@fakeemail.com");
        System.out.println(((Branch)manager).getSuccessFlag());
        manager.addStaff("TY2", "Dan", true, false);
        System.out.println(((Branch)manager).getSuccessFlag());
        manager.addStaff("TY3", "Eve", false, true);
        System.out.println(((Branch)manager).getSuccessFlag());
        manager.addStaff("TY4", "Fez", false, false);
        System.out.println(((Branch)manager).getSuccessFlag());
        manager.addStaff("TR1", "Gil", true, true, "French", 11);
        System.out.println(((Branch)manager).getSuccessFlag());
        manager.addStaff("TR2", "Han", true, false, "French", 14);
        System.out.println(((Branch)manager).getSuccessFlag());
        manager.addStaff("TR3", "Kit", false, true, "German", 12);
        System.out.println(((Branch)manager).getSuccessFlag());
        manager.addStaff("TR4", "Lil", false, false, "German", 10);
        System.out.println(((Branch)manager).getSuccessFlag() + "\n");
        
        System.out.println(manager.getAllStaff());
        
        
        /*
         * Test no.3: Adding a job to the system (including adding a customer). Expect Job ID: 100 and assigned
         * staff member details("Eve"), including "working" status and BT as a customer, and a success message
         * that the job was added to the system.
        */
        System.out.println("Test no.3: Adding a job (and customer)" + "\n" + "Current state: N/A");
                            
                            
        System.out.println("Result:" + "\n" + manager.addJob("BT", true, true, "English") + "\n" + manager.getAllCustomers() +
        ((Branch)manager).getSuccessFlag() + "\n");
        
        //Adding more jobs (and customers) to system for later tests.
        manager.addJob("Amazon", false, false, "English");
        manager.addJob("APC", true, false, "French");
        manager.addJob("Nike", true, true, "German");
        manager.addJob("Barclays", true, true, "English");
        manager.addJob("Sky", true, false, "English");


        /*
         * Test no.4: Get list of jobs that are waiting. Expect jobs with job numbers 102 and 104 to be "waiting" 
         * along with associated customer names ("APC" and "Barclays", respectively).
        */
        System.out.println("Test no.4: Jobs waiting" + "\n" + manager.getJobsWaiting());
        
        /*
         * Test no.5: Set all jobs as "done". Expect 3 '0's' as 3 jobs have been set as done and success messages for 
         * jobs with job numbers 100, 101, and 103 which are set to 'done'.
         */
        System.out.println("Test no.5: Jobs done" + "\n" + "State before:" + "\n" + manager.getAllJobs() + manager.setJobDone(100, 1)
        + "\n" + ((Branch)manager).getSuccessFlag() + "\n" + manager.setJobDone(101, 2) + "\n" + ((Branch)manager).getSuccessFlag() + "\n"+ 
                            "\n" + manager.setJobDone(103, 1) + "\n" + ((Branch)manager).getSuccessFlag() + "\n");
        System.out.println("State after:" + "\n" + manager.getAllJobs());                   
                            
        /*
         * Test no.6: Get job cost of job with job number 100. Expect 57 ((12*1hour) + 20 + 25) and for job number 100
         * to no longer be in the system.
         */               
        System.out.println("Test no.6: Get job cost of job number 100" + "\n" + manager.getJobCost(100) + "\n" + 
        manager.getAllJobs());
        
        //Getting job costs of other remaining "done" jobs to remove them from the system.
        manager.getJobCost(101);
        manager.getJobCost(103);
                            
        /*
         * Test no.7: Check if any jobs that are "waiting" can be assigned to a staff member now that other jobs have been "done". 
         *Expect job number 104 to be returned, as that job has been assigned a staff member, and "Eve" to now be "working".
         */

        System.out.println("Test no.7: Check any jobs that are 'waiting' that can be assigned a staff member");
        System.out.println("State before:" + "\n" + manager.getAllStaff());
        System.out.println("State after:" + "\n" + manager.checkJobsWaiting() + "\n" + manager.getAllStaff());

        /*
         * Test no.8: Remove a staff member from the system. Expect staff member "Ann" to be 
         * removed from the hashMap of customers and a message stating the staff member was removed successfully.         
         */ 
        System.out.println("Test no.8: Remove customer from system.");
        System.out.println("State before:" + "\n" + manager.getAllStaff());
        manager.removeStaff("CL1");
        System.out.println(((Branch)manager).getSuccessFlag());
        System.out.println("State after:" + "\n" + manager.getAllStaff());

        /*
         * Test no.9: Try removing staff member ("Eve") who is currently working on a job. Expect staff member "Eve" to still
         * be in the system after method call as "Eve" is currently working.
         */
        System.out.println("Test no.9: Trying to remove a currently working staff member");
        System.out.println("State before:" + "\n" + manager.getAllStaff());
        manager.removeStaff("TY3");
        System.out.println(((Branch)manager).getSuccessFlag());
        System.out.println("State after:" + "\n" + manager.getAllStaff());
        
        /*
         * Test no.10: Adding a second job for customer "BT" to take balance over credit limit. Expect job to be accepted
         * as job number 106 with staff member "Fez" assigned and now "working". Job number 106 should now appear in jobs list
         * associated with customer "BT". Also expect a message stating the success of adding the job.
         */
        System.out.println("Test no.10: Adding a second job for customer 'BT'");
        System.out.println("State before:" + "\n" + manager.getAllJobs());
        System.out.println(manager.addJob("BT", true, false, "English"));
        System.out.println(((Branch)manager).getSuccessFlag());
        System.out.println("State after:" + "\n" + manager.getAllJobs());
        
        //Setting job number 106, "BT", as done and getting the job cost to take "BT's" balance over the credit limit.
        manager.setJobDone(106, 2);
        manager.getJobCost(106);
        
        /*
         * Test no.11: Adding a job for a customer who is over their credit limit. Expect "Customer over credit limit" 
         * and a message stating the job was not added to the system.
         */
        System.out.println("Test no.11: Adding a job when customer is over their credit limit");
        System.out.println("State: " + "\n" + manager.addJob("BT", true, true, "German"));
        System.out.println(((Branch)manager).getSuccessFlag() + "\n");
        /*
         * Test no.12: Trying to get the cost of a job before it is "done". Expect a cost of 0.0 to
         * be returned as job is not yet "done".
         */
        System.out.println("Test no.12: Getting the cost of a job that is not yet 'done'");
        System.out.println(manager.getJobCost(105) + "\n");
        
        /*
         * Test no.13: Setting a job as "done" when it is already set as "done". Expect -1 to be returned 
         * and a message stating that job number 104 is either not in the system or is already 'done'.
         */
        System.out.println("Test no.13: Setting a job as 'done' when it is already 'done'");
        manager.setJobDone(104, 1);
        System.out.println(manager.setJobDone(104, 1));
        System.out.println(((Branch)manager).getSuccessFlag() + "\n");
        
        /*
         * Test no.14: Customer adding a job when that customer already has a job in the system. Expect message
         * saying that the job was not added because the customer already has a job in the system. (This prevents customers 
         * from adding further jobs before they have had the job cost added to their balance for their original job posted).
         */
        System.out.println("Test no.14: Customer adding a job when that customer already has a job in the system");
        System.out.println(manager.addJob("APC", true, true, "English") + "\n");
        
        /*
         * Test no.15: Get all information of branch including its location, staff, jobs, and customers.
         * Expect "Watford" as location, list of staff including 9 staff members (Gil, Kit, Han, Lil, Bob, 
         * Dan, Che, Fez, Eve), 6 customers (Nike, Sky, BT, APC, Barclays, Amazon), and 3 jobs (job numbers 102, 104 and 105).
         */
        System.out.println("Test no.15: Get all information of branch" + "\n" + manager.toString());        
                        
    }
}
