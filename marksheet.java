import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
class marksheet
{
    String fname, lname, branch, exam, roll,file,res,sres;
    String markings="\n";
    String text="";
    String[] subj = new String[10];
    int sem, nsub, i, subtotal ,total=0;
    int[] marks = new int[10];  
    double perc = 0.0;
    Scanner s = new Scanner(System.in);
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));   

    void gd() throws IOException
    {
        System.out.println("Enter First Name: ");   
        fname = r.readLine();
        System.out.println("Enter Last Name: ");
        lname = r.readLine();
        System.out.println("Enter Roll No: ");
        roll = r.readLine();
        file = roll+".txt";
        for(;;)
        {      
            System.out.println("Enter Branch (CO/IF/EJ): ");
            branch = r.readLine();
            System.out.println(branch);
            if(branch.equals("CO") || branch.equals("IF") || branch.equals("EJ") || branch.equals("co") || branch.equals("if") || branch.equals("ej"))
            {
                break;
            }
        }
        for(;;)
        {      
            System.out.println("Enter Semester (1-6): ");
            sem = Integer.parseInt(r.readLine());
            if(sem<6)
            {
                break;
            }
        }
        for(;;)
        {      
            System.out.println("Enter Exam (S for Summer/W for Winter): ");
            exam = r.readLine();
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
            nsub = Integer.parseInt(r.readLine());
            if(nsub<10)
            {
                for(i=0;i<nsub;i++)
                { 
                    System.out.println("Enter Subject " + (i+1) + " Name: ");
                    subj[i] = r.readLine();
                    while(true)
                    {
                        System.out.println("Enter marks (Out of 100) for subject " + subj[i] + ":");
                        marks[i] = Integer.parseInt(r.readLine());
                        if(marks[i]<=100)
                            break;
                    }
                }
                break;
            } 
        }
        subtotal = nsub * 100;
    }

    void result() throws IOException
    {
        for(i=0;i<nsub;i++)
        {
            total += marks[i];
        }
        perc = (((double)total/(double)subtotal)*100.00);
        DecimalFormat df = new DecimalFormat("#.00");
        df.format(perc);
        for(i=0;i<nsub;i++)
        {
            if(marks[i]<28)
            {       
                res = "FAIL";
                break;
            }
            else
            {
                res = "PASS";
            }
        }
    }

    void sheeet() throws IOException
    {   
        for(i=0;i<nsub;i++)
        {   
            sres = (marks[i]>28)?("\t\tPASS"):("\t\tFAIL");
            markings = markings.concat("\n"+subj[i]+":\t\t"+marks[i]+sres+"\n");
        } 
        File f = new File(file);    
        f.createNewFile();
        System.out.println("File created: " + f.getName());
        FileWriter fw = new FileWriter(file);
        text = ("Name: "+fname+" "+lname+"\t\t\t\tRoll Number: "+roll+"\n\nBranch: "+branch+"\t\tSem: "+sem+"\t\t\t\tExam: "+exam+markings+"\nTotal: "+total+"\t\tPerecntage: "+perc+"\t\tRESULT: "+res);
        System.out.println(text);
        fw.write(text);
        fw.close();
    }
    public static void main(String args[]) throws IOException
    {
        marksheet m = new marksheet();
        m.gd();
        m.result();    
        m.sheeet();
    }
}