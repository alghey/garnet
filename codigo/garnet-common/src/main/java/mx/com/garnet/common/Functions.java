package mx.com.garnet.common;

import java.util.ArrayList;
import java.util.List;

public class Functions {
	
	
	/***********************************************************************************
	 * 		Pagina una lista de objetos   *
	 * *********************************************************************************
	 * @param sourceList lista a paginar
	 * @param page numero de pagina(debe empezar desde 1)
	 * @param pageSize tamanio de pagina
	 * @return lista paginada
	 */	
	
	
	public static <T> List<T> getPage(List<T> sourceList, int page, int pageSize) {
		List<T> response=new ArrayList<>();
	    if(pageSize > 0 || page> 0) {
	    	if(sourceList!=null) {
	    		int fromIndex = (page - 1) * pageSize;
		    	if(sourceList.size() > fromIndex) {
		    		response=sourceList.subList(fromIndex, Math.min(fromIndex + pageSize, sourceList.size()));
		    	}else {
		    		return response;
		    	}
	    	}else {
	    		return response;
	    	}
	    }else {
	    	response=sourceList;
	    }
	    return response;
	}
	
	
}
