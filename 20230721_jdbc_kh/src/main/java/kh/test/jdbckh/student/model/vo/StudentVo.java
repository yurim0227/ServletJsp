package kh.test.jdbckh.student.model.vo;

import java.sql.Date;

public class StudentVo {
//	------------------ -------- ------------- 
//	STUDENT_NO         NOT NULL VARCHAR2(10)  
//	DEPARTMENT_NO      NOT NULL VARCHAR2(10)  
//	STUDENT_NAME       NOT NULL VARCHAR2(40)  
//	STUDENT_SSN                 VARCHAR2(14)  
//	STUDENT_ADDRESS             VARCHAR2(200) 
//	ENTRANCE_DATE               DATE          
//	ABSENCE_YN                  CHAR(1)       
//	COACH_PROFESSOR_NO          VARCHAR2(20)
	private String studentNo;
	private String departmentNo;
	private String studentName;
	private String studentSsn;
	private String studentAddress;
	private Date entranceDate;
	private String absenceYn;
	private String coachProfessorNo;
	
	private String departmentName;
	
	@Override
	public String toString() {
		return "StudentVo [studentNo=" + studentNo + ", departmentNo=" + departmentNo + ", studentName=" + studentName
				+ ", studentSsn=" + studentSsn + ", studentAddress=" + studentAddress + ", entranceDate=" + entranceDate
				+ ", absenceYn=" + absenceYn + ", coachProfessorNo=" + coachProfessorNo + ", departmentName="
				+ departmentName + "]";
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentSsn() {
		return studentSsn;
	}
	public void setStudentSsn(String studentSsn) {
		this.studentSsn = studentSsn;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public Date getEntranceDate() {
		return entranceDate;
	}
	public void setEntranceDate(Date entranceDate) {
		this.entranceDate = entranceDate;
	}
	public String getAbsenceYn() {
		return absenceYn;
	}
	public void setAbsenceYn(String absenceYn) {
		this.absenceYn = absenceYn;
	}
	public String getCoachProfessorNo() {
		return coachProfessorNo;
	}
	public void setCoachProfessorNo(String coachProfessorNo) {
		this.coachProfessorNo = coachProfessorNo;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}
