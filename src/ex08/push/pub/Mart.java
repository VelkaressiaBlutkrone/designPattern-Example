package ex08.push.pub;

import ex08.push.sub.Customer;

/**
 * Subject(Publisher) 인터페이스 - 상태를 관리하고 구독자에게 알림을 보내는 발행자의 계약
 *
 * 구조:
 * Mart (Publisher)
 *  - customers: List<Customer>
 *  + add(customer)       ← 구독 등록 (subscribe)
 *  + remove(customer)    ← 구독 해제 (unsubscribe)
 *  + notify(msg)         ← 모든 구독자에게 알림 (push)
 *        │
 *        ▼
 * <<interface>> Customer (Subscriber)
 *  + update(msg)
 */
public interface Mart {
    // 구독 등록 - 구독자를 목록에 추가
    void add(Customer customer);

    // 상품 입고 - 상태 변경 후 구독자에게 알림
    void received();

    // 모든 구독자에게 데이터를 직접 전달 (Push)
    void notify(String msg);

    // 구독 해제 - 구독자를 목록에서 제거
    void remove(Customer customer);
}
