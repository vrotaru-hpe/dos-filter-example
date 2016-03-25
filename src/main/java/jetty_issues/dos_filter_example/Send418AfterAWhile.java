package jetty_issues.dos_filter_example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Send418AfterAWhile extends HttpServlet {

    private static Logger LOGGER = Logger.getLogger(Send418AfterAWhile.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Starting processing request at: " + new Date());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            LOGGER.warning("Interrupted at: " + new Date());
        }

        if (resp.isCommitted()) {
            LOGGER.warning("Response already committed, giving up");
        }
        else {
            LOGGER.info("Sending 418 status code at : " + new Date());
            resp.sendError(418, "After some deliberations, I realised, that I'm a teapot");
        }
    }
}
