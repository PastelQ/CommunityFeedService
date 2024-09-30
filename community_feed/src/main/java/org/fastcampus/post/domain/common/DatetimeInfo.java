package org.fastcampus.post.domain.common;

import java.time.LocalDateTime;

// 게시글, 댓글에서 공통적으로 사용(수정 여부, 수정 시간)
public class DatetimeInfo {

  private boolean isEdited;
  private LocalDateTime dateTime;
  
  // 생성자 호출 시 각 필드는 1. false / 2. 현재시간(LocalDateTime) 입력
  public DatetimeInfo() {
    this.isEdited = false;
    this.dateTime = LocalDateTime.now();
  }
  
  public void updateEditDatetime() {
    this.isEdited = true;
    this.dateTime = LocalDateTime.now();
  }
  
  public boolean isEdited() {
    return isEdited;
  }
  public LocalDateTime getDateTime() {
    return dateTime;
  }
}
