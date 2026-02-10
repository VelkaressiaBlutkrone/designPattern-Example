package ex04;

/**
 * Tiger - 싱글톤 Doorman이 처리하는 구체 동물 클래스
 *
 * - 싱글톤인 Doorman.instance가 이 객체를 chaseOut()으로 처리
 */
public class Tiger extends Animal {
    private String name = "호랑이";

    /** Animal의 추상 메서드를 구현 - 호랑이 고유의 이름 반환 */
    @Override
    public String getName() {
        return name;
    }
}
