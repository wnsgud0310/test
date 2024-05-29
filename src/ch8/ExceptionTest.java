package ch8;

/*
 *  *  ------------------ Exception 처리 문제( 해결 해보세요!!!!)  -----------------
 *  - 요구사항
 * 	     파일을 처리하는 예외 발생할 수 있음을 가정하고 프로그램 구현.
 * 		- 기능 : 설치, 복사공간 여유 확인, 메모리 여유 확인, 파일복사, 설치, 임시파일 삭제 
 * 
 * 
 * 		- 예외 처리 : 복사 공간 여유 없을 때, 메모리가 부족 할 때
 * 		- 프로그램 동작 순서
 * 		   - 설치 시작 ->  복사공간 여유 확인 -> 메모리 여유 확인 -> 파일복사 ->
 * 		   - 설치 완료 -> 임시파일 삭제
 * 		- 좋은 코드로 작성하기 위한 기준 
 * 		  응집도 높다 => 관련있는 것끼리 묶음 =>  메소드 형태
 * 									  => 설치 메소드, 
 * 										 파일복사, 
 * 										 파일삭제체크, 
 * 										 디스크, 
 * 										 메모리  용량 체크
 * 
 * 		  재사용성이 높은 것  => 예외클래스 작성
 * 
 * 
 * 
 * 
 */
//insufficient :  불충분한
//ExceptionTest.java

class CopySpaceException extends Exception { 
	public CopySpaceException(String message) {
      super(message);
	}
	
}

class MemoryException extends Exception {
	public MemoryException(String message) {
     super(message);
 }
}

public class ExceptionTest {

 // 복사 공간 확인 
 private void checkCopySpace() throws CopySpaceException {
     
     if (Math.random() > 0.7) { // 무작위 조건으로 예제 구현
         throw new CopySpaceException("설치를 진행하기에 충분한 복사 공간이 없습니다.");
     }
 }

 // 메모리 공간  확인
 private void checkMemory() throws MemoryException { //이름바꾸기 alt+shift+r
    
     if (Math.random() > 0.7) { // 무작위 조건으로 구현
         throw new MemoryException("설치를 진행하기에 충분한 메모리 공간이 없습니다.");
     }
 }
 //  기능 : 설치, 복사공간 여유 확인, 메모리 여유 확인, 파일복사, 설치, 임시파일 삭제
 // 파일 복사 메소드
 private void copyFiles() {
     System.out.println("파일을 복사 합니다");
 }

 //  설치 메소드
 private void install() {
     System.out.println("소프트웨어를 설치 합니다");
 }

 // 임시 파일 삭제 메소드
 private void deleteFile() {
     System.out.println("임시 파일을 삭제 합니다");
 }

 // 시작 메소드
 public void start() {
     try {
         System.out.println("설치를 시작합니다");
         checkCopySpace();
         checkMemory();
         copyFiles();
         install();
         System.out.println("설치가 완료되었습니다.");
         deleteFile();
     } catch (CopySpaceException | MemoryException e) {
         System.err.println("설치 중 오류 발생: " + e.getMessage());
     }  finally {
    	 System.out.println("프로그램이 종료되었다..");
     }
 }

 public static void main(String[] args) {
     ExceptionTest installer = new ExceptionTest();
     installer.start();
 	}
}




