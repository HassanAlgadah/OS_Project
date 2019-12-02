import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Queue;

public class CPU {
    public static void main(String[] args) {
        Queue<PCB> fnl = new LinkedList<>();
        Utilities u = new Utilities();
        u.genaratePCB();
        u.ToRam();
        while (!u.RAMQ.isEmpty()){
            u.ToRam();
            PCB k = u.RAMQ.remove();
            if(u.IsNormally()){
                k.setProcessState("normally");
            }else if(u.IsAbnormally()){
                k.setProcessState("abnormally");
            }else if(u.IsInterrupt()){
                k.setProcessState("Interrupted");
            }else if(u.IsIOrequest()){
                k.setProcessState("Busy");
            }else if(u.IsIOtrminate()){
                k.setProcessState("IOtrminate");
            }
            u.ram+=k.getSize();
            fnl.add(k);
        }
        File o2 = new File("OS");
        try{
            FileWriter fw = new FileWriter(o2);
            fw.write("The number of initially generated jobs stored on the H-disk = " + u.nJobs);
            fw.write(System.getProperty("line.separator"));
            fw.write("The average program size of all jobs: " + u.sizeJ/u.nJobs+"KB");
            fw.write(System.getProperty("line.separator"));
            fw.write("The average number of jobs that have completed their execution normally: " +(u.normally/u.nJobs)+" Jobs");
            fw.write(System.getProperty("line.separator"));
            fw.write("The average number of jobs that have completed their execution abnormally: " + u.abnormally / u.nJobs+" Jobs");
            fw.write(System.getProperty("line.separator"));
            fw.close();
        }catch(Exception e){
        }

        File o1 = new File("Jobs");
        try{
            FileWriter fw = new FileWriter(o1);
            while(!fnl.isEmpty()){
                PCB k = fnl.remove();
                fw.write("ID: " + k.getProcessID());
                fw.write(System.getProperty("line.separator"));
                fw.write("state: " +k.getProcessState());
                fw.write(System.getProperty("line.separator"));
                fw.write("size: " +k.getSize());
                fw.write(System.getProperty("line.separator"));
                fw.write("The expected execution time " + k.getExecutionTime());
                fw.write(System.getProperty("line.separator"));
                fw.write(System.getProperty("line.separator"));
                fw.write(System.getProperty("line.separator"));
            }
            fw.close();
        }catch(Exception e){
        }
    }
}
