## 전자시계 구현

### 🖥환경
- Java

### 🖼썸네일
![시계](https://user-images.githubusercontent.com/83056872/128211824-7a27015f-0293-4766-8783-e9e997103009.JPG)

### ✋소개
- 스레드 상속
- Calendar클래스로 현재 시간(시,분,초)을 구해 Label에 추가

### ✍중요
**분,초는 60이 될 경우, 0으로 초기화해준 다음 시,분에 1을 더한다**
```java
sec++;
if (sec == 60) {
    sec = 0;
min++;
}
if(min == 60) {
    min = 0;
hour++;
}
```
