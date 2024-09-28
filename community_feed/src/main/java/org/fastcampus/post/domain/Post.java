package org.fastcampus.post.domain;

import org.fastcampus.user.domain.User;

// 게시글 도메인
public class Post {

  // User 객체를 가져오지 않고 Id(Long 타입)만 가져옴
  // private final User author;
  private final Long authorId;
  private final PostContent content;
  
  // Constructor : 유효성(작성자 !null)
  public Post(Long authorId, PostContent content) {
    if (authorId == null) {
      throw new IllegalArgumentException();
    }
    
    // this.author = author;
    this.authorId = authorId;
    this.content = content;
  }
}
