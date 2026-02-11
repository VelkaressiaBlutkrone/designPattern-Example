package ex07.shape;

/**
 * 구체 Product B - 사각형(Rectangle)
 *
 * Shape 인터페이스를 구현하는 구체 클래스.
 * 클라이언트가 직접 new Rectangle()을 호출하지 않고,
 * ShapeFactory를 통해 생성된다.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("사각형 그리기");
    }
}
