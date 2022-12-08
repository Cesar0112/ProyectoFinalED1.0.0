package auxiliar;

import java.util.LinkedList;
/**Esta clase permite tener ordenado de mayor a menor los elementos en una lista con a lo mas k elementos
 @param Object*/
public class ListaInsercionOrdenada <E>{
	LinkedList<E> listadoObjetos;
	int k;
	public ListaInsercionOrdenada(int k) {
		super();
		this.k=k;
		this.listadoObjetos = new LinkedList<>();
	}


	public int getK() {
		return k;
	}


	public void setK(int k) {
		this.k = k;
	}


	public LinkedList<E> getlistadoObjetos() {
		return listadoObjetos;
	}

	public void setlistadoObjetos(LinkedList<E> listadoObjetos) {
		this.listadoObjetos = listadoObjetos;
	}


	/**Permite insertar en la lista de forma ordenada sin sobrepasar el limite k
	 * @author César Fernández García
	 * @param Object*/
	/*este metodo fue probado con objetos Integer*/
	public void insertar(E e) {
		int i=0;//funciona para saber en que indice debe ir el objeto en la lista
		int j=0;//funciona como indice para apuntar en el listado de objetos

		boolean succeed=false;

		E act;
		while(j<listadoObjetos.size()&&!succeed) {
			act=listadoObjetos.get(j);
			/*Puede que halla un problema con el objeto en caso de que no sea comparable*/
			if(e instanceof Comparable) {
				if(((Comparable<E>) e).compareTo(act)>0) {//compara para saber en que lugar debe ir el elemento nuevo
					succeed=true;
				}else {
					i++;
				}
			}
			j++;
		}

		if((listadoObjetos.size()+1)>k) {//si el numero de elementos es mayor que k es que excede el numero de elementos k-esimos
			if(i!=0) {//si i es distinto de cero significa que él es el mayor elemento y no serviria de nada introducirlo si despues lo vas a remover
				listadoObjetos.removeFirst();
				listadoObjetos.add(i-1,e);//
			}
		}else {//si no trae ningun problema insertarlo nomas
			listadoObjetos.add(i,e);
		}
	}

}
