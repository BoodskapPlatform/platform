package io.boodskap.iot.spi.storage.jpa;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

import io.boodskap.iot.PackageUtil;
import io.boodskap.iot.util.JtwigUtil;

public class PersistenceUpdaterTool {
	
	private static void update() {
		
		try {
			
			String pkg = "io.boodskap.iot.model.jpa";
			SortedSet<String> entities = new TreeSet<String>(); 			
			
		    PackageUtil.getClasses(pkg).forEach(clz -> {
		    	Entity entity = clz.getAnnotation(Entity.class);
		    	MappedSuperclass msu = clz.getAnnotation(MappedSuperclass.class);
		    	Embeddable emb = clz.getAnnotation(Embeddable.class);
		    	if(null != entity || null != msu || null != emb) {
		    		entities.add(pkg + "." + clz.getSimpleName());
		    	}
		    });
		    
		    Map<String, Object> props = new HashMap<>();
		    props.put("entities", entities);
		    
		    String result = JtwigUtil.mergeClasspathTemplate("/templates/persistence.twig", props);
		    
		    System.out.println(result);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PersistenceUpdaterTool.update();
	}
}
