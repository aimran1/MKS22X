public class FrontierStack implements Frontier{

    public Location next(){
	return new Location(5,3,null);
    }

    public void add(Location n){}

    public boolean hasNext(){
	return true;
    }

}
