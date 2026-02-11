package ex08.poling;

/**
 * 옵저버 패턴 - 폴링(Pull) 방식 사용 예시
 *
 * 옵저버(Customer)가 주기적으로 Subject(LotteMart)의 상태를 직접 확인한다.
 * Subject는 상태 변경 시 알림을 보내지 않으므로,
 * 옵저버가 반복적으로 "상품 왔어?"를 확인해야 한다. → 비효율적
 */
public class App {
    public static void main(String[] args) {
        LotteMart lotteMart = new LotteMart();
        Customer customer = new Customer(lotteMart);

        // 스레드 1: 마트 측 - 10초 후 상품 입고
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("입고중...");

                try{Thread.sleep(1000);}
                catch (Exception ignored){}
            }
            lotteMart.received(); // 상태 변경 (알림 없음)
            System.out.println("입고완료");
        }).start();

        // 스레드 2: 고객 측 - 3초마다 상품 입고 여부를 직접 확인 (폴링)
        // 상품이 올 때까지 "상품 왔어?"를 반복 → 불필요한 확인이 반복됨
        new Thread(()->{
            boolean isRequest = true;

            while (isRequest){
                System.out.println("상품 왔어?");

                isRequest = !customer.request(); // Pull: 직접 확인

                try {
                    Thread.sleep(3000);
                } catch (Exception ignored){}
            }
        }).start();
    }
}
