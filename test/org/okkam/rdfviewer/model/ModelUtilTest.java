package org.okkam.rdfviewer.model;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class ModelUtilTest {
	private static Log log = LogFactory.getLog(ModelUtilTest.class);
	
	static Model model = null ;
	static ModelUtil modelUtil=null;
	static ModelLoader loader=null;
/*	@Before
	public void setUp() throws Exception {
		loader = ModelLoader.getInstance();
		model=loader.getInputModel();
		modelUtil=new ModelUtil();
	}*/
	@Test
	public void testGetResult() {
		ModelUtil modelitil=new ModelUtil();
		Model tempmodel=modelitil.getResult();
		StmtIterator iter = tempmodel.listStatements();
		while(iter.hasNext()){
			Statement statment=iter.next();
			System.out.println("Subject: "+statment.getSubject()+"Property: "+statment.getPredicate()+"Object: "+statment.getObject());
		}
		iter = tempmodel.listStatements();
		int x=iter.toList().size();
		System.out.println("There are "+x+" results");
	}

}
