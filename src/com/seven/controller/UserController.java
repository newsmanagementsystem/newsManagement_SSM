package com.seven.controller;
import com.seven.entity.News;
import com.seven.entity.Theme;
import com.seven.entity.User;
import com.seven.service.NewsService;
import com.seven.service.ThemeService;
import com.seven.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@Controller
public class UserController  {
	@Autowired
	private UserService userService;
	@Autowired
	private ThemeService themeService;
	@Autowired
	private NewsService newsService;

	@RequestMapping("/register1")
	public String register2(User user,HttpServletResponse response){
		if (userService.addUser(user)){
			return "index";
		}else
			return "regis";
	}
	@RequestMapping("/check")
	@ResponseBody
	public Map<String, String> check(@Param("userName") String userName) {
		boolean userNameIsExit = userService.checkUserNameIsExit(userName);
		Map<String, String> map = new HashMap<>();
		if (userNameIsExit != true) {
			map.put("msg", "1");
		} else {
			map.put("msg", "2");
		}
		return map;
	}


	@ResponseBody
	@RequestMapping(value="/login",method= RequestMethod.POST)
	public User login(User user,HttpServletRequest request) {//登录验证
		System.out.println("----------------------login----------------------------");
		User u = new User();
		boolean exist=false;
		exist = userService.checkUserNameIsExit(user.getUserName());
		System.out.println("-----------------------------------"+exist);
		//根据判断结果进行决定是否添加用户
		if (exist) {
			//查询用户
			u = userService.getUserByUserName(user.getUserName());
			//将用户名写入到Session中
			request.getSession().setAttribute("login", user.getUserName());
			return u;
		} else {
			//用户不存在
			u.setUserName("");
			System.out.println("不存在："+user.getUserName());
			return u;
		}
	}
	@RequestMapping(value="/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("----------------------logout----------------------------");
		System.out.println("退出的Servlet进去了");
		// 设置字符编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//获取Session对象
		HttpSession session = request.getSession(true);
		//让Session过期
		session.invalidate();
		//给出退出提示
		response.sendRedirect(request.getContextPath()+"/user/mainPage");
//		request.getRequestDispatcher("/index.jsp").forward(request, response);
		//清空缓冲区并退出
		out.flush();
		out.close();
	}

	@RequestMapping(value="/mainPage")
	public void mainPage(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("mainpage");
		//获取Session
		HttpSession session = request.getSession();

		// 查询主题信息
		List<Theme> themeList = themeService.findAllThemes();
		session.setAttribute("themeList", themeList);

		// 查询新闻信息
		List<News> newsList = newsService.getAllNews();
		session.setAttribute("newsList", newsList);

		// 查询主题信息
		List<News> chinaNewsList = newsService.findAllNewsByThemeId(1);
		session.setAttribute("chinaNewsList", chinaNewsList);
		List<News> intelNewsList = newsService.findAllNewsByThemeId(2);
		session.setAttribute("intelNewsList", intelNewsList);
		List<News> playNewsList = newsService.findAllNewsByThemeId(5);
		session.setAttribute("playNewsList", playNewsList);

		// 返回页面
//		request.getRequestDispatcher("/index.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}


}
