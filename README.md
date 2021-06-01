# **Дипломный проект "Автоматизация тестирования сервиса "Путешествие дня"**

[План автоматизации](https://github.com/Yuliyarubtsova/Diplom/blob/master/Plan.md)


Запуск автотестов
1. Склонировать [репозиторий](https://github.com/Yuliyarubtsova/Diplom.git)
1. Открыть проект в программе IntelliJIdea 
1. В терминале запустить команду docker-compose up -d --force-recreate
1. Проверить запуск контейнеров командой doker-compose ps (3 контейнера должны быть в статусе Up - mysql, npm start, postgres)
1. Запустить приложение командой - java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -Dspring.datasource.username=user -Dspring.datasource.password=pass -Durl="jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar
1. Запустить автотесты командой - gradlew clean test
1. Запустить отчет по автотестам - gradlew allureReport


Выявленные баги занесены в issues

1. [Ответ банка пользователю "Одобрено" при обработке запроса как "DECLINED"](https://github.com/Yuliyarubtsova/Diplom/issues/1)
1. [Значение месяца "00" принято как валидное](https://github.com/Yuliyarubtsova/Diplom/issues/2)
1. [При пустом поле "Месяц" возникает ошибка "Неверный формат"](https://github.com/Yuliyarubtsova/Diplom/issues/3)
1. [Программа допускает введение некорректного значения в поле "Владелец"](https://github.com/Yuliyarubtsova/Diplom/issues/4)
1. [Программа допускает введение в поле "Владелец" одного символа](https://github.com/Yuliyarubtsova/Diplom/issues/5)
1. [Программа допускает введение в поле "CVC/CVV" нулевых значений](https://github.com/Yuliyarubtsova/Diplom/issues/6)
1. [При закрытии сообщения об отказе банка появляется сообщение об одобрении](https://github.com/Yuliyarubtsova/Diplom/issues/7)



