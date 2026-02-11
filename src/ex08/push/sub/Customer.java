package ex08.push.sub;

/**
 * Observer(Subscriber) 인터페이스 - 알림을 받을 구독자의 계약
 *
 * Push 방식에서 발행자(Publisher)가 상태 변경 시
 * 등록된 모든 구독자의 update()를 호출하여 데이터를 직접 전달한다.
 * 구독자는 폴링처럼 직접 확인할 필요 없이, 알림을 받기만 하면 된다.
 */
public interface Customer {
    // 발행자가 상태 변경 시 호출하는 알림 메서드 (Push: 데이터를 직접 전달받음)
    void update(String msg);
}
