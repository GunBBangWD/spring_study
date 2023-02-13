package study08;

public class Manager {
	static int seqNum2 = 2000;
	
	private int managerId;
	private String managerName;
	
	public Manager(String managerName) {
		managerId=seqNum2++;
		this.managerName=managerName;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
}
