package com.jdyun.example08_loading_property_in_configuration_class;
// example7_1 프로퍼티들을 그대로 사용한다.
// [자바파일을 이용한 프로퍼티 DI 방법]

// [Spring 3.X 방법]
// 		1. 프로퍼티 파일 작성 
// 		2. @Configuration 클래스에서 PropertySourcesPlaceholderConfigurer 클래스를 사용해서 여러 프로퍼티 파일들 로딩 
// 		3. AnnotationConfigApplicationContext로 설정 클래스 로딩 및 빈 가져오기


// [Spring 4.X 방법]
// 		1. 프로퍼티 파일 작성 
// 		2. @Configuration 클래스에서 @PropertySources, @PropertySource 어노테이션을 추가하여 경로를 지정 후 여로 프로퍼티 파일들 로딩 
// 		3. AnnotationConfigApplicationContext로 설정 클래스 로딩 및 빈 가져오기
