Сборка
------
Для сборки дистрибутива к корневом каталоге репа запускается команда:
```batch
sbt clean clean-files dist
```
После сборки в под-каталоге `\target\universal\` появится файл `${IJ_PROJECT_NAME}-1.0.zip` 

Запуск
------
Взять файл `${IJ_PROJECT_NAME}-1.0.zip`, сформированный на этапе сборки, раззиповать куда-либо и запустить приложение:
```batch
./${IJ_PROJECT_NAME}-1.0/bin/${IJ_PROJECT_NAME}
```

Тюнинг
------
По умолчанию приложение использует файл конфигурации `conf/application.conf`. В нём лежат все настройки программы, включая реквизиты доступа к базе данных.
Запустить приложение с использованием альтернативного конфигурационного (здесь -- `super.puper.conf`) файла можно так:
```batch
./${IJ_PROJECT_NAME}-1.0/bin/${IJ_PROJECT_NAME} -Dconfig.resource=super.puper.conf
```

Проверка
--------
При нормальном запуске приложение должно корректно реагировать на запрос GET /
т.е. оно должно выдать 200 OK и пустую страницу

