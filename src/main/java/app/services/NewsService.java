package app.services;

import app.models.News;

import java.util.List;

public interface NewsService {

    List<News> getAll();

    void addNews(News news);
}
