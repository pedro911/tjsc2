
public class ServicosPendentes {
	
	private String placa;
	private int odometro;
	private int kmProximoServico;
	private String dataProximoServico;
	private String TipoServico;
	private String situacaoVeiculo;
	private String situacaoServico;
	
	public ServicosPendentes() {
		super();
	}

	public ServicosPendentes(String placa, int odometro, int kmProximoServico,
			String dataProximoServico, String tipoServico,
			String situacaoVeiculo, String situacaoServico) {
		super();
		this.placa = placa;
		this.odometro = odometro;
		this.kmProximoServico = kmProximoServico;
		this.dataProximoServico = dataProximoServico;
		TipoServico = tipoServico;
		this.situacaoVeiculo = situacaoVeiculo;
		this.situacaoServico = situacaoServico;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getOdometro() {
		return odometro;
	}

	public void setOdometro(int odometro) {
		this.odometro = odometro;
	}

	public int getKmProximoServico() {
		return kmProximoServico;
	}

	public void setKmProximoServico(int kmProximoServico) {
		this.kmProximoServico = kmProximoServico;
	}

	public String getDataProximoServico() {
		return dataProximoServico;
	}

	public void setDataProximoServico(String dataProximoServico) {
		this.dataProximoServico = dataProximoServico;
	}

	public String getTipoServico() {
		return TipoServico;
	}

	public void setTipoServico(String tipoServico) {
		TipoServico = tipoServico;
	}

	public String getSituacaoVeiculo() {
		return situacaoVeiculo;
	}

	public void setSituacaoVeiculo(String situacaoVeiculo) {
		this.situacaoVeiculo = situacaoVeiculo;
	}

	public String getSituacaoServico() {
		return situacaoServico;
	}

	public void setSituacaoServico(String situacaoServico) {
		this.situacaoServico = situacaoServico;
	}
	
	

}
