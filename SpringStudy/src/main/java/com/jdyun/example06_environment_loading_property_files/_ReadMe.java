package com.jdyun.example06_environment_loading_property_files;

// Environment ����Ͽ� ������Ƽ ��� �� ��������
// https://galid1.tistory.com/514?category=769011 �ڼ��� �����Ǿ��̚�.
// setEnvironment�� afterPropertiesSet ���� ���� ȣ��ȴ�.

// 1. ApplicationContext ���� �� ������Ƽ ���� �ε�
// 2. XML ���Ϸε� �� refresh�Լ��� ȣ���ϸ� EnviornmentAware �������̽��� ��ӹ��� Ŭ�����鸶�� ���������� setEnviornment �Լ��� ȣ������
// 3. ȣ��� setEnvironment �Լ����� ������Ƽ�� �о �� ��������� ������  
