package ex05.techer;

/**
 * [ConcreteClass B] PythonTecher - Python 강의를 담당하는 구체 선생님
 *
 * 템플릿 메서드 패턴에서 ConcreteClass에 해당한다.
 * - HtmlTecher와 동일한 구조, lecture() 내용만 다름
 * - 새로운 과목(Java, CSS 등) 추가 시 Techer를 상속하고 lecture()만 구현하면 된다
 */
public class PythonTecher extends Techer {
    /** hook 구현 - Python 강의 내용을 제공 */
    @Override
    public void lecture() {
        System.out.println("Python 강의하기");
    }
}
