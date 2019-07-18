package com.seven.dao;
import com.seven.entity.News;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface NewsDao {
    // 根据themeId查找新闻的数量
    @Select("select count(*) from newstable where themeId=#{themeId}")
    public int getNewsCountBythemeId(@Param("themeId")int themeId);

    // 返回所有的新闻
    @Select("select newsId,themeId,newsTitle,newsAuthor,newsCreatedate,newsPicpath,newsContent,newsModifydate,newsSummary from newstable")
    public List<News> getAllNews();

    @Insert("INSERT INTO newstable "+
            "(newsId,themeId,newsTitle,newsAuthor,newsCreatedate,newsPicpath,newsContent,newsModifydate,newsSummary)"+
            "values (#{newsId},#{themeId},#{newsTitle},#{newsAuthor},#{newsCreatedate},#{newsPicpath},#{newsContent},#{newsModifydate},#{newsSummary})")
    public int addNews(News news);

    @Select("SELECT * FROM newstable WHERE newsTitle = #{newsTitle}")
    public News checkNewsIfExist(@Param("newsTitle")String newsTitle);

    // 获取某主题的所有新闻
    @Select("select * from newstable WHERE themeId = #{themeId}")
    public List<News> findAllNewsByThemeId(@Param("themeId")int themeId);

    // 修改新闻
    @Update("UPDATE newstable SET "+
            "themeId=#{themeId},newsTitle=#{newsTitle},newsModifydate=#{newsModifydate},newsSummary=#{newsSummary},newsContent=#{newsContent},newsPicpath=#{newsPicpath} "+
            "WHERE newsId = #{newsId}")
    public int updateNews(News news);

    // 删除新闻
    @Delete("DELETE FROM newstable WHERE newsId = #{newsId}")
    public int deleteNews(@Param("newsId")int newsId);

    @Select("SELECT count(*) FROM newstable")
    public int getNewsCount();

    // 根据id查新闻
    @Select("SELECT * from newstable WHERE newsId = #{newsId}")
    public News findNewsById(@Param("newsId")int newsId);

    //分页查找新闻数据
    @Select("select * from newstable LIMIT #{startRow},#{pageSize}")
    public ArrayList<News> getNewsListSplit(@Param("startRow")int startRow, @Param("pageSize")int pageSize);

    //根据标题查询新闻
    @Select("SELECT * FROM newstable WHERE newsTitle = #{newsTitle}")
    public News findNewsByTitle(@Param("newsTitle")String newsTitle);

}
