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
    

}
