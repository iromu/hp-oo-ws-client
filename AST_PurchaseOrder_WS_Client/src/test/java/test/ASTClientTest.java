package test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.junit.BeforeClass;
import org.junit.Test;

import ast_purchaseorder_ws.ASTPurchaseOrderWSPortType;
import ast_purchaseorder_ws.AuthenticationInfo;
import ast_purchaseorder_ws.ObjectFactory;

public class ASTClientTest {
	private static ASTPurchaseOrderWSPortType client;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		QName serviceName = new QName("urn:AST_PurchaseOrder_WS",
				"AST_PurchaseOrder_WSService");

		QName portName = new QName("urn:AST_PurchaseOrder_WS",
				"AST_PurchaseOrder_WSPort");

		System.out.println("Starting Client");
		Service service = Service.create(serviceName);
		service
				.addPort(
						portName,
						SOAPBinding.SOAP11HTTP_BINDING,
						"http://configuracion.tsm.inet/arsys/services/ARService?server=fsg0x021.tsm.inet&webService=AST_PurchaseOrder_WS");

		client = service.getPort(portName, ASTPurchaseOrderWSPortType.class);

	}

	@Test
	public void testList() {
		System.out.println("Invoking getListOfNewPOs...");
		java.lang.String _getListOfNewPOs_supplier = "SUPPLIER";
		
		ObjectFactory factory = new ObjectFactory();
		AuthenticationInfo info = factory.createAuthenticationInfo();
		
		info.setUserName("USERNAME");
		info.setPassword("PASSWORD");
		
		java.util.List<org.tempuri.PurchaseOrderOutputMapping.GetListValues> _getListOfNewPOs__return = client
				.getListOfNewPOs(_getListOfNewPOs_supplier, info);
		System.out
				.println("getListOfNewPOs.result=" + _getListOfNewPOs__return);

	}

}
