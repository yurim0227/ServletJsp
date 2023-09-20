package kh.lclass.db2.tbUser.model.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class TbUserDto {
	private int userNo;
	private String userId;
	private String userName;
	private int userAge;
}
