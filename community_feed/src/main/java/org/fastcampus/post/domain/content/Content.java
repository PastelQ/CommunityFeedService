package org.fastcampus.post.domain.content;

public abstract class Content {
  String contentText;

  protected Content(String contentText) {
    checkText(contentText);
    this.contentText = contentText;
  }
  
  // 게시글, 댓글의 유효성 검사를 진행할 추상 메서드
  protected abstract void checkText(String contentText);
  
  public String getContentText() {
    return contentText;
  }
  
}
