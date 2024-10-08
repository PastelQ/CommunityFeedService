package org.fastcampus.user.domain;

import java.util.Objects;
import org.fastcampus.common.domain.PositiveIntegerCounter;

// User 정보
public class User {

  private final Long id;
  private final UserInfo info; // UserInfo VO로 대체
  private final PositiveIntegerCounter followingCount; // User의 팔로잉 카운트 - common으로 빼 공통으로 동일한 로직 사용
  private final PositiveIntegerCounter followarCounter;// User의 팔로워 카운터 - common으로 빼 공통으로 동일한 로직 사용
  
  public User(Long id, UserInfo userInfo) {
    if(userInfo == null) {
      throw new IllegalArgumentException();
    }
    
    this.id = id;
    this.info = userInfo;
    this.followingCount = new PositiveIntegerCounter();
    this.followarCounter = new PositiveIntegerCounter();
  }
  
  // 팔로우 기능
  public void follow(User targetUser) {
    if (targetUser.equals(this)) {
      throw new IllegalArgumentException();
    }
    
    followingCount.increase();              // 나의 팔로잉 카운트 +
    targetUser.increaseFollowarCount();
  }
  
  // 언팔로우 기능 구현
  public void unfollow(User targetUser) {
    if (this.equals(targetUser)) {
      throw new IllegalArgumentException();
    }
    
    followingCount.increase();
    targetUser.decreaseFollowarCount();
  }
  
  /* targetUser의 카운팅 증감 메서드 2가지
   -팔로우/언팔로우 기능에서 다른 객체에(targetUser) 접근하는 것을 막기 위함
   (체이닝, 스트림을 제외하고 .연산자가 2회 쓰일 경우 주의(다른 2개의 객체를 동시 조작하고 있는 것일 수 있음) */
  private void increaseFollowarCount() {
    followarCounter.increase();
  }
  
  private void decreaseFollowarCount() {
    followarCounter.decrease();
  }
  
  
  //필드 id : 객체를 메모리 주소값으로 비교를 하기 때문에 hashCode(), equals()를 재정의해야함
  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    return Objects.equals(id, other.id);
  }
  
  // User의 id를 반환하는 Get method
  public Long getId() {
    return id;
  }
}
