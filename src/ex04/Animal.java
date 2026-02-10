package ex04;

/**
 * Animal - 모든 동물의 추상 클래스
 *
 * 싱글톤 Doorman이 처리하는 대상 객체의 공통 타입을 정의한다.
 * - 싱글톤(Doorman)은 하나의 인스턴스로 다양한 Animal을 처리
 */
public abstract class Animal {
    /**
     * 동물의 이름을 반환하는 추상 메서드
     * - 각 구체 클래스(Tiger, Mouse)가 자신만의 이름을 반환하도록 오버라이딩
     */
    public abstract String getName();
}
