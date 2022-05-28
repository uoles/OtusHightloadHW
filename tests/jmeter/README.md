# Нагрузочное тестирование

### Apache JMeter

Источники инфо:  
- создание теста https://habr.com/ru/post/165159/     
- создание отчета https://octoperf.com/blog/2017/10/19/how-to-analyze-jmeter-results/#simple-data-writer, https://jmeter.apache.org/usermanual/generating-dashboard.html  
- фильтрация ответов приложения https://www.quora.com/How-do-I-verify-if-the-API-is-throwing-200-OK-as-a-status-code-in-JMeter

### Команда для запуска теста
jmeter -n -t test-plan.jmx -l test-results.jtl

### Команда для генерации HTML отчета
jmeter -g test-results.jtl -o report-folder