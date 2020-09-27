# Документация к Веб приложению по космическому туризму (Space Drive).

## Стек технологий:
**Шаблонизатор:** Freemarker

**База данных:** PostgreSQL

**Паттерн проектирования:** DAO

**Библиотека для CSS:** Bootstrap

**Паттерн проектирования:** MVC

## Краткое описание проекта:
   Space Drive – это сайт, который помогает путешественникам во всем мире сравнивать и приобретать билеты на
   космические путешествия.  Мы показываем все доступные варианты и актуальные цены, чтобы вы сами могли сделать 
   выбор. Всего один клик, и вы переходите на страницу для покупки или оформления заказа.

## Функциональные требования:
* Регистрация и авторизация на сайте
* Возможность хранить сессии пользователей
* Профиль пользователя, возможность редактировать профиль
* После покупки билета, сайт генерирует уникальный QR-билет для пользователя
* Пользователи могут оставить отзыв о путешествии
* Для не авторизированных пользователей доступен список путевок, но для их бронирования необходимо авторизоваться 
* Поиск по ключевым словам и тэгам
* Должна быть возможность фильтровать список и поиск путевок по цене, по длительности и т.д.

## Нефункциональные требования:
* Приятный дизайн
* Масштабируемость 
* Безопасность
* Надежность

## Бизнес требования:
* Цель: создать качественное приложение.
* Мы даем: удобный интерфейс, понятную каждому легкую навигацию по сайту.
* Наш продукт соответствует требованиям федеральных законов:
  "О персональных данных" от 27.07.2006 N 152-ФЗ