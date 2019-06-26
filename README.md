# Zendesk_codingChallenge

How to run the application:
* Clone the repository into your local machine.
    git clone https://github.com/anitanaseri/Zendesk_codingChallenge.git
    
* cd in to the root folder

Compile the source code using following command.

    javac -sourcepath src -cp libraries/json-20180813.jar src/Main.java

Run the application using following command.

    java -cp src:libraries/json-20180813.jar Main

Tests :
first compile:    

    javac -sourcepath src -cp libraries/junit-4.10.jar:libraries/json-20180813.jar src/test/*.java

run:

    java -cp src:libraries/junit-4.10.jar:libraries/json-20180813.jar org.junit.runner.JUnitCore test.APICallTest test.TicketPresentationTest test.TicketReaderTest


Design Decisions:

    Code structure:

        In this project, the code is separate into 4 packages logic, main, presentation and Test. 
        the reason I did not only create 2 packages main and test was to separate concerns and 
        responsibilities into different packages and classes. 

        One of the main classes is APICall which is responsible for connecting to API 
        and passing the ticket JSON array to another class. 
        
        Based Information Expert pattern, APICall class based on its responsibility is 
        the only class that has credentials necessary for login and API Call. APICall 
        class is also the only class that class that has access to Decrypt class and 
        only uses it to decrypt the credentials. 
        
        I tried to keep high cohesion within our code by having the code for performing 
        API Call in its class together that also leads to easier testing and 
        modification. 

        TicketReader class is responsible to get InputStream from APICall class and 
        read tickets as json objects from the input stream. 

        Having 2 separate classes responsible for specific tasks only one for first 
        getting information from API and another for reading the information helps to 
        achieve loose coupling.  This helps to have more robust and maintainable 
        system. 
        for example, if i want to change the data structure that tickets are stored
        in, i only need to change structure at TicketReader class and won’t have to 
        modify APICall.

    Storing Credentials:

        Identification credentials are encrypted and stored at Config.properties. 
        At run time the application decrypts them and uses them to connect to API.
        I chose this approach and encrypted passwords so unauthorised user won't be
        able to take the credentials and use them in the URL to access the data. 
        There is a flaw that decryption code is uploaded to github too so attacker
        can try to decrypt and use the credentials, but it is only uploaded so 
        application can be run on Zendesk's team local computer to assess the 
        application. 
        In a real-life application, I would keep the decryption code and credential to
        stay on the server side and called upon somehow. 

    Application path decisions:

        After running the application, user can choose to view all of the ticket or one 
        by one based on id.
        If user chooses the first options, 25 tickets will be displayed, and at the end 
        of each set of tickets user will have the options to go to previous, next page 
        or go back to main menu or choose a specific ticket by id from the list to view 
        in more details (view its description)or exit the application.

        I added the option for user to be able to choose a specific ticket and view its 
        description while viewing the list of tickets.  Because it would be useful when 
        viewing a large amount of data and it would be inconvenient to leave a specific 
        point in the list to view further data then having to return.


    Tests:
        APICall tests :
            I wrote one test to check when facing an unavailable API application responds 
            error code and does not crash.
            Another test is to check that for wrong credentials 401 error is returned.
            
        TicketReader tests:
            First test is checking that when ticketDataReader get an InputStream it parses
            the string correctly. it's done by giving the function an example input and
            check if output matches it.
            Second test checks that createTicket function correctly creates ticket.
        
        TicketPresentation tests:
            First test checks that displaySummaryTicketById function fetches ticket with 
            ID 1 is correctly.
            Second test checks that displaySummaryTicketById function handles the request
            for a tikcet when the given ID doesn't exist correctly.
            Third test checks that the ticket printed by showIndividualTicket() is 
            same as expected print value.
    


