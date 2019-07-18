package com.seven.dao;

import com.seven.entity.Theme;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface ThemeDao {
    @Insert("insert into themetable (themeID,themeName) values (#{themeID},#{themeName})")
    public int addTheme(Theme theme);

    //自增版本怎么考虑？？
    //@Insert("insert into themetable (themeID,themeName) values (#{themeID},#{themeName})")
    //public void addTheme(Theme theme);

    //public boolean checkThemeIfExist(String themeName);
    @Select("select count(*) from themetable where themeName=#{themeName}")
    public Theme checkThemeIfExist(@Param("themeName")String themeName);

    @Select("select * from themetable")
    public List<Theme> findAllThemes();

    // 更新主题
    @Update("update themetable set themeName=#{themeName} where themeID=#{themeID}")
    public int updateTheme(Theme theme);

    // 根据名字查找主题
    @Select("select themeID,themeName from themetable where themeName=#{themeName}")
    public Theme findThemeByName(@Param("themeName")String themeName);

    // 通过themeID删除主题
    @Delete("DELETE FROM themetable WHERE themeID =#{themeID} ")
    public int deleteTheme(@Param("themeID")int themeID);
}
