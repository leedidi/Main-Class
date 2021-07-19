/*===============================
  ■■■ 변수와 자료형 ■■■
  - 형 변환 / 접미사 활용
 ================================*/

public class Test006
{
	public static void main(String[] args)
	{
		int a;
		a = 10;
		System.out.println("a 의 결과 : " + a);

		int b = 20;
		System.out.println("b 의 결과 : " + b);

		short c;
	
		// 연산 및 처리(대입 연산)
		//c = a;
		//--==>> 에러 발생(컴파일 에러)
		//-- 기본적으로는 자료형이 작은 것에 큰 것을 담지 못한다.
		//   (자동 형 변화 규칙 위반)

		// 명시적인 형 변환(강제 형 변환)
		c = (short)a;
		// c = (short)10;
		// c = 10; (@정수형 10을 short형으로 변환하고 대입)
		//-- a 가 가지고 있는 데이터를
		//	 short형으로 형 변환을 수행한 후
		//	 변수 c에 대입한다.

		// 00000000 00000000 00000000 00001010 → int 형 변수 a → 10
		//              ↓ 형 변환
		//				↓
		//				↓
		// 00000000	00001010

		//결과 출력
		System.out.println("c 의 결과 : " + c);

		//변수 선언 및 초기화
		//long d = 10000000000; //백억
		//@ 오른쪽 100억 int에 먼저 넣는데 안넣어짐...!!
		long d = 10000000000L;
		// -- 접미사 『L』이 중요하다.
		//	  long 형은 숫자(상수) 뒤에 『L』 또는 『l』 을 붙여
		//	  상수를 표현해야 한다.
		//    즉, 약 21억 이상 되는 상수에는 데이터 뒤에 접미사를
		//	  꼭 붙여줄 수 있도록 한다.

		// 결과 출력
		System.out.println("d 의 결과 : " + d);

		// 변수 선언 및 초기화
		int e = 030;

		System.out.println("e 의 결과 : " + e);
		//--==>> e 의 결과 : 24
		//-- 접두어 『0』 → 8진수

		// 변수 선언 및 초기화
		int f = 0xa6;

		// 결과 출력
		System.out.println("f 의 결과 : " + f);
		//--==>> f의 결과 : 166
		//-- 접두어 『0』 → 16진수

		// 1 2 3 4 5 6 7 8 9  a  b  c  d  e  f
		//                   10 11 12 13 14 15(이렇게 표현못해서 위로 표현)

		// 변수 선언 및 초기화
		float g = 0.0f;
		// @원래 실수 double로 왼쪽 잡아줌->컴파일에러. 자바야, 이번만 float으로 잡아줘!(~f)
		// @ ※ 대입연산자 좌측 우측 데이터 타입 같을수 있도록 형을 변환하는 습관 들이기!

		// 결과 출력
		System.out.println("g 의 결과 : " + g);

	}
}

//실행 결과
/*
a 의 결과 : 10
b 의 결과 : 20
c 의 결과 : 10
d 의 결과 : 10000000000
e 의 결과 : 24
f 의 결과 : 166
g 의 결과 : 0.0
계속하려면 아무 키나 누르십시오 . . .
*/