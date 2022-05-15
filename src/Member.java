
public class Member {
	private String fname,lname,newuname,newpwd;

	public Member() {
		super();
	}

	public Member(String fname, String lname, String newuname, String newpwd) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.newuname = newuname;
		this.newpwd = newpwd;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getNewuname() {
		return newuname;
	}

	public void setNewuname(String newuname) {
		this.newuname = newuname;
	}

	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
}
	
