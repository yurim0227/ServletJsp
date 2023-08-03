package kh.test.jdbckh.department.model.dto;

public class DepartmentDto {
//	--------------- -------- ------------ 
//	DEPARTMENT_NO   NOT NULL VARCHAR2(10) 
//	DEPARTMENT_NAME NOT NULL VARCHAR2(40) 
//	CATEGORY                 VARCHAR2(40) 
//	OPEN_YN                  CHAR(1)      
//	CAPACITY                 NUMBER
	private Integer departmentNo;
	private String departmentName;
	private String category;
	private String openYn;
	private String capacity;
	public DepartmentDto() {
	}
	public DepartmentDto(Integer departmentNo, String departmentName, String category, String openYn, String capacity) {
		super();
		this.departmentNo = departmentNo;
		this.departmentName = departmentName;
		this.category = category;
		this.openYn = openYn;
		this.capacity = capacity;
	}
	public Integer getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(Integer departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getOpenYn() {
		return openYn;
	}
	public void setOpenYn(String openYn) {
		this.openYn = openYn;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
}
