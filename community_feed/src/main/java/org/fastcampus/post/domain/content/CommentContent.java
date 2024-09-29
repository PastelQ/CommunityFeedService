package org.fastcampus.post.domain.content;

// 댓글(comment) 내용 VO : Content Abstract 클래스를 상속 받음
public class CommentContent extends Content {

  // 글자수 제한 상수로 선언(최대 100)
  public static final int MAX_COMMENT_LENGTH = 100;
  
  public CommentContent(String content) {
    super(content);
  }
  
  // 추상메서드 checkText() 공통으로 사용
  @Override
  protected void checkText(String contentText) {
    if(contentText == null || contentText.isEmpty()) {
      throw new IllegalArgumentException();
    }
    
    if(contentText.length() > MAX_COMMENT_LENGTH) {
      throw new IllegalArgumentException();
    }
  }
}
