package com.example.demo.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.model.LoginBean;
import com.example.demo.repository.ILoginBeanDao;

@Repository
public class LoginBeanDaoImpl implements ILoginBeanDao{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public LoginBean insert(LoginBean loginBean) {
		String hql = "from LoginBean where email=:email";
		List<LoginBean> loginBean1 = null;
		
		try {
			loginBean1 = entityManager.createQuery(hql, LoginBean.class)
									 .setParameter("email", loginBean.getEmail())
									 .getResultList();
			if(loginBean1.size() == 0) {
				entityManager.persist(loginBean);
				return loginBean;
			}
		}catch(NoResultException e) {
			e.printStackTrace();
		}catch(NonUniqueResultException e) {
			System.out.println("NonUniqueResultException");;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public LoginBean selectByEmail(String email) {
		String hql = "from LoginBean where email=:email";
		LoginBean loginBean2 = null;
		try {
			loginBean2 = entityManager.createQuery(hql, LoginBean.class)
									 .setParameter("email", email)
									 .getSingleResult();
		}catch(NoResultException e) {
			;
		}catch(NonUniqueResultException e) {
			;
		}
		return loginBean2;
	}

	@Override
	public void update(LoginBean loginBean) {
		LoginBean resultBean = selectById(loginBean.getMemberid()); 
		if (resultBean != null) {
			resultBean.setFirstname(loginBean.getFirstname());
			resultBean.setLastname(loginBean.getLastname());
			resultBean.setGender(loginBean.getGender());
			resultBean.setBirthday(loginBean.getBirthday());
			resultBean.setMobile(loginBean.getMobile());
		}
		entityManager.detach(resultBean);
		entityManager.merge(loginBean);
	}

	@Override
	public LoginBean selectById(Integer memberid) {
		return entityManager.find(LoginBean.class, memberid);
	}
	
	public boolean checkLogin(LoginBean users) {
		String hql = "from LoginBean where email=:user and password=:pwd";
		LoginBean loginBean3 = null;
		try {
			loginBean3 = entityManager.createQuery(hql, LoginBean.class)
									 .setParameter("user", users.getEmail())
									 .setParameter("pwd", users.getPassword())
									 .getSingleResult();
			if(loginBean3!=null) {
				return true;
			}
		
		}catch(NoResultException e) {
			;
		}catch(NonUniqueResultException e) {
			;
		}
		return false;
	}
	
	@Override
	 public List<LoginBean> findAll() {
	  String hql = "FROM   LoginBean";
	  return entityManager.createQuery(hql, LoginBean.class)
	                .getResultList();
	 }
	
	@Override
	 public void delete(Integer memberid) {
		LoginBean loginBean = entityManager.find(LoginBean.class, memberid);
		entityManager.remove(loginBean);
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
}