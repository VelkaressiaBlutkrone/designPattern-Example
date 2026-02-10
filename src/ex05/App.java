package ex05;

import ex05.techer.HtmlTecher;
import ex05.techer.Techer;

/**
 * [클라이언트] App - 템플릿 메서드 패턴 동작을 확인하는 실행 클래스
 *
 * 실행 흐름:
 *   1. HtmlTecher(ConcreteClass) 생성 → Techer(AbstractClass) 타입으로 참조
 *   2. techer.lesson() 호출 → 템플릿 메서드 실행
 *   3. 출력:
 *      입장하기        ← 공통 (Techer)
 *      출석 부르기     ← 공통 (Techer)
 *      Html 강의하기   ← hook (HtmlTecher가 구현)
 *      퇴장하기        ← 공통 (Techer)
 *
 * 포인트:
 *   - HtmlTecher를 PythonTecher로 바꾸면 "Html 강의하기"만 "Python 강의하기"로 변경
 *   - 수업 흐름(입장→출석→퇴장)은 어떤 선생님이든 동일하게 유지
 *   - 상위 클래스(Techer)가 흐름을 제어하고, 하위 클래스는 세부 내용만 결정 (IoC)
 */
public class App {
    public static void main(String[] args) {
        Techer techer = new HtmlTecher(); // 구체 클래스 생성, 추상 타입으로 참조

        techer.lesson(); // 템플릿 메서드 호출 → 입장 → 출석 → Html 강의 → 퇴장
    }
}
