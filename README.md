# 🍯Sweet Tomato🍅



## 0. 기획의도

Sweet Tomato는 WebRTC 기술을 기반으로 한 온라인 화상 스터디 프로그램이다. 해당 프로그램은 크게 비공개 스터디와 공개 스터디로 나뉜다. Sweet Tomato 의 가장 핵심적인 기술은 바로 뽀모도로 시간 관리법에 기반한 집중 시간 관리 기능을 제공한다는 것이다. 이 외에도 사용자들이 스터디 시에 필요한 다양한 기능들을 포함해 효율적으로 스터디를 관리하도록 한다.





## 1. 팀원 정보 및 업무 분담 내역

| <img src="https://user-images.githubusercontent.com/75067702/135885502-0402b3fa-b756-41a4-ad1e-9897a8c421a9.PNG" style="zoom:50%;"/>| <img src="https://user-images.githubusercontent.com/75067702/135885557-46f01af2-aa77-469a-ab10-bcae1d74d0f5.PNG" style="zoom:50%;" />| <img src="https://user-images.githubusercontent.com/75067702/135885622-9d6e925b-00b4-49c9-b06a-70d07ded2989.PNG" style="zoom:50%;" />| <img src="https://user-images.githubusercontent.com/75067702/135885650-9f95d77e-8efe-42ef-b637-7bd352943004.PNG" style="zoom:50%;" />|
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 전혜민                                                       | 김종혁                                                       | 이유진                                                       | 박근일                                                       |
| BE, 배포, Openvidu 관련                                      | BE                                                           | FE                                                           | FE, 기획, 디자인, 영상제작                                   |




## 2. 프로젝트 구조

### 2-1. 프로젝트 아키텍처

![image-20211005003148510](https://user-images.githubusercontent.com/75067702/135885800-14c70617-1657-4e68-ac29-93af343c3e34.png)


### 2-2. 브랜치 관리 전략

- Git Flow를 사용한 브랜치 관리

- 참고 자료
  https://nvie.com/posts/a-successful-git-branching-model/
  https://techblog.woowahan.com/2553/




## 3. 프로젝트 소개


### 3-1. 화상회의
<img src="https://user-images.githubusercontent.com/75067702/135885825-f94a8e5f-7bdf-4fb1-9f04-ec7477abf2b8.png" style="zoom:50%;" />

- 캠, 오디오 on/ off 
- 웹 소켓 채팅
- 스터디, 참가자 확인
- 블랙리스트 등록
- 타이머



### 3-2. 뽀모도로 기능

> 뽀모도로란, 본인이 정한 시간만큼은 최대한 집중할 수 있도록 하는 집중 기법입니다.

<img src="https://user-images.githubusercontent.com/75067702/135885846-f266d42b-819e-423d-80aa-ef3099942dba.png" style="zoom:50%;" />

- 원하는 뽀모도로 시간 및 개수 설정
- 토마토 익기 버튼 클릭시, 집중시간 시작!



### 3-3. 공부시간 시각화
<img src="https://user-images.githubusercontent.com/75067702/135885881-ecf5ac49-cce6-4c65-9388-2da480866485.png" style="zoom:50%;" />

- Piechart, HeatMap 등을 이용한 개인 및 스터디의 공부량을 확인 가능



### 3-4. 스터디 커뮤니티
<img src="https://user-images.githubusercontent.com/75067702/135885909-bf33f5fa-d038-4b01-be49-deca569e6808.png" style="zoom:50%;" />

- 댓글 기능
- 자료실 첨부파일 등록 및 다운로드 가능



### 3-5. 그 외

- 스터디 검색
- 비밀번호 찾기 (임시비밀번호 이메일 전송)





## 4. 화면 설계

<img src="https://user-images.githubusercontent.com/75067702/135885941-c4808daf-ace1-4a64-8683-75ca1b68f43b.png" style="zoom:50%;" />

- [Figma 링크 참조](https://www.figma.com/file/n0U0H4rmLrkFV9bUBuFQqS/UI-리뉴얼?node-id=0%3A1)





## 5. ERD 설계

<img src="https://user-images.githubusercontent.com/75067702/135885978-977051c6-d5e9-4d74-9ff7-a15ccbfd77a8.png" style="zoom:50%;" />




