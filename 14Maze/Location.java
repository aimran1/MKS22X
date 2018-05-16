public class Location implements Comparable<Location>{

    private int x,y;
    private Location previous;
    private int d;
    private int f = 0 ;
    private boolean A;

    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public Location(int _x, int _y, Location prev, int dist, int from, boolean m){
	x = _x;
	y = _y;
	previous = prev;
	d = dist;
	f = from;
	A = m;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public Location getPrev(){
	return previous;
    }

    public int getDistance(){
	return d;
    }

    public int getFrom(){
	return f;
    }

    public int compareTo(Location other){
	if (!A){
	    if (d > other.getDistance()){
		return 1;
	    }
	    else if(d == other.getDistance()){
		return 0;
	    }
	    return -1;
	}
	else{
	    if (d + f > other.getDistance() + other.getFrom()){
		return 1;
	    }
	    else if(d + f == other.getDistance() + other.getFrom()){
		return 0;
	    }
	    return -1;
	}
    }

    
    public String toString(){
	return  x + " " + y;
    }
}
