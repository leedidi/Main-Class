
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class ManagerMode 
{
	private static BufferedReader br;
	private static Integer sel;				//-- 선택 값
	private static String con;	

	static
	{
		// BufferedReader 인스턴스 생성
		br = new BufferedReader(new InputStreamReader(System.in));

		// 사용자 입력값 초기화
		sel = 1;
		con = "Y";
	}

	public void mMenuPrint() // 메뉴 출력 메소드
	{
		System.out.println("    [메뉴 출력]");
		System.out.println("1. 요청사항 확인");
		System.out.println("2. 재고 관리");
		System.out.println("3. 금고 관리");
		System.out.println();
		System.out.print(">> 메뉴 선택(1~3) : ");

	}

	public void mMenuSelect() throws IOException// 메뉴 선택 메소드
	{
		do
		{
			sel = Integer.parseInt(br.readLine());
		}
		while (sel<1 || sel>3);
		
	}

	public void mMenuRun() throws IOException // 메뉴 호출 메소드
	{
		switch (sel)
		{
			case Menus.E_ONE : mNote(); break;
			case Menus.E_TWO : mStorage(); break;
			case Menus.E_THREE : mMoney(); break;
			default : System.out.println(">> 메뉴 선택 오류~!!!"); break;
		}
	}

	public void mNote() // 요청사항 확인 메소드
	{
		System.out.println("요청사항 확인 메소드");
	}


	public void mStorage() throws IOException // 재고 관리 메소드
	{
		System.out.print(">> 메뉴 선택(1~2) : ");

		int sel = Integer.parseInt(br.readLine());

		switch (sel)
		{
			case Menus.E_ONE : mStorageChange(); break;
			case Menus.E_TWO : mStorageNew(); break;
			default : System.out.println(">> 메뉴 선택 오류~!!!"); break;
		}

	}

	public void mStock()
	{
		// 1. 현재 재료 출력(종류별 출력) - 수정중.. 벡터.. 재고 가져옴(신규품목 추가삭제와 공유)
		//    (번호, 제품명, 수량)
		
		ISetup is = new ISetup();
		is.firstSet();

		System.out.println("\n    [재고 관리]");
		System.out.println();
		System.out.println("추가·삭제할 재료 선택");
		System.out.println("-----------------------");
		System.out.println("    [야채]");
		System.out.println();
		
		for (int n=0; n<is.vVeg.size(); n++)
		{	
			System.out.printf("%5s, %5d개\n", is.vVeg.get(n).name, is.vVeg.get(n).num);
			//System.out.print(is.vVeg.get(n).name + "    ");
			//System.out.println(is.vVeg.get(n).num);
		}
		//for문 - vVeg.get(0).name
		//v.leng
		
		System.out.println("-----------------------");
		System.out.println("    [육류]");
		System.out.println();

		for (int n=0; n<is.vMain.size(); n++)
		{	
			System.out.printf("%5s, %5d개\n", is.vMain.get(n).name, is.vMain.get(n).num);
			//System.out.print(is.vVeg.get(n).name + "    ");
			//System.out.println(is.vVeg.get(n).num);
		}
		
		System.out.println("-----------------------");
		System.out.println("    [소스류]");
		System.out.println();
		for (int n=0; n<is.vSource.size(); n++)
		{	
			System.out.printf("%5s, %5d개\n", is.vSource.get(n).name, is.vSource.get(n).num);
			//System.out.print(is.vVeg.get(n).name + "    ");
			//System.out.println(is.vVeg.get(n).num);
		}

		System.out.println("-----------------------");
		System.out.println("    [토핑류]");
		System.out.println();
		// 토핑 추가시 출력
		
	}

	public void mStorageChange() throws IOException // 재료 추가/삭제 메소드
	{	
		ISetup is = new ISetup();
		is.firstSet();

		Scanner sc = new Scanner(System.in);

		System.out.println("재료 추가/삭제 메소드");
		/*
		1. 현재 재료 출력
		2. 추가(+), 삭제(-) 여부 선택 입력문구 - 입력 do~while
		3. 재료번호, 수량 입력문구 - 입력
		4. 추가 삭제 확정 여부 출력
		5. 추가 수행 여부 입력문구 및 입력
		*/

		// 2. 추가(+), 삭제(-) 여부 선택 입력문구
		// --> 입력오류시 : 입력에 문제가 있습니다 출력. 
		//(여기서 입력오류란? +/-, [재료번호, 재료수량의 최소값~최대값] 이외의 무언가 입력시?)
		

		//1. 추가삭제 물어보는거
		//2. 물어보는거 입력값 받아와서 수행하는 메소드

		String oper;
		int ctSelect;
		int num;
		int su;

		while(true) 
		{
			System.out.print("재료를 추가하시려면 (+), 삭제하시려면 (-) : "); // oper
			//op = (char)System.in.read();
			//op = sc.nextInt();
			//op = (char)System.in.read();
			oper = sc.next();
			//테스트
			//System.out.println(oper); //--- + 입력시 + 출력, 입력은 됨!

			if(oper.equals("+")||oper.equals("-")) 
			{
			break;
			}
			System.out.println("\n입력에 문제가 있습니다.\n");			
		}
			
		ISetup is = new ISetup();
		is.firstSet();

			while (true)
		{
		
			System.out.print("재료 카테고리 : "); // num
			num = Integer.parseInt(br.readLine());

			if(num<20) //조건: [재료번호의 최대값 초과] 입력시
			{
				break;  // 재료 입력칸 통과
			}
			System.out.println("\n입력에 문제가 있습니다.\n");
		}

		while (true)
		{	
		
			System.out.print("재료 번호 : "); // num
			num = Integer.parseInt(br.readLine());
			

			if(num<20) //조건: [재료번호의 최대값 초과] 입력시
			{
				break;  // 재료 입력칸 통과
			}
			System.out.println("\n입력에 문제가 있습니다.\n");
		}
			
		while (true)
		{
			System.out.print("재료 수량 : "); // su
			su = Integer.parseInt(br.readLine());
			
			//* 재료 종류(야채,메인,토핑...) /  재료 수 두개 입력받아서 저장해놓고 가져다쓰기?
			//* 이후 switch 돌리기?

			if(su<20) // 조건: [재료수량의 최대값 초과] 입력시
			{
				break;  // 재료 입력칸 통과
			}
			System.out.println("\n입력에 문제가 있습니다.\n");
		
		}
		
	
		if (oper.equals("-"))
		{
			System.out.println("\n재고를 삭제하시겠습니까? (Y/N)");
			String yn = sc.next();
			if(yn == "y" || yn == "Y")
				{
				// + 재고 삭제 실행	
				//is.vVeg.get(n).name
				is.vVeg.get(num).num = is.vVeg.get(num).num - su;
				System.out.println("재료가 삭제되었습니다.");
				}
				else if(yn == "n" || yn == "N")
				{
				// 처음 화면으로,,,,,어케 돌아가지,,,,? 루프?
				System.out.println("취소되었습니다.");
				return;
				}
		}
			else
			{
				System.out.println("\n재고를 추가하시겠습니까? (Y/N)");
				String yn = sc.next();
				if(yn == "y" || yn == "Y")
					{
					// + 재고 추가 실행	
					is.vVeg.get(num).num = is.vVeg.get(num).num + su;
					System.out.println("재료가 추가되었습니다.");
					}
					else if(yn == "n" || yn == "N")
					{
					// 처음 화면으로,,,,,어케 돌아가지,,,,?
					System.out.println("취소되었습니다.");
					return;
					}
			}
		
		System.out.println("끝입니다.");

		// 
	}


	public void mStorageNew() // 신규 품목 추가/삭제 메소드
	{
		System.out.println("신규 품목 추가/삭제 메소드");
	}


	public void mMoney() // 금고 관리 메소드
	{
		System.out.println("금고 관리 메소드");
	}


	public void mMoneyChange() // 시재
	{
		
	}


	public void mMoneyCheck() // 매출 확인
	{
		
	}


	public void mMoneyCal() // 정산
	{
		
	}


}

	//* 메소드 둘로 나눔
	//public void mStorageChange() throws IOException // 재료 추가/삭제 메소드
	
	/*
	public void mStorageChangeInput() throws IOException // 재료 추가/삭제 입력 + 잘못된 입력시 다시 입력하는 메소드
	{

		ISetup is = new ISetup();
		is.firstSet();

		Scanner sc = new Scanner(System.in);

		System.out.println("재료 추가/삭제 메소드");
		
		//1. 현재 재료 출력
		//2. 추가(+), 삭제(-) 여부 선택 입력문구 - 입력 do~while
		//3. 재료번호, 수량 입력문구 - 입력
		//4. 추가 삭제 확정 여부 출력
		//5. 추가 수행 여부 입력문구 및 입력
		
		
		// 2. 추가(+), 삭제(-) 여부 선택 입력문구
		// --> 입력오류시 : 입력에 문제가 있습니다 출력. 
		//(여기서 입력오류란? +/-, [재료번호, 재료수량의 최소값~최대값] 이외의 무언가 입력시?)
		

		//1. 추가삭제 물어보는거
		//2. 물어보는거 입력값 받아와서 수행하는 메소드

		String oper;
		int num;
		int su;
		
		while(true) 
		{
			System.out.print("재료를 추가하시려면 (+), 삭제하시려면 (-) : "); // oper
			//op = (char)System.in.read();
			//op = sc.nextInt();
			//op = (char)System.in.read();
			oper = sc.next();
			//테스트
			//System.out.println(oper); //--- + 입력시 + 출력, 입력은 됨!

			if(oper.equals("+")||oper.equals("-")) 
			{
			break;
			}
			System.out.println("\n입력에 문제가 있습니다.\n");			
		}

		while (true)
		{
			System.out.print("재료 번호 : "); // num
			num = Integer.parseInt(br.readLine());

			if(num<20) //조건: [재료번호의 최대값 초과] 입력시
			{
				break;  // 재료 입력칸 통과
			}
			System.out.println("\n입력에 문제가 있습니다.\n");
		}
			

		while (true)
		{
			System.out.print("재료 수량 : "); // su
			su = Integer.parseInt(br.readLine());

			if(su<20) // 조건: [재료수량의 최대값 초과] 입력시
			{
				break;  // 재료 입력칸 통과
			}
			System.out.println("\n입력에 문제가 있습니다.\n");
		
		}
		
	}

	public void mStorageChangeExecution()												
	{														// 입력된 재료의 숫자대로 재고 내용 삭제, 실행하는 클래스
															// 위클래스 상속....? 
		// 3. 추가 삭제 확정 여부 출력
		// 4. 추가, 삭제 실행
		// -->> 재료 추가되었습니다 / 삭제되었습니다 문구 출력
		
		if (oper.equals("-"))
		{
			System.out.println("\n재고를 삭제하시겠습니까? (Y/N)");
			String yn = sc.next();
			if(yn == "y" || yn == "Y")
				{
				// + 재고 삭제 실행	
				is.vVeg.get(num).num = is.vVeg.get(num).num - su;

				System.out.println("재료가 삭제되었습니다.");
				}
				else if(yn == "n" || yn == "N")
				{
				// 처음 화면으로,,,,,어케 돌아가지,,,,? 루프?
				System.out.println("취소되었습니다.");
				return;
				}
		}
			else
			{
				System.out.println("\n재고를 추가하시겠습니까? (Y/N)");
				String yn = sc.next();
				if(yn == "y" || yn == "Y")
					{
					// + 재고 추가 실행	
					is.vVeg.get(num).num = is.vVeg.get(num).num + su;

					System.out.println("재료가 추가되었습니다.");
					}
					else if(yn == "n" || yn == "N")
					{
					// 처음 화면으로,,,,,어케 돌아가지,,,,.
					return;
					}
			}
			// 끝 확인용 테스트
			System.out.println("끝입니다.");
	}
*/
