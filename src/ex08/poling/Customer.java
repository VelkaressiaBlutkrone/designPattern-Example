package ex08.poling;

/**
 * Observer (옵저버) - 폴링 방식에서 주기적으로 상태를 직접 확인하는 객체
 *
 * Push 방식과 달리, Subject(LotteMart)가 알림을 보내주지 않으므로
 * 옵저버가 직접 request()를 호출하여 상태 변경 여부를 확인해야 한다.
 * 구현이 단순하지만, 불필요한 확인이 반복되어 비효율적이다.
 */
public class Customer {

    // Subject 참조 - 상태를 확인할 대상
    private LotteMart lotteMart;

    public Customer(LotteMart lotteMart) {
        this.lotteMart = lotteMart;
    }

    /**
     * 폴링(Pull) - Subject의 상태를 직접 가져와서 변경 여부를 확인
     * @return true: 상품 입고됨 (알림 수신), false: 아직 입고 안 됨
     */
    public boolean request() {
        String value = lotteMart.getValue(); // Pull: 직접 가져옴

        if(value != null){
            update(value);
            return true;
        }

        return false;
    }

    // 상태 변경 감지 시 실행되는 갱신 메서드
    public void update(String msg){
        System.out.println("손님이 받은 알림 : " + msg);
    }
}
