package ex07;

import ex07.shape.Shape;
import ex07.shape.ShapeFactory;

/**
 * 팩토리 패턴 (Factory Pattern) 사용 예시
 *
 * 핵심: 클라이언트는 ShapeFactory.create()만 호출하고,
 * 구체 클래스(Circle, Rectangle, Triangle)를 직접 new 하지 않는다.
 * 새로운 도형 추가 시 팩토리만 수정하면 되고, 클라이언트 코드는 변경 불필요.
 */
public class App {
    public static void main(String[] args) {
        // 팩토리를 통해 객체 생성 - new Circle()을 직접 쓰지 않음
        Shape shape1 = ShapeFactory.create("circle");
        Shape shape2 = ShapeFactory.create("rectangle");
        Shape shape3 = ShapeFactory.create("triangle");

        // 클라이언트는 Shape 인터페이스만 알면 된다
        shape1.draw(); // "원 그리기"
        shape2.draw(); // "사각형 그리기"
        shape3.draw(); // "삼각형 그리기"
    }
}
