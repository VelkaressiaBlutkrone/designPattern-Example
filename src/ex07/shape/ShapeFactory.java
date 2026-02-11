package ex07.shape;

/**
 * 팩토리 (Factory) - 타입에 따라 적절한 객체를 생성하여 반환
 *
 * 객체 생성 로직을 별도의 팩토리에 위임하여,
 * 클라이언트가 구체 클래스를 직접 new 하지 않게 한다.
 *
 * 클라이언트는 ShapeFactory.create("circle")만 호출하고,
 * Circle 클래스의 존재를 알 필요가 없다.
 * 새로운 도형 추가 시 팩토리만 수정하면 된다.
 */
public class ShapeFactory {

    /**
     * 정적 팩토리 메서드 - 타입 문자열에 따라 적절한 Shape 객체 생성
     *
     * @param type 생성할 도형 타입 ("circle", "rectangle", "triangle")
     * @return Shape 인터페이스를 구현한 구체 객체
     * @throws IllegalArgumentException 알 수 없는 타입인 경우
     */
    public static Shape create(String type) {
        switch (type) {
            case "circle":    return new Circle();
            case "rectangle": return new Rectangle();
            case "triangle":  return new Triangle();
            default: throw new IllegalArgumentException("알 수 없는 도형: " + type);
        }
    }
}
