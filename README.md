## 프로젝트 구조

```
src/
├── ex00/          # 메모리 구조 & 다형성 기초
├── ex01/          # 전략 패턴 (Strategy)
├── ex02/          # 프록시 패턴 (Proxy)
├── ex03/          # 어댑터 패턴 (Adapter)
├── ex04/          # 싱글톤 패턴 (Singleton)
├── ex05/          # 템플릿 메서드 패턴 (Template Method)
├── ex06/          # 데코레이터 패턴 (Decorator)
├── ex07/          # 팩토리 패턴 (Factory)
├── ex08/          # 옵저버 패턴 (Observer)
│   ├── polling/   #   - 폴링 방식 (Pull)
│   └── push/      #   - 푸시 방식 (Push)
│       ├── pub/   #     - 발행자 (Publisher)
│       └── sub/   #     - 구독자 (Subscriber)
├── ex09/          # 위임 패턴 (Delegation)
├── ex10/          # 커맨드 + 팩토리 패턴 (Command + Factory)
└── mock/          # 목 객체 패턴 (Mock Object)
```

---

## 패턴별 개념 설명

### ex01 - 전략 패턴 (Strategy)

**목적:** 알고리즘(행위)을 캡슐화하여 런타임에 교체할 수 있게 한다.

- 동일한 문제를 해결하는 여러 알고리즘을 인터페이스로 추상화한다.
- 클라이언트는 구체적인 알고리즘을 몰라도, 인터페이스를 통해 실행할 수 있다.
- `if-else` / `switch` 분기를 제거하고, 새로운 전략을 추가해도 기존 코드를 수정하지 않는다. (OCP)

```
Context ──has-a──▶ <<interface>> Strategy
                        ▲
              ┌─────────┼─────────┐
        ConcreteA   ConcreteB   ConcreteC
```

---

### ex02 - 프록시 패턴 (Proxy)

**목적:** 실제 객체에 대한 접근을 제어하는 대리 객체를 둔다.

- 프록시는 실제 객체와 같은 인터페이스를 구현하여, 클라이언트는 프록시인지 실제 객체인지 구분하지 못한다.
- **접근 제어**(권한 검사), **지연 초기화**(Lazy Loading), **로깅/캐싱** 등에 활용한다.
- 실제 객체의 생성·호출 전후에 부가 로직을 삽입할 수 있다.

```
Client ──▶ <<interface>> Subject
                 ▲
           ┌─────┴─────┐
         Proxy ──▶ RealSubject
```

---

### ex03 - 어댑터 패턴 (Adapter)

**목적:** 호환되지 않는 인터페이스를 가진 클래스를 함께 사용할 수 있게 변환한다.

- 기존 클래스(Adaptee)의 인터페이스를 클라이언트가 기대하는 인터페이스(Target)로 변환한다.
- 기존 코드를 수정하지 않고, 어댑터 클래스만 추가하여 호환성을 확보한다.
- **클래스 어댑터**(상속 이용)와 **객체 어댑터**(합성 이용) 두 가지 방식이 있다.

```
Client ──▶ <<interface>> Target
                 ▲
              Adapter ──has-a──▶ Adaptee
```

---

### ex04 - 싱글톤 패턴 (Singleton)

**목적:** 클래스의 인스턴스가 오직 하나만 존재하도록 보장하고, 전역 접근점을 제공한다.

- 생성자를 `private`으로 막고, 정적 메서드(`getInstance()`)를 통해 유일한 인스턴스를 반환한다.
- 설정 관리, 로깅, 커넥션 풀 등 하나의 인스턴스만 필요한 자원에 사용한다.
- 멀티스레드 환경에서는 동기화 처리(`synchronized`, `enum`, `static inner class`)가 필요하다.

```
Singleton
 - static instance: Singleton
 - private Singleton()
 + static getInstance(): Singleton
```

---

### ex05 - 템플릿 메서드 패턴 (Template Method)

**목적:** 알고리즘의 골격(템플릿)을 상위 클래스에서 정의하고, 세부 단계를 하위 클래스에서 구현한다.

- 상위 클래스가 `final` 템플릿 메서드로 실행 순서를 고정한다.
- 하위 클래스는 추상 메서드(hook)를 오버라이딩하여 각 단계의 구체적인 동작을 결정한다.
- **제어의 역전(IoC)**: 상위 클래스가 하위 클래스를 호출하는 구조이다. ("Don't call us, we'll call you")

```
AbstractClass
 + templateMethod()  ← final (골격 정의)
 # step1()           ← abstract
 # step2()           ← abstract
       ▲
 ConcreteClass
 # step1() { ... }
 # step2() { ... }
```

---

### ex06 - 데코레이터 패턴 (Decorator)

**목적:** 객체에 동적으로 새로운 책임(기능)을 추가한다. 상속 대신 합성을 사용한다.

- 데코레이터는 감싸는 객체와 동일한 인터페이스를 구현하여 투명하게 기능을 확장한다.
- 여러 데코레이터를 겹겹이 감싸서(체이닝) 기능을 조합할 수 있다.
- 상속으로 인한 클래스 폭발 문제를 해결한다.

```
<<interface>> Component
       ▲
 ┌─────┴──────────┐
Concrete      Decorator ──has-a──▶ Component
Component        ▲
           ┌─────┴─────┐
       DecoratorA   DecoratorB
```

---

### ex07 - 팩토리 패턴 (Factory)

**목적:** 객체 생성 로직을 별도의 팩토리에 위임하여, 클라이언트가 구체 클래스를 직접 `new`하지 않게 한다.

- 클라이언트는 팩토리에게 "무엇을 만들어줘"라고 요청만 하고, 구체적인 생성 방법은 모른다.
- **팩토리 메서드**: 하위 클래스가 생성할 객체의 타입을 결정한다.
- **추상 팩토리**: 관련 있는 객체군을 한꺼번에 생성하는 인터페이스를 제공한다.

```
Client ──▶ Factory.create(type)
                │
         ┌──────┼──────┐
     ProductA  ProductB  ProductC
```

---

### ex08 - 옵저버 패턴 (Observer)

**목적:** 한 객체의 상태 변화를 관찰하는 다수의 객체에게 자동으로 알린다. (1:N 의존 관계)

#### 폴링 방식 (Pull)
- 옵저버가 주기적으로 주체(Subject)의 상태를 직접 확인한다.
- 구현이 단순하지만, 불필요한 확인이 반복되어 비효율적이다.

#### 푸시 방식 (Push)
- 주체의 상태가 변하면 등록된 모든 구독자에게 즉시 통지한다.
- **Publisher(발행자)**: 상태를 관리하고, 변경 시 구독자에게 알린다.
- **Subscriber(구독자)**: 알림을 받아 자신의 상태를 갱신한다.

```
Subject (Publisher)
 - observers: List<Observer>
 + subscribe(observer)
 + unsubscribe(observer)
 + notify()
       │
       ▼
<<interface>> Observer (Subscriber)
 + update(data)
```

---

### ex09 - 위임 패턴 (Delegation)

**목적:** 객체가 특정 작업을 직접 수행하지 않고, 다른 객체(delegate)에게 위임한다.

- 상속 대신 합성을 사용하여 코드를 재사용하는 기법이다.
- 위임받는 객체를 런타임에 교체할 수 있어 유연성이 높다.
- 전략 패턴, 프록시 패턴 등 다른 패턴의 기반이 되는 기본 원리이다.

```
Delegator ──has-a──▶ Delegate
 + doWork()           + doWork()
   → delegate.doWork()
```

---

### ex10 - 커맨드 + 팩토리 패턴 (Command + Factory)

**목적:** 요청(명령)을 객체로 캡슐화하고, 팩토리가 적절한 커맨드 객체를 생성한다.

- **커맨드 패턴**: 실행할 작업을 객체로 만들어 매개변수화, 큐잉, 로깅, 실행 취소(Undo)를 가능하게 한다.
- **팩토리 패턴과 결합**: 커맨드 객체의 생성을 팩토리가 담당하여, 클라이언트는 구체적인 커맨드 타입을 몰라도 된다.

```
Client ──▶ CommandFactory.create(type) ──▶ <<interface>> Command
                                                 + execute()
                                                 + undo()
                                                    ▲
                                           ┌────────┼────────┐
                                       CommandA  CommandB  CommandC
```

---

### mock - 목 객체 패턴 (Mock Object)

**목적:** 테스트 시 실제 의존 객체를 가짜(Mock) 객체로 대체하여 단위 테스트를 격리한다.

- 외부 시스템(DB, 네트워크, 파일 등)에 의존하지 않고 테스트할 수 있다.
- 목 객체는 기대되는 호출과 반환값을 미리 설정(stub)하고, 호출 여부를 검증(verify)한다.
- **테스트 더블** 종류: Dummy, Stub, Spy, Mock, Fake

```
[테스트 코드] ──▶ [테스트 대상] ──▶ <<interface>> Dependency
                                          ▲
                                    ┌─────┴─────┐
                               RealImpl     MockImpl (테스트용)
```