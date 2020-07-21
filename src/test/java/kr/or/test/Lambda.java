package kr.or.test;

import java.util.function.IntSupplier;

public class Lambda {
		public static int method(int x, int y) {
	/*	IntSupplier supplier = () -> {  //람다식메서드
		x = x * 10;
		int result = x + y;
		return result;
		};*/
		IntSupplier supplier = new IntSupplier() {
			@Override                  // 기존메서드
			public int getAsInt() {
				int result = x + y;
				return result;
			}
		};
		int result = supplier.getAsInt();
		return result;
		}
		public static void main(String[] args) {
			System.out.println(method(3,5));
		}
		
}