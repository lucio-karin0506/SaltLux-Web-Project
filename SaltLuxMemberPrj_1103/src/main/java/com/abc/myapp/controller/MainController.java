package com.abc.myapp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abc.myapp.service.IStudentService;

/*
 * 메인 화면 뷰 페이지 및 url 매핑
 * */
@Controller
public class MainController {
	@Autowired
	IStudentService studentService;
	
	// 메인 화면 로그인 버튼 클릭 시 login.jsp로 이동
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}
	
	// 로그인 완료 시 loginHome.jsp로 이동
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView getAfterLoginPage(@RequestParam String id, @RequestParam String password, HttpServletRequest request, 
			ModelAndView mav) {		
		Map<String, Object> userLoginInfo = studentService.checkUser(id, password);
		
		HttpSession session = request.getSession();
		
		if(userLoginInfo != null) {
			// 로그인 성공, loginHome.jsp로 이동
			String userId = (String) userLoginInfo.get("email_id");
			String userPassword = (String) userLoginInfo.get("password");

            session.setAttribute("id", userId);
            session.setAttribute("password", userPassword);
            request.setAttribute("message", "로그인 성공했습니다.");
            mav.setViewName("loginHome");
		} else {
			// 로그인 실패, login.jsp로 이동
        	session.invalidate();
        	request.setAttribute("message", "로그인 실패했습니다.");
        	mav.setViewName("login");
		}
		return mav;
	}
	
	// 로그아웃 시 로그인 페이지 login.jsp로 이동
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/login";
	}
}
