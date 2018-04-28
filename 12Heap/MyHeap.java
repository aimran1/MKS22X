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

    private static void swap(int[]ary,int a, int b){
	int c = ary[a];
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
    
}
