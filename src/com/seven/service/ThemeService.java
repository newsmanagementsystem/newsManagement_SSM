package com.seven.service;

import com.seven.dao.ThemeDao;
import com.seven.entity.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThemeService{
    @Autowired
    private ThemeDao themeDao;

    public int addTheme(Theme theme) {
        //执行添加主题方法
        return themeDao.addTheme(theme);
    }


    public boolean checkThemeIfExist(String themeName) {
        Theme theme=themeDao.checkThemeIfExist(themeName);
        //执行查询主题方法
        if (theme!=null) return true;
        return false;
    }

    public List<Theme> findAllThemes() {
        return themeDao.findAllThemes();
    }


    public int updateTheme(Theme theme) {
        return themeDao.updateTheme(theme);
    }


    public Theme findThemeByName(String name) {
        return themeDao.findThemeByName(name);
    }


    public int deleteTheme(int tid) {
        return themeDao.deleteTheme(tid);
    }

}
