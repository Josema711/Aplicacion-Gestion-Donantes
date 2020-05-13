package Objetos;

public class Donacion {
	
	//Atributos
	private Integer nºdonacion;
	private Integer cod_colecta;
	private String tipo_donacion;
	private Integer pulso;
	private Integer ta_sist;
	private Integer ta_diast;
	private Integer hb_cap;
	private Integer hb_ven;
	private String fecha;
	
	//Constructor
	public Donacion(Integer nºdonacion, Integer cod_colecta, String tipo_donacion, Integer pulso, Integer ta_sist,
			Integer ta_diast, Integer hb_cap, Integer hb_ven, String fecha) {
		super();
		this.nºdonacion = nºdonacion;
		this.cod_colecta = cod_colecta;
		this.tipo_donacion = tipo_donacion;
		this.pulso = pulso;
		this.ta_sist = ta_sist;
		this.ta_diast = ta_diast;
		this.hb_cap = hb_cap;
		this.hb_ven = hb_ven;
		this.fecha = fecha;
	}

	//Atributos
	public Integer getNºdonacion() {
		return nºdonacion;
	}

	public void setNºdonacion(Integer nºdonacion) {
		this.nºdonacion = nºdonacion;
	}

	public Integer getCod_colecta() {
		return cod_colecta;
	}

	public void setCod_colecta(Integer cod_colecta) {
		this.cod_colecta = cod_colecta;
	}

	public String getTipo_donacion() {
		return tipo_donacion;
	}

	public void setTipo_donacion(String tipo_donacion) {
		this.tipo_donacion = tipo_donacion;
	}

	public Integer getPulso() {
		return pulso;
	}

	public void setPulso(Integer pulso) {
		this.pulso = pulso;
	}

	public Integer getTa_sist() {
		return ta_sist;
	}

	public void setTa_sist(Integer ta_sist) {
		this.ta_sist = ta_sist;
	}

	public Integer getTa_diast() {
		return ta_diast;
	}

	public void setTa_diast(Integer ta_diast) {
		this.ta_diast = ta_diast;
	}

	public Integer getHb_cap() {
		return hb_cap;
	}

	public void setHb_cap(Integer hb_cap) {
		this.hb_cap = hb_cap;
	}

	public Integer getHb_ven() {
		return hb_ven;
	}

	public void setHb_ven(Integer hb_ven) {
		this.hb_ven = hb_ven;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	
	

}
