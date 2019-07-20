This project consists of two RESTful webservices :
1. Http GET endpoint - http://localhost:8284/perfectnumber/check/n
where 'n' is the number to be checked whether it is a Perfect Number. 

It returns 'true' if 'n' is a Perfect Number, else returns 'false'

2. Http POST endpoint - http://localhost:8284/perfectnumber/find
with the input Body of the following JSON format:

{"startNumber":x,"endNumber":y}

where 'x' and 'y' represent a number range and are positive 
integers and x < y. 

This URL returns all the Perfect Numbers between 'x' and 'y' with 
x and y both inclusive

This program uses Jersey which is on of the implementations of JAX-RS 
specifications. Jersey has in-built JAXB JSON parser to send and receive
the response in JSON format by auto-converting the Java primitive/objects to 
and from JSON format.

The build tool used is Gradle while the application runs on an embedded Jetty 
server. 