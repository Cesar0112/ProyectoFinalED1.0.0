package logica;

public class Patron {
	private double[] parametros;//contiene los parametros
	private String clase;
	private int numberOfParametters;
	
	
	public Patron() {
		super();
	}
	public Patron(double[] parametros) {
		super();
		this.parametros = parametros;
		this.clase = null;
		this.numberOfParametters = parametros.length;
	}
	public Patron(double[] parametros, String clase) {
		super();
		this.parametros = parametros;
		this.clase = clase;
		this.numberOfParametters = parametros.length;
	}
	public double[] getParametros() {
		return parametros;
	}
	public void setParametros(double[] parametros) {
		this.parametros = parametros;
		numberOfParametters = parametros.length;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public int getNumberOfParametters() {
		return numberOfParametters;
	}
	public void setNumberOfParametters(int numberOfParametters) {
		this.numberOfParametters = numberOfParametters;
	}
	
	
 }
