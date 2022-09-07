# DAO

MVC모델 중 Model을 담당

DAO (Data Access Object) :  데이터베이스의 데이터를 조회하거나 수정하는 기능을 전담하도록 구성한 객체
                            전략 패턴(Strategy Pattern)으로 구현
                            
                            기준점 1. 테이블당 하나의 DAO생성
                                 2. 기능별로 하나의 DAO생성
                            필요시 DTO,VO 구현.(과다한 매개변수 방지)
데이터 베이스의 데이터 클래스
DTO(Data Transfer Object) : getter 와 setter 모두 존재
VO(Value Object) : getter 만 


#DB
Oracle사용
SQL Developer을 사용하여 로컬네트워크가 아닌 상태로 연결
