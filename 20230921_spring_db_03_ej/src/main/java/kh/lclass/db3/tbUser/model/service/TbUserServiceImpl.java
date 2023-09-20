package kh.lclass.db3.tbUser.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.lclass.db3.tbUser.model.dao.TbUserDao;
import kh.lclass.db3.tbUser.model.dto.TbUserDto;

@Service
public class TbUserServiceImpl implements TbUserService {
	@Autowired
	private TbUserDao tbUserDao;
	
	@Override
	public List<TbUserDto> selectList() throws Exception {
		return tbUserDao.selectList();
	}
	
	@Override
	public int insert(TbUserDto tbUserDto) throws Exception {
		return tbUserDao.insert(tbUserDto);
	}
	
	@Override
	public TbUserDto selectOne(String userId) throws Exception {
		return tbUserDao.selectOne(userId);
	}
}
