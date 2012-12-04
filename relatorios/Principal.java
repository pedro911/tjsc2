import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Gerando relatório...");
		// lista com os nossos clientes
		List lista = new ArrayList();
		Pessoa c1 = new Pessoa(); c1.setNome("Alexandre Macedo"); 
		c1.setEmail("alexbmac@gmail.com");
		c1.setTelefone("9999-9999"); 
		Pessoa c2 = new Pessoa(); 
		c2.setNome("Rafael Cosentino");
		c2.setEmail("cosen@gmail.com");
		c2.setTelefone("8888-8888");
		Pessoa c3 = new Pessoa(); 
		c3.setNome("Daniel Machado");
		c3.setEmail("daniel@gmail.com");
		c3.setTelefone("7777-7777");
		
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		
		// compilacao do JRXML 
		JasperReport report;
		try {
			report = JasperCompileManager.compileReport("relatorios/teste.jrxml");
			JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
			// exportacao do relatorio para outro formato, no caso PDF
			JasperExportManager.exportReportToPdfFile(print, "relatorios/Relatorio.pdf");
			System.out.println("Relatório gerado.");
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
