package com.mypet.web.pxy;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("pxy") @Lazy
public class Proxy {
	public int parseInt(String param) {
		Function<String, Integer> f =  Integer :: parseInt;
		return f.apply(param);
	}
	public int random(int a, int b) {
		BiFunction<Integer,Integer , Integer> bf = (t,u)-> (int)(Math.random()*(u-t))+t;
		bf.apply(a, b);
		return bf.apply(a, b);
	}
	public int[] intArray(int size) {
		Function<Integer, int[]> f = t-> new int[t];
		f.apply(size);
		return f.apply(size);
	}
	public boolean equals(String x,String y) {
		BiPredicate<String, String> p = String :: equals;
		return p.test(x, y);
	}
	public String toString(Object param) {
		Function<Object, String> f = s->String.valueOf(s);
		f.apply(param);
		return f.apply(param);
	}
	public void printer(String t) {
		Consumer<String> c = System.out :: println;
		//System.out :: println 객체이기 떄문에
		//우리가 알고 있떤 메서드를 객체로 만들어 파라미터에 던질 수 있게 해준다.
		c.accept(t);
	}
	//Integer :: parseInt ,String :: equals, System.out :: println 
	//메서드 참조 !!

}
