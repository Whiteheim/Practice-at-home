// JavaScript 관련 구글링
// 👉 site:developer.mozilla.org {연관_키워드}
'use strict';

// Web API란
// - 웹 개발을 돕는, 잘 만들어진 도구들(제공되는 객체와 함수등의 코드)
// - 예: console.log(), document.querySelector(), Array.push(), ..
// - 구글링: 자바스크립트 Web API란
// - 참조: https://developer.mozilla.org/ko/

// 1. Date & String 클래스
// - Date: 특정 시간을 객체로 다루기 위한 틀
// - String: 문자열을 객체로 다루기 위한 틀
// - 구글링: 자바스크립트 Date 클래스, 자바스크립트 문자열 split
// - 참조: https://developer.mozilla.org/ko/ 에서 검색

// 1) 시간 객체 생성
const firstMetDate = new Date("2022-02-12");
const the100thDate = new Date("2022-11-04");
console.log(firstMetDate);
console.log(firstMetDate.toISOString());
//2022-02-12T00:00:00.000Z => 2022-02-12
console.log(firstMetDate.toISOString());
console.log(firstMetDate.toISOString().split("T")[0]);
console.log(the100thDate.toISOString().split("T")[0]);

// 2) 시간 간격 계산
const ms = the100thDate.getTime() - firstMetDate.getTime();
console.log(ms);

// 3) 단위 변환 (밀리초 : 1/1000 -> 초 -> 분 -> 시간 -> 일)
// 초
const sec = ms / 1000; 
console.log(sec);
// 분
const min = sec / 60;
console.log(min);
// 시간
const hour = min / 60;
console.log(hour);
// 일
const day = hour / 24;
console.log(day);

console.log(`${sec}초 => ${hour}시간 => ${day}일`);

// 4) 검증
const clone = new Date(the100thDate);
// 2022-11-04 - 265일
clone.setDate(clone.getDate() - 265);
console.log(clone.toISOString().split("T")[0]);

const clone2 = new Date(the100thDate);
clone2.setDate(clone2.getDate() + 100);
console.log(clone2.toISOString().split("T")[0]);

// 2. setTimeout() 메소드
// - 일정 시간이 지나고, 동작을 수행하는 메소드
// - 해당 메소드는 window 객체가 수행하지만, 보통 생략 됨
// - 실제 호출: window.setTimeout()
// - 구글링: 자바스크립트 setTimeout 사용법
// - 참조: https://developer.mozilla.org/ko/ 에서 검색

function openRandomBox() {
    
    // a) 선물 객체 배열 생성
    const items = [
        {name: "지갑", price: 168000, desc: "컴순이가 지갑을 안들고 다니던데, 이번 기회에 선물해주면 어떨까..?"},
        {name: "향수", price: 82000, desc: "좋은향 싫어하는 여자는 없다! 근데 컴순이 향수 취향을 모르는데.."},
        {name: "아이패드", price: 1200000, desc: "대학생에게 이만한 선물이 있을까? 문제는 가격이라능.."},
        {name: "에어팟", price: 359000, desc: "한번 써보면, 줄이어폰으로 못돌아 간다는 그 아이템..!"},
        {name: "애플워치", price: 359000, desc: "함께 커플로 애플워치를 하고 싶어..!"},
        ];

    // b) 랜덤 선물 선정
    const randFloat = Math.random() * items.length;
    const randInt = Math.floor(randFloat); // 0.0 ~ 4.9 => 0 ~ 4
    const pickedItem = items[randInt];
    console.log(pickedItem);

    // c) 브라우저 (DOM객체)에 반영
    const cardTitle = document.querySelector("#practice-2 .card-body h5.card-title");
    const cardPrice = document.querySelector("#practice-2 .card-body h6.card-subtitle");
    const cardText = document.querySelector("#practice-2 .card-body p.card-text");
        
    cardTitle.innerText = pickedItem.name;
    cardPrice.innerText = `₩ ${pickedItem.price.toLocaleString()}`;
    cardText.innerText = pickedItem.desc;
};

// [연습2] 기념 선물 고르기, 여러 선물들 중 택1(랜덤박스)
// 1) 이벤트 감시 대상 가져오기
const pickBtn = document.querySelector("#practice-2 .card-body a.btn");



// 2) 이벤트 감지 시작 및 처리 함수 연결
pickBtn.addEventListener("click", function(event) {
    // 3) 클릭 이벤트 처리
    // 3.1) 화살표 함수로 변경
    // setTimeout(특정 시간 후 동작할 함수, 지연시간);
    // setTimeout(function() {console.log(3)}, 0);
    // setTimeout(function() {console.log(2)}, 1000);
    // setTimeout(function() {console.log(1)}, 2000);
    // setTimeout(function() {console.log("뿅")}, 3000);
    setTimeout(() => {console.log(3)}, 0);
    setTimeout(() => {console.log(2)}, 1000);
    setTimeout(() => {console.log(1)}, 2000);
    setTimeout(() => {openRandomBox()}, 3000);
    // console.log(3);
    // console.log(2);
    // console.log(1);
    // console.log("뿅");
});
