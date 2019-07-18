package com.seven.controller;
import com.seven.entity.News;
import com.seven.entity.Theme;
import com.seven.service.NewsService;
import com.seven.service.ThemeService;
import com.seven.util.PageBean;
import com.seven.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/news")
@Controller
public class NewsController {
	@Autowired
	private NewsService newsService;
	@Autowired
	private ThemeService themeService;
	@ResponseBody
	@RequestMapping("/getNews")
	public Result<List<News>> getNews(){
		System.out.println("--------------------------getNews------------------------------------");
		//newsService.getNews();返回list
		int count=newsService.getNewsCountBythemeId(5);
		System.out.println("--------------------------count:"+count+"------------------------------------");
		System.out.println("--------------------------getNews------------------------------------");
        List<News> list=newsService.getAllNews();
        // 包装json返回给前端
		return Result.success(list);
	}

	@RequestMapping("/newsAdd")
	public void newsAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Theme> themeList = new ArrayList<Theme>();
		themeList = themeService.findAllThemes();
		request.setAttribute("themeList", themeList);
		//转发页面
		request.getRequestDispatcher("admin/newsAdd.jsp").forward(request, response);
	}

	@RequestMapping("/newsModify")
	public String newsModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//把所有主题加载出来
		List<Theme> themeList = new ArrayList<Theme>();
		themeList = themeService.findAllThemes();
		request.setAttribute("themeList", themeList);
		int nid = Integer.parseInt(request.getParameter("nid"));

		News news = newsService.findNewsById(nid);
		request.setAttribute("news", news);
		return "admin/newsModify";
	}


	@RequestMapping("/deleteNews")
	public void deleteNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nid = Integer.parseInt(request.getParameter("nid"));
		int result = newsService.deleteNewsById(nid);
		request.getRequestDispatcher("/news/listNews").forward(request,response);
	}

	@RequestMapping("/updateNews")
	public void updateNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String nowDate = df.format(new Date());
		News news = new News();
		//String ntitle = new String(request.getParameter("ntitle").getBytes("ISO-8859-1"), "UTF-8");
		//String ncontent = new String(request.getParameter("ncontent").getBytes("ISO-8859-1"), "UTF-8");
		//String nsummary = new String(request.getParameter("nsummary").getBytes("ISO-8859-1"), "UTF-8");
		String ntitle = request.getParameter("ntitle");
		String nsummary = request.getParameter("nsummary");
		String ncontent = request.getParameter("ncontent");
		String npicPath = request.getParameter("file");
		news.setNewsId(Integer.parseInt(request.getParameter("nid")));
		news.setThemeId(Integer.parseInt(request.getParameter("ntid")));
		news.setNewsAuthor(request.getParameter("nauthor"));
		news.setNewsTitle(ntitle);
		news.setNewsSummary(nsummary);
		news.setNewsContent(ncontent);
		news.setNewsPicpath(request.getParameter("file"));
		news.setNewsModifydate(nowDate);
		// 用于保存当前路径
		String contextPath = request.getContextPath();
		// 创建out对象
		PrintWriter out = response.getWriter();
		// 创建业务逻辑层对象
		int result = newsService.updateNews(news);
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/news/listNews").forward(request,response);
	}

	@RequestMapping("/listNews")
	public String listNews(Model model,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("");
		request.setCharacterEncoding("utf-8");
		int currentPage;
		int pageSize = 7;
		if(request.getParameter("currentPage") == null){
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		PageBean<News> pageBean = newsService.getPageBean(currentPage,pageSize);
		System.out.println(pageBean.toString());
		request.setAttribute("pB",pageBean);
		//model.addAttribute("pB",pageBean);
		//request.getRequestDispatcher("/news/newsList").forward(request,response);
		return "admin/newsList";
	}

	@RequestMapping("/toaddNews")
	public String toaddNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//把所有主题加载出来
		List<Theme> themeList = new ArrayList<Theme>();
		themeList = themeService.findAllThemes();
		request.setAttribute("themeList", themeList);
		return "admin/newsAdd";
	}
	@RequestMapping("/addNews")
	public void addNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		News news = new News();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String ceateDate = df.format(new Date());
		String ntid = request.getParameter("ntid");
		System.out.println(ntid);
		String title = request.getParameter("ntitle");
		String author = request.getParameter("nauthor");
		String summary = request.getParameter("nsummary");
		String content = request.getParameter("ncontent");
		String picPath = request.getParameter("file");
		String newPic="/pic/"+picPath;
		System.out.println("new:"+newPic);
		//String title = new String(request.getParameter("ntitle").getBytes("ISO-8859-1"), "UTF-8");
		//String content = new String(request.getParameter("ncontent").getBytes("ISO-8859-1"), "UTF-8");
		//String summary = new String(request.getParameter("nsummary").getBytes("ISO-8859-1"), "UTF-8");
		news.setThemeId(Integer.parseInt(ntid));
		news.setNewsTitle(title);
		news.setNewsAuthor(author);
		news.setNewsSummary(summary);
		news.setNewsContent(content);
		news.setNewsPicpath(newPic);
		news.setNewsCreatedate(ceateDate);
		news.setNewsModifydate(ceateDate);
		System.out.println(news.toString());
		//这里调用service方法保存
		newsService.addNews(news);
		//这里再做跳转操作
		request.getRequestDispatcher("/news/listNews").forward(request,response);
	}


}
