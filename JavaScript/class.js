// JavaScript 관련 구글링
// 👉 site:developer.mozilla.org {연관_키워드}
'use strict';
// 1. 클래스란?
// - 클래스란? 객체를 찍어내는 틀(like a 붕어빵틀, 설계도)
// - 클래스는 필드(상태)와 메소드(동작)으로 구성 됨
// 댕댕이 클래스 만들기
// class Dog {
//     // 필드(상태; 변수): 이름, 품종, 나이
//     _name;
//     _breed;
//     _age;
//     // 메소드(동작; 함수): 짖기, 앉기, 눕기
//     bark() {
//         console.log("댕댕이가 짖습니다.");
//     }
//     sit() {
//         console.log("댕댕이가 앉습니다.");
//     }
//     lieDown() {
//         console.log("댕댕이가 눕습니다.");
//     }
// }

// 2. 생성자란?
// - 생성자란? 객체를 만들때 사용되는 메소드로 constructor라 함
// - 클래스로부터 객체를 만들 시, new 키워드가 필요
// 댕댕이 클래스 만들기
// class Dog {
//     // 필드(상태; 변수): 이름, 품종, 나이
//     _name;
//     _breed;
//     _age;
//     // 생성자(객체를 만드는 특별한 메소드)
//     constructor(name, breed, age) {
//         this._name = name;
//         this._breed = breed;
//         this._age = age;
//     }
//     // 메소드(동작; 함수): 짖기, 앉기, 눕기
//     bark() {
//         console.log("댕댕이가 짖습니다.");
//     }
//     sit() {
//         console.log("댕댕이가 앉습니다.");
//     }
//     lieDown() {
//         console.log("댕댕이가 눕습니다.");
//     }
// }
// 5. this 키워드
// - 메소드를 수행한 주체 객체를 의미(예외 있음(할말하않), 나중에..)
// - dog0.bark()가 호출될 때, this => dog0
// - dog1.sit()가 호출될 때, this => dog1
// - dog2.lieDown()가 호출될 때, this => dog2
// 댕댕이 클래스 만들기
class Dog {
    // 필드(상태; 변수): 이름, 품종, 나이
    _name;
    _breed;
    _age;
    // 생성자(객체를 만드는 특별한 메소드)
    constructor(name, breed, age) {
        this._name = name;
        this._breed = breed;
        this._age = age;
    }
    // 메소드(동작; 함수): 짖기, 앉기, 눕기
    bark() {
        console.log(`[${this._name}]가 짖습니다.`);
    }
    sit() {
        console.log(`[${this._name}]가 앉습니다.`);
    }
    lieDown() {
        console.log(`[${this._name}]가 눕습니다.`);
    }
}
// 댕댕이 객체 생성
const dog0 = new Dog("뭉치", "골든리트리버", 4);
const dog1 = new Dog("뽀삐", "시고르자브종", 2);
const dog2 = new Dog("콩이", "푸들", 1);
// 객체 정보 확인
console.log(dog0);
console.log(dog1);
console.log(dog2);

// 3. 객체값 읽고 쓰기
// - 필드와 메소드 모두 객체의 프로퍼티(키와 값의 쌍)임
// - 따라서 닷(.)연산, 브라켓([])연산, for..in 등 사용 가능
// 댕댕이 나이 1살씩 증가
dog0._age += 1;
dog1._age += 1;
dog2._age += 1; 
// 댕댕이 정보 출력
console.log(`${dog0._name}(${dog0._breed}, ${dog0._age}살)`);
console.log(`${dog1._name}(${dog1._breed}, ${dog1._age}살)`);
console.log(`${dog2["_name"]}(${dog2["_breed"]}, ${dog2["_age"]}살)`);
// for..in 으로 프로퍼티 순회
for(let key in dog0) {
    console.log(`${key} => ${dog0[key]}`);
}

// 4. 메소드 호출하기
// - 메소드란? 클래스 내부에 작성된 함수로,
// - 특정 객체가 주체가되어 수행하는 동작
// 메소드 호출: 댕댕이들에게 다양한 동작을 하게 함
dog0.bark();
dog1.sit();
dog2.lieDown();

