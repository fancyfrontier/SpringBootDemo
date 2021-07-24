package com.example.demo.repository;

import com.example.demo.model.LoginBean;

public interface ILoginBeanDao {

	public LoginBean insert(LoginBean loginBean);
	public LoginBean selectByEmail(String email);
	public void update(LoginBean loginBean);
	public LoginBean selectById(Integer memberid);
	public boolean checkLogin(LoginBean users);

}
