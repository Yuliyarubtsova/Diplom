# **Дипломный проект "Автоматизация тестирования сервиса "Путешествие дня"**

Запуск автотестов
1. Склонировать [репозиторий](https://github.com/Yuliyarubtsova/Diplom.git)
1. Открыть проект в программе IntelliJIdea 
1. В терминале запустить команду docker-compose up -d --force-recreate
1. Проверить запуск контейнеров командой doker-compose ps (3 контейнера должны быть в статусе Up - mysql, npm start, postgres)
1. Запустить приложение командой - java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -Dspring.datasource.username=user -Dspring.datasource.password=pass -Durl="jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar
1. 




[План автоматизации](https://github.com/Yuliyarubtsova/Diplom/blob/master/Plan.md)