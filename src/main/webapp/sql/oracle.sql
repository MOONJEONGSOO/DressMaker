select * from user_tables;

drop table member;
drop table product;
drop table board;
drop table buyInfo;


create table member(				-- 회원 테이블
	mid varchar(20) primary key, 	-- 회원 아이디
	mpw varchar(20),				-- 회원 비밀번호
	mname varchar(20),				-- 회원 이름
	mmail varchar(100)				-- 회원 이메일
);
insert into member values('moon','1234','문정수','j38317_study@naver.com');
select mid from member where mid='moon';
create table product(				-- 상품 테이블
	pnum int primary key,			-- 상품 번호
	pname varchar(100),				-- 상품 이름
	pimg varchar(500),				-- 상품 이미지
	pprice int,						-- 상품 가격
	pinfo varchar(500),				-- 상품 정보
	prental varchar(20)				-- 대여여부
);

select count(*) as listcnt from product;
select * from ( select rownum as rnum, A.pnum, A.pname, A.pimg, A.pprice, A.pinfo, A.prental from (select * from PRODUCT order by pnum desc) A) where rnum between 1 and 6;
 -- PNUM 으로 정렬을 하고 정렬 상태에서 RNUM 으로 임시번호를 부여 하고 RNUM BETWEEN으로 뽑아옴

select * from product where pname like '%'||''||'%' and pprice BETWEEN 0 AND 9999999 order by pnum desc;
select count(*) as listcnt from product where pname like '%'||''||'%' and pprice BETWEEN 0 AND 999999 order by pnum desc;
select * from ( select rownum as rnum, A.pnum, A.pname, A.pimg, A.pprice, A.pinfo, A.prental from (select * from PRODUCT where pname like '%'||''||'%' and pprice BETWEEN 0 AND 9999999 order by pnum desc) A) where rnum between ? and ?;


create table Board(					-- 후기 게시판 테이블
	bnum int primary key,			-- 글 번호
	mid varchar(20),				-- 회원 아이디(작성자)
	btitle varchar(50),				-- 글 제목
	bcontent varchar(500),			-- 글 내용
	bimg varchar(50),				-- 후기 사진
	pnum int						-- 상품 번호
);

select product.pname from board, product where board.pnum=product.pnum; -- 이름 가져오는 로직

select product.pname, board.pnum from board, product where 123=product.pnum; -- 이름 가져오는 로직
select board.*, product.pname from board, product where board.pnum=product.pnum order by bnum desc; -- pnum로 검색
select board.bnum, board.mid, board.btitle, board.bcontent, board.bimg, board.pnum from board, product where board.pnum=product.pnum and product.pnum=402;
SELECT * FROM BOARD ORDER BY BNUM DESC

insert into board values(1001,'작성자','제목','내용','',1); --아님

create table buyInfo(				-- 구매정보 테이블
	inum int primary key,			-- 정보 번호
	mid varchar(20),				-- 회원 아이디
	pnum int						-- 상품 번호
);


insert into member values('admin','1234','관리자','ADMIN'); --아님

select * from member;
select * from product;
select * from board;
select * from buyInfo;


insert into board values(1,'제목 테스트','관리자','내용 테스트'); --아님

select pname,BuyInfo.pnum from product, BuyInfo where BuyInfo.pnum=product.pnum and BuyInfo.mid='moon';
update product set prental='대여중' where pnum=2;