package com.jdyun.example06_environment_loading_property_files;

// Environment 사용하여 프로퍼티 등록 및 가져오기
// https://galid1.tistory.com/514?category=769011 자세히 정리되어이싿.
// setEnvironment가 afterPropertiesSet 보다 먼저 호출된다.

// 1. ApplicationContext 생성 및 프로퍼티 파일 로딩
// 2. XML 파일로딩 후 refresh함수를 호출하면 EnviornmentAware 인터페이스를 상속받은 클래스들마다 내부적으로 setEnviornment 함수를 호출해줌
// 3. 호출된 setEnvironment 함수에서 프로퍼티를 읽어서 각 멤버변수에 대입해  
