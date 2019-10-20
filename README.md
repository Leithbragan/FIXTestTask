Описание запуска проекта
========================

* переход в директорию проекта *cd ../TestTask*
* сборка проекта *mvn package*
* переход в директорию с собранным jar файлом *cd target*
* запуск jar файла *java jar TestTask-1.0-SNAPSHOT.jar*
* переход по следующим адресам:
> ##### [Rest](http://localhost:8080/horse/rest/count?width=8&height=8&start=A1&end=H8)
> ##### [Servlet](http://localhost:8080/horse/servlet/count?width=8&height=8&start=A1&end=H8)
