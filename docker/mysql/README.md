### Запуск MySQL в контейнере:

#### Запуск с рандомным паролем MYSQL_ROOT_PASSWORD:
/var/lib/mysql - место хранения БД 
> docker run -p 6603:3306 --name social-mysql \
    -e MYSQL_RANDOM_ROOT_PASSWORD=yes \
    -v <Путь на локальной машине>:/var/lib/mysql \
    -d mysql:8

#### В логах можно посмотреть MYSQL_ROOT_PASSWORD:
> docker logs social-mysql

#### Запуск с заданным паролем MYSQL_ROOT_PASSWORD:
> docker run -p 6603:3306 --name social-mysql \
    -e MYSQL_ROOT_PASSWORD=8b03005ef88c426498523bbe0757d101 \
    -v <Путь на локальной машине>:/var/lib/mysql \
    -d mysql:8 

#### Подключение директории с конфигурацией
Для подключения конфигурации извне нужно использовать свой образ
> docker build -t uoles/mysql .

/etc/mysql - место хранениия конфигурации БД
> docker run -p 6604:3306 --name social-mysql-test \
    -e MYSQL_ROOT_PASSWORD=8b03005ef88c426498523bbe0757d101 \
    -v <Путь на локальной машине>:/var/lib/mysql \
    -v <Путь на локальной машине>:/etc/mysql \
    -d uoles/mysql

### Инфо
Настройка репликации https://www.k-max.name/linux/replikaciya-mysql-master-slave/ 

### Проблема с liquibase "Waiting for changelog lock...."
Инфо: https://stevenschwenke.de/multipleWaitingForChangelogLockLiquibaseLockedYourDatabase
> SELECT * FROM DATABASECHANGELOGLOCK; 
> 
> UPDATE DATABASECHANGELOGLOCK \
SET locked=0, lockgranted=null, lockedby=null \
WHERE id=1; 
> 
> commit;