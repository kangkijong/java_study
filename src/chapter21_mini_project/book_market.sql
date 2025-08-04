use hrdb2019;
select database();

/**************************************************************************************
	book_market_books : 도서 테이블
    book_market_cart : 장바구니 테이블
    book_market_member : 회원 테이블
    
    
	도서 테이블 : 도서ID(ISBN0001), 도서명, 도서가격, 저자, 도서 소개, 도서 분류, 날짜
    장바구니 테이블 : 도서ID, 수량, 합계(수량*도서가격)
    회원 테이블 : 고객명, 연락처(01012345678), 배송지(서울시 여의도 ~)
**************************************************************************************/

create table book_market_books(
	bid			char(8)				primary key,
    title			varchar(50)		not null,
    author		varchar(40),
    price			int,
    intro			varchar(60),
    category	varchar(20),
    bdate		datetime
);

create table book_market_cart(
	bid			char(8)				primary key,
    quantity		int,
    total			int
);

create table book_market_member(
	cid			varchar(10)		not null,
    phone		char(11)			primary key,
    city			varchar(50)
);

insert into book_market_books(title, author, price, intro, category, bdate)
	values('쉽게 배우는 JSP 프로그래밍', '송미영',  27000, '단계별로 쇼핑폼을 구현하며 배우는 JSP 웹 프로그래밍', 'IT전문서', curdate()) ;
insert into book_market_books(title, author, price, intro, category, bdate)
	values('안드로이드 프로그래밍', '우재남',  33000, '실습 단계별 명쾌한 멘토링!', 'IT전문서', curdate()) ;
insert into book_market_books(title, author, price, intro, category, bdate)
	values('스크래치', '고광일',  22000, '컴퓨팅 사고력을 키우는 볼륨 코딩', '컴퓨터', curdate()) ;

select * from book_market_books;
    
    
delimiter $$
create trigger trg_book_market_books_bid
before insert	 on book_market_books -- 테이블명
for each row
begin
declare max_code int;	-- 'ISBN0001'

select ifnull(max(cast(right(bid, 4) as unsigned)), 0) 
into max_code
from book_market_books;

-- 'ISBN0001' 형식으로 아이디 생성, LPAD(값, 크기, 채워지는 문자형식) : M0001
set new.bid = concat('ISBN', LPAD((max_code+ 1), 4, '0'));

end $$
delimiter ;

select * from information_schema.triggers;


select bid, title, price, author, intro, category, bdate
from book_market_books;
