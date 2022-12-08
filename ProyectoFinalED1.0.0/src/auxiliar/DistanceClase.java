package auxiliar;

import java.util.Objects;
/**Esta clase contiene la distancia y la clasificacion*/
public class DistanceClase<E,C> implements Comparable<E>{
	private  E distance;
	private  C clase;
	

	public DistanceClase(E distance, C clase) {
		super();
		this.distance = distance;
		this.clase = clase;
		
	}
	
	public DistanceClase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public E getDistance() {
		return distance;
	}
	public void setDistance(E distance) {
		this.distance = distance;
	}
	public C getClase() {
		return clase;
	}
	public void setClase(C clase) {
		this.clase = clase;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Object o) {
		
		return compare(this.distance,((DistanceClase<E,C>)o).distance);
	}
	/** Metodo que devuelve  0 si x==y 1 si x>y -1 si x<y
	 * @author Cesar
	 * @return int*/
	
	private int compare(E x, Object y) {
		int valor = 1;
		
		if( ((Double)x) < ((Double)y) ) {
			valor = -1;
		}else if(Objects.equals((x), (y))){
			valor = 0;
		}
		
		return valor;
		
		
	}
	
}
