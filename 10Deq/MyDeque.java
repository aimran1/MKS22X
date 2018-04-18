import java.util.*;
import java.io.*;

public class MyDeque<E>{
    private E[] data;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[])new Object[10];
    }
}
