package app.services;

import app.models.News;
import app.repositories.NewsRepository;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> getListOfNews() {
        return newsRepository.findAll();
    }
}
