package edy.ynmd.cms.service.impl;

import edy.ynmd.cms.dao.CarouselDao;
import edy.ynmd.cms.dao.NewsDao;
import edy.ynmd.cms.model.Carousel;
import edy.ynmd.cms.model.News;
import edy.ynmd.cms.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private CarouselDao carouselDao;


    @Override
    public boolean addNews(News news) {

        try {
            newsDao.save(news);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public boolean deletenews(String id) {
        try {
            newsDao.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }



    }

    @Override
    public boolean updateNews(News news) {
        try {
            newsDao.save(news);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public News getNews(String id) {
        return newsDao.findOne(id);
    }

    @Override
    public List<News> getNewsList() {
        return newsDao.findAll();
    }

    @Override
    public boolean addCarousel(Carousel carousel) {
        try {
            carouselDao.save(carousel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delteCarousel(String id) {
        try {
            carouselDao.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public boolean updateCarousel(Carousel carousel) {

        try {
            carouselDao.save(carousel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public Carousel getCarousel(String id) {
        return carouselDao.findOne(id);
    }

    @Override
    public List<Carousel> getCarouselList() {
        return carouselDao.findAll();
    }
}
