package com.mypet.web.pxy;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component @Lazy
public class Json<T> {
	
	private HashMap<String, T> json;
	public void clear() {json.clear();}
	public int size() {return json.size();}
	public void put(List<String> x, List<T> y) {
		for(int i=0;i<x.size();i++) {
			json.put(x.get(i), y.get(i));
		}
	}
}
