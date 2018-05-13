public class Location implements Comparable<Location>{

    private int x,y;
    private Location previous;
    private int d;

    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public Location(int _x, int _y, Location prev, int dist){
	x = _x;
	y = _y;
	previous = prev;
	d = dist;
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

    public int compareTo(Location other){
	if (d > other.getDistance()){
	    return 1;
	}
	else if(d == other.getDistance()){
	    return 0;
	}
	return -1;
    }

    
    public String toString(){
	return "x:" + x + " y: " + y + " p:" + previous;
    }
}
