# AuthService 애플리케이션

## 개요
이 애플리케이션은 Java로 작성된 간단한 인증 서비스로, JDBC를 통해 PostgreSQL 데이터베이스와 연결됩니다. 로그인 기능을 지원하며, 다국어 오류 메시지와 함께 표준화된 JSON 형식으로 응답을 반환합니다.

## 기능
- **로그인**: 이메일과 비밀번호를 사용하여 사용자 로그인 기능을 제공합니다.
- **다국어 지원**: 인증 실패 시, ResourceBundle을 사용하여 다국어로 오류 메시지를 반환합니다.

## 응답 구조
서비스 응답은 다음과 같은 JSON 형식을 따릅니다:

### 성공 시 응답
```json
{
  "status": "success",
  "data": {
    "데이터": "서비스 응답 데이터"
  }
}
```

### 실패 시 응답
```json
{
  "status": "fail",
  "data": {
    "errorCode": "에러 코드",
    "errorMessage": "엔드 유저에게 보여줄 오류 메시지 (다국어 지원)"
  }
}
```

## 사용 기술
- **Language** : Java
- **Database** : Docker에서 실행되는 PostgreSQL 이미지
- **Connection** : JDBC를 통해 PostgreSQL 데이터베이스에 연결