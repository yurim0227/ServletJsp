package kh.lclass.db3.tbUser.model.service;

import java.util.List;

import kh.lclass.db3.tbUser.model.dto.TbUserDto;

public interface TbUserService {
	List<TbUserDto> selectList() throws Exception;
	int insert(TbUserDto tbUserDto) throws Exception;
	TbUserDto selectOne(String userId) throws Exception;
}
