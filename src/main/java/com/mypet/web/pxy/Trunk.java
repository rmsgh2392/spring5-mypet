package com.mypet.web.pxy;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component  @Lazy
public class Trunk<T>{
	//이녀석의 용도는 값을 담고 뺴는 역활 !
	private HashMap<String, T> trunk;
	public Trunk() {trunk = new HashMap<String,T>();}
	public void put(String s, T t) {trunk.put(s, t);}
	public void put (List<String> x,List<T> y) {
		trunk = new HashMap<>();
		for(int i=0; i<x.size();i++) {
			trunk.put(x.get(i), y.get(i));
		}
		trunk.forEach((k,v)->System.out.println(String.format("%s : %s",k,v)));
	}
	public T get(String k) {
		Function<String, T> f = a -> trunk.get(a);
		return f.apply(k);
	}
	public HashMap<String, T> get(){return trunk;}
	public int size() {return trunk.size();}
	public void clear() {trunk.clear();}
}
