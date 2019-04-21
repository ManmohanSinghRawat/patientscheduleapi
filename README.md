# patientscheduleapi
java assignment

In this api, I have used spring boot, jpa(for hibernate), H2(embedded database rather then sql), Swagger and logging. 
I have add Swagger api and looging from the plus point list , and both of them are working .

Swagger
   I have springfox-swagger and springfox-swagger-ui dependence. The configuration of swagger is done by
   @EnableSwagger2
   @ComponentScan(basePackages = "" to the basic (main) class. 
  At localhost we can go to :
  http://localhost:8080/swagger-ui.html
  to see all the function for add , delete , retrive etc.
  
I doesn't use any test cases, but Swagger is quite useful to test the proper working of api.

Logging
   I have use basic logging with ERROR level at root.
   Logging file is application.log used to save logs.
   The file stores in the form " %d{yyyy-MMM-dd HH:mm:ss.SSS} %-5level [%thread] %logger{15} - %msg%n ".
   
