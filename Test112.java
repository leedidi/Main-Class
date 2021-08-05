/*=========================================
   ■■■ 클래스 고급 ■■■
   - 상속 관계에 있는 클래스들 간의 캐스팅
   - 업 캐스팅, 다운 캐스팅
 =========================================*/
 //@★ 마지막까지도 쓰이는 문법! 중요중요~!!!
 //@   이게 당연스럽게 쓰여야 함!

// super class, 부모 클래스, 상위 클래스
class SuperTest112
{
	public int a=10, b=20;

	public void write()
	{
		System.out.println("슈퍼 클래스... write() 메소드...");
	}
	
	public int hap()
	{
		return a + b;
	}
}

// sub class, 자식 클래스, 하위 클래스
class SubTest112 extends SuperTest112
{
	public int b=100, c=200;

	@Override
	public int hap()
	{
		return a + b + c;
	}

	public void print()
	{
		System.out.println("서브 클래스... print() 메소드...");
	}

}

// main() 메소드를 포함하는 외부의 다른 클래스
public class Test112
{
	public static void main(String[] args)
	{
		// sub class 기반 인스턴스 생성
		SubTest112 ob1 = new SubTest112();
		System.out.println("ob1.b : " + ob1.b);
		//--==>> ob1.b : 100
		
		// ○ 업 캐스팅(@아래 있는걸 위로 끌어올림)
		//SuperTest112 ob2;
		SuperTest112 ob2 = ob1; // 『SuperTest112 ob2 = (SuperTest112)ob1;』 과 동일한 코드
		//@ 원래는 기본적으로 '=' 양쪽 데이터타입은 같아야함...! 여기는 아님!

		/*
		학생 중호 = new 학생();
		인간 사람 = 중호;		// 『인간 사람 = (인간)중호;』과 동일한 코드
		
		byte a = 10;
		short b = a;			// 『short b = (short)a;』과 동일한 코드
		*/

		System.out.println("ob2.b : " + ob2.b);
		//--==>> ob2.b : 20
		//-- 변수는 객체별로 따로 할당되므로
		//   변수 b 는 ob2 의 변수이다.

		System.out.println("합   : " + ob2.hap());
		//--==>> 합   : 310
		//-- hap() 메소드는 오버라이딩(Overriding) 되어 있고
		//   ob2 는 ob1 을 업캐스팅한 상태의 객체이므로
		//   『SuperTest112』의 hap() 메소드를 호출하는 것이 아니라
		//   『SubTest112』에서 재정의한 hap() 메소드를 호출하게 된다.
		//   즉, 메소드는 업캐스팅이 되더라도
		//   재정의(덮어쓰기)한 이상... 원래의 기능으로 되돌릴 수 없다.

		//@ 이미 아버지 차 튜닝했다면... 원래 차로 돌아갈수는 없다.

		ob2.write();
		//--==>> 슈퍼 클래스... write() 메소드...		
		
		//ob2.print(); //@ ob2의 법적인 지위는 : 상위 객체!
		 			   //@ 태어나는건 자식으로 태어났지만 이제 위상은 슈퍼테스트!(부모)
					   //@ 부모입장에서는 자식이 뭐 가졌는지 모름.. 자식은 부모가 어떤어떤 메소드 가지고 있는지 암
					   //@ 부모는 자식이 몇 명인지도 모름! 무책임한 부모..!ㅋㅋ
		//--==>> 에러 발생(컴파일 에러)
		//@ 이유가 중요! 부모객체에는 print() 존재X
		
		
		// ○ 다운 캐스팅(@위에 있는걸 아래로 끌어내림)
		((SubTest112)ob2).print();
		//@ob2를 SubTest112로 캐스팅.. 이후 print();
		//--==>> 서브 클래스... print() 메소드...
		
		/*
		byte a = 10;
		short b = a;
		byte c = (byte)b;
		
		//-->> 가능!
		*/

		// ※ 추가 관찰 --------------------------------------------
		//    다운 캐스팅 가능 여부

		SuperTest112 ob3 = new SuperTest112(); //@ 부모객체 생성
		//subTest112 ob4;
		
		//System.out.println(ob3.c);
		//--==>> 에러 발생(컴파일 에러)
		//-- 상위 객체는 하위 객체의 멤버에 접근하는 것이 불가능하다.
		//@ 당연한 거지만 기억해 두기!

		//ob4 = ob3;
		//--==>> 에러 발생(컴파일 에러)
		//@-> 불가능
		//@-->> 부모 메모리에 올라갈 때 자식은 메모리에 올라가지 않음.(할당받지 못함)

		//ob4 = (SubTest112)ob3;
		//--==>> 에러 발생(컴파일 에러)

		// ※ 작성된 구문의 문법적인 구조만 봤을 때
		//	  다운 캐스팅이 이루어지는 상황이다.
		//    하지만, 정상적인 캐스팅이 이루어지지 않는다.
		//	  현재 SubTest112 객체에 대해 메모리 할당이 이루어지지 않은 상태이기 때문에
		//    다운 캐스팅은 불가능한 것이다.
	}
}


/*
○ 업 캐스팅, 다운 캐스팅이 정상적으로 이루어지는 경우 -------------------------------------------------

	1. 하위 객체 생성;		//-- check~!!
	2. 상위 = 하위;			// 업 캐스팅.   정상.
	3. 하위 = 상위;			// 에러 발생. (@자동형변환규칙에 위배...)
	4. 하위 = (하위)상위;	// 다운 캐스팅. 정상.

○ 다운 캐스팅이 정상적으로 이루어지지 않는 경우       -------------------------------------------------

	1. 상위 객체 생성;		//--check~!!!
	2. 하위 = 상위;			// 에러 발생.
	3. 하위 = (하위)상위;	// 다운 캐스팅. 런타임 에러 발생.


※ 업 캐스팅은 항상 가능. 다운 캐스팅은 경우에 따라 가능.
//@ 다운캐스팅 어떤 경우에 가능한지 꼭 체크해 놔야 함!
//@ 이 캐스팅 수시로 하게 될거임! 자연스럽게 다뤄질거.. 잘 이해하기~~!! 왜 되는지 알아야 함~!!!
*/