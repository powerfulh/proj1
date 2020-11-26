CREATE TABLE local(
    loc NUMBER(3)
        CONSTRAINT LOCAL_LOC_PK PRIMARY KEY,
    locname VARCHAR2(20 CHAR)
        CONSTRAINT LOCAL_LOCNAME_NN NOT NULL
);

CREATE TABLE resipi(
    rno NUMBER(4)
        CONSTRAINT RESIPI_RNO_PK PRIMARY KEY,
    rname VARCHAR2(20 CHAR)
        CONSTRAINT RESIPI_RNAME_UK UNIQUE
        CONSTRAINT RESIPI_RNAME_NN NOT NULL,
    category VARCHAR2(3 CHAR)
        CONSTRAINT RESIPI_CATEGORY_CK CHECK (category IN('한','중','일','양','퓨'))
        CONSTRAINT RESIPI_CATEGORY_NN NOT NULL,
    ingred VARCHAR2(500 CHAR)
        CONSTRAINT RESIPI_INGRED_NN NOT NULL,
    video VARCHAR2(100 CHAR),
    time NUMBER(2)
        CONSTRAINT RESIPI_TIME_NN NOT NULL,
    situat VARCHAR2(10 CHAR)
        CONSTRAINT RESIPI_SITUAT_CK CHECK (situat IN('반찬','자취','안주','든든'))
        CONSTRAINT RESIPI_SITUAT_NN NOT NULL
);


CREATE TABLE member(
    mno NUMBER(4)
        CONSTRAINT MEMB_MNO_PK PRIMARY KEY,
    id VARCHAR2(20 CHAR)
        CONSTRAINT MEMB_ID_UK UNIQUE
        CONSTRAINT MEMB_ID_NN NOT NULL,
    pw VARCHAR2(20 CHAR)
        CONSTRAINT MEMB_PW_NN NOT NULL,
    joindate DATE DEFAULT SYSDATE
        CONSTRAINT MEMB_JOINDATE_NN NOT NULL,
    age NUMBER(2)
        CONSTRAINT MEMB_AGE_NN NOT NULL,
    gen CHAR
        CONSTRAINT MEMB_GEN_CK CHECK (gen IN('M','F')),
    mail VARCHAR2(30 CHAR)
        CONSTRAINT MEMB_MAIL_UK UNIQUE
        CONSTRAINT MEMB_MAIL_NN NOT NULL,
    local NUMBER(3)
        CONSTRAINT MEMB_LOCAL_FK REFERENCES local(loc),
    tel VARCHAR2(20 CHAR)
        CONSTRAINT MEMB_TEL_UK UNIQUE,
    grade NUMBER(2) DEFAULT 1
        CONSTRAINT MEMB_GRADE_NN NOT NULL,
    avt NUMBER(4) DEFAULT 1001
        CONSTRAINT MEMB_AVT_FK REFERENCES avatar(pno)
);

CREATE TABLE avatar(
    pno NUMBER(4)
        CONSTRAINT AVT_PNO_PK PRIMARY KEY,
    pname VARCHAR2(20 CHAR)
        CONSTRAINT AVT_PNAME_NN NOT NULL,
    dir VARCHAR2(50 CHAR)
        CONSTRAINT AVT_DIR_NN NOT NULL,
    len NUMBER
        CONSTRAINT AVT_LEN_NN NOT NULL
);

CREATE TABLE thumb(
    tno NUMBER(4)
        CONSTRAINT THUMB_TNO_PK PRIMARY KEY,
    dir VARCHAR2(50 CHAR)
        CONSTRAINT THUMB_DIR_NN NOT NULL,
    tname VARCHAR2(20 CHAR)
        CONSTRAINT THUMB_TNAME_NN NOT NULL,
    tmno NUMBER(4)
        CONSTRAINT THUMB_TMNO_FK REFERENCES member(mno)
        CONSTRAINT THUMB_TMNO_NN NOT NULL
);

CREATE TABLE BOARD(
    bno NUMBER(4)
        CONSTRAINT BOARD_BNO_PK PRIMARY KEY,
    title VARCHAR2(20 CHAR)
        CONSTRAINT BOARD_TITLE_NN NOT NULL,
    wmno NUMBER(4)
        CONSTRAINT BOARD_WMNO_FK REFERENCES member(mno),
    wdate DATE DEFAULT SYSDATE
        CONSTRAINT BOARD_WDATE_NN NOT NULL,
    body VARCHAR2(1000 CHAR)
        CONSTRAINT BOARD_BODY_NN NOT NULL,
    lcount NUMBER(4) DEFAULT 0
        CONSTRAINT BOARD_LCOUNT_NN NOT NULL,
    rno NUMBER(4)
        CONSTRAINT BOARD_RNO_FK REFERENCES resipi(rno)
        CONSTRAINT BOARD_RNO_NN NOT NULL,
    imgno NUMBER(4) 
        CONSTRAINT BOARD_IMGNO_FK REFERENCES thumb(tno),
    cnt NUMBER(5) DEFAULT 0
        CONSTRAINT BOARD_CNT_NN NOT NULL
);




CREATE TABLE image(
    imgno NUMBER(5)
        CONSTRAINT IMG_INO_PK PRIMARY KEY,
    imgbno NUMBER(4)
        CONSTRAINT IMG_IBNO_FK REFERENCES board(bno)
        CONSTRAINT IMG_IBNO_NN NOT NULL,
    oriname VARCHAR2(50 CHAR)
        CONSTRAINT IMG_ONAME_NN NOT NULL,
    savename VARCHAR2(50 CHAR)
        CONSTRAINT IMG_SNAME_UK UNIQUE
        CONSTRAINT IMG_SNAME_NN NOT NULL,
    len NUMBER
        CONSTRAINT IMG_LEN_NN NOT NULL,
    imgdate DATE DEFAULT SYSDATE
        CONSTRAINT IMG_IDATE_NN NOT NULL,
    dir VARCHAR2(50 CHAR)
        CONSTRAINT IMG_DIR_NN NOT NULL
);

CREATE TABLE ingredient(
    ino NUMBER(4)
        CONSTRAINT INGRED_INO_PK PRIMARY KEY,
    iname VARCHAR2(20 CHAR)
        CONSTRAINT INGRED_INAME_UK UNIQUE
        CONSTRAINT INGRED_INAME_NN NOT NULL,
    category VARCHAR2(20 CHAR)
        CONSTRAINT INGRED_CATEGORY_CK CHECK (category IN('육류','콩/두부','채소류','과일류','해산물','조미료','유제품','면류'))
);

CREATE TABLE userlike(
    lno NUMBER(4) 
        CONSTRAINT LIKE_LNO_PK PRIMARY KEY,
    lmno NUMBER(4)
        CONSTRAINT LIKE_LMNO_FK REFERENCES member(mno)
        CONSTRAINT LIKE_LMNO_NN NOT NULL,
    lbno NUMBER(4)
        CONSTRAINT LIKE_LBNO_FK REFERENCES board(bno)
        CONSTRAINT LIKE_LBNO_NN NOT NULL,
    ldate DATE
        CONSTRAINT LIKE_LDATE_NN NOT NULL
);

CREATE TABLE reply(
    reno NUMBER(5)
        CONSTRAINT REPLY_RENO_PK PRIMARY KEY,
    rebno NUMBER(4)
        CONSTRAINT REPLY_REBNO_FK REFERENCES board(bno)
        CONSTRAINT REPLY_REBNO_NN NOT NULL,
    body VARCHAR2(200 CHAR)
        CONSTRAINT REPLY_BODY_NN NOT NULL,
    remno NUMBER(4)
        CONSTRAINT REPLY_REMNO_FK REFERENCES member(mno)
        CONSTRAINT REPLY_REMNO_NN NOT NULL,
    redate DATE DEFAULT SYSDATE
        CONSTRAINT REPLY_REDATE_NN NOT NULL
);

ALTER TABLE image MODIFY(dir VARCHAR2(100 CHAR));
ALTER TABLE avatar MODIFY(dir VARCHAR2(100 CHAR));
ALTER TABLE thumb MODIFY(dir VARCHAR2(100 CHAR));

COMMIT;

INSERT INTO 
    member
VALUES(
    (SELECT NVL(MAX(mno) + 1, 1001) FROM member),'jiwoo','12345',SYSDATE,20,'M','jiwoo@increpas.com',032,'010-1111-1111',10,1001)
;

INSERT INTO 
    avatar
VALUES(
    (SELECT NVL(MAX(mno) + 1, 1001) FROM member), 'jiwoo', '/cls/img/avatar/noimage.jpg',100000)
;



commit;


INSERT INTO 
    member
VALUES(
    (SELECT NVL(MAX(mno) + 1, 1001) FROM member),'jiwoo','12345',SYSDATE,20,'M','jiwoo@increpas.com',032,'010-1111-1111',10,1001)
;

insert INTO local VALUES(
031 , '서울/경기'
);
insert INTO local VALUES(
033 , '강원도'
);
insert INTO local VALUES(
043 , '충청북도'
);
insert INTO local VALUES(
054 , '경상북도'
);
insert INTO local VALUES(
063 , '전라북도'
);
insert INTO local VALUES(
061 , '전남/제주'
);
insert INTO local VALUES(
055 , '경상남도'
);
insert INTO local VALUES(
041 , '충청남도'
);

commit;
select * from local;

SELECT
    i.dir,r.rname,r.video,b.wdate,b.body,b.lcount,b.cnt
FROM
    board b, image i, resipi r , member
WHERE
    bno = imgbno
    AND brno = rno
    AND id = 'jiwoo'
;

INSERT INTO
    image(imgno, imgbno, oriname, savename, len, dir)
VALUES(
    (SELECT NVL(MAX(imgno) + 1, 10001) FROM image),
    1001,'image1','image1',100000,'/cls/img/avatar/noimage.jpg'
);

INSERT INTO
    board(bno, title, wmno, body, brno, btno)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1001) FROM board),
    '베이컨 볶음밥 만드는법', 1001, '맛있게 드세요', 1001, 1001 
);

INSERT INTO
    resipi(rno, rname, category, ingred, video, time, situat)
VALUES(
    (SELECT NVL(MAX(rno) + 1, 1001) FROM resipi),
    '베이컨 볶음밥','한', '당근/베이컨/백미밥/','https://www.youtube.com/watch?v=UKKK7cWwZOg',20, '자취'
);

INSERT INTO
    thumb(tno, dir, tname, tmno)
VALUES(
    (SELECT NVL(MAX(tno) + 1, 1001) FROM thumb),
    '/cls/img/avatar/noimage.jpg','image1',1001
);

ALTER TABLE BOARD DROP COLUMN body;

CREATE TABLE body(
    bono NUMBER(4)
        CONSTRAINT BODY_BONO_PK PRIMARY KEY,
    body VARCHAR2(500 CHAR)
        CONSTRAINT BODY_BODY_NN NOT NULL,
    bobno NUMBER(4)
        CONSTRAINT BODY_BOBNO_FK REFERENCES BOARD(bno)
        CONSTRAINT BODY_BOBNO_NN NOT NULL
);


ALTER TABLE 
    IMAGE 
ADD 
    imgbono NUMBER(4) 
    CONSTRAINT IMAGE_IBONO_FK REFERENCES body(bono);
    
    
INSERT INTO ingredient
VALUES('1001','소고기','육류');

INSERT INTO ingredient
VALUES('1002','돼지고기','육류');

INSERT INTO ingredient
VALUES('1003','양고기','육류');

INSERT INTO ingredient
VALUES('2001','검은콩','콩/두부');

INSERT INTO ingredient
VALUES('2002','두부','콩/두부');

select * from ingredient;

commit;

INSERT INTO 
    member
VALUES(
    1002, 'jiwoo2','12345',sysdate,24,'M','jiwoo2@increpas.com',032,'010-2222-2222',10,'1001'
);

INSERT INTO 
    member
VALUES(
    1003, 'jiwoo3','12345',sysdate,24,'M','jiwoo3@increpas.com',032,'010-3333-3333',10,'1001'
);

INSERT INTO 
    member
VALUES(
    1004, 'jiwoo4','12345',sysdate,24,'M','jiwoo4@increpas.com',032,'010-4444-4444',10,'1001'
);

INSERT INTO 
    member
VALUES(
    1005, 'jiwoo5','12345',sysdate,24,'M','jiwoo5@increpas.com',032,'010-5555-5555',10,'1001'
);

INSERT INTO 
    member
VALUES(
    1006, 'jiwoo6','12345',sysdate,24,'M','jiwoo6@increpas.com',032,'010-6666-6666',10,'1001'
);

INSERT INTO 
    member
VALUES(
    1007, 'jiwoo7','12345',sysdate,24,'M','jiwoo7@increpas.com',032,'010-7777-7777',10,'1001'
);

INSERT INTO 
    member
VALUES(
    1008, 'jiwoo8','12345',sysdate,24,'M','jiwoo8@increpas.com',032,'010-8888-8888',10,'1001'
);
INSERT INTO
    image(imgno, imgbno, oriname, savename, len, dir)
VALUES(
    (SELECT NVL(MAX(imgno) + 1, 10001) FROM image),
    1001,'image3','image3',100000,'/cls/img/avatar/noimage.jpg'
);

INSERT INTO
    board(bno, title, wmno, body, brno, btno)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1001) FROM board),
    '베이컨 볶음밥 만드는법', 1001, '맛있게 드세요', 1001, 1001 
);

INSERT INTO
    resipi(rno, rname, category, ingred, video, time, situat)
VALUES(
    (SELECT NVL(MAX(rno) + 1, 1001) FROM resipi),
    '베이컨 볶음밥','한', '당근/베이컨/백미밥/','https://www.youtube.com/watch?v=UKKK7cWwZOg',20, '자취'
);

INSERT INTO
    thumb(tno, dir, tname, tmno)
VALUES(
    (SELECT NVL(MAX(tno) + 1, 1001) FROM thumb),
    '/cls/img/avatar/noimage.jpg','image1',1001
);

ALTER TABLE 
    board 
DROP COLUMN 
    body
;

ALTER TABLE 
    IMAGE 
ADD 
    imgbono NUMBER(4) 
    CONSTRAINT IMAGE_IBONO_FK REFERENCES body(bono);
    
CREATE TABLE body(
    bono NUMBER(4)
        CONSTRAINT BODY_BONO_PK PRIMARY KEY,
    body VARCHAR2(500 CHAR)
        CONSTRAINT BODY_BODY_NN NOT NULL,
    bobno NUMBER(4)
        CONSTRAINT BODY_BOBNO_FK REFERENCES BOARD(bno)
        CONSTRAINT BODY_BOBNO_NN NOT NULL
);


INSERT INTO 
    body   
VALUES(
    (SELECT NVL(MAX(bono) + 1, 1001) FROM body), '오늘할 레시피는 베이컨 볶음밥이에요.',1001
);

INSERT INTO 
    body   
VALUES(
    (SELECT NVL(MAX(bono) + 1, 1001) FROM body), '다들 준비되셨나요.',1001
);

INSERT INTO 
    body   
VALUES(
    (SELECT NVL(MAX(bono) + 1, 1001) FROM body), '네 알려드렸습니다.',1001
);

INSERT INTO
    reply(reno,rebno,body,remno,redate)
VALUES(
    (SELECT NVL(MAX(reno) + 1, 10001) FROM reply), 1001, '조리하기 쉬워요', 1001, sysdate
);

INSERT INTO
    reply(reno,rebno,body,remno,redate)
VALUES(
    (SELECT NVL(MAX(reno) + 1, 10001) FROM reply), 1001, '하기 힘드네요 저는', 1002, sysdate
);

INSERT INTO
    reply(reno,rebno,body,remno,redate)
VALUES(
    (SELECT NVL(MAX(reno) + 1, 10001) FROM reply), 1001, '좋아요 만족스러워요', 1003, sysdate
);

INSERT INTO
    reply(reno,rebno,body,remno,redate)
VALUES(
    (SELECT NVL(MAX(reno) + 1, 10001) FROM reply), 1001, '하이요', 1004, sysdate
);

INSERT INTO
    reply(reno,rebno,body,remno,redate)
VALUES(
    (SELECT NVL(MAX(reno) + 1, 10001) FROM reply), 1001, '왜그러세요 뭐가문제죠', 1005, sysdate
);

INSERT INTO
    reply(reno,rebno,body,remno,redate)
VALUES(
    (SELECT NVL(MAX(reno) + 1, 10001) FROM reply), 1001, '요리 망치지마세요', 1006, sysdate
);

INSERT INTO
    reply(reno,rebno,body,remno,redate)
VALUES(
    (SELECT NVL(MAX(reno) + 1, 10001) FROM reply), 1001, '안돼요 왜이리 어려워요', 1007, sysdate
);

INSERT INTO
    reply(reno,rebno,body,remno,redate)
VALUES(
    (SELECT NVL(MAX(reno) + 1, 10001) FROM reply), 1001, '요리좋아요', 1008, sysdate
);
commit;


