package org.fastcampus.post.domain.comment;

import org.fastcampus.common.domain.PositiveIntegerCounter;
import org.fastcampus.post.domain.Post;
import org.fastcampus.post.domain.content.CommentContent;
import org.fastcampus.user.domain.User;

// 댓글 도메인
public class Comment {

  private final Long id;
  private final Post post;
  private final User author;
  private final CommentContent content;
  private final PositiveIntegerCounter likeCount;
  
  public Comment(Long id, Post post, User author, CommentContent content) {
    if(id == null) {
      throw new IllegalArgumentException();
    }
    
    if(post == null) {
      throw new IllegalArgumentException();
    }
    
    if(content == null) {
      throw new IllegalArgumentException();
    }
    
    this.id = id;
    this.post = post;
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
  
  public void updateComment(User user, String updatedContent) {
    if(!this.author.equals(user)) {
      throw new IllegalArgumentException();
    }
    
    this.content.updateContent(updatedContent);
  }
}
