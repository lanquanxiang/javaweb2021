package cn.pzhu.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * Application Lifecycle Listener implementation class VisitorListener
 *
 */
@WebListener
public class VisitorListener implements HttpSessionListener {
	private static int visitor = 0;

    /**
     * Default constructor. 
     */
    public VisitorListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	synchronized (VisitorListener.class) {
			visitor = visitor + 1;
			se.getSession().getServletContext().setAttribute("visitor", visitor);
		}
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
