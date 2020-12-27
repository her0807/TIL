# git SSH 로 자동 로그인하기



내 로컬 저장소에서 원격 저장소로 push 할 때마다 로그인하라고 나와서 

자동로그인으로 설정 할 수 있을까? 고민후 ssh 를 만들고 설정해줬더니

한결 편해졌다  참고했던 블로그를 아래에 적어둔다. 



### ssh 생성 및 설정



 https://jootc.com/p/201905122827





그리고 나는 이미 remote 를 설정해뒀기 때문에 바꿔줘야했다. 





#### git remote push, fetch url 변경

#### 

```
$git remote set-url origin <원격지 저장소 주소>

$git remote set-url origin https://github.com/shelljs/shelljs.git
```

