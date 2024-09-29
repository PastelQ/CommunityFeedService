package org.fastcampus.post.domain;

import org.fastcampus.post.domain.content.PostContent;
import org.fastcampus.user.domain.User;

// 게시글 도메인
public class Post {

  // User 객체 필드로 다시 변경 / 게시글 id 생성
  private final Long id;
  private final User author;
  private final PostContent content;
  
  // Constructor : 유효성(작성자 !null)
  public Post(Long id, User author, PostContent content) {
    if (author == null) {
      throw new IllegalArgumentException();
    }
    
    this.id = id;
    this.author = author;
    this.content = content;
  }
}
