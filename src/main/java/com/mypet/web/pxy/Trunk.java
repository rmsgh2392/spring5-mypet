package com.mypet.web.pxy;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component  @Lazy
public class Trunk<T>{
	//이녀석의 용도는 값을 담고 뺴는 역활 !
	private HashMap<String, T> map;
	public void put (List<String> x,List<T> y) {
		map = new HashMap<>();
		for(int i=0; i<x.size();i++) {
			map.put(x.get(i), y.get(i));
		}
		map.forEach((k,v)->System.out.println(String.format("%s : %s",k,v)));
	}
	public T get(String k) {
		Function<String, T> f = a -> map.get(a);
		return f.apply(k);
	}
	public HashMap<String, T> get(){return map;}
	public int size() {return map.size();}
	public void clear() {map.clear();}
}
