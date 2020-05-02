package Objetos;

import java.sql.Date;

public class Donante {
	
	//Atributos
	
	private int nºdonante;
	private String nombre;
	private String Apellido1;
	private String Apellido2;
	private String identificacion;
	private Date fecha_nacimiento;
	private String direccion;
	private String poblacion;
	private int cp;
	private String correo;
	private String sexo;
	private String grupo_sanguineo;
	private String ciclo;
	
	
	
	//Constructor
	
	public Donante(int nºdonante, String nombre, String apellido1, String apellido2, String identificacion,
			Date fecha_nacimiento, String direccion, String poblacion, int cp, String correo, String sexo,
			String grupo_sanguineo, String ciclo) {
		super();
		this.nºdonante = nºdonante;
		this.nombre = nombre;
		Apellido1 = apellido1;
		Apellido2 = apellido2;
		this.identificacion = identificacion;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.cp = cp;
		this.correo = correo;
		this.sexo = sexo;
		this.grupo_sanguineo = grupo_sanguineo;
		this.ciclo = ciclo;
	}
	
	
	
	//Metodos

	public int getNºdonante() {
		return nºdonante;
	}

	public void setNºdonante(int nºdonante) {
		this.nºdonante = nºdonante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return Apellido1;
	}

	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}

	public String getApellido2() {
		return Apellido2;
	}

	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getGrupo_sanguineo() {
		return grupo_sanguineo;
	}

	public void setGrupo_sanguineo(String grupo_sanguineo) {
		this.grupo_sanguineo = grupo_sanguineo;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	
	
	
	
	

}
