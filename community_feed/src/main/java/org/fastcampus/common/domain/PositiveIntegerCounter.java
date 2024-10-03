package org.fastcampus.common.domain;
//UserRelationCounter 클래스의 숫자 증감 로직을 공통으로 빼 좋아요 기능에도 활용
public class PositiveIntegerCounter {

  private int count;
 
  public PositiveIntegerCounter() {
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
  
  // Get Method
  public int getCount() {
    return count;
  }
}
