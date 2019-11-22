package com.mypet.web.usr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mypet.web.pxy.Proxy;

@Component
public class UserService extends Proxy{
	@Autowired UserMapper userMapper;
	
	//public String test()  {
//		List<Integer> list = Arrays.asList(1,2,3,4,5);
//		Stream<Integer> intStream = Arrays.asList(1,2,3,4,5).stream();
	    //stream타입  엔진이 자동으로 걸려있다.list값들이 가만히 있는게 아니라 지가 막 움직이고 있다.그래서 for문을 안걸어도 된다. loop이 필요없다  내부적으로 자동으로 걸려있따.
//		for(int i =1;i<=10;i++) {
//			list.add(i);//list가 반복되서 움직이는게 아니라 가만히 있고 i가 움직이고 반복됨
//			System.out.print(i + "+");
//		}
//		Arrays.asList(1,2,3,4,5).forEach(System.out :: println) 값을 유지하고 싶을때
//		Arrays.asList(1,2,3,4,5).stream().forEach(System.out :: println);
		//메서드를 객체로 만들어서 참조변수로 만들어 쓰는게 메서드 참조!!, for를 메서드로 하고 찍는것을 메서드 참조로  값을 메모리에서 제거하고 싶을때 값을 찍자마자 사라짐 (예 넷플릭스 ,유투브
		//IntStream.range(100, 115).forEach(System.out :: println);
		//IntStream.rangeClosed(100,105).forEach(System.out :: println);
		//new Random().ints().limit(5).forEach(System.out :: println);
		//return toString("1,2,3,4,5");
	//}
	//public static void main(String[] args) {
		//UserService s = new UserService();
		//s.test();
	//}
	public String selectAll() {
		List<User> list = userMapper.selectAll();
		List<String> list2 = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			list2.add(list.get(i).getUid());
		}
		Stream.of(list2)
		.sorted()
		.forEach(System.out :: println);
//		userMapper.selectAll().forEach(System.out :: println);
		return  toString("5");
	}
	public String selectUname() {
//		List<User> list = userMapper.selectUname();
		userMapper.selectUname().forEach(System.out :: println);
		return  toString("11");
	}
	
}
