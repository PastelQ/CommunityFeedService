package org.fastcampus.user.domain;

import java.util.Objects;

// User 정보
public class User {

  private final Long id;
  private final UserInfo info; // UserInfo VO로 대체
  
  public User(Long id, UserInfo userInfo) {
    this.id = id;
    this.info = userInfo;
  }
  
  //필드 id : 객체를 메모리 주소값으로 비교를 하기 때문에 hashCode(), equals()를 재정의해야함
  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    return Objects.equals(id, other.id);
  }
}
