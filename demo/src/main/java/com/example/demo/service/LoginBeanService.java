package com.example.demo.service;

import java.util.List;

import com.example.demo.model.LoginBean;

public interface LoginBeanService {
	public LoginBean insert(LoginBean loginBean);
	public LoginBean selectByEmail(String email);
	public void update(LoginBean loginBean);
	public LoginBean selectById(Integer memberid);
	public boolean checkLogin(LoginBean users);
	public List<LoginBean> findAll();
	public void delete(Integer memberid);
}
