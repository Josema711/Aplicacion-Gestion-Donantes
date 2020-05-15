package Vista;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ImprimeArchivo {

	//Atributos
	private String filename;
	private String filepath;
	private int NºDonante;
	private String Nombre;
	private String Apellido1;
	private String Apellido2;
	private String Sangre;
	private String Identificacion;


	//Constructores
	public ImprimeArchivo(String filename, String filepath) {
		super();
		this.filename = filename;
		this.filepath = filepath;
	}


	public ImprimeArchivo(String filename, String filepath, int nºDonante, String nombre, String apellido1,
			String apellido2, String sangre, String identificacion) {
		super();
		this.filename = filename;
		this.filepath = filepath;
		NºDonante = nºDonante;
		Nombre = nombre;
		Apellido1 = apellido1;
		Apellido2 = apellido2;
		Sangre = sangre;
		Identificacion = identificacion;
	}


	

	//Metodos
	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public String getFilepath() {
		return filepath;
	}


	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}


	public int getNºDonante() {
		return NºDonante;
	}


	public void setNºDonante(int nºDonante) {
		NºDonante = nºDonante;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
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

	public String getSangre() {
		return Sangre;
	}


	public void setSangre(String sangre) {
		Sangre = sangre;
	}
	
	public String getIdentificacion() {
		return Identificacion;
	}


	public void setIdentificacion(String identificacion) {
		Identificacion = identificacion;
	}

	
	
	/* Este método generará el PDF  */
	public void generarArchivoPDF(int nºDonante, String nombre, String apellido1,
			String apellido2,String sangre, String identificacion) throws FileNotFoundException, DocumentException {

		// Crea el nombre del archivo con el path, el nombre del  fichero y la extensión PDF
		String sFileNamePath = filepath + filename+".pdf";

		// Se crea el documento que se va a imprimir
		Document documento = new Document();


		// En principio el tamaño de la página está paara un A4 en vertical, pero puedes investigar y cambiar el tamaño de la zona de impresión
		// Eso sí... te tocará investigar y buscar: el método setPageSize
		//documento.setPageSize() Lo que le pases como  argumento

		System.out.println(sFileNamePath);

		// Se crea el OutputStream para el fichero donde queremos dejar el pdf.
		FileOutputStream ficheroPdf = new FileOutputStream(sFileNamePath);

		// Se asocia el documento al OutputStream y se indica que el espaciado entre
		// lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
		PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);

		// Se abre el documento.
		documento.open();

		// La unidad para imprimir es el párrafo se pasa el texto del párrafo, se pueden poner saltos de línea dentro
		// el tipo, tamaño de letra y si es en negrita (BOLD), cursiva (ITALIC), en cursivaNEgrita (BOLDITALIC) o normal (NORMAL)

		Paragraph p1 = new Paragraph("CARNET DE DONANTE",
		FontFactory.getFont("arial",   // fuente
		13,                            // tamaño
		Font.BOLD));

		// Una vez creado el párrafo puedes modificar varias opciones... como aquí la alineación
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFY
		p1.setAlignment(Element.ALIGN_CENTER);

		// Añade el párrafo al documeento
		documento.add(p1);


		Paragraph p2 = new Paragraph(nombre + " " + apellido1 + " " + apellido2,
		FontFactory.getFont("arial",   // fuente
		11,                            // tamaño
		Font.ITALIC));

		// Una vez creado el párrafo puedes modificar varias opciones... como aquí la alineación
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFY
		p2.setAlignment(Element.ALIGN_CENTER);

		// Añade el párrafo al documeento
		documento.add(p2);
		
		// La unidad para imprimir es el párrafo se pasa el texto del párrafo, se pueden poner saltos de línea dentro
		// el tipo, tamaño de letra y si es en negrita (BOLD), cursiva (ITALIC), en cursivaNEgrita (BOLDITALIC) o normal (NORMAL)

		Paragraph p3 = new Paragraph("Soy tipo: " + sangre,
		FontFactory.getFont("arial",   // fuente
		11,                            // tamaño
		Font.ITALIC));

		// Una vez creado el párrafo puedes modificar varias opciones... como aquí la alineación
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFY
		p3.setAlignment(Element.ALIGN_CENTER);

		// Añade el párrafo al documeento
		documento.add(p3);

		
		// La unidad para imprimir es el párrafo se pasa el texto del párrafo, se pueden poner saltos de línea dentro
		// el tipo, tamaño de letra y si es en negrita (BOLD), cursiva (ITALIC), en cursivaNEgrita (BOLDITALIC) o normal (NORMAL)

		Paragraph p4 = new Paragraph("DNI/NIE: " + identificacion,
		FontFactory.getFont("arial",   // fuente
		11,                            // tamaño
		Font.ITALIC));

		// Una vez creado el párrafo puedes modificar varias opciones... como aquí la alineación
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFY
		p4.setAlignment(Element.ALIGN_CENTER);

		// Añade el párrafo al documeento
		documento.add(p4);
		
		Paragraph p5 = new Paragraph("Soy el donante nº: " + nºDonante,
		FontFactory.getFont("arial",   // fuente
		11,                            // tamaño
		Font.ITALIC));

		// Una vez creado el párrafo puedes modificar varias opciones... como aquí la alineación
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFY
		p5.setAlignment(Element.ALIGN_CENTER);

		// Añade el párrafo al documeento
		documento.add(p5);

	

		documento.close();


	}

}
	
	



	

