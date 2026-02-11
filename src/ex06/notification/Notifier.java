package ex06.notification;

/**
 * Component 인터페이스 - 데코레이터 패턴의 기본 인터페이스
 *
 * 데코레이터와 기본 구현 모두 이 인터페이스를 구현하여,
 * 클라이언트는 데코레이터인지 실제 객체인지 구분하지 못한다.
 *
 * 구조:
 * <<interface>> Notifier
 *        ▲
 *  ┌─────┼──────────────┐
 * BasicNotifier   EmailNotifier   SmsNotifier
 *  (기본 구현)    (데코레이터)    (데코레이터)
 */
public interface Notifier {
    void send();
}
