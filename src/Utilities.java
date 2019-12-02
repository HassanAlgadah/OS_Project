import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Utilities {
    int HDD = 2000000;
    int ram = 32000;
    Queue<PCB> HDDQ = new PriorityQueue<>();
    Queue<PCB> RAMQ = new PriorityQueue<>();
    int nJobs = 1;
    int sizeJ = 0;
    double normally = 0;
    double abnormally = 0;

    public Utilities() {
    }

    public void genaratePCB() {
        while (HDD > 0) {
            PCB k = new PCB(nJobs++);
            HDDQ.add(k);
            HDD -= k.getSize();
            sizeJ += k.getSize();
        }
    }

    public void ToRam() {
            while (ram > 0) {
                if(HDDQ.isEmpty()){
                    break;
                }
                PCB k = HDDQ.remove();
                RAMQ.add(k);
                ram -= k.getSize();
            }
        }


    public Boolean IsInterrupt() {
        Random r = new Random();
        int k = r.nextInt(100);
        if (k <= 10) {
            return true;
        }
        return false;
    }

    public Boolean IsIOrequest() {
        Random r = new Random();
        int k = r.nextInt(100);
        if (k <= 20) {
            return true;
        }
        return false;
    }

    public Boolean IsIOtrminate() {
        Random r = new Random();
        int k = r.nextInt(100);
        if (k <= 20) {
            return true;
        }
        return false;
    }

    public Boolean IsNormally() {
        Random r = new Random();
        int k = r.nextInt(100);
        if (k <= 5) {
            normally++;
            return true;
        }
        return false;
    }

    public Boolean IsAbnormally() {
        Random r = new Random();
        int k = r.nextInt(100);
        if (k <= 1) {
            abnormally++;
            return true;
        }
        return false;
    }

}