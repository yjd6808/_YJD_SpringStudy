package com.jdyun.example05_bean_lifecycle_callback;
// 빈 생성과 소멸에 호출되는 함수들 사용해보기
//
// InitializingBean, DisposableBean

// 위의 2가지 스프링함수를 사용하지 않고 간단하게 추가할 수 있는 어노테이션 방법
// @PostConstruct, @PreDestroy (JSR 250에 추가됨)
//     => https://devbible.tistory.com/461
//        이 두 함수는 Java 9 이후로 Deprecated 되었다고 한다. 그래서 추가하기 위해서는 종속성 추가를 해줘야한다.(Maven)
// 생성과 소멸시 호출해줄 함수를 추가할 수 있다.

/*

둘다 같은 느낌의 함수이다.
어노테이션 추가해서 하는게 좀 더 깔끔한 것 같다.
 
 */
