package ex08.push;

import ex08.push.pub.LotteMart;
import ex08.push.pub.Mart;
import ex08.push.sub.Cus1;
import ex08.push.sub.Cus2;
import ex08.push.sub.Customer;

/**
 * 옵저버 패턴 - 푸시(Push) 방식 사용 예시
 *
 * 발행자(LotteMart)의 상태가 변하면 등록된 모든 구독자에게 즉시 알린다.
 * 폴링 방식과 달리 구독자가 주기적으로 확인할 필요 없이,
 * 발행자가 변경 즉시 데이터를 직접 전달(Push)하므로 효율적이다.
 */
public class App {
    public static void main(String[] args) {
        // 발행자(Publisher) 생성
        Mart mart = new LotteMart();

        // 구독자(Subscriber) 생성
        Customer cus1 = new Cus1();
        Customer cus2 = new Cus2();

        // 구독 등록 (subscribe) - cus1, cus2 모두 알림 대상
        mart.add(cus1);
        mart.add(cus2);

        // 구독 해제 (unsubscribe) - cus2는 더 이상 알림을 받지 않음
        mart.remove(cus2);

        // 상품 입고 → 상태 변경 → 등록된 구독자(cus1만)에게 즉시 알림 (Push)
        // 출력: "손님이 받은 알림 : 바나나" (cus1만 수신)
        new Thread(mart::received).start();

    }
}
