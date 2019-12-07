import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Utilities {
    //Hardware specifications
    int HDD = 2000000;
    int ram = 32000;
    //PriorityQueue from the java Library
    Queue<PCB> HDDQ = new PriorityQueue<>();
    Queue<PCB> RAMQ = new PriorityQueue<>();

    //counters
    int nJobs = 1;
    int sizeJ = 0;
    double normally = 0;
    double abnormally = 0;

    //default constrictor
    public Utilities() {
    }

    //generating the jobs to the HDD
    public void genaratePCB() {
        while (HDD > 0) {
            nJobs++;
            PCB k = new PCB(nJobs);
            k.setBasedOnSize(true);
            HDDQ.add(k);
            HDD -= k.getSize();
            sizeJ += k.getSize();
        }
    }

    //removing the jobs from HDD to Ram
    public void ToRam() {
        while (ram > 0) {
            if (HDDQ.isEmpty()) {
                break;
            }
            PCB k = HDDQ.remove();
            k.setBasedOnSize(false);
            RAMQ.add(k);
            ram -= k.getSize();
        }
    }

    //checking if an interrupt happened
    public Boolean IsInterrupt() {
        Random r = new Random();
        int k = r.nextInt(100);
        //10%
        if (k <= 10) {
            return true;
        }
        return false;
    }

    //checking if an IO request happened
    public Boolean IsIOrequest() {
        Random r = new Random();
        int k = r.nextInt(100);
        //20%
        if (k <= 20) {
            return true;
        }
        return false;
    }

    //checking if IO terminated happened
    public Boolean IsIOtrminate() {
        Random r = new Random();
        int k = r.nextInt(100);
        //20%
        if (k <= 20) {
            return true;
        }
        return false;
    }

    //checking if the job terminated normally happened
    public Boolean IsNormally() {
        Random r = new Random();
        int k = r.nextInt(100);
        //5%
        if (k <= 5) {
            normally++;
            return true;
        }
        return false;
    }

    ////checking if the job terminated Abnormally happened
    public Boolean IsAbnormally() {
        Random r = new Random();
        int k = r.nextInt(100);
        //1%
        if (k <= 1) {
            abnormally++;
            return true;
        }
        return false;
    }

}