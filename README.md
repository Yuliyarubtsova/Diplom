# **Дипломный проект "Автоматизация тестирования сервиса "Путешествие дня"**

* [План автоматизации](https://github.com/Yuliyarubtsova/Diplom/blob/master/DiplomDocuments/Plan.md)
* [Отчет о проведенном тестировании](https://github.com/Yuliyarubtsova/Diplom/blob/master/DiplomDocuments/Report.md)
* [Отчет о проведении автоматизации](https://github.com/Yuliyarubtsova/Diplom/blob/master/DiplomDocuments/Summary.md)

Запуск автотестов с помощью MySQL:
1. Склонировать [репозиторий](https://github.com/Yuliyarubtsova/Diplom.git)
1. Открыть проект в программе IntelliJIdea Ultimate
1. В терминале запустить команду `docker-compose up -d --force-recreate`
1. Проверить запуск контейнеров командой `docker-compose ps` (2 контейнера должны быть в статусе Up - mysql, npm start)
1. Запустить приложение с помощью команды - `java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -Dspring.datasource.username=user -Dspring.datasource.password=pass -jar artifacts/aqa-shop.jar`
1. Запустить автотесты командой - `gradlew clean test -Durl="jdbc:mysql://localhost:3306/app" -Duser="user" -Dpassword="pass" --info`
1. Запустить отчет по автотестам - `gradlew allureReport`

Запуск автотестов с помощью Postgres:
1. Склонировать [репозиторий](https://github.com/Yuliyarubtsova/Diplom.git)
1. Открыть проект в программе IntelliJIdea Ultimate
1. В терминале запустить команду `docker-compose up -d --force-recreate`
1. Проверить запуск контейнеров командой `docker-compose ps` (2 контейнера должны быть в статусе Up - npm start, postgres)
1. Запустить приложение с помощью команды `java -Dspring.datasource.url=jdbc:postgresql://localhost:5432/app2 -Dspring.datasource.username=user2 -Dspring.datasource.password=pass2 -jar artifacts/aqa-shop.jar`
6. Запустить автотесты командой - `gradlew clean test -Durl="jdbc:postgresql://localhost:5432/app2" -Duser="user2" -Dpassword="pass2" --info`
7. Запустить отчет по автотестам - `gradlew allureReport`
