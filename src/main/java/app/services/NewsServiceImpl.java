package app.services;

import app.repositories.NewsRepository;

public class NewsServiceImpl implements NewsService {
    NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
}
