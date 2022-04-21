# OtusHightloadHW
Домашние задания по курсу Otus. Highload Architect.
JDK: 11.

URL для входа: http://localhost:8081/

---
### Создание БД:
> docker run -p 6603:3306 --name social-mysql \
        -e MYSQL_ROOT_PASSWORD=8b03005ef88c426498523bbe0757d101 \
        -v /home/uoles/project/mysql_db:/var/lib/mysql \
        -d mysql:8
---
### Создаем образ с приложением:
> docker build -t uoles/mooncake-social .

### Запускаем контейнер:
> docker run --name social-project \
        -p 8081:8081 \
        --network=host \
        -d uoles/mooncake-social
---
### Задание: 
Заготовка для социальной сети.

### Цель:
В результате выполнения ДЗ вы создадите базовый скелет социальной сети, который будет развиваться в дальнейших ДЗ.

### В данном задании тренируются навыки:
- декомпозиции предметной области;
- построения элементарной архитектуры проекта

### Описание/Пошаговая инструкция выполнения домашнего задания:
Требуется разработать создание и просмотр анект в социальной сети.

### Функциональные требования:
1. Авторизация по паролю.
2. Страница регистрации, где указывается следующая информация:
- Имя
- Фамилия
- Возраст
- Пол
- Интересы
- Город
3. Страницы с анкетой.

### Нефункциональные требования:
- Любой язык программирования
- В качестве базы данных использовать MySQL
- Не использовать ORM
- Программа должна представлять из себя монолитное приложение.

### Не рекомендуется использовать следующие технологии:
- Репликация
- Шардинг
- Индексы
- Кэширование

Верстка не важна. Подойдет самая примитивная. Разместить приложение на любом хостинге. Например, heroku. ДЗ принимается в виде исходного кода на github и демонстрации проекта на хостинге.

### Критерии оценки:
Оценка происходит по принципу зачет/незачет.

### Требования:
- Есть возможность регистрации, создавать персональные страницы, возможность подружиться, список друзей.
- Отсутствуют SQL-инъекции.
- Пароль хранится безопасно.
---