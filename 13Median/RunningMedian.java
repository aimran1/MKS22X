public class RunningMedian{

    private MyHeap<Double> min = new MyHeap();
    private MyHeap<Double> max = new MyHeap(false);
    
    public RunningMedian(){}

    public void add(Double m){
	if (m.compareTo(getMedian()) > 0){
	    max.add(m);
	}
	else {
	    min.add(m);
	}
    }

    public Double getMedian(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	if (min.size() == max.size()){
	    return min.peek() + max.peek() / 2;
	}
	else if (min.size() > max.size()){
	    return min.peek();
	}
	else {
	    return max.peek();
	}
    }
}
