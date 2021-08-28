[![Build Status](https://travis-ci.com/Selesito/job4j_microservices.svg?branch=master)](https://travis-ci.com/Selesito/job4j_microservices)
# job4j_microservices

### Описание проекта

Проект реализован ввиде сервисов.Один сервис это обычный CRUD серверное приложение, которое представляет Rest API.Второй же сервис будет работать с ним через RestTemplate, а так же с пользователем!

### Использованные технологии
  <ul>  
      <li>Spring Boot 2</li>
      <li>Liquibase</li>
      <li>JWT</li>
      <li>PostgresSQL</li>
      <li>JUnit</li>
      <li>TravisCI</li>
      <li>JaCoCo</li>
  </ul>
  
  ### Методы
  <ul>  
      <li>/save, сохранить данные паспорта</li>
      <li>/update?id=*, обновить данные паспорта</li>
      <li>/delete?id=*, удалить данные паспорта</li>
      <li>/find, загрузить все паспорта</li>
      <li>/find?seria=*, загрузить паспорта с заданной серией</li>
      <li>/unavaliabe, загрузить паспорта чей срок вышел</li>
      <li>/find-replaceable, загрузить паспорта, которые нужно заменить в ближайшие 3 месяца</li>
  </ul>
  
