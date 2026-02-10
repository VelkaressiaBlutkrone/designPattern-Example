package ex00;

/**
 *  목표 : heap, stack, static 구분하기
 *
 *  1. JVM은 static 키워드가 붙은 친구들을 static 메모리에 로드한다.
 *  2. JVM은 static 메모리에서 main 메서드를 찾아서 실행한다.
 *  3. JVM의 생명주기는 main 메서드의 코드 스레드 생명주기 (Queue)
 *  4. heap 동적 메모리 할당
 *  5. 메서드 실행시에 stack이 열린다.
 */

class Animal {
    String name = "강아지";

    void speak(){ // speack 메서드 스택 생성
        String sound = "멍멍";
        System.out.println(sound);
    } // speak 메서드 스택 소멸
}

public class Mem01 {
    public static void main(String[] args) {
        Animal a =  new Animal();

        a.speak();

        System.out.println(a.name);
    }
}