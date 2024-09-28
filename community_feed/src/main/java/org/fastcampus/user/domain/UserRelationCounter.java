package org.fastcampus.user.domain;

// UserRelationCounter VO : 팔로워, 팔로잉 카운터는 로직이 동일하여 해당 VO로 감싸 로직 처리
public class UserRelationCounter {

  private int count;
  
  public UserRelationCounter() {
    this.count = 0;
  }
  
  // 카운트 증가
  public void increase() {
    this.count++;
  }
  
  // 카운트 감소 (단, 0 이하일 경우 진행 X)
  public void decrease() {
    if(count <= 0) {
      return;
    }
    this.count--;
  }
}
