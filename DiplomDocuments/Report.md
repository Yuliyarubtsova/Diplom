# **Отчет о тестировании сервиса "Путешествие дня"**

## **Краткое описание**
c 23.05.2021 по 05.06.2021 было проведено тестирование сервиса "Путешествие дня".

На тестирование было затрачено 42 часа.

## **Описание процесса тестирования**

Проведено тестирование сервиса покупки тура с помощью оплаты по карте и покупки в кредит. 

Общее количество тестов - 36

Количество успешно пройденных тестов - 24

![allurereport](https://prnt.sc/147dnpl)

В результате тестирования были выявлены следующие дефекты:
1. [Ответ банка пользователю "Одобрено" при обработке запроса как "DECLINED"](https://github.com/Yuliyarubtsova/Diplom/issues/1)
1. [Значение месяца "00" принято как валидное](https://github.com/Yuliyarubtsova/Diplom/issues/2)
1. [При пустом поле "Месяц" возникает ошибка "Неверный формат"](https://github.com/Yuliyarubtsova/Diplom/issues/3)
1. [Программа допускает введение некорректного значения в поле "Владелец"](https://github.com/Yuliyarubtsova/Diplom/issues/4)
1. [Программа допускает введение в поле "Владелец" одного символа](https://github.com/Yuliyarubtsova/Diplom/issues/5)
1. [Программа допускает введение в поле "CVC/CVV" нулевых значений](https://github.com/Yuliyarubtsova/Diplom/issues/6)
1. [При закрытии сообщения об отказе банка появляется сообщение об одобрении](https://github.com/Yuliyarubtsova/Diplom/issues/7)


## **Тестирование проводилось в следующем окружении:**
* Windows 10 PRO версия 1909
* Браузер Google Chrom Версия 90.0.4430.212
* openjdk version "11.0.9.1" 2020-11-04