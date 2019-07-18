package com.seven.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seven.entity.News;
import com.seven.entity.Theme;
import com.seven.service.NewsService;
import com.seven.service.ThemeService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/index")
public class IndexController {
	@Autowired
	private NewsService newsServiceObject;

	@Autowired
	private ThemeService themeServiceObject;
	
	// 用于保存新闻列表
	private List<News> newsList_class = null;
	private List<News> themeList = null;
	private List<News> chinaNewsList = null;
	private List<News> intelNewsList = null;
	private List<News> playNewsList = null;
	
	@RequestMapping("/main")
	public String mainPage(Model model) {
		// 查询新闻
		List<News> newsList = newsServiceObject.getAllNews();
		model.addAttribute("newsList", newsList);

		// 查询所有主题
		List<Theme> themeList = themeServiceObject.findAllThemes();
		model.addAttribute("themeList", themeList);
		
		// 查询主题信息
		List<News> chinaNewsList = newsServiceObject.findAllNewsByThemeId(1);
		model.addAttribute("chinaNewsList", chinaNewsList);
		List<News> intelNewsList = newsServiceObject.findAllNewsByThemeId(2);
		model.addAttribute("intelNewsList", intelNewsList);
		List<News> playNewsList = newsServiceObject.findAllNewsByThemeId(5);
		model.addAttribute("playNewsList", playNewsList);
		
		// 保存到类的属性中
		newsList_class = newsList;
		return "index";
	}
	
	@RequestMapping("/readNews")
	public String readNewsFunc(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		String newsTitle= request.getParameter("newsTitle");
		//根据主题查询新闻
		System.out.println("-----------------------+"+newsTitle+"+");
		News aNews = newsServiceObject.findNewsByTitle(newsTitle);
		System.out.println("-----------------------+"+aNews+"+");
		model.addAttribute("news", aNews);
		System.out.println("-----------------------+"+aNews.getNewsCreatedate()+"+");
		System.out.println("-----------------------+"+aNews.getNewsModifydate()+"+");
		// 查询主题信息
		List<News> chinaNewsList = newsServiceObject.findAllNewsByThemeId(1);
		model.addAttribute("chinaNewsList", chinaNewsList);
		List<News> intelNewsList = newsServiceObject.findAllNewsByThemeId(2);
		model.addAttribute("intelNewsList", intelNewsList);
		List<News> playNewsList = newsServiceObject.findAllNewsByThemeId(5);
		model.addAttribute("playNewsList", playNewsList);
		System.out.println("-----------------------+"+chinaNewsList+"+");
		System.out.println("-----------------------+"+chinaNewsList.size()+"+");
		//再次添加分类新闻
		return "newsRead";
	}


	@RequestMapping("/readNewsId")
	public String readNewsId(@RequestParam("newsId")int newsId, HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		//根据Id查询新闻
		News aNews = newsServiceObject.findNewsById(newsId);
		System.out.println("-----------------------+"+aNews+"+");
		model.addAttribute("news", aNews);
		System.out.println("-----------------------+"+aNews.getNewsCreatedate()+"+");
		System.out.println("-----------------------+"+aNews.getNewsModifydate()+"+");
		// 查询主题信息
		List<News> chinaNewsList = newsServiceObject.findAllNewsByThemeId(1);
		model.addAttribute("chinaNewsList", chinaNewsList);
		List<News> intelNewsList = newsServiceObject.findAllNewsByThemeId(2);
		model.addAttribute("intelNewsList", intelNewsList);
		List<News> playNewsList = newsServiceObject.findAllNewsByThemeId(5);
		model.addAttribute("playNewsList", playNewsList);
		System.out.println("-----------------------+"+chinaNewsList+"+");
		System.out.println("-----------------------+"+chinaNewsList.size()+"+");
		//再次添加分类新闻
		return "newsRead";
	}
	@RequestMapping("/newsList")
	public String newsListFunc(int themeID, Model model) {
		List<News> newsList = newsServiceObject.findAllNewsByThemeId(themeID);
		model.addAttribute("newsList", newsList);

		// 查询所有主题
		List<Theme> themeList = themeServiceObject.findAllThemes();
		model.addAttribute("themeList", themeList);

		// 查询主题信息
		List<News> chinaNewsList = newsServiceObject.findAllNewsByThemeId(1);
		model.addAttribute("chinaNewsList", chinaNewsList);
		List<News> intelNewsList = newsServiceObject.findAllNewsByThemeId(2);
		model.addAttribute("intelNewsList", intelNewsList);
		List<News> playNewsList = newsServiceObject.findAllNewsByThemeId(5);
		model.addAttribute("playNewsList", playNewsList);
		return "index";
	}
}
