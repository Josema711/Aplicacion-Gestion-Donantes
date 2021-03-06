package Objetos;


public class Donante {
	
	//Atributos
	
	private Integer nēdonante;
	private String nombre;
	private String Apellido1;
	private String Apellido2;
	private String identificacion;
	private String fecha_nacimiento;
	private String direccion;
	private String poblacion;
	private Integer cp;
	private Integer telefono;
	private String correo;
	private String sexo;
	private String grupo_sanguineo;
	private String ciclo;
	
	
	
	//Constructor
	
	public Donante(Integer nēdonante, String nombre, String apellido1, String apellido2, String identificacion,
			String fecha_nacimiento, String direccion, String poblacion, Integer cp, Integer telefono, String correo, String sexo,
			String grupo_sanguineo, String ciclo) {
		super();
		this.nēdonante = nēdonante;
		this.nombre = nombre;
		this.Apellido1 = apellido1;
		this.Apellido2 = apellido2;
		this.identificacion = identificacion;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.cp = cp;
		this.telefono = telefono;
		this.correo = correo;
		this.sexo = sexo;
		this.grupo_sanguineo = grupo_sanguineo;
		this.ciclo = ciclo;
	}
	
	
	
	//Metodos

	public Integer getNēdonante() {
		return nēdonante;
	}

	public void setNēdonante(Integer nēdonante) {
		this.nēdonante = nēdonante;
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

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
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

	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
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



	public Integer getTelefono() {
		return telefono;
	}



	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
	
	
	
	

}
