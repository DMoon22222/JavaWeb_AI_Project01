create table clazz
(
    id          int unsigned auto_increment comment 'ID,主键'
        primary key,
    name        varchar(30)      not null comment '班级名称',
    room        varchar(20)      null comment '班级教室',
    begin_date  date             not null comment '开课时间',
    end_date    date             not null comment '结课时间',
    master_id   int unsigned     null comment '班主任ID, 关联员工表ID',
    subject     tinyint unsigned not null comment '学科, 1:java, 2:前端, 3:大数据, 4:Python, 5:Go, 6: 嵌入式',
    create_time datetime         null comment '创建时间',
    update_time datetime         null comment '修改时间',
    constraint name
        unique (name)
)
    comment '班级表';

INSERT INTO tlias.clazz (id, name, room, begin_date, end_date, master_id, subject, create_time, update_time) VALUES (1, 'JavaEE就业163期', '212', '2023-04-30', '2023-06-29', 10, 1, '2023-06-01 17:08:23', '2023-06-01 17:39:58');
INSERT INTO tlias.clazz (id, name, room, begin_date, end_date, master_id, subject, create_time, update_time) VALUES (2, 'JavaEE就业166期', '101', '2023-06-01', '2024-01-25', 7, 1, '2026-03-17 09:30:05', '2026-03-17 09:30:05');
INSERT INTO tlias.clazz (id, name, room, begin_date, end_date, master_id, subject, create_time, update_time) VALUES (3, '4021', '603', '2026-03-02', '2026-03-31', null, 1, '2026-03-17 09:30:41', '2026-03-17 09:30:41');
