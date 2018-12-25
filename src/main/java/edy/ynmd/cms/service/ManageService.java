package edy.ynmd.cms.service;

import edy.ynmd.cms.model.Carousel;
import edy.ynmd.cms.model.News;

import java.util.List;

public interface ManageService {

    public boolean addNews(News news);
    public boolean deletenews(String id);
    public boolean updateNews(News news);
    public News getNews(String id);
    public List<News> getNewsList();


    public boolean addCarousel(Carousel carousel);
    public boolean delteCarousel(String id);
    public boolean updateCarousel(Carousel carousel);
    public Carousel getCarousel(String id);
    public List<Carousel> getCarouselList();

}
