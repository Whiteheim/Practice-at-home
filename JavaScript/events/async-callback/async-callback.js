// JavaScript 관련 구글링
// 👉 site:developer.mozilla.org {연관_키워드}
'use strict';

// 1. 동기 함수(synchronous function)
// - 순차적으로 수행되는 함수
// - 결과물을 받아야만, 다음을 진행할 수 있음
// - 👍 장점: 실행 흐름 파악, 쉬움
// - 👎 단점: 대기시간 누적으로, 처리지연 증가

// 동기적 시간지연 함수 
function sleep(ms) {
    // 깨어날 시간
    const wakeUpTime = Date.now() + ms;
    // 깨어날 시간 까지 대기
    while(Date.now() < wakeUpTime) {

    }
};

// 집안일 동기적 처리하기
function synchronousSample(){
    // 집안일하기 (세탁 - 재료손질 - 요리 - 식사 - 설거지)
    sleep(6000);
    console.log("세탁기 돌리기(60분)");
    sleep(1500);
    console.log("재료 손질(15분))");
    sleep(2000);
    console.log("요리하기(20분)");
    sleep(1500);
    console.log("식사하기(15분)");
    sleep(1000);
    console.log("설거지하기(10분)");

}

//synchronousSample();

// 2. 비동기 함수(asynchronous function)
// - 비순차적으로 수행되는 함수
// - 결과물을 받지 않고, 다음을 진행
// - 주로 외부 자원(서버, DB, API, ..) 네트워크 요청 시, 사용
// - 👍 장점: 요청 결과를 기다리지 않고, 다른 작업이 가능(시간단축)
// - 👎 단점: 실행 흐름 파악이 어려울 수 있음
// - 예: setTimeout(), fetch(), ...

// 집안일, 비동기 방식으로
function asynchronousSample() {
    // 시작 시간 측정
    const start = Date.now();
    // 세탁
    //setTimeout(수행함수, 지연시간);
    setTimeout(() => {
        console.log("세탁기 (60분)")
    }, 6000);
    
    // 식사를 위한 작업
    setTimeout(()=>{
        console.log("재료손질 (15분)")
    }, 1500)
    setTimeout(()=>{
        console.log("요리하기 (20분)")
    }, 2000)
    setTimeout(()=>{
        console.log("식사하기 (15분)")
    }, 1500)
    setTimeout(()=>{
        console.log("설거지하기 (10분)")
    }, 1000)
    // 총 수행시간 확인
    const end = Date.now();
    console.log(`총 수행시간 : ${end - start}`);
}

// asynchronousSample();

// 3. 콜백(callback: do next..)
// - 함수를 파라미터로 받아, 함수 호출의 하는 기법
// - 비동기 함수의 연속성을 위해, 주로 사용
// - 예1: setTimeout(callback, delay)
// - 예2: addEventListener(event, callback)

// 집안일을 위한 콜백 함수
function housework(task, delay, doNext){
    // setTimeout(지연시간_후_동작시킬_함수, 밀리초_지연시간);
    setTimeout(function() {
        console.log(task);
        doNext(); // 콜백 수행: 파라미터로 전달된 함수를 호출
    }, delay);
};

// 집안일하기, 콜백으로 비동기 함수의 연속성 (순서, 종속성) 부여
function callbackSample(){
    // 세탁기를 돌리고, 콜백으로 소요시간 측정
    const startA = Date.now();
    housework("세탁기 돌리기(60분)", 6000, function() {
        console.log(`세탁완료까지 : ${(Date.now() - startA)/100}분`);
    });
        
    // 식사를 위한 일련의 작업 후, 콜백으로 소요시간 측정
    const startB = Date.now();
    housework("재료 손질(15분)", 1500, function() {
        housework("요리하기 (20분)", 2000, function() {
            housework("식사하기 (15분)", 1500, function() {
                housework("설거지하기(10분)", 1000, function() {
                    console.log(`재료손질 ~ 설거지 : ${(Date.now() - startB)/100}분`);
                });
            });
        });
    });
}

callbackSample();