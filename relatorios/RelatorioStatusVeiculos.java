import java.sql.SQLException;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.fean.tjsc.dao.veiculo.Veiculo;
import com.fean.tjsc.mb.veiculo.VeiculoMB;


public class RelatorioStatusVeiculos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Gerando relatório...");
		// lista com os veiculos
		/* melhorar esse relatorio: fazer usando os valores que jah estao na tabela da tela inicial, 
		 * pegar cada celula, setar o valor para o objeto util.ServicosPendentes.java
		 * criar um List<> adicionando cada linha da tabela
		 * passar esse List<> pra gerar o relatorio
		 * e tambem arrumar o relatorio pra ficar bonito...
		 * feito isso: FIM!!! 
		 */

		VeiculoMB veiculoMB = VeiculoMB.getInstance();
		

		try {
			List<Veiculo> veiculosTestados = veiculoMB.statusTodosVeiculos();
			// compilacao do JRXML 
			JasperReport report;
			try {
				report =
						JasperCompileManager .compileReport("relatorios/servicosPendentes.jrxml");
				JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(veiculosTestados));
				// exportacao do relatorio para outro formato, no caso PDF
				JasperExportManager.exportReportToPdfFile(print, "relatorios/Relatorio.pdf");
				System.out.println("Relatório gerado.");
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

}
