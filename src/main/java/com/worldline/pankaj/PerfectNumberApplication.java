package com.worldline.pankaj;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.eclipse.jetty.servlet.ServletContextHandler.NO_SESSIONS;

/*
 * PerfectNumberApplication is a bootstrap class that starts the embedded jetty server on port 8284
 * with servlet context being 'perfectnumber'
 * @author Pankaj Poshirkar
 * @date   18 July 2019
 */
public class PerfectNumberApplication {

    private static final Logger logger = LoggerFactory.getLogger(PerfectNumberApplication.class);

    public static void main(String[] args) {

        Server server = new Server(8284);

        ServletContextHandler servletContextHandler = new ServletContextHandler(NO_SESSIONS);

        servletContextHandler.setContextPath("/perfectnumber");
        server.setHandler(servletContextHandler);

        ServletHolder servletHolder = servletContextHandler.addServlet(ServletContainer.class, "/*");
        servletHolder.setInitOrder(0);
        servletHolder.setInitParameter("jersey.config.server.provider.packages",
                "com.worldline.pankaj.controllers");

        try {
            server.start();
            server.join();
        }
        catch (Exception ex) {
            logger.error("Error occurred while starting Jetty", ex);
            System.exit(1);
        }
        finally {
            server.destroy();
        }
    }
}
