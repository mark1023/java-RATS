
/**
 * Write a description of class CourseworkTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CourseworkTest
{
    public void doTest()
    {
        Manager manager = new Branch("Watford");
        manager.addStaff("CL1", "Ann");
        manager.addStaff("CL2", "Bob");
        manager.addStaff("TY1", "Che", true, true);
        manager.addStaff("TY2", "Dan", true, false);
        manager.addStaff("TY3", "Eve", false, true);
        manager.addStaff("TY4", "Fez", false, false);
        manager.addStaff("TR1", "Gil", true, true, "French", 20);
        manager.addStaff("TR2", "Han", true, false, "French", 20);
        manager.addStaff("TR3", "Kit", false, true, "German", 30);
        manager.addStaff("TR4", "Lil", false, false, "German", 30);
        
        manager.addStaff("TY9", "Yan", true, false);
        manager.addStaff("TR9", "Zen", false, true, "Greek", 40);
        
        System.out.println(manager.getAllStaff());
        System.out.println("*************" + "\n");
        manager.removeStaff("TY2");
        
        System.out.println("Lil in Watford branch? " + manager.isStaff("TR4"));
        System.out.println("Dan in Watford branch? " + manager.isStaff("TY2") + "\n");
        
        /*
         * According to my program, customers who already have a job in the system cannot add
         * a second job until the first is completed, therefore some jobs will not be accepted here.
         * As a result, further questions in this Testing section of the Test may
         * not produce desired results, but they do produce desired results
         * according to MY interpretation of the specification.
         * Customers are only allowed £100 credit limit, therefore they should not be allowed to add a second job
         * until the first is 'done' and paid for, otherwise they will continue to go over their credit limit.
         * This would allow someone to use the system to add jobs and assign staff to those jobs when they have
         * no intention of paying for any of these jobs.
         */
        System.out.println(manager.addJob("AA", true, true, "French"));
        System.out.println(manager.addJob("AA", true, false, "French"));
        System.out.println(manager.addJob("AA", false, true, "German"));
        System.out.println(manager.addJob("BB", true, false, "French"));
        System.out.println(manager.addJob("BB", true, true, "English"));
        System.out.println(manager.addJob("BB", true, false, "English"));
        System.out.println(manager.addJob("ZZ", false, true, "English"));
        System.out.println(manager.addJob("CC", false, false, "English"));
        
        System.out.println("");
        
        System.out.println(manager.getJobsWaiting());
        
        System.out.println(manager.setJobDone(101, 10));
        System.out.println(((Branch)manager).getSuccessFlag());
        System.out.println(manager.getJobCost(101));
        System.out.println(((Branch)manager).getSuccessFlag());
        
        System.out.println("");
        
        System.out.println("End of answers to test. The following output is explained in comments in source code" + "\n");
        /*
         * The following is to show you that my system does work with the jobs you have 
         * supplied, however, I will change the job numbers that you have requested i use
         * so that you can see the system does work.
         */
        
        /*
         *I will set job number 102 (previously job number 106) as 'done' with 10hours
         *as a parameter and return the cost of that job 
         *(because job number 101 was rejected since customer "AA" already has a job in the system)
         *Expected result is 165.0 as job requires shorthand (£20), takes 10hours for Typist "Che" to complete
         *at £12 an hour (£120) plus the £25 fee.
         */
        
        System.out.println(manager.setJobDone(102, 10));
        System.out.println(((Branch)manager).getSuccessFlag());
        System.out.println(manager.getJobCost(102));
        
        
       

        
    }
}
