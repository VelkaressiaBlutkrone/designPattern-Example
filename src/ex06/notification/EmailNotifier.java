package ex06.notification;

/**
 * 구체 데코레이터 A - 이메일 알림 기능을 추가하는 데코레이터
 *
 * 기존 Notifier를 감싸서 이메일 알림 기능을 동적으로 추가한다.
 * 다른 데코레이터와 겹겹이 감싸서(체이닝) 기능을 자유롭게 조합할 수 있다.
 * 예: new SmsNotifier(new EmailNotifier()) → 이메일 + SMS 알림
 */
public class EmailNotifier implements Notifier {
    // 감싸는 대상 (합성) - 상속 대신 합성을 사용하여 기능 확장
    private Notifier notifier;

    // 단독 사용 시 (이메일 알림만 수행)
    public EmailNotifier() {
    }

    // 다른 Notifier를 감싸서 이메일 알림 기능을 추가
    public EmailNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(){
        // 감싸고 있는 Notifier가 있으면 먼저 실행 (체이닝)
        if(notifier != null) notifier.send();
        // 자신의 고유 기능: 이메일 알림 수행
        System.out.println("email alarm");
    }
}
