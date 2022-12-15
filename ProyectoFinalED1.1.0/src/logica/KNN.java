package logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import auxiliar.DistanceClase;
import auxiliar.ListaInsercionOrdenada;

public class KNN {
	private int k;//los vecinos a tomar en cuenta
	private LinkedList<Patron> patternsOfTraining;      //LISTADO DE PATRONES de entrenamiento
	private LinkedList<DistanceClase<Double,String>> distanciasInsertadasOrdenadas;
	private HashMap<String,Integer> frecuenciasKVecinos;
	/*variables necesarias para representarlos en tabla*/
	/* las cuales cuentan la frecuencia de clasificaciones de cada clase*/
	// osea de cada Iris-setosa Iris-versicolor o Iris-Virginica
	private Integer contIris_setosa=0,contIris_versicolor=0,contIris_virginica=0;
	private String Iris_virginica="Iris-virginica";
	private String Iris_versicolor="Iris-versicolor";
	private String Iris_setosa="Iris-setosa";
	private HashMap<String,Integer> frecuenciasClasificacion;
	
	
	public KNN(int k, LinkedList<Patron> patternsOfTraining) {
		super();
		this.k = k;
		this.patternsOfTraining = patternsOfTraining;
		this.distanciasInsertadasOrdenadas = new LinkedList<DistanceClase<Double,String>>();
		this.frecuenciasKVecinos = new HashMap<String, Integer>();

	}
	
	public KNN() {
		super();
		this.k = 0;
		this.patternsOfTraining = new LinkedList<>();
		this.distanciasInsertadasOrdenadas = new LinkedList<>();
		this.frecuenciasKVecinos = new HashMap<>();
	}

	/**
	 * Calula la distancia entre dos patrones
	 * @author César Fernández García
	 * @param patrones
	 * @return -1 si la cantidad de parametros entre los patrones no es la misma si no, retorna la distancia en double
	 *
	 * */
	public double calculaDistancia(Patron pattern1, Patron pattern2) {//calcula la distancia entre dos patrones
		double distance = -1;//alamacena -1 para en caso de que los patrones tengan cantidades distintas de parametros saber que no se puede calcular la distancia


		//verificar que los patrones tengan la misma cantidad de parametros
		if((pattern1.getNumberOfParametters())!=(pattern2.getNumberOfParametters())){
			return distance;
		}

		int sum = 0;//variable que almacena la sumatoria que va dentro de la raiz

		int numOfParametters = pattern1.getNumberOfParametters();//variable que almacena la cantidad de parametros para saber cuando dejar de calcular

		for(int i=0;i<numOfParametters;i++) {//recorre cada parametro de los dos patrones
			sum += Math.pow( (pattern1.getParametros()[i])-(pattern2.getParametros()[i]) , 2);//resta y eleva al cuadrado cada parametro correspondiente a los dos patrones y lo guarda en la variable sum
		}
		distance = Math.sqrt(sum);//halla la raiz cuadrada y lo asigna a distance
		return distance;
	}
	/**
	 * Calcula todas las distancias entre un patrón y todos los patrones de
	 * entrenamiento y ademas los ordena ascendentemente.
	 * @author Cesar Fernandez Garcia.
	 * @return arreglo de DistanceClase si logró realizar la operacion con exito.
	 * @param Patron 
         * @param LinkedList<Patron>
	 * */
	public ListaInsercionOrdenada<DistanceClase<Double,String>> calculaYOrdenaTodasDistanciaEnOrden(Patron patron,LinkedList<Patron> listadoDePatrones,int k) {//calcula las distancias entre un patron y un listado de patrones y los ordena ascentemente en una lista

		ListaInsercionOrdenada<DistanceClase<Double,String>>  listadoDistancias = new ListaInsercionOrdenada<>(k);//lugar donde se va a almacenar las distancias
		
		Iterator<Patron> ite = listadoDePatrones.iterator();
		while(ite.hasNext()){
			Patron actPatron=ite.next();
			listadoDistancias.insertar(new DistanceClase<>(calculaDistancia(patron, actPatron),actPatron.getClase()));
		}

		setDistanciasInsertadasOrdenadas(listadoDistancias.getlistadoObjetos());
		return listadoDistancias;
	}
	/**Clasifica un patron
	 * @author César Fernández García
	 * @param patron
	 * @return String */
	public String clasificaPatron(Patron patron) {//clasifica el  patron 
		String clase="No hay clasificación";

		ListaInsercionOrdenada<DistanceClase<Double,String>> listadoDistancias = calculaYOrdenaTodasDistanciaEnOrden(patron, patternsOfTraining,this.k);	
		for(DistanceClase<Double,String> i : listadoDistancias.getlistadoObjetos()) {
			if(i.getClase().equals(Iris_virginica)) {
				contIris_virginica++;
			}else if(i.getClase().equals(Iris_versicolor)) {
				contIris_versicolor++;
			}else if(i.getClase().equals(Iris_setosa)) {
				contIris_setosa++;
			}
		}

		frecuenciasClasificacion = new HashMap<>();
		/*Agrego las frecuencias con sus respectivas clasificaciones*/
		frecuenciasClasificacion.put(Iris_virginica, contIris_virginica);
		frecuenciasClasificacion.put(Iris_versicolor, contIris_versicolor);
		frecuenciasClasificacion.put(Iris_setosa, contIris_setosa);
		
		
		
		clase = mayor(frecuenciasClasificacion);//asigno la clasificación con mayor frecuencia
		return clase;
	}

	
	public Integer getContIris_setosa() {
		return contIris_setosa;
	}

	public void setContIris_setosa(Integer contIris_setosa) {
		this.contIris_setosa = contIris_setosa;
	}

	public Integer getContIris_versicolor() {
		return contIris_versicolor;
	}

	public void setContIris_versicolor(Integer contIris_versicolor) {
		this.contIris_versicolor = contIris_versicolor;
	}

	public Integer getContIris_virginica() {
		return contIris_virginica;
	}

	public void setContIris_virginica(Integer contIris_virginica) {
		this.contIris_virginica = contIris_virginica;
	}

	public String getIris_virginica() {
		return Iris_virginica;
	}

	public void setIris_virginica(String iris_virginica) {
		Iris_virginica = iris_virginica;
	}

	public String getIris_versicolor() {
		return Iris_versicolor;
	}

	public void setIris_versicolor(String iris_versicolor) {
		Iris_versicolor = iris_versicolor;
	}

	public String getIris_setosa() {
		return Iris_setosa;
	}

	public void setIris_setosa(String iris_setosa) {
		Iris_setosa = iris_setosa;
	}

	public HashMap<String,Integer> getListadoClasificaciones() {
		return frecuenciasClasificacion;
	}

	public void setFrecuenciasClasificacion(HashMap<String,Integer> frecuenciasClasificacion) {
		this.frecuenciasClasificacion = frecuenciasClasificacion;
	}

	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
	}
	public LinkedList<Patron> getPatronesDeEntrenamiento() {
		return patternsOfTraining;
	}
	public void setPatronesDeEntrenamiento(LinkedList<Patron> patronesDeEntrenamiento) {
		this.patternsOfTraining = patronesDeEntrenamiento;
	}
	
	 
		
	/**Metodo que devuelve el elemento mayor de un HashMap
	 * @author César Fernández García*/	
	public String mayor(HashMap<String,Integer> mapa) {
		
		Iterator<String> ite = mapa.keySet().iterator();
		String mayorClasi = ite.next();
		int mayor = mapa.get(mayorClasi);

		while (ite.hasNext()) {
			String act = ite.next();
			if(mapa.get(act)>mayor) {
				mayor=mapa.get(act);
				mayorClasi=act;
			}
		}
		
		return mayorClasi;

	}
	public LinkedList<Patron> getPatternsOfTraining() {
		return patternsOfTraining;
	}
	public void setPatternsOfTraining(LinkedList<Patron> patternsOfTraining) {
		this.patternsOfTraining = patternsOfTraining;
	}
	public LinkedList<DistanceClase<Double, String>> getDistanciasInsertadasOrdenadas() {
		return distanciasInsertadasOrdenadas;
	}
	public void setDistanciasInsertadasOrdenadas(LinkedList<DistanceClase<Double, String>> distanciasInsertadasOrdenadas) {
		this.distanciasInsertadasOrdenadas = distanciasInsertadasOrdenadas;
	}
	public HashMap<String, Integer> getFrecuenciasKVecinos() {
		return frecuenciasKVecinos;
	}
	public void setFrecuenciasKVecinos(HashMap<String, Integer> frecuenciasKVecinos) {
		this.frecuenciasKVecinos = frecuenciasKVecinos;
	}

	public HashMap<String, Integer> getFrecuenciasClasificacion() {
		
		return frecuenciasClasificacion;
	}
	
}
