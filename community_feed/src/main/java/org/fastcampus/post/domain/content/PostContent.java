package org.fastcampus.post.domain.content;

// 게시글 내용 VO : Content Abstract 클래스를 상속 받음
public class PostContent extends Content{

  // 글자수 제한 상수로 선언(최소 5 / 최대 500)
  private static final int MIN_POST_LENGTH = 5;
  private static final int MAX_POST_LENGTH = 500;
  
  // 생성자
  public PostContent(String content) {
    super(content);
  }
  
  // 추상메서드 checkText() 공통으로 사용
  @Override
  protected void checkText(String contentText) {
    if(contentText == null || contentText.isEmpty()) {
      throw new IllegalArgumentException();
    }
    
    if(contentText.length() < MIN_POST_LENGTH) {
      throw new IllegalArgumentException();
    }
    
    if(contentText.length() > MAX_POST_LENGTH) {
      throw new IllegalArgumentException();
    }
  }
}
