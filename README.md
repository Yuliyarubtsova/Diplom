# **Дипломный проект "Автоматизация тестирования сервиса "Путешествие дня"**

* [План автоматизации](https://github.com/Yuliyarubtsova/Diplom/blob/master/DiplomDocuments/Plan.md)
* [Отчет о проведенном тестировании](https://github.com/Yuliyarubtsova/Diplom/blob/master/DiplomDocuments/Report.md)
* [Отчет о проведении автоматизации](https://github.com/Yuliyarubtsova/Diplom/blob/master/DiplomDocuments/Summary.md)

Запуск автотестов
1. Склонировать [репозиторий](https://github.com/Yuliyarubtsova/Diplom.git)
1. Открыть проект в программе IntelliJIdea 
1. В терминале запустить команду `docker-compose up -d --force-recreate`
1. Проверить запуск контейнеров командой `docker-compose ps` (3 контейнера должны быть в статусе Up - mysql, npm start, postgres)
1. Запуск приложения: 
* Для работы с БД MySQL команда `java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -Dspring.datasource.username=user -Dspring.datasource.password=pass -jar artifacts/aqa-shop.jar`
* Для работы с БД Postgres запустить приложение командой `java -Dspring.datasource.url=jdbc:postgresql://localhost:5432/app2 -Dspring.datasource.username=user2 -Dspring.datasource.password=pass2 -jar artifacts/aqa-shop.jar`
6. Запустить автотесты командой - `gradlew clean test`
7. Запустить отчет по автотестам - `gradlew allureReport`


