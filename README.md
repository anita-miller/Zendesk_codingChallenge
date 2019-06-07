# Zendesk_codingChallenge

Design Deceisions:

	In this project, the code is seperate into 4 packages logic, main , presentation and Test. the reasong I did not only create 2 packages main and test was to seperation of concerns and responsiblities into different packages and classes. 

	Following Information Expert pattern, APICall class based on its responsibility is the only class that has credentials necessary for login and API Call. Keeping high cohesion within our code by having the code for a API Call module all located together and working well together leads to easier testing and modification. It then uses DecryptionClass to decrypt the credentials. 

	Following Information Expert pattern to achive loose coupling, APICall class should be only responsible to connecting to API therefore it shouldn't be responsible for reading the recevied inputstream. 
	That is why I created the TicketReader to be responsible  to get InputStream from APICall class and read tickets as json objects from the input stream. 

	In this case, some level of coupling needs to exist since TicketReader gets the InputStream from APICall. The idea of loose coupling is not to remove knowledge about other objects, it is meant to minimize that knowledge. 


	Splitting the implementation into well-defined pieces makes it easier to find things.This also, supports low coupling which leads to more robust and maintainable system. for example, if i want to change the data structure that tickets are stored in, i only need to change structure at TicketReader class.

		- Ticket class includes fields for each ticket and since ticketpresentation class is an information expert  on presenting tickets fileds, it can access them using getters. This supports low coupling which leads to more robust and maintainable system.
	
