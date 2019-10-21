package webservice;

import javax.xml.ws.Endpoint;

public class Test {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8090/service",new TestWebserviceImp());
		System.out.println("发布成功");
	}
}
