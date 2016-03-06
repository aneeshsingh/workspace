package com.macquarie.analytics;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public class PrintHashmap {
	public static void hashMapPrinter(HttpServletResponse resp,HashMap completeHashMap) throws IOException{
		
		 Iterator it = completeHashMap.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        resp.getWriter().println(pair.getKey() + " = " + pair.getValue());
		    }
	}
}
