package org.fastcampus.post.domain;

import org.fastcampus.common.domain.PositiveIntegerCounter;
import org.fastcampus.post.domain.content.PostContent;
import org.fastcampus.user.domain.User;

// 게시글 도메인
public class Post {

  // User 객체 필드로 다시 변경 / 게시글 id 생성
  private final Long id;
  private final User author;
  private final PostContent content;
  private final PositiveIntegerCounter likeCount;
  
  // Constructor : 유효성(작성자 !null)
  public Post(Long id, User author, PostContent content) {
    if (author == null) {
      throw new IllegalArgumentException();
    }
    
    this.id = id;
    this.author = author;
    this.content = content;
    this.likeCount = new PositiveIntegerCounter();
  }
  
  // 좋아요 기능 like(), unlike()
  // - 글쓴이와 좋아요를 누르는 user가 동일하면 에러 발생
  public void like(User user) {
    if(this.author.equals(user)) {
      throw new IllegalArgumentException();
    }
    likeCount.increase();
  }
  
  public void unlike() {
    likeCount.decrease();
  }
}
