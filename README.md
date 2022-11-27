# *Items management system*

## This app is created mainly for educational purposes


## *Technology used*
 - Java 17
 - Spring boot 2.7.5
 - Lombok 1.8.24
 - Mapstruck 1.5.2
 - MongoDB <latest>
 - Docker <latest>
 
 ## Runing application
 - Using your favorite IDE:
  1. InteliJ:
   + Right click on main application class(ItemsApplication), select option "Run 'ItemsApplication.main()'".
   + In the toolbar you can find icon "play" click on it and program will start
  2. Eclipse
   + Same options goes for eclipse
 
 - Using Maven:
  1. Type command in terminal inside your source code directory:
   + mvn ./mvnw spring-boot:run
   + mvn spring-boot:run
   
 ## Endpoints
 ### You can check endpoints in your browser after running the app, i prefer to use postman in this cases
 
  1.Get Method (For getting all items from mongo)
   - http://localhost:8080/items 
    + NOTE: you can modifie url with specific parameters for elements for page size(pageSize), number of page(pageNo),<br> sorting type(sortBy) and sorting directions(sortDirection)
    in that case url would look likes this:
    http://localhost:8080/items?pageSize=20&pageNo=2&sortBy=itemId&sortDirection=DSC
