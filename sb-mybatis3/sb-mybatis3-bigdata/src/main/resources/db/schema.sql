create table t_student
(
    sid   varchar(10) primary key not null comment '主键',
    sname varchar(60)             not null comment '姓名',
    birth date                    not null comment '生日',
    sex   char(2)                 not null comment '性别'
);

create table t_score
(
    sid   varchar(10) comment '学号',
    cid   varchar(10) not null comment '课程号',
    score double      not null comment '分数'
);

create table t_course
(
    cid   varchar(10) primary key not null comment '课程号',
    cname varchar(20)             not null comment '课程名',
    tid   varchar(10)             not null comment '教师号'
);

create table t_teacher
(
    tid   varchar(10) primary key not null comment '教师号',
    tname varchar(20)             not null comment '教师名'
);