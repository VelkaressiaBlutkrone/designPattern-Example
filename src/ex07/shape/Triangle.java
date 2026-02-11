package ex07.shape;

/**
 * 구체 Product C - 삼각형(Triangle)
 *
 * Shape 인터페이스를 구현하는 구체 클래스.
 * 새로운 도형을 추가할 때 이 클래스처럼 Shape를 구현하고,
 * ShapeFactory에만 등록하면 된다. (기존 클라이언트 코드 수정 불필요)
 */
public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("삼각형 그리기");
    }
}
