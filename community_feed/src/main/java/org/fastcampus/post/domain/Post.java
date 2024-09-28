package org.fastcampus.post.domain;

import org.fastcampus.user.domain.User;

// 게시글 도메인
public class Post {

  private final User author;
  private final String content;
  
  // Constructor : 유효성(작성자 !null & 5 <= 게시글 글자 <= 500)
  public Post(User author, String content) {
    if (author == null) {
      throw new IllegalArgumentException();
    }
    
    if (content == null || content.length() < 5 || content.length() > 500) {
      throw new IllegalArgumentException();
    }
    
    this.author = author;
    this.content = content;
  }
}
