package com.generation.thunderdev.contigo;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author imssbora
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[] {};
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[] {};
   }

   @Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }
}