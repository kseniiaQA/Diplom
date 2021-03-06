# План по проверке и автоматизации приложения «Мобильный хоспис»

## Определение "границ" приложения.

Приложение состоит из двух основных частей: верхней панели, которая позволяет переключаться между экранами, и содержимое выбранного экрана. Так же есть экран загрузки и форма входа в приложение.

Верхняя панель состоит из нескольких навигационных клавиш:

- Меню (три полоски)
- Тематические цитаты (бабочка)
- Кнопка выхода

В меню доступны следующие вкладки, функционал которых необходимо протестировать.

- Главная страничка
- Объявления
- Новости
- О приложении
 
### Что будем тестировать.

1. Проверка экран авторизации
2. Проверка экрана "Главная"
   1. Проверка элементов отображения
      - Блок новостей
      - Блок претензий 
   2. Проверка элементов взаимодействия
      - Сворачивание/разворачивание блока новостей
      - Сворачивание/разворачивание блока претензий
      - Сворачивание/разворачивание отдельной новости
      - Сворачивание/разворачивание объявления
      - Создание претензии
3. Проверка экрана "Новости"
   1. Проверка элементов отображения
      - Сворачивание/разворачивание отдельной новости
   2. Проверка элементов взаимодействия
      - Порядок отображения новостей
      - Фильтрация новостей
      - Переход на экран "Панель управления"
4. Проверка экрана "Панель управления"
   1. Проверка элементов отображения
      - Сворачивание/разворачивание отдельной новости
   2. Проверка элементов взаимодействия
      - Порядок отображения новостей
      - Фильтрация новостей
      - Создание новости
      - Редактирование новости
      - Удаление новости
5. Проверка экрана "Претензии"
   1. Проверка элементов отображения
      - Сворачивание/разворачивание отдельного объявления
   2. Проверка элементов взаимодействия
    
6. Проверка экрана "О приложение"
   1. Проверка элементов отображения
      - Версия приложения
      - Права пользования
      - Права конфиденциальности
   2. Проверка элементов взаимодействия
      - Открытие ссылки "Права пользования"
      - Открытие ссылки "Права конфиденциальности"
7. Проверка экрана "Тематические цитаты"
   1. Проверка элементов отображения
      - Сворачивание/разворачивание отдельной цитаты

- Проверка переходов между экранами
- Проверка событий
- Проверка механизма авторизации
- Проверка выхода из приложения


## Сроки реализации 
1. Исследуем приложение. 15.05 - 16.05 
2. Составляем чек-лист. 17.05
3. Расписываем тест-кейсы. 18.05 - 20.05
1. Проверка экранов 20.05 - 23.05 
2. Проверка элементов на экранах 23.05 - 27.05
3. Проверка доп функционала (Авторизация, интенты) 27.05-31.05
4. Автоматизируем приложение 01.06 - 07.06  
