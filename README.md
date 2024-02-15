# cft_test_task_24
Test task for CFT Shift course

## Functional
Десктопная утилита на Java. Её функция отсортировать по типам данных входные данные из разных файлов.
### Default Settings
  Output directory: current   
  Output files: integers.txt for integer type values  
                floats.txt for float type values  
                strings.txt for string type valuse  
### Flags 
  -a - выключениечает перезапись файло
  -o - позволяет задать папку для выходного файла, если её не существует, создаст файлы в папке откуда вызывается утилита
  -p - установка префикса для выходных файлов  
  -s - включение отображения краткой статистики по обработанным данным
  -f - включение отображения полной статистики по обработанным данным 
  (если одновременно используются оба флага вывода статистики, то выводится полная статистика)

### Example of using
   java -jar util.jar -s -a -p sample- in1.txt in2.txt

## Libs   
- maven-shade-plugin:3.5.1 - https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-shade-plugin 
- maven-jar-plugin:3.3.0 - https://mvnrepository.com/artifact/log4j/log4j
- log4j:1.2.17 - https://mvnrepository.com/artifact/log4j/log4j
- commons-cli:1.6.0 - https://mvnrepository.com/artifact/commons-cli/commons-cli

## Start using
- перейти в корневую папку проекта.
- выполнить команду mvn clean install
- проверить наличие папки target с находящимся в нём архивом cft_util-1.0-shaded.jar
- запустить утилиту: java -jar target/cft_util-1.0-shaded.jar [параметры запуска]
  
   
