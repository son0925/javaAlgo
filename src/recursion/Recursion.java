package recursion;

public class Recursion {
	// 재귀함수란?
	// 함수 내부에서 자기 자신을 호출하는 함수를 말한다
	// 자신을 반복적으로 호출하면서 원하는 결과를 도출할 수 있다
	
	// 단 함수이기 때문에 Stack 메모리에 데이터가 쌓여 stack overflow가 생길 수 있다
	// 따라서 재귀 함수를 사용할 때는 기본 사례를 명확하게 정의하고,
	// 호출 깊이를 적절히 제한해야한다

	public static void main(String[] args) {
//		System.out.println("재귀함수 팩토리얼 구하기 : " + factorial(5));
//		System.out.println("자연수의 합 구하기 : " + sumNaturalNumber(5));
//		System.out.println("거듭제곱 구하기 : " + power(2,7));
//		System.out.println("문자열 뒤집기 구하기 : "+reverseString("abcde"));
//		System.out.println("피보나치 구하기 : "+pibonacci(8));
//		System.out.println("최대공약수 구하기 : " + gcd(10,7));
		System.out.println("이항계수 구하기 : " + binomialCoefficient(4, 2));
	}
	
	public static int factorial(int n) {
		if (n < 1) {
			return n;
		}
		
		if (n > 1) {
			return n * factorial(n-1);
		}
		return 1;
	}
	
	public static int sumNaturalNumber(int n) {
		if (n > 0) {
			return n + sumNaturalNumber(n-1);
		}
		return 0;
	}
	
	public static long power(int n, int count) {
		if (count > 0) {
			return n * power(n, --count);
		}
		return 1;
	}
	
	public static String reverseString(String s) {
		if (s.length() == 0) {
			return "";
		}
		else {
			// reverseStrig(bcde) + a => reverseString(cde) + b + a => reverseString(de) + c + b + a... edcba로 된다
			return reverseString(s.substring(1)) + s.charAt(0);
		}
	}
	
	public static long pibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		else {
			return pibonacci(n-1) + pibonacci(n-2);
		}
	}
	
	public static int gcd(int m, int n) {
		if (n == 0) {
			return m;
		}
		else {
			return gcd(n, m%n);
		}
	}
	
	public static int binomialCoefficient(int n, int k) {
		if (k ==0 || k == n) {
			return 1;
		}
		else {
			return binomialCoefficient(n-1, k-1) + binomialCoefficient(n-1, k);
		}
	}

}
