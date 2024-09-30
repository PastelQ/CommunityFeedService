package org.fastcampus.post.domain.content;

import org.fastcampus.post.domain.common.DatetimeInfo;

public abstract class Content {
  String contentText;
  final DatetimeInfo datetimeInfo;

  protected Content(String contentText) {
    checkText(contentText);
    this.contentText = contentText;
    this.datetimeInfo = new DatetimeInfo();
  }
  
  // 게시글, 댓글의 유효성 검사를 진행할 추상 메서드
  protected abstract void checkText(String contentText);
  
  // 수정 : checkText() 추상 메서드를 이용해 Post, Comment 각기 다른 유효성 검사를 if문 없이 진행
  public void updateContent(String updateContent) {
    checkText(updateContent);
    this.contentText = updateContent;
    this.datetimeInfo.updateEditDatetime();
  }
  
  public String getContentText() {
    return contentText;
  }
}
