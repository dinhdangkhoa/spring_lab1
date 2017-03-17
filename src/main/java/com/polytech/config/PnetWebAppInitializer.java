//package com.polytech.config;
//
///**
// * Created by KHOA on 14-Mar-17.
// */
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//
//// lancer le programme sous form web application
//public class PnetWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class<?>[]{ApplicationConfig.class};
//    }
//
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class<?>[]{WebConfig.class};
//    }
//
//
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        super.onStartup(servletContext);
//        servletContext.setInitParameter("spring.profiles.active", "PROD");
//    }
//}
