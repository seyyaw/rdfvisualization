package org.okkam.rdfviewer.model;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ModelUtilTest {
	private static Log log = LogFactory.getLog(ModelUtilTest.class);
	@Test
	public void testGetResult() {
		ModelUtil modelitil=new ModelUtil();
		MultiMap multimap=modelitil.getResult();
		Iterator it=multimap.keySet().iterator();
		while(it.hasNext()){
			MultiMap propObjresult=(MultiMap) it.next();
			String subject=multimap.get(propObjresult).toString();
			Iterator propObjIt=propObjresult.keySet().iterator();
			String property=propObjIt.next().toString();
			String object=propObjresult.get(property).toString();
			log.info("Subject: "+subject+"Property: "+property+"Object: "+object);
		}
	}

}
