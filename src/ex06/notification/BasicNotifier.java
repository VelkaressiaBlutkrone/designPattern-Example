package ex06.notification;

/**
 * 기본 구현 (ConcreteComponent) - 장식 대상이 되는 원본 객체
 *
 * 데코레이터 패턴에서 가장 안쪽에 위치하는 기본 알림 기능을 제공한다.
 * 다른 Notifier를 감쌀 수도 있어, 데코레이터 역할도 겸할 수 있다.
 * 상속 없이 합성(has-a)으로 기능을 동적으로 조합한다.
 */
public class BasicNotifier implements Notifier {

    // 감싸는 대상 (합성) - 데코레이터 체이닝을 위한 참조
    private Notifier notifier;

    // 단독 사용 시 (체이닝 없이 기본 알림만 수행)
    public BasicNotifier() {
    }

    // 다른 Notifier를 감싸서 기능을 조합할 때 사용
    public BasicNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(){
        // 감싸고 있는 Notifier가 있으면 먼저 실행 (체이닝)
        if(notifier != null) notifier.send();
        // 자신의 고유 기능 수행
        System.out.println("baisc alarm");
    }
}
