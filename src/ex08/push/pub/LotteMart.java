package ex08.push.pub;

import ex08.push.sub.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * 구체 Publisher - 상태를 관리하고 변경 시 구독자에게 즉시 알리는 발행자
 *
 * Push 방식: 상태가 변하면 등록된 모든 구독자에게 즉시 통지한다.
 * 폴링 방식과 달리 구독자가 직접 확인할 필요 없이, 발행자가 알림을 보낸다.
 */
public class LotteMart implements Mart {
    // 상태값 - 입고된 상품
    String value = null;
    // 구독자 목록 - 알림을 받을 Customer 리스트 (1:N 의존 관계)
    List<Customer> customerList = new ArrayList<>();

    // 구독 등록 (subscribe) - synchronized로 멀티스레드 안전성 확보
    @Override
    synchronized public void add(Customer customer) {
        customerList.add(customer);
    }

    // 상품 입고 - 상태 변경 후 즉시 모든 구독자에게 알림 (Push)
    @Override
    public void received() {
        value = "바나나";
        notify(value); // 상태 변경 즉시 구독자에게 push
    }

    // 모든 구독자에게 데이터를 직접 전달 (Push 방식의 핵심)
    @Override
    public void notify(String msg) {
        customerList.forEach(c -> {
            c.update(msg); // 각 구독자의 update() 호출하여 데이터 전달
        });
    }

    // 구독 해제 (unsubscribe) - 더 이상 알림을 받지 않음
    @Override
    public void remove(Customer customer) {
        customerList.remove(customer);
    }
}
