package com.seven.controller;
import com.seven.entity.Theme;
import com.seven.service.NewsService;
import com.seven.service.ThemeService;
import com.seven.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RequestMapping("/theme")
@Controller
public class ThemeController {
	@Autowired
	private ThemeService themeService;
	@Autowired
	private NewsService newsService;
	@ResponseBody
	@RequestMapping(value = "/getNewsCount",method= RequestMethod.GET)
	public Result<Integer> getNewsCount(Model model, @RequestParam("themeId") int themeId) {
		int count=newsService.getNewsCountBythemeId(themeId);
		return Result.success(count);
	}

	@RequestMapping("/themeList")
	public String listTheme(Model model) {
        List<Theme> themeList=themeService.findAllThemes();
		model.addAttribute("themeList",themeList);
		return "admin/themeList";
	}

    @RequestMapping("/themeAdd")
    public String themeAdd() {
        return "admin/themeAdd";
    }

    @RequestMapping("/themeModify")
    public String themeModify(HttpServletRequest request, Model model, @RequestParam("themeID")int themeID, @RequestParam("themeName")String themeName) throws UnsupportedEncodingException {
		themeName = new String(request.getParameter("themeName").getBytes("ISO-8859-1"), "UTF-8");
        model.addAttribute("themeID",themeID);
        model.addAttribute("themeName",themeName);
        return "admin/themeModify";
    }
	//@ResponseBody
	@RequestMapping("/addTheme")
	public void addTheme(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//@RequestParam("themeName")String themeName
		// 解决乱码问题
		String themeName=request.getParameter("themeName");
		//String themeName1 = new String(request.getParameter("themeName").getBytes("gbk"), "UTF-8");
		System.out.println("------------------------------------------"+themeName);
		Theme theme=new Theme();
		theme.setThemeName(themeName);
		int res=themeService.addTheme(theme);
		request.getRequestDispatcher("/theme/themeList").forward(request,response);
	}

	@RequestMapping("/delete")
	public void delete(@RequestParam("themeId")int themeId){
        themeService.deleteTheme(themeId);
	}

	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public void update(HttpServletRequest request, HttpServletResponse response, @RequestParam("themeID")int themeID, @RequestParam("themeName")String themeName) throws IOException, ServletException {
		//themeName = new String(request.getParameter("themeName").getBytes("ISO-8859-1"), "UTF-8");
        Theme theme=new Theme();
        theme.setThemeID(themeID);
        theme.setThemeName(themeName);
        int res=themeService.updateTheme(theme);
		request.getRequestDispatcher("/theme/themeList").forward(request,response);
	}
}
