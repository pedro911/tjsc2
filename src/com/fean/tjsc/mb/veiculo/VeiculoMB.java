package com.fean.tjsc.mb.veiculo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import com.fean.tjsc.dao.abastecimento.Abastecimento;
import com.fean.tjsc.dao.abastecimento.AbastecimentoDAO;
import com.fean.tjsc.dao.servico.Servico;
import com.fean.tjsc.dao.servico.ServicoDAO;
import com.fean.tjsc.dao.tiposervico.TipoServico;
import com.fean.tjsc.dao.tiposervico.TipoServicoDAO;
import com.fean.tjsc.dao.tiposervico.TipoServicoModelo;
import com.fean.tjsc.dao.tiposervico.TipoServicoModeloDAO;
import com.fean.tjsc.dao.tiposervico.TipoServicoModeloId;
import com.fean.tjsc.dao.tiposervico.TipoServicoVeiculo;
import com.fean.tjsc.dao.tiposervico.TipoServicoVeiculoDAO;
import com.fean.tjsc.dao.usuario.Usuario;
import com.fean.tjsc.dao.usuario.UsuarioDAO;
import com.fean.tjsc.dao.veiculo.Veiculo;
import com.fean.tjsc.dao.veiculo.VeiculoDAO;
import com.fean.tjsc.util.DataUtil;




public class VeiculoMB {
	private static VeiculoMB abastecimentoMB = new VeiculoMB();

	private VeiculoMB(){

	}

	public static VeiculoMB getInstance(){
		return abastecimentoMB;

	}

	public String inserir(Veiculo veiculo) {
		String retorno = "ok";
		VeiculoDAO veiculoDAO = VeiculoDAO.getInstance();
		try {
			veiculoDAO.save(veiculo);
		} catch (Exception e) {
			retorno = "erro";
		}

		return retorno;
	}

	public String editar(Veiculo veiculo) {
		String retorno = "ok";
		VeiculoDAO veiculoDAO = VeiculoDAO.getInstance();
		try {
			veiculoDAO.update(veiculo);
		} catch (Exception e) {
			retorno = "erro";
		}

		return retorno;
	}


	public String apagar(Veiculo veiculo) {
		String retorno = "ok";
		VeiculoDAO veiculoDAO = VeiculoDAO.getInstance();
		try {
			veiculoDAO.delete(veiculo);
		} catch (Exception e) {
			retorno = "erro";
		}

		return retorno;
	}

	public Veiculo retornarVeiculo(int id) {
		VeiculoDAO veiculoDAO = VeiculoDAO.getInstance();
		return veiculoDAO.findById(id);

	}

	public List<Veiculo> finbByAll() throws ClassNotFoundException, SQLException{
		VeiculoDAO veiculoDAO = VeiculoDAO.getInstance();
		return veiculoDAO.findAll();
	}
	
	public List<TipoServicoModelo> statusVeiculos () throws ClassNotFoundException, SQLException{
		
		List<Veiculo> veiculo = finbByAll();
		List<TipoServicoModelo> tiposServicosModeloVeiculo = null;
		List<TipoServicoModelo> tiposServicosModeloResultado = null;
		String retorno = "";
		TipoServicoModeloDAO tiposervicomodeloDAO = TipoServicoModeloDAO.getInstance();
		ServicoDAO servicoDAO = ServicoDAO.getInstance();
		//TipoServicoVeiculoDAO tipoServicoVeiculoDAO = TipoServicoVeiculoDAO.getInstance();
		Calendar hoje = Calendar.getInstance();

		for (int i1=0;i1<veiculo.size();i1++){
			
			tiposServicosModeloVeiculo = (List<TipoServicoModelo>) tiposervicomodeloDAO.findTipoServicoByModelo(veiculo.get(i1).getModelo());
			
			for (int i=0;i<tiposServicosModeloVeiculo.size();i++){
				// para cada tipo de servico busca o ultimo servico feito
				// terminar o teste para cada servico quando != null

				Servico ultimoServico = servicoDAO.findUltimoServico(veiculo.get(i1), tiposServicosModeloVeiculo.get(i).getTipoServico());

				if ( ultimoServico != null ){
					Calendar dataUltimoServicoPercent = Calendar.getInstance();  
					dataUltimoServicoPercent.setTime(ultimoServico.getData2());
					dataUltimoServicoPercent.add(Calendar.MONTH, ((tiposServicosModeloVeiculo.get(i).getTempo()-1)));  // adicionar 5 meses  

					Calendar dataUltimoServico = Calendar.getInstance();   
					dataUltimoServico.setTime(ultimoServico.getData2());
					dataUltimoServico.add(Calendar.MONTH, (tiposServicosModeloVeiculo.get(i).getTempo()));  // adicionar 6 meses

					if ( (veiculo.get(i1).getOdometro() > (ultimoServico.getKm() + (tiposServicosModeloVeiculo.get(i).getKm()*0.8)))  
							|| ( hoje.after(dataUltimoServicoPercent) ) ) {					
						if ( ( (veiculo.get(i1).getOdometro() > ( ultimoServico.getKm() + (tiposServicosModeloVeiculo.get(i).getKm()*0.8)) 
								&& veiculo.get(i1).getOdometro() < ( ultimoServico.getKm() + (tiposServicosModeloVeiculo.get(i).getKm())) ) ) 
								|| ( hoje.after(dataUltimoServicoPercent) && hoje.before(dataUltimoServico) ) ){
							if( hoje.after(dataUltimoServico)){
								retorno = "vermelho";
							}						
							else{
								retorno = "amarelo";
							}
						}
						else{
							retorno = "vermelho";
						}
					}
					else{
						retorno = "verde";
					}					
				}
				else{

					Calendar dataCadastroPercent = Calendar.getInstance();  
					dataCadastroPercent.setTime(veiculo.get(i1).getDataCadastro());
					dataCadastroPercent.add(Calendar.MONTH, ((tiposServicosModeloVeiculo.get(i).getTempo()-1)));  // adicionar 5 meses  

					Calendar dataCadastro = Calendar.getInstance();   
					dataCadastro.setTime(veiculo.get(i1).getDataCadastro());
					dataCadastro.add(Calendar.MONTH, (tiposServicosModeloVeiculo.get(i).getTempo()));  // adicionar 6 meses

					if ( (veiculo.get(i1).getOdometro() > (veiculo.get(i1).getKmCadastro() + (tiposServicosModeloVeiculo.get(i).getKm()*0.8)))  
							|| ( hoje.after(dataCadastroPercent) ) ) {					
						if ( ( (veiculo.get(i1).getOdometro() < ( veiculo.get(i1).getKmCadastro() + (tiposServicosModeloVeiculo.get(i).getKm())) 
								&& veiculo.get(i1).getOdometro() < ( veiculo.get(i1).getKmCadastro() + (tiposServicosModeloVeiculo.get(i).getKm())) ) ) 
								|| ( hoje.after(dataCadastroPercent) && hoje.before(dataCadastro) ) ){
							if( hoje.after(dataCadastro) ){
								retorno = "vermelho";
							}
							else{
								retorno = "amarelo";
							}						
						}
						else{
							retorno = "vermelho";
						}
					}
					else{
						retorno = "verde";
					}
				}				
			}
			veiculo.get(i1).setSituacao(retorno);
			editar(veiculo.get(i1));			
		}
		return tiposServicosModeloResultado;
	}
	
	public List<Veiculo> statusTodosVeiculos () throws ClassNotFoundException, SQLException{
		
		List<Veiculo> veiculo = finbByAll();
		List<TipoServicoModelo> tiposServicosModeloVeiculo = null;
		String retorno = "";
		TipoServicoModeloDAO tiposervicomodeloDAO = TipoServicoModeloDAO.getInstance();
		ServicoDAO servicoDAO = ServicoDAO.getInstance();
		Calendar hoje = Calendar.getInstance();

		for (int i1=0;i1<veiculo.size();i1++){
			
			tiposServicosModeloVeiculo = (List<TipoServicoModelo>) tiposervicomodeloDAO.findTipoServicoByModelo(veiculo.get(i1).getModelo());
			
			for (int i=0;i<tiposServicosModeloVeiculo.size();i++){
				// para cada tipo de servico busca o ultimo servico feito
				// terminar o teste para cada servico quando != null

				Servico ultimoServico = servicoDAO.findUltimoServico(veiculo.get(i1), tiposServicosModeloVeiculo.get(i).getTipoServico());

				if ( ultimoServico != null ){
					Calendar dataUltimoServicoPercent = Calendar.getInstance();  
					dataUltimoServicoPercent.setTime(ultimoServico.getData2());
					dataUltimoServicoPercent.add(Calendar.MONTH, ((tiposServicosModeloVeiculo.get(i).getTempo()-1)));  // adicionar 5 meses  

					Calendar dataUltimoServico = Calendar.getInstance();   
					dataUltimoServico.setTime(ultimoServico.getData2());
					dataUltimoServico.add(Calendar.MONTH, (tiposServicosModeloVeiculo.get(i).getTempo()));  // adicionar 6 meses

					if ( (veiculo.get(i1).getOdometro() > (ultimoServico.getKm() + (tiposServicosModeloVeiculo.get(i).getKm()*0.8)))  
							|| ( hoje.after(dataUltimoServicoPercent) ) ) {					
						if ( ( (veiculo.get(i1).getOdometro() > ( ultimoServico.getKm() + (tiposServicosModeloVeiculo.get(i).getKm()*0.8)) 
								&& veiculo.get(i1).getOdometro() < ( ultimoServico.getKm() + (tiposServicosModeloVeiculo.get(i).getKm())) ) ) 
								|| ( hoje.after(dataUltimoServicoPercent) && hoje.before(dataUltimoServico) ) ){
							if( hoje.after(dataUltimoServico)){
								retorno = "vermelho";
							}						
							else{
								retorno = "amarelo4";
							}
						}
						else{
							retorno = "vermelho";
						}
					}
					else{
						retorno = "verde";
					}					
				}
				else{

					Calendar dataCadastroPercent = Calendar.getInstance();  
					dataCadastroPercent.setTime(veiculo.get(i1).getDataCadastro());
					dataCadastroPercent.add(Calendar.MONTH, ((tiposServicosModeloVeiculo.get(i).getTempo()-1)));  // adicionar n-1 meses  

					Calendar dataCadastro = Calendar.getInstance();   
					dataCadastro.setTime(veiculo.get(i1).getDataCadastro());
					dataCadastro.add(Calendar.MONTH, (tiposServicosModeloVeiculo.get(i).getTempo()));  // adicionar n meses

					if ( (veiculo.get(i1).getOdometro() > (veiculo.get(i1).getKmCadastro() + (tiposServicosModeloVeiculo.get(i).getKm()*0.8)))  
							|| ( hoje.after(dataCadastroPercent) ) ) {					
						if ( ( (veiculo.get(i1).getOdometro() < ( veiculo.get(i1).getKmCadastro() + (tiposServicosModeloVeiculo.get(i).getKm())) 
								&& veiculo.get(i1).getOdometro() < ( veiculo.get(i1).getKmCadastro() + (tiposServicosModeloVeiculo.get(i).getKm())) ) ) 
								|| ( hoje.after(dataCadastroPercent) && hoje.before(dataCadastro) ) ){
							if( hoje.after(dataCadastro) ){
								retorno = "vermelho";
							}
							else{
								retorno = "amarelo";
							}						
						}
						else{
							retorno = "vermelho";
						}
					}
					else{
						retorno = "verde";
					}
				}
				
							
			}
			veiculo.get(i1).setSituacao(retorno);
			editar(veiculo.get(i1));								
		}
		return veiculo;
	}
		

}	











