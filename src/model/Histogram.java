package model;
import java.util.*;

public class Histogram <T> {
    private Map<T,Integer> map;

    public Histogram() {
        map = new HashMap<T,Integer>();
    }
   
    public Integer get(T Key){
        return map.get(Key);
    }
    public Set<T> keySet(){
        return map.keySet();
    }
    public void increment(T key){
        if(map.containsKey(key)){
            map.put(key,map.get(key)+1);
        }else{
            map.put(key,1);
        }
    }
}

