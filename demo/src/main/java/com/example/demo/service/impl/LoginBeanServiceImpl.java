package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.LoginBean;
import com.example.demo.repository.ILoginBeanDao;
import com.example.demo.service.LoginBeanService;

@Service
@Transactional
public class LoginBeanServiceImpl implements LoginBeanService {
	
	@Autowired
    ILoginBeanDao iLoginBeanDao;
 

	@Override
	public LoginBean insert(LoginBean loginBean) {
		
		return iLoginBeanDao.insert(loginBean);
	}

	@Override
	public LoginBean selectByEmail(String email) {
		
		return iLoginBeanDao.selectByEmail(email);
	}

	@Override
	public void update(LoginBean loginBean) {
		iLoginBeanDao.update(loginBean);
	}

	@Override
	public LoginBean selectById(Integer memberid) {
		return iLoginBeanDao.selectById(memberid);
	}
	
	@Override
	public boolean checkLogin(LoginBean users) {
		
		return iLoginBeanDao.checkLogin(users);
	}
	
	@Override
	public List<LoginBean> findAll() {
		
		return iLoginBeanDao.findAll();
	}
	@Override
	public void delete(Integer memberid) {
		iLoginBeanDao.delete(memberid);
	}

}
