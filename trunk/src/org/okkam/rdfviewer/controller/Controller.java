package org.okkam.rdfviewer.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.okkam.rdfviewer.model.ModelLoader;
import org.okkam.rdfviewer.model.ModelUtil;
import org.okkam.rdfviewer.view.DataView;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
   
	ModelUtil modelutil = null;
	
    Model inputModel = null ;
	ModelLoader loader = null;
   
    public void init() throws ServletException {
        
    	ServletContext sc = getServletContext();
		String inputDatasetFileName=sc.getRealPath("resources/test/rdfviewer.ttl");
    	InputStream in = FileManager.get().open( inputDatasetFileName );
		if (in == null) {		    
		
			System.exit(0);
		}
		
		// Create the input model. Models different from the default one import also the 
		// rdf and rdf-schema axioms. The input model usually comes with blank nodes. 
		inputModel = ModelFactory.createDefaultModel();
		
		// read the RDF/TURTLE file
		inputModel.read(in, null, "TURTLE");
    	
    	
    	
    	modelutil=new ModelUtil();
        
        
		
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		Model tempmodel=modelutil.getResult(inputModel);
		
		StmtIterator iter = tempmodel.listStatements();
		
		//DataView dataview[] =new DataView[iter.toList().size()];
		DataView dataview =new DataView();
		Statement statement=iter.next();
		
		dataview.setSubject(statement.getSubject().toString());
		dataview.setProperty(statement.getPredicate().toString());
		dataview.setObject(statement.getObject().toString());		
		
		request.setAttribute("DataView", dataview);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
