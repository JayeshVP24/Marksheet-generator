import java.util.Scanner;

class marksheet
{
    String fname, lname, branch, exam;
    String[] subj = new String[10];
    int sem, nsub, i, total=0,j=0;
    int[] marks = new int[10];
    double perc;
    Scanner s = new Scanner(System.in);
    void gd()
    {
        System.out.println("Enter First Name: ");
        fname = s.nextLine();
        System.out.println("Enter Last Name: ");
        lname = s.nextLine();
        for(;;)
        {      
            System.out.println("Enter Branch (CO/IF/EJ): ");
            branch = s.nextLine();
            System.out.println(branch);
            if(branch.equals("CO") || branch.equals("IF") || branch.equals("EJ") || branch.equals("co") || branch.equals("if") || branch.equals("ej"))
            {
                break;
            }
        }
        for(;;)
        {      
            System.out.println("Enter Semester (1-6): ");
            sem = s.nextInt()   ;
            if(sem<6)
            {
                break;
            }
        }
        while(true)
        {      
            System.out.println("Enter Exam (S for Summer/W for Winter): ");
            exam = s.nextLine();
            if(exam.equals("S") || exam.equals("s"))
            {   
                exam = "SUM";
                break;
            }
            else if(exam.equals("W") || exam.equals("w"))
            {
                exam = "WIN";
                break;
            }
        }
        while(true)
        {
            System.out.println("Enter number of subjects (less than 10)");
            nsub = s.nextInt();
            if(nsub<10)
            {
                for(i=0;i<nsub;i++)
                { 
                    System.out.println(i+1);  
                    System.out.println("Enter Subject " + (i+1) + " Name: \n");
                    subj[i] = s.nextLine();
                    System.out.println("Enter marks (Out of 100) for subject " + subj[i] + ":\n");
                    marks[i] = s.nextInt();
                }
                break;
            } 
        }
    }
    void result()
    {
        for(i=0;i<nsub;i++)
        {
            total += marks[i];
        }
        perc = ((total/100)*(nsub*100));
    }
    public static void main(String args[]) 
    {
        marksheet m = new marksheet();
        m.gd();
        m.result();    
    }
}