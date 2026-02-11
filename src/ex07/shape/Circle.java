package ex07.shape;

/**
 * 구체 Product A - 원(Circle)
 *
 * Shape 인터페이스를 구현하는 구체 클래스.
 * 클라이언트가 직접 new Circle()을 호출하지 않고,
 * ShapeFactory를 통해 생성된다.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("원 그리기");
    }
}
