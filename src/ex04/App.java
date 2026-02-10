package ex04;

import ex04.Doorman;
import ex04.Tiger;

/**
 * [클라이언트] App - 싱글톤 패턴 동작을 확인하는 실행 클래스
 *
 * 실행 흐름:
 *   1. Doorman.instance로 싱글톤 인스턴스 획득 (new가 아님!)
 *   2. Tiger 생성
 *   3. doorman.chaseOut(tiger) → "호랑이 chase out!!"
 *
 * 포인트:
 *   - new Doorman()이 아닌 Doorman.instance로 접근 → 항상 같은 객체
 *   - Doorman doorman2 = Doorman.instance; 해도 doorman == doorman2 (true)
 *   - new Doorman()은 private 생성자 때문에 컴파일 오류 발생
 */
public class App {
    public static void main(String[] args) {
        Doorman doorman = Doorman.instance; // 싱글톤: new가 아닌 정적 필드로 인스턴스 획득
        Tiger tiger = new Tiger();

        doorman.chaseOut(tiger); // "호랑이 chase out!!"
    }
}
