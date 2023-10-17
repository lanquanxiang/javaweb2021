package cn.pzhu.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import cn.pzhu.pojo.User;

/**
 * Application Lifecycle Listener implementation class OnlineListener
 *
 */
@WebListener
public class OnlineListener implements HttpSessionAttributeListener {
	private static int online = 0;

    /**
     * Default constructor. 
     */
    public OnlineListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         synchronized (OnlineListener.class) {
			if(se.getName().equals("user")) {
				online = online +1;
				se.getSession().getServletContext().setAttribute("online", online);
				if(se.getValue() instanceof User) {
					User user = (User)se.getValue();
					System.out.println(user.getUsername()+"上线了...");
				}
			}
		}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	 synchronized (OnlineListener.class) {
 			if(se.getName().equals("user")) {
 				online = online -1;
 				se.getSession().getServletContext().setAttribute("online", online);
 				if(se.getValue() instanceof User user) {
 					System.out.println(user.getUsername()+"下线了...");
 				}
 			}
 		}
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
