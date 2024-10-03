package org.fastcampus.common.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// Test의 경우 public을 빼는 것이 좋다
class PositiveIntegerCounterTest {

  @Test
  void givenCreated_whenIncrease_thenCountIsOne() {
    // given(주어진 상태) : PositiveIntegerCounter 객체 생성
    PositiveIntegerCounter counter = new PositiveIntegerCounter();
    
    // when(조건이 가해진 상태) : increase() 실행
    counter.increase();
    
    // then(결과) : 예상 값인 1과 count 필드를 비교
    assertEquals(1, counter.getCount());
  }
  
  @Test
  void givenCreatedAndIncreased_whenDecrease_thenCounterIsZero() {
    // given : 객체 생성 및 increase() 실행 후
    PositiveIntegerCounter counter = new PositiveIntegerCounter();
    counter.increase();
    
    // when : decrease() 실행
    counter.decrease();
    
    // then : 예상 값 0과 비교
    assertEquals(0, counter.getCount());
  }
  
  // count가 0일 경우 decrease()로 음수로 떨어지는 부분이 방지되는 지 테스트 
  @Test
  void givenCreate_whenDecrease_thenCounterIsZero() {
    // given
    PositiveIntegerCounter counter = new PositiveIntegerCounter();
    
    // when
    counter.decrease();
    
    // then
    assertEquals(0, counter.getCount());
  }
}
