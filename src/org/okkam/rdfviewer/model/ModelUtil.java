package org.okkam.rdfviewer.model;

import java.util.Iterator;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.query.*;

public class ModelUtil {

	static Model model = null;

	static ModelLoader loader = null;

	public MultiMap getResult() {
		
		MultiMap rdfResults = new MultiMap();
		Query query = QueryFactory.create("prefix tax: <http://localhost/TaxOntology.owl#> "
						+ "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>  "
						+ "SELECT ?subject ?predicate ?object "
						+ "WHERE {?subject ?predicate ?object . }");
		loader = ModelLoader.getInstance();
		model = loader.getInputModel();
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		try {
			ResultSet results = qe.execSelect();
			while (results.hasNext()) {
				QuerySolution result = results.next();
				MultiMap propertyObjectResult = new MultiMap();
				propertyObjectResult.put(result.get("predicate"), result.get("object"));
				rdfResults.put(result.get("subject"),propertyObjectResult );
			}
		} finally {
			qe.close();
		}
		return rdfResults;
	}	
}
