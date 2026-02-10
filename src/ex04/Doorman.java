package ex04;

/**
 * [Singleton 역할] Doorman - 인스턴스가 오직 하나만 존재하는 문지기
 *
 * 싱글톤 패턴의 핵심 구현:
 * 1. private 생성자 → 외부에서 new Doorman() 불가
 * 2. static instance 필드 → 클래스 로딩 시 유일한 인스턴스 생성 (Eager Initialization)
 * 3. Doorman.instance로 전역 접근 → 어디서든 같은 인스턴스 사용
 *
 * 구조:
 *   Doorman
 *    - static instance: Doorman  ← 유일한 인스턴스
 *    - private Doorman()          ← 외부 생성 차단
 *    + chaseOut(Animal)           ← 비즈니스 로직
 *
 * 특징: Eager 방식 - 클래스 로딩 시점에 인스턴스를 미리 생성
 *       (cf. Lazy 방식은 getInstance() 최초 호출 시 생성)
 */
public class Doorman {

    /**
     * 유일한 인스턴스 - 클래스 로딩 시 1회만 생성 (Eager Initialization)
     * - 모든 곳에서 Doorman.instance로 접근
     * - 항상 같은 객체를 반환하므로 메모리 낭비 방지
     */
    public static Doorman instance = new Doorman();

    /**
     * private 생성자 - 외부에서 new Doorman() 호출 차단
     * → 반드시 Doorman.instance를 통해서만 접근 가능
     */
    private Doorman() {}

    /**
     * 동물을 쫓아내는 비즈니스 로직
     * - 싱글톤이므로 하나의 Doorman이 모든 요청을 처리
     */
    public void chaseOut(Animal a){
        System.out.println(a.getName() + " chase out!!");
    }
}
