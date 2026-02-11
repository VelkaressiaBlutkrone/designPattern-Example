package ex08.push.sub;

/**
 * 구체 Subscriber 1 - 알림을 받아 자신의 상태를 갱신하는 구독자
 *
 * Customer 인터페이스를 구현하여, 발행자(LotteMart)가
 * 상태 변경 시 update()를 호출하면 알림을 수신한다.
 */
public class Cus1 implements Customer{
    // 발행자가 push한 데이터를 수신하는 메서드
    @Override
    public void update(String msg){
        System.out.println("손님이 받은 알림 : " + msg);
    }
}
