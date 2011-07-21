package org.okkam.rdfviewer.model;

import java.util.ArrayList;
import java.util.Iterator;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.query.*;

public class ModelUtil {

	public Model getResult(Model model) {
		
		MultiMap rdfResults = new MultiMap();
		Query query = QueryFactory.create("prefix tax: <http://localhost/TaxOntology.owl#> "
						+ "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>  "
						+ "SELECT ?subject ?predicate ?object "
						+ "WHERE {?subject ?predicate ?object . }");
		
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		Model tempmodel=ModelFactory.createDefaultModel() ;
		
		try {
			ResultSet results = qe.execSelect();
			while (results.hasNext()) {
				QuerySolution result = results.next();
				/*
				MultiMap propertyObjectResult = new MultiMap();
				propertyObjectResult.put(result.get("predicate"), result.get("object"));
				rdfResults.put(result.get("subject"),propertyObjectResult );*/
				Resource subject=model.createResource(result.get("subject").toString()) ;
				Property property=model.createProperty(result.get("predicate").toString());
				Resource object=model.createResource(result.get("object").toString()) ;
				Statement newstmt=ResourceFactory.createStatement(subject, property, object) ;
				tempmodel.add(newstmt);
			}
		} finally {
			qe.close();
		}
		return tempmodel;
	}	
	
}
