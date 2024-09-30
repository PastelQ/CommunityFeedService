package org.fastcampus.post.domain.content;

// 공개 여부 : 전체 공개 / 팔로워 공개 / 나만 보기
public enum PostPublicationState {
  PUBLIC,
  ONLY_FOLLOWER,
  PRIVATE
}
