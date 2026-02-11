package ex08.poling;

/**
 * Subject (주체) - 폴링 방식에서 상태를 보유하는 객체
 *
 * 폴링(Pull) 방식에서는 Subject가 구독자에게 알림을 보내지 않는다.
 * 대신 getter만 제공하고, 옵저버(Customer)가 주기적으로
 * getValue()를 호출하여 상태 변경 여부를 직접 확인한다.
 */
public class LotteMart {
    // 상태값 - 입고된 상품 (null이면 아직 입고 안 됨)
    private String value = null;

    // getter만 제공 - 옵저버가 직접 가져감 (Pull)
    public String getValue() {
        return value;
    }

    // 상품 입고 - 상태 변경 (구독자에게 알리지 않음)
    public void received(){
        value = "상품";
    }
}
