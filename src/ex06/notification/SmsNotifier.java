package ex06.notification;

/**
 * 구체 데코레이터 B - SMS 알림 기능을 추가하는 데코레이터
 *
 * 기존 Notifier를 감싸서 SMS 알림 기능을 동적으로 추가한다.
 * 상속으로 인한 클래스 폭발 문제 없이, 합성으로 기능을 조합한다.
 * 예: new SmsNotifier(new SmsNotifier(new EmailNotifier()))
 *     → 이메일 + SMS + SMS (같은 데코레이터도 중복 적용 가능)
 */
public class SmsNotifier implements Notifier {
    // 감싸는 대상 (합성) - 상속 대신 합성을 사용하여 기능 확장
    private Notifier notifier;

    // 단독 사용 시 (SMS 알림만 수행)
    public SmsNotifier() {
    }

    // 다른 Notifier를 감싸서 SMS 알림 기능을 추가
    public SmsNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(){
        // 감싸고 있는 Notifier가 있으면 먼저 실행 (체이닝)
        if(notifier != null) notifier.send();
        // 자신의 고유 기능: SMS 알림 수행
        System.out.println("sms alarm");
    }
}
