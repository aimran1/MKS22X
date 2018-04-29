public class MyHeap{

    private String[] heap = new String[10];
    private boolean ismax;
    private int length = 0;

    public MyHeap(){
	ismax = true;
    }

    public MyHeap(boolean max){
	if (max){
	    ismax = true;
	}
	else{
	    ismax = false;
	}
    }

    public int size(){
	return length;
    }

    public String peek(){
	return heap[0];
    }

    private void pushDown(int i){
	int left = 2 * i + 1;
	int right = 2 * i + 2;
	if (ismax && heap[left].compareTo(heap[i]) > 0 && heap[left].compareTo(heap[right]) >= 0){
	    swap(heap,left,i);
	    pushDown(left);
	}
	else if (ismax && heap[right].compareTo(heap[i]) > 0){
	    swap(heap,right,i);
	    pushDown(right);
	}
	else if (!ismax && heap[left].compareTo(heap[i]) < 0 && heap[left].compareTo(heap[right]) <= 0){
	    swap(heap,left,i);
	    pushDown(left);
	}
	else if (!ismax && heap[right].compareTo(heap[i]) < 0){
	    swap(heap,right,i);
	    pushDown(right);
	}	
    }

    public String remove(){
	String ans = heap[0];
	swap(heap, 0, length - 1);
	pushDown(0);
	heap[length-1] = null;
	length--;
	return ans;
    }

    private void pushUp(int i){
	int parent = (i - 1) / 2;
	if (ismax && heap[parent].compareTo(heap[i]) < 0){
	    swap(heap,parent,i);
	    pushUp(parent);
	}
      	else if (!ismax && heap[parent].compareTo(heap[i]) > 0){
	    swap(heap,parent,i);
	    pushUp(parent);
	} 
    }

    public void add(String str){
	if (length == heap.length){
	    resize();
	}
	heap[length] = str;
	pushUp(length);
	length++;
    }
    
    private static void swap(String[]ary,int a, int b){
	String c = ary[a];
	ary[a] = ary[b];
	ary[b] = c;
    }

    private void resize(){
	String[] temp = new String[heap.length * 2];
	for (int i = 0; i < heap.length; i++){
	    temp[i] = heap[i];
	}
	heap = temp;
    }

    public String toString(){
	String ans = "";
	for(int i = 0; i < length; i++){
	    ans += heap[i] + " ";
	}
	return ans;
    }

    public static void main(String[] args){
	MyHeap m = new MyHeap();
	for (int i = 0; i < 11; i++){
	    m.add(i + "");
	}
	System.out.println(m);
    }
    
    
}
