# cofeeshop
Simple Cofee Shop billing app.
Allows to fill basket with a products.
Add addons to the products and set different options.
Also programmed product catalog is available

# Running the app

1. Clone the project, cd into the folder and then the src folder then run javac
   to compile:
   
    `git clone git://github.com/belrbeZ/cofeeshop`
   
    or Use Git or checkout with SVN using the web URL 
    
    `https://github.com/belrbeZ/cofeeshop.git`
    
2. Compile and start console applications with demonstration of billing.

    `cd cofeeshop/src/` 
    
    `javac cyk.java`
        
3. Run the program by giving it a grammar|input file of your choosing and supplying
   a string:
   
   3.1. CYK:

       `java Cyk grammar_hw6.txt word1_hw6.txt`

    Or simple start application to use the default input files ("grammar_hw6.txt" and "word1_hw6.txt").

       `java Cyk`
    
    3.2. CNF:

       `java Grammar grammar_hw6.txt`

    Or simple start application to use the default input files ("grammar_hw6.txt").

       `java Grammar`