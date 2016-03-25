## Just a DoSFilter demo

#### of some unexpected for me behaviour of Jetty

Here, for demonstration purposes, DoSFilter is configured to cut the connection after a 2 seconds timeout.

Start the jetty using the ```maven-jetty-plugin``` and go to [http://localhost:9999](http://localhost:9999).
After that it should be obvious.

Expecting a 414 status or 408 (request timeout status), but instead getting a 200 status code and no output.