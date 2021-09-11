## 최단거리

### BFS

가중치가 모두 1이어야한다.

O(v+e)

Depth First Search 

Breadth first Search



### Dijkstra 다익스트라

O(E log v)

가중치 상관없음



### 입력

그래프가 주어지고, 모든 간선이 음수가 아니어야하며,

시작 정점이 주어져야한다. 

### 출력

시작점에서 모든 점까지 최단거리가주어짐

### 필요한 정보

dist[i] : 시작점에서 i번 정점까지 가능한 최단거리

자료구조 D = {v,d } : 시작점에서 v 까지 d 만에 갈 수 있음을 확인했다.



---

### 순서도

1. Dist 배열 초기화

모든 i 에 대해서 시작점이면, 0이고, 아니면 무한대라는 점을 적어둔다.

2. 비어 있지 않은지 검정
3. 가치없는 젖ㅇ보를 폐기
4. 새로운 정보 d 를 추가 
5. 

### 수행시간

N= D 에 원소가 추가된 횟수

M =D 에 원소가 추출된 횟수

N(0 v,d 가 가치가 있으면 v 와 관련된 간선들을 보니까 볼떄 마다 갱신됨. )

모든 정점은 최대 한번씩 가치가 있는 v로 등장한다.

V, D 도 한번씩.. 뽑힘

N(모든 정점에 차수보다 같거나 적다.)

즉 전체 시간이 <= [T(5) + T(3)]X 간선수

T(3) 니가 가진 자료 중, 가장 작은 값을 가진 걸 줘.

T(5) 는 임의의 V,D 를 넣어줌.

이건 어떤 구조를 쓰냐에 따라서 달라짐.

1 차원 배열은 모든 배열을 봐야하고

Priority Queue, min Heap 을 보면 O(log E) 가 걸림

### O(E log  V) 만큼 걸림

근데 왜 다익스트라에서 음수가 있으면 안되냐??

그러면 의미 있는 간선이 여러번 나올 수가 있다,



### 주의할 점

맨 처음 초기화할 때 계산될수 있는 수보다 더 크게 초기화 해야함



그리고 최소 힙을 생성하고

시작점에 대해서 priorityQueue 에 시작점과 ,0 을 넣어줌



그 다음은 

비었는지? 안비었으면 꺼냄.

어떤 점정번호의 최단거리보다 dist 에 있는게 크다면 가치가 없기 떄문에 continue;

그게 아니라면 모든 간선들에 대해 봐야함.

### < 최단거리의 특성>

같은 정점을 두번 방문할 이유가 없음.

따라서 정답은 최대 * 정점수 보다 이하임 
