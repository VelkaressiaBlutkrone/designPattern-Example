package ex05.techer;

/**
 * [ConcreteClass A] HtmlTecher - HTML 강의를 담당하는 구체 선생님
 *
 * 템플릿 메서드 패턴에서 ConcreteClass에 해당한다.
 * - Techer(AbstractClass)를 상속받아 추상 메서드 lecture()만 구현
 * - 수업 흐름(입장→출석→강의→퇴장)은 상위 클래스가 제어
 * - 이 클래스는 "무엇을 강의할지"만 결정
 */
public class HtmlTecher extends Techer {
    /** hook 구현 - HTML 강의 내용을 제공 */
    @Override
    public void lecture() {
        System.out.println("Html 강의하기");
    }
}
