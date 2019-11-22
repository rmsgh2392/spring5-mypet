package com.mypet.web.pxy;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {
	@Autowired Trunk<Integer> trunk;
	
	public int sum(int a, int b) {
		trunk.put(Arrays.asList("c"), Arrays.asList(a+b));
		return trunk.get("c");
	}
	public int sub(int a, int b) {
		return a - b;
	}
	public int abs(int a) {
		return Math.abs(a);
	}
}
