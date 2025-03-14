# KioskProject

### 1. 프로젝트 소개
   - 해당 프로젝트는 객체지향언어인 JAVA를 이용하여 키오스크를 구현한다.
   - level 1 : 입력 처리와 간단한 흐름 제어를 복습하는 키오스크 구현
  
### 2. 요구사항 정의
#### Lv 1. 기본적인 키오스크를 프로그래밍해보자
- **햄버거 메뉴 출력 및 선택하기**
   - `Scanner`를 사용하여 여러 햄버거 메뉴를 출력합니다.
   - 제시된 메뉴 중 입력받은 숫자에 따라 다른 로직을 실행하는 코드를 작성합니다.
   - 반복문을 이용해서 특정 번호가 입력되면 프로그램을 종료합니다.
 
**Lv1을 구현하면 터미널에 이렇게 보여집니다.**

#### Lv 2. 객체 지향 설계를 적용해 햄버거 메뉴를 클래스로 관리하기
- **MenuItem 클래스 생성하기**
   - 설명 : 개별 음식 항목을 관리하는 클래스입니다. 현재는 햄버거만 관리합니다.
   - 클래스는 이름, 가격, 설명 필드를 갖습니다.
 
- **main 함수에서 MenuItem 클래스를 활용하여 햄버거 메뉴를 출력합니다.**
   - MenuItem 객체 생성을 통해 이름, 가격, 설명을 세팅합니다.
      - 키워드: new
   - List를 선언하여 여러 MenuItem을 추가합니다.
      - List<MenuItem> menuItems = new ArrayList<>();
   - 반복문을 활용해 menuItems를 탐색하면서 하나씩 접근합니다.

#### Lv 3. 객체 지향 설계를 적용해 순서 제어를 클래스로 관리하기
- **Kiosk 클래스 생성하기**
   - 설명: 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스입니다.
   - MenuItem을 관리하는 리스트가 필드로 존재합니다.
   - main 함수에서 관리하던 입력과 반복문 로직은 이제 start 함수를 만들어 관리합니다.
   - List<MenuItem> menuItems 는 Kiosk 클래스 생성자를 통해 값을 할당합니다.
      - Kiosk 객체를 생성하고 사용하는 main 함수에서 객체를 생성할 때 값을 넘겨줍니다.

- **요구사항에 부합하는지 검토**
   - 키오스크 프로그램을 시작하는 메서드가 구현되어야 합니다.
      - 콘솔에 햄버거 메뉴를 출력합니다.
      - 사용자의 입력을 받아 메뉴를 선택하거나 프로그램을 종료합니다.
      - 유효하지 않은 입력에 대해 오류 메시지를 출력합니다.
      - 0을 입력하면 프로그램이 ‘뒤로가기’되거나 ‘종료’됩니다.
#### Lv 4. 
- **Menu 클래스 생성하기**
- 설명 : MenuItem 클래스를 관리하는 클래스입니다.
- 예를 들어, 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함합니다.
- List<MenuItem> 은 Kiosk 클래스가 관리하기에 적절하지 않으므로 Menu 클래스가 관리하도록 변경합니다.
- 여러 버거들을 포함하는 상위 개념 ‘버거’ 같은 카테고리 이름 필드를 갖습니다.
- 메뉴 카테고리 이름을 반환하는 메서드가 구현되어야 합니다.
#### Lv 5. 캡슐화 적용하기
- `MenuItem`, `Menu` 그리고 `Kiosk` 클래스의 필드에 직접 접근하지 못하도록 설정합니다.
- Getter와 Setter 메서드를 사용해 데이터를 관리합니다.
#### 도전 Lv 1. 장바구니 및 구매하기 기능을 추가하기
- **장바구니 생성 및 관리 기능**
   - 사용자가 선택한 메뉴를 장바구니에 추가할 수 있는 기능을 제공합니다.
   - 장바구니는 메뉴명, 수량, 가격 정보를 저장하며, 항목을 동적으로 추가 및 조회할 수 있어야 합니다.
   - 사용자가 잘못된 선택을 했을 경우 예외를 처리합니다(예: 유효하지 않은 메뉴 번호 입력)
- **장바구니 출력 및 금액 계산**
   - 사용자가 결제를 시도하기 전에, 장바구니에 담긴 모든 메뉴와 총 금액을 출력합니다.
   - 출력 예시
      - 각 메뉴의 이름, 가격, 수량
      - 총 금액 합계
- **장바구니 담기 기능**
   - 메뉴를 클릭하면 장바구니에 추가할 지 물어보고, 입력값에 따라 “추가”, “취소” 처리합니다.
      - 메뉴는 한 번에 1개만 담을 수 있습니다.
   - 장바구니에 담은 목록을 출력합니다.
- **주문 기능**
   - 장바구니에 담긴 모든 항목을 출력합니다.
   - 합산하여 총 금액을 계산하고, “주문하기”를 누르면 장바구니를 초기화합니다.
#### 도전 Lv 2. Enum, 람다 & 스트림을 활용한 주문 및 장바구니 관리 
- **Enum을 활용한 사용자 유형별 할인율 관리하기**
   - 사용자 유형의 Enum 정의 및 각 사용자 유형에 따른 할인율 적용
      - 예시 : 군인, 학생, 일반인
   - 주문 시, 사용자 유형에 맞는 할인율 적용해 총 금액 계산
- **람다 & 스트림을 활용한 장바구니 조회 기능**
   - 기존에 생성한 Menu의 MenuItem을 조회 할 때 스트림을 사용하여 출력하도록 수정
   - 기존 장바구니에서 특정 메뉴 빼기 기능을 통한 스트림 활용
      - 예시 : 장바구니에 SmokeShack 가 들어 있다면, stream.filter를 활용하여 특정 메뉴 이름을 가진 메뉴 장바구니에서 제거

### 3. 설계
#### Lv 1. 설계
- 메뉴 선택
- 상세 페이지 출력
#### Lv 2. 설계
- MenuItem 클래스 생성

#### Lv 3. 설계
- Kiosk 클래스를 만들어 start 메소드 내에서 입력, 반복 처리하기
- main에서 kiosk 객체를 생성할 때 값 넘겨주기(근데 무슨 값을 넘겨주지)
- MuneItem을 필드로 관리하기(kiosk 생성자를 통해 값을 할당함)
- 유효하지 않은 입력에 대해 오류 메시지 출력하기
- 0을 입력하면 뒤로가거나 종료하기
#### Lv 4. 설계
- MenuItem을 Menu 클래스에서 관리하기
   - Menu에는 category 필드를 가진다.
   - 메뉴 카테고리 이름을 반환하는 메소드가 구현
#### 도전 Lv 1. 설계
- ShoppingCart 클래스 생성
   - menuItem의 이름, 수량, 가격 정보를 저장함(ArrayList로 관리)
   - setter를 이용해 장바구니에 추가
   - 잘못된 선택에 대한 예외 처리하기(유효하지 않은 메뉴 번호 입력)
   - 장바구니에 담긴 모든 메뉴와 총 금액 출력
- 메뉴를 선택하면 장바구니에 추가할지 선택 후 처리(추가, 취소)
   - 메뉴는 한 번에 1개만 담을 수 있음
- 장바구니 선택하면 장바구니 목록 출력
   - 주문하기 누르면 장바구니를 초기화
- 메뉴를 출력할 때마다 현재 장바구니 수량과 총 금액 보여주기
#### 도전 Lv 2. 설계
- 조회는 스트림을 사용
- 스트림을 활용해서 기존 장바구니에서 메뉴를 뺌
