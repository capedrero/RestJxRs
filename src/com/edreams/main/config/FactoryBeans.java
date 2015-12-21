package com.edreams.main.config;

import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class FactoryBeans {

	    private static FactoryBeans instance;    

	    private static AnnotationConfigApplicationContext context;  


		static{
			FactoryBeans.instance = new FactoryBeans();
		}
		private FactoryBeans(){}
	  
	    public static <T> FactoryBeans  getInstance(Class<T> cl) {	        
	       context = new AnnotationConfigApplicationContext();    	   	  
	       setConfiguration(cl);
	       context.refresh();    
	       return instance;
	    }
	   
	    private static <T> void setConfiguration(Class<T> cl) {    	    
	    	context.register(cl);	    	    	
		}

		public  <T> Map<String, T> getAllBeans(Class<T> sClass) {      	
	    	return context.getBeansOfType(sClass);    	
	    }   
	    public  <T> T getBean(Class<T> sClass) {      	
	    	return context.getBean(sClass);    	
	    }   
	   
	}
