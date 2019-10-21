package webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface TestWebservice {

	@WebMethod(action = "getName")
	public String getName(String id);
	
	@WebMethod(action = "getAll")
	public String getAll();
}
