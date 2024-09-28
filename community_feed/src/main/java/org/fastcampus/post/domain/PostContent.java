package org.fastcampus.post.domain;

public class PostContent {

  private final String content;
  
  // 생성자 : 유효성 검사(컨텐츠 길이 5이상 500이하 & content != null)
  public PostContent(String content) {
    
    if (content == null || content.length() < 5 || content.length() > 500) {
      throw new IllegalArgumentException();
    }
    
    this.content = content;
  }
  
  // Content 필드의 GetMethod
  public String getContent() {
    return content;
  }
}
