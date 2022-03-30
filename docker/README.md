###Запуск MySQL в контейнере:

- docker run -p 6603:3306 --name social-mysql -e MYSQL_RANDOM_ROOT_PASSWORD=yes -v /Users/17425490/IdeaProjects/mysql:/var/lib/mysql -d mysql:8
- docker logs social-mysql