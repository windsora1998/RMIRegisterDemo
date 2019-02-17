# RMI - Remote Method Invocation

The RMI (Remote Method Invocation) is an API that provides a mechanism to create distributed
application in java. The RMI allows an object to invoke methods on an object running in another JVM.

## Exercises

You are provided a list from file app_c_new.csv contains 151,671 surnames of US citizens from 2000, which occur more than 100 times in the nation. You need to program a RMI application to meet the following requirements:

Your program must have a Person class.

- A user wants to find whether an input surname is available. 

      Command format: java Client find "surname"

- Input a pctwhite, return all the surnames have pctwhite smaller than the given. 

      Command format: java Client pctwhite <number>

- A user wants to list all Person whose count is larger than a given. 

      Command format: java Client list <number>

## How to run on MacOS
1. Open Terminal in your folder contains file:
   
       javac *.java

2. start the RMI: 

       rmiregistry 1069

3. Open other Terminal in your folder contains file and run the Server:
 
       java Server

4.  Open other Terminal in your folder contains file and run the Client one the way:

        java Client find NGUYEN
        java Client pctwhite 12.5
        java Client list 180

## How to run on Windows
1. Open cmd in your folder contains file:
   
       javac *.java

2. start the RMI: 

       start rmiregistry 1069

3. Open other cmd in your folder contains file and run the Server:
 
       java Server

4.  Open other cmd in your folder contains file and run the Client one the way:

        java Client find NGUYEN
        java Client pctwhite 12.5
        java Client list 180


## Result

You can see the result on the folder result