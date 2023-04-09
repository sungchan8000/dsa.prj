CREATE USER 'u_dsa'@'localhost' IDENTIFIED BY 'a1234567';
CREATE USER 'u_dsa'@'%' IDENTIFIED BY 'a1234567';

GRANT ALL PRIVILEGES ON o_dsa.* TO 'u_dsa'@'localhost';
GRANT ALL PRIVILEGES ON o_dsa.* TO 'u_dsa'@'%';

CREATE DATABASE simple DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;



-- 회원마스터
create table tbl_member_mst
(
    mem_mst_seq  bigint auto_increment comment '마스터 SEQ',
    mem_name     varchar(200) not null comment '회원 이름',
    mem_id       varchar(200) not null comment '회원 ID',
    mem_phone    varchar(11)  not null comment '회원 전화번호',
    mem_mail     varchar(200) not null comment '회원 이메일 주소',
    mem_password text         not null comment '회원 비밀번호',
    create_date  datetime comment '생성 날짜',
    modify_date  datetime comment '수정 날짜',
    constraint primary key (mem_mst_seq)
);

-- 이벤트 마스터
create table tbl_event_mst
(
    eve_mst_seq      bigint auto_increment comment '이벤트 SEQ',
    eve_id           varchar(200) not null comment '이벤트 ID',
    eve_name         varchar(200) not null comment '이벤트 제목',
    eve_desc         text comment '이벤트 설명',
    eve_min_capacity int comment '이벤트 최소 인원',
    eve_max_capacity int comment '이벤트 최대 인원',
    eve_date_year    varchar(10)  not null comment '이벤트 YYMMDDHHmm',
    start_sign_date  datetime     not null comment '모집 시작 시간',
    end_sign_date    datetime     not null comment '모집 종료 날짜',
    event_flag       boolean comment '이벤트 활성화 여부',
    create_date      datetime comment '이벤트 생성 날짜',
    modify_date      datetime comment '이벤트 수정 날짜',
    constraint primary key (eve_mst_seq)
);

