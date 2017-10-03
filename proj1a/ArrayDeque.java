public class ArrayDeque <T> {
	
	T[] item = (T[]) new Object[8];
	int size;
	int nextFirst;
	int nextLast;


	public ArrayDeque(){
		item = (T[]) new Object[8];
		size = 0;
		nextFirst = 7;
		nextLast = 0;
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		if (size == 0){
			return true;
		}
		else{return false;}
	}

	public void addFirst(T i){
		item[nextFirst] = i;
		size += 1;
		nextFirst -= 1;
	}

	public void addLast(T i){
		item[nextLast] = i;
		size += 1;
		nextFirst += 1;
	}

	public void printDeque(){
		int p = 0;
		while(p != size){
			System.out.println(item[nextInQue(nextFirst,size)]);
			p += 1;
		}
	}

	public T removeFirst(){
		T firstReturn = item[nextInQue(nextFirst,size)];
		item[nextInQue(nextFirst,size)] = null;
		nextFirst = nextInQue(nextFirst,size);
		size -= 1;
		return firstReturn;
	}

	public T removeLast(){
		T lastReturn = item[preInQue(nextLast,size)];
		item[preInQue(nextLast,size)] = null;
		nextFirst = preInQue(nextLast,size);
		size -= 1;
		return lastReturn;
	}


	private int nextInQue(int i, int size){
		if (i ==size){
			return 0;
		}
		else {return i+1;}
	}

	private int preInQue(int i, int size){
		if (i == 0){
			return size;
		}
		else {return i-1;}
	}

	public T get(int index){
		return item[index];
	}


}