package ex05.techer;

/**
 * [AbstractClass 역할] Techer - 수업 진행의 골격(템플릿)을 정의하는 추상 클래스
 *
 * 템플릿 메서드 패턴에서 AbstractClass에 해당한다.
 * - lesson()이 템플릿 메서드: 수업의 전체 흐름을 고정
 * - entering(), attendance(), exiting()은 공통 단계 → private으로 변경 불가
 * - lecture()만 추상 메서드(hook) → 하위 클래스가 각자의 강의 내용을 구현
 *
 * 실행 순서 (고정):
 *   입장하기 → 출석 부르기 → [강의하기 - 하위 클래스 결정] → 퇴장하기
 *
 * 제어의 역전(IoC): 상위 클래스(Techer)가 하위 클래스(HtmlTecher 등)의
 *   lecture()를 호출한다. ("Don't call us, we'll call you")
 */
public abstract class Techer {

    /**
     * 템플릿 메서드 - 수업의 전체 흐름을 정의하고 실행 순서를 고정
     * - 하위 클래스는 이 메서드를 오버라이딩할 수 없음 (골격 보호)
     * - 내부에서 공통 단계 + 추상 단계(lecture)를 순서대로 호출
     */
    public void lesson(){
        entering();     // 1단계: 입장 (공통)
        attendance();   // 2단계: 출석 (공통)
        lecture();      // 3단계: 강의 (하위 클래스가 구현 ← hook)
        exiting();      // 4단계: 퇴장 (공통)
    }

    /** 공통 단계 - 모든 선생님이 동일하게 수행 (private → 변경 불가) */
    private void entering(){
        System.out.println("입장하기");
    }

    /** 공통 단계 - 모든 선생님이 동일하게 수행 */
    private void attendance() {
        System.out.println("출석 부르기");
    }

    /**
     * 추상 메서드 (hook) - 하위 클래스가 반드시 구현해야 할 단계
     * - HtmlTecher → "Html 강의하기"
     * - PythonTecher → "Python 강의하기"
     * - 새로운 과목 추가 시 이 메서드만 구현하면 된다
     */
    protected abstract void lecture();

    /** 공통 단계 - 모든 선생님이 동일하게 수행 */
    private void exiting(){
        System.out.println("퇴장하기");
    }
}
