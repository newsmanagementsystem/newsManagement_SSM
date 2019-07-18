package com.seven.service;

import com.seven.dao.NewsDao;
import com.seven.entity.News;
import com.seven.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsDao newsDao;

    public int getNewsCountBythemeId(int themeId) {
        return newsDao.getNewsCountBythemeId(themeId);
    }

    public List<News> getAllNews(){

        return newsDao.getAllNews();
    }

    public List<News> findAllNewsByThemeId(int themeId){
        return newsDao.findAllNewsByThemeId(themeId);
    }
    public List<News> selectAllNews() {
        List<News> allNews = newsDao.getAllNews();
        return allNews;
    }
    //根据标题查询新闻
    public News findNewsByTitle(String newsTitle) {
        return newsDao.findNewsByTitle(newsTitle);
    }

    //service层增加数据
    public void addNews(News news){
        newsDao.addNews(news);
    }

    //安装新闻id查找新闻
    public News findNewsById(int nid){
        return newsDao.findNewsById(nid);
    }

    //update新闻
    public int updateNews(News news){
        return newsDao.updateNews(news);
    }
    //按照id删除新闻
    public int deleteNewsById(int nid){
        return newsDao.deleteNews(nid);
    }
    //分页
    public PageBean<News> getPageBean(int currentPage, int pageSize){
        //先得到总的记录数
        int totalCount = newsDao.getNewsCount();
        PageBean<News> pageBean = new PageBean<>(currentPage,pageSize,totalCount);
        pageBean.setList(newsDao.getNewsListSplit(pageBean.getStartRow(),pageBean.getPageSize()));
        return pageBean;
    }
}
