package ex07.shape;

/**
 * Product 인터페이스 - 팩토리가 생성할 객체의 공통 타입
 *
 * 팩토리 패턴에서 클라이언트는 이 인터페이스에만 의존하므로,
 * 구체적인 클래스(Circle, Rectangle, Triangle)의 존재를 알 필요가 없다.
 *
 * 구조:
 * Client ──▶ Factory.create(type) ──▶ <<interface>> Shape
 *                                            ▲
 *                                     ┌──────┼──────┐
 *                                  Circle  Rectangle  Triangle
 */
public interface Shape {
    void draw();
}
