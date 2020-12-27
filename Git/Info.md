#  git

git 에 대한 전반적인 학습 내용들을 다룰 예정이다. 

git 을 사용하긴 했었지만, -f 사용해서 레포를 날린 경험과 커밋을 다시 돌릴 수 없을까 고민 끝에 

reset 해본적이 있다. 그래서 조금 무섭기는 하지만 차근 차근 배워서 협업할 때 

이 시행착오들이 도움이 되길 바란다. 

------

우선 아래 방법을 따라하면 기본적으로 git에 올릴 수 있다. 



- 올리고싶은 프로젝트 폴더 우클릭 
- git bash here클릭
- 

#### 사용자 등록

```
$ git config --global user.email akwogml112@gmail.com
```



#### 계정 연결 확인

```]
$ git config --list
```



#### git 레포지토리 만들기

![1](https://user-images.githubusercontent.com/26570275/103166564-ad857200-4866-11eb-9132-71ae8edca465.PNG)

- new 클릭



![2](https://user-images.githubusercontent.com/26570275/103166579-db6ab680-4866-11eb-8bd4-00f98559267f.PNG)

- repository name 설정 후 
- create repository를 하게되면 생성 완료




#### 리모트 연결하기

```
$ git remote add origin 레포지토리 주소 (ex.httpsgithub.comher0807-java.git)
```

오리진이라는 이름으로 연결



#### 리모트 연결 확인

```
$ git remote -v
```



####  업로들할 파일 지정

```
$ git add .
```

add  와 . 사이에 간격 필수



#### 로컬 저장소에서 원격 저장소로 올릴 파일 지정 후 설명

```
$ git commit -m "커밋 메세지"
```

나중에 커밋 메세지를 보고 바로 어떤 작업을 했는지 알 수 있게

커밋 메세지 안에는 의미 있는 설명을 적어야 함.



#### 원격 저장소로 올리기 

```
$ git push origin master
```

 



이렇게 하면 git 에 업로드 완료