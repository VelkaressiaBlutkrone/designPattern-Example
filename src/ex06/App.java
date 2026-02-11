package ex06;

import ex06.notification.BasicNotifier;
import ex06.notification.EmailNotifier;
import ex06.notification.SmsNotifier;

/**
 * 데코레이터 패턴 (Decorator Pattern) 사용 예시
 *
 * 핵심: 상속 없이 객체를 감싸는 방식으로 기능을 동적으로 조합한다.
 * 여러 데코레이터를 겹겹이 감싸서(체이닝) 기능을 자유롭게 조합할 수 있다.
 */
public class App {
    public static void main(String[] args) {
        // 데코레이터 체이닝: EmailNotifier → SmsNotifier → SmsNotifier
        // 출력: email alarm → sms alarm → sms alarm (안쪽부터 바깥쪽으로 실행)
        SmsNotifier smsNotifier = new SmsNotifier(new SmsNotifier(new EmailNotifier()));

        smsNotifier.send();

        // 데코레이터 체이닝: EmailNotifier → SmsNotifier → BasicNotifier
        // 출력: email alarm → sms alarm → baisc alarm
        BasicNotifier basicNotifier = new BasicNotifier(new SmsNotifier(new EmailNotifier()));

        basicNotifier.send();

        // 단독 사용: 데코레이터 없이 SMS 알림만 수행
        // 출력: sms alarm
        SmsNotifier smsNotifier1 = new SmsNotifier();

        smsNotifier1.send();
    }
}
