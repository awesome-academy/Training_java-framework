package tpiv.mvcthymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tpiv.mvcthymeleaf.entities.Employee;

//@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//public class EmployeeDao  extends HibernateDaoSupport{
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	public int saveEmployee(Employee e) {
//		String query = "insert into employees  values('" + e.getId() + "','" + e.getName()  + "','" + e.getAddress() + "')";
//		return jdbcTemplate.update(query);
//	}
//
//	public int updateEmployee(Employee e) {
//		String query = "update employees  set name='" + e.getName() + "' where id='" + e.getId() + "' ";
//		return jdbcTemplate.update(query);
//	}
//
//	public int deleteEmployee(Long id) {
//		String query = "delete from employees  where id='" + id + "' ";
//		return jdbcTemplate.update(query);
//	}
//
//	public List<Employee> loadAllEmployees() {
//		return jdbcTemplate.query("select id, name, address from employees", (result,
//				rowNum) -> new Employee(result.getInt("id"), result.getString("name"), result.getString("address")));
//	}
//
//	public Employee findElementById(Long id) {
//		String query = "select * from employees where id='" + id + "' ";
//		return jdbcTemplate.queryForObject(query, new EmployeeMapper());
//	}

//	@Transactional
//	public void employeeOperation(Employee e) {
//		saveEmployee(e);
//		updateEmployee(e);
//		deleteEmployee(e);
//	}
}
