package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.LoginBean;
import com.example.demo.service.LoginBeanService;
import com.example.demo.util.AESUtil;

@Controller
public class NewLoginController {
	
	@Autowired
	private LoginBeanService loginBeanService;
	
	
	@GetMapping("/NewLogin")
	public String showForm() {
		return "NewLogin";
	}
	

	@PostMapping("/UserCheckMemberData")
	public String checkMemberData(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, HttpServletRequest request, Model m) {

		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		boolean checkStatus = loginBeanService.checkLogin(new LoginBean(email, AESUtil.encryptString(password)));

		if (checkStatus) {
			LoginBean result = loginBeanService.selectByEmail(email);
			request.getSession().setAttribute("login", result.getMemberid());
			m.addAttribute("member", result);
			return "UserShowLogin";
		}

		errors.put("message", "please input correct username and password");
		return "Error";
	}
	
	
	@PostMapping("/UserGetMemberData")
	public String getMemberLogin(@RequestParam(name = "memberid") Integer memberid, Model m) {
		
		LoginBean result = loginBeanService.selectById(memberid);
		m.addAttribute("member", result);
		
		return "UserUpdatePage";
	}
	
	
	@PostMapping("/UserUpdateMemberData")
	public String updateData(@RequestParam(name = "memberid") Integer memberid, HttpServletRequest request, Model m) {
		System.out.println("memberid = " + memberid);
		LoginBean loginBean = loginBeanService.selectById(memberid);
		loginBean.setFirstname(request.getParameter("firstname"));
		loginBean.setLastname(request.getParameter("lastname"));
		loginBean.setGender(request.getParameter("gender"));
		loginBean.setBirthday(request.getParameter("birthday"));
		loginBean.setMobile(request.getParameter("mobile"));
		loginBeanService.update(loginBean);
		LoginBean member = loginBeanService.selectById(memberid); 		
		m.addAttribute("member", member);
		
		return "UserShowLogin";
	}
	
	
	@PostMapping("/Registermember")
	public String registermember(@RequestParam(name = "email") String email, 
								 @RequestParam(name = "password") String password, Model m) {
		LoginBean insertbean = new LoginBean();
		insertbean.setEmail(email);
		insertbean.setPassword(AESUtil.encryptString(password));
		LoginBean result = loginBeanService.insert(insertbean);
		if(result==null) {
			Map<String, String> errors = new HashMap<String, String>();
			m.addAttribute("errors", errors);
			errors.put("message", "email????????????");
			return "Error";
		}
		m.addAttribute("member", result);
		
		return "UserShowLogin";

	}
	
	@GetMapping("/SystemUpdateMember")
	public String toSystemUpdateMember(@RequestParam(name = "memberid") Integer memberid, Model m) {
		
		LoginBean result = loginBeanService.selectById(memberid);
		m.addAttribute("member", result);
		
		return "SystemUpdateMember";
	}
	
	@PostMapping("/SystemToUpdateMember")
	public String systemUpdate(@RequestParam(name = "memberid") Integer memberid, HttpServletRequest request, Model m) {
		System.out.println("memberid = " + memberid);
		LoginBean loginBean = loginBeanService.selectById(memberid);
		loginBean.setFirstname(request.getParameter("firstname"));
		loginBean.setLastname(request.getParameter("lastname"));
		loginBean.setGender(request.getParameter("gender"));
		loginBean.setBirthday(request.getParameter("birthday"));
		loginBean.setMobile(request.getParameter("mobile"));
		loginBeanService.update(loginBean);
		
		List<LoginBean> memberData = loginBeanService.findAll();
		m.addAttribute("memberData", memberData);
		return "SystemShowMember";
	}

	@GetMapping("/SystemShowMember")
	 public String showAllMemberData(Model m) {
		List<LoginBean> memberData = loginBeanService.findAll();
		m.addAttribute("memberData", memberData);
		return "SystemShowMember";
	 }
	
	@GetMapping("/ToDeleteMember")
	 public String deleteMember(@RequestParam(name = "memberid") Integer memberid, Model m) {
		loginBeanService.delete(memberid);
		List<LoginBean> memberData = loginBeanService.findAll();
		m.addAttribute("memberData", memberData);
		return "SystemShowMember";
	 }
	
	@GetMapping("/newLogout")
	public String logout(HttpServletRequest request) {
		if(request.getSession().getAttribute("login")!=null) {
			request.getSession().invalidate();
		}
		return "NewLogin";
	}

}



//@RequestMapping(path="/newCheckMemberData.controller", method = RequestMethod.POST)
//public String checkMemberData(@RequestParam(name = "email") String email,
//		@RequestParam(name = "password") String password, HttpServletRequest request, Model m) {
//
//	Map<String, String> errors = new HashMap<String, String>();
//	m.addAttribute("errors", errors);
//	
//	boolean checkStatus = loginBeanService.checkLogin(new LoginBean(email, AESUtil.encryptString(password)));
//
//	if (checkStatus) {
//		
//		LoginBean result = loginBeanService.selectByEmail(email);
//		request.getSession().setAttribute("login", result.getMemberid());
//		
//		m.addAttribute("member", result);
//		
//		return "NewShowLogin";
//	}
//
//	errors.put("message", "please input correct username and password");
//	return "Error";
//}
