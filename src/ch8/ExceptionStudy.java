package ch8;

public class ExceptionStudy {
	public static void main(String[] args) {
		try {
		int result = 4/2; // 나누기 성공
		}catch(Exception e) {
			System.out.println("문제 발생");
		}finally {
			System.out.println("문제종료");		
		}
		
	}
}
