# cofeeshop
Simple Cofee Shop billing app.
Allows to fill basket with a products.
Add addons to the products and set different options.
Also programmed product catalog is available

Result
Author name : ALEXANDR VASILEV
Codeship : [ ![Codeship Status for belrbeZ/coffeeshop](https://app.codeship.com/projects/e7fc25a0-f391-0135-89fa-4e3622f3d72a/status?branch=master)](https://app.codeship.com/projects/272704)

# Running the app

1. Clone the project, cd into the folder and then the src folder then run javac
   to compile:
   
    `git clone git://github.com/belrbeZ/cofeeshop`
   
    or Use Git or checkout with SVN using the web URL 
    
    `https://github.com/belrbeZ/cofeeshop.git`
    
2. Compile console applications with demonstration of billing (may be not right):

    `cd cofeeshop/` 
    
    `javac -d .\out -sourcepath ru/*.java:ru.testing/*.java:ru.testing.cofeeshop/*.java:ru.testing.cofeeshop/*.java:ru.testing.cofeeshop.app/*.java:ru.testing.cofeeshop.config/*.java:ru.testing.cofeeshop.controller/*.java:ru.testing.cofeeshop.domain/*.java:ru.testing.cofeeshop.productcatalog/*.java:ru.testing.cofeeshop.utils/*.java`
        
3. Run the program by giving it a grammar|input file of your choosing and supplying
   a string:
   
   `java CoffeeShopApp`
    
4. Make an executable jar file:

    `jar cf coffeeshop.jar CoffeeShopApp.class`
    
5. Execute jar file

    `java -jar coffeeshop.jar`
