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
        boolean check = true;
        do
        {      
            System.out.println("Enter Branch (CO/IF/EJ): ");
            branch = s.nextLine();
            if(branch == "CO" || branch == "IF" || branch == "EJ" || branch == "co" || branch == "if" || branch == "ej")
            {
                break;
            }
        }while(check);
        check = true;
        for(;;)
        {      
            System.out.println("Enter Semester (1-6): ");
            sem = s.nextInt()   ;
            if(sem>6)
            {
                break;
            }
        }
        check =  true;
        while(check==true)
        {      
            System.out.println("Enter Exam (S for Summer/W for Winter): ");
            exam = s.nextLine();
            if(exam == "S" || exam == "s")
            {
                check = false;
                exam = "SUM";
            }
            else if(exam == "W" || exam == "w")
            {
                check = false;
                exam = "WIN";
            }
        }
        check = true;
        while(check==true)
        {
            System.out.println("Enter number of subjects (less than 10)");
            nsub = s.nextInt();
            for(i=0;i<nsub;i++)
            {
                System.out.println("Enter Subject " + i+1 + "Name: ");
                subj[i] = s.nextLine();
                System.out.println("Enter marks (Out of 100) for subject " + subj[i] + ":");
                marks[i] = s.nextInt();
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