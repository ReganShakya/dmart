/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author regan
 */

@SpringBootApplication
public class appRunner {
    public static void main(String[] args){
        BCryptPasswordEncoder encoder =
                new BCryptPasswordEncoder();
        SpringApplication.run(appRunner.class, args);
        System.out.println(encoder.encode("password"));
    }
}

//public class appRunner implements WebApplicationInitializer{
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext ctx = 
//                new AnnotationConfigWebApplicationContext();
//        ctx.register(SystemConfiguration.class);
//        
//        ServletRegistration.Dynamic dispatcher = 
//                servletContext.addServlet("dispatcher", 
//                        new DispatcherServlet(ctx));
//        dispatcher.addMapping("/");
//    }
//    
//}