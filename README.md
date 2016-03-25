## Just a DoSFilter demo

#### of some unexpected for me behaviour of Jetty

Here, for demonstration purposes, DoSFilter is configured to cut the connection after a 2 seconds timeout. Here are the
relevant bits of configuration for ```DoSFilter```

```xml
        <init-param>
            <param-name>maxRequestMs</param-name>
            <param-value>2000</param-value>
        </init-param>
```

Start the jetty using the ```maven-jetty-plugin``` and go to [http://localhost:9999](http://localhost:9999).

Expecting a 418 status or a 503 (Service Unavailable) after clicking on the link, but instead getting a 200 status code and no output.