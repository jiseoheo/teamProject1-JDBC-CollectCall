

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpDAO {
	/*public static List<Emp> getEmpListByHireYear(String hireYear) throws Exception{
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = conn.createStatement();
		String sql = "select * from employees where year(hire_date) = '" + hireYear + "'";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.salary = rs.getInt("salary");
			result.add(emp);
		}
		return result;
	}
	
			Dep dep = new Dep();
			dep.departmentName = rs.getString("d.department_id");
			dep.depatrmentId = rs.getInt("d.depatrment_id");
			dep.locationId = rs.getInt("d.location_id");
			dep.managerId = rs.getInt("manager_id");
			
			Loc loc = new Loc();
			loc.city = rs.getString("l.city");
			loc.countryId = rs.getString("l.country_id");
			loc.locationId = rs.getInt("l.location_id");
			loc.postalCode = rs.getString("l.postal_code");
			loc.stateProvince = rs.getString("l.state_province");
			loc.streetAddress = rs.getString("l.street_address");
			*/
	
	//1번
	/*
	select *
	from employees
	where last_name = 'King';
	*/
	public static List<Emp> getEmpListByLastName(String lastName) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = con.createStatement();
		String sql = "select * from employees where last_name = '" + lastName + "'";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Emp emp = new Emp();
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.lastName = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phoneNumber = rs.getString("phone_number");
			emp.hireDate = rs.getString("hire_date");
			emp.jobId = rs.getString("job_id");
			emp.salary = rs.getDouble("salary");
			emp.commissionPct = rs.getDouble("commission_pct");
			emp.managerId = rs.getInt("manage_id");
		}
		return result;
	}
	
	// 2번
	/*
	 select *
	from employees
	where hire_date like '2015%';
	 */
	public static List<Emp> getEmpListByHireYear(String hireYear) throws Exception{
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = conn.createStatement();
		String sql = "select * from employees where year(hire_date) = '" + hireYear + "'";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Emp emp = new Emp();
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.lastName = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phoneNumber = rs.getString("phone_number");
			emp.hireDate = rs.getString("hire_date");
			emp.jobId = rs.getString("job_id");
			emp.salary = rs.getDouble("salary");
			emp.commissionPct = rs.getDouble("commission_pct");
			emp.managerId = rs.getInt("manage_id");
			result.add(emp);
		}
		return result;
	}
	
	// 3번
	/*select *
from employees
where
department_id  IS NOT NULL
and department_id = 20#입력값
*/
	public static List<Emp> getEmpListByDepatrmentId(int departmentId) throws Exception{
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = conn.createStatement();
		String sql = "select * from employees where department_id is not null and department_id = " + departmentId;
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Emp emp = new Emp();
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.lastName = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phoneNumber = rs.getString("phone_number");
			emp.hireDate = rs.getString("hire_date");
			emp.jobId = rs.getString("job_id");
			emp.salary = rs.getDouble("salary");
			emp.commissionPct = rs.getDouble("commission_pct");
			emp.managerId = rs.getInt("manage_id");
			result.add(emp);
		}
		return result;
	}
	
	// 4번
	/*select *
	from employees
	where job_id = 'IT_PROG'#입력값
	;*/
	public static List<Emp> getEmpListByJobId(String jobId) throws Exception{
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = conn.createStatement();
		String sql = "select * from employees where job_id = '" + jobId + "'";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Emp emp = new Emp();
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.lastName = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phoneNumber = rs.getString("phone_number");
			emp.hireDate = rs.getString("hire_date");
			emp.jobId = rs.getString("job_id");
			emp.salary = rs.getDouble("salary");
			emp.commissionPct = rs.getDouble("commission_pct");
			emp.managerId = rs.getInt("manage_id");
			result.add(emp);
		}
		return result;
	}
	
	// 5번
	/*
	(
			select *
			from employees e
			left join departments d on e.department_id = d.department_id
			left join locations l on d.location_id = l.location_id
			where l.city ='Seattle'#입력값
			)
			union
			(
			select *
			from employees e
			right join departments d on e.department_id = d.department_id
			right join locations l on d.location_id = l.location_id
			where l.city ='Seattle'#입력값
			)*/
	public static List<Emp> getEmpListByCityName(String cityName) throws Exception{
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = conn.createStatement();
		String sql = "(select * from employees e left join departments d on e.department_id = d.department_id left join locations l on d.location_id = l.location_id where l.city ='" + cityName + "')union(select * from employees e right join departments d on e.department_id = d.department_id right join locations l on d.location_id = l.location_id where l.city ='" + cityName + "')";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Emp emp = new Emp();
			emp.employeeId = rs.getInt("e.employee_id");
			emp.firstName = rs.getString("e.first_name");
			emp.lastName = rs.getString("e.last_name");
			emp.email = rs.getString("e.email");
			emp.phoneNumber = rs.getString("e.phone_number");
			emp.hireDate = rs.getString("e.hire_date");
			emp.jobId = rs.getString("e.job_id");
			emp.salary = rs.getDouble("e.salary");
			emp.commissionPct = rs.getDouble("e.commission_pct");
			emp.managerId = rs.getInt("e.manage_id");
			result.add(emp);
		}
		return result;
	}
	
	// 7번
	/*부서장 성으로 부서원을 검색할 수 있는가? -서브쿼리 필수
	select *
	from employees
	where department_id = (select e.department_id
	from departments d left join employees e on d.manager_id = e.employee_id
	where e.last_name = 'King');*/
	public static List<Emp> getEmpListByDepManagerLastName(String lastName) throws Exception{
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = conn.createStatement();
		String sql = "select * from employees where department_id = (select e.department_id from departments d left join employees e on d.manager_id = e.employee_id from departments d left join employees e on d.manager_id = e.employee_id where e.last_name = '" + lastName + "')";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Emp emp = new Emp();
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.lastName = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phoneNumber = rs.getString("phone_number");
			emp.hireDate = rs.getString("hire_date");
			emp.jobId = rs.getString("job_id");
			emp.salary = rs.getDouble("salary");
			emp.commissionPct = rs.getDouble("commission_pct");
			emp.managerId = rs.getInt("manage_id");
			result.add(emp);
		}
		return result;
	}
	
	// 8번
	/*(
			select *
			from employees e
			left join departments d on e.department_id = d.department_id
			left join locations l on d.location_id = l.location_id
			left join countries c on l.country_id = c.country_id
			where c.country_name = 'Canada'#입력값
			)
			union #union은 기본적으로 중복을 제거하는 역할을 한다.
			(
			select *
			from employees e
			right join departments d on e.department_id = d.department_id
			right join locations l on d.location_id = l.location_id
			right join countries c on l.country_id = c.country_id
			where c.country_name = 'Canada'#입력값
			)
			;*/
	public static List<Emp> getEmpListByCountryName(String contryName) throws Exception{
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = conn.createStatement();
		String sql = "(select * from employees e left join departments d on e.department_id = d.department_id left join locations l on d.location_id = l.location_id left join countries c on l.country_id = c.country_id where c.country_name = '" + contryName + "')union(select * from employees e right join departments d on e.department_id = d.department_id right join locations l on d.location_id = l.location_id right join countries c on l.country_id = c.country_id where c.country_name = '" + countryName + "')";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Emp emp = new Emp();
			emp.employeeId = rs.getInt("e.employee_id");
			emp.firstName = rs.getString("e.first_name");
			emp.lastName = rs.getString("e.last_name");
			emp.email = rs.getString("e.email");
			emp.phoneNumber = rs.getString("e.phone_number");
			emp.hireDate = rs.getString("e.hire_date");
			emp.jobId = rs.getString("e.job_id");
			emp.salary = rs.getDouble("e.salary");
			emp.commissionPct = rs.getDouble("e.commission_pct");
			emp.managerId = rs.getInt("e.manage_id");
			result.add(emp);
		}
		return result;
	}

}

