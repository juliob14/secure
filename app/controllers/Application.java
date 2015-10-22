package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import play.data.validation.Check;
@With(Secure.class)
public class Application extends Controller {

    public static void index() {
        String user = Security.connected();
        render(user);
        
        
    }
    @Check("administrator")
   public static void delete(Long id) {
   }
    static boolean check(String profile) {
        User user = User.find("byEmail", connected()).first();
        if ("administrator".equals(profile)) {
            return user.admin;
        }
        else {
            return false;
        }
    }    
    
}