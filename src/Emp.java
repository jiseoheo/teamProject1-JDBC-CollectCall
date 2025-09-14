
public class Emp {
	/*public int id;
	public String lastName;
	public int salary;
	
	@Override
	public String toString() {
	return "Emp [id=" + id + ", lastName = " + lastName + ", salary = " + salary + "]";
	}*/
	
	int employeeId;
	String firstName;
	String lastName;
	String email;
	String phoneNumber;
	String hireDate;
	String jobId;
	double salary;
	double commissionPct;
	int managerId;
	int departmentId;
	
	public String getString() {
		return "- 아이디 : " + employeeId + " | 성 : " + lastName + " | 이름 : " + firstName + " | email : " + email + " | 전화번호 : " + phoneNumber + " | 입사일 : " + hireDate + " | 직무아이디 : " + jobId + " | 급여 : " + salary + " | 커미션비율 : " + commissionPct + " | 관리자 아이디 : " + managerId + " | 부서 아이디 : " + departmentId;
		}
}
