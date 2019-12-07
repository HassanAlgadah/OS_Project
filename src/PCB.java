import java.util.Random;

public class PCB implements Comparable<PCB> {
	private Integer executionTime;
	private int processID;
	private String processState ;
	private int size;
	private boolean isInterrupted ;


	public PCB(int processID) {
		this.processID = processID;
		processState = "new";
		isInterrupted = false;
		Random r = new Random();
		size = r.nextInt(16378)+16;
		executionTime = r.nextInt(506)+16;
	}

	//a compare to method so we can use the interface Comparable
	@Override
	public int compareTo(PCB pcb) {
		return getExecutionTime().compareTo(pcb.getExecutionTime());
	}


	public Integer getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(int executionTime) {
		this.executionTime = executionTime;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getProcessID() {
		return processID;
	}

	public void setProcessID(int processID) {
		this.processID = processID;
	}

	public String getProcessState() {
		return processState;
	}

	public void setProcessState(String processState) {
		this.processState = processState;
	}

	public void setExecutionTime(Integer executionTime) {
		this.executionTime = executionTime;
	}

	public boolean getisInterrupted() {
		return isInterrupted;
	}

	public void setInterrupted(boolean interrupted) {
		isInterrupted = interrupted;
	}
}

