create table dept
(
    id          int unsigned auto_increment comment 'ID, 主键'
        primary key,
    name        varchar(10) not null comment '部门名称',
    create_time datetime    null comment '创建时间',
    update_time datetime    null comment '修改时间',
    constraint name
        unique (name)
)
    comment '部门表';

INSERT INTO tlias.dept (id, name, create_time, update_time) VALUES (1, '学工部', '2024-09-25 09:47:40', '2024-09-25 09:47:40');
INSERT INTO tlias.dept (id, name, create_time, update_time) VALUES (3, '咨询部', '2024-09-25 09:47:40', '2024-09-30 21:26:24');
INSERT INTO tlias.dept (id, name, create_time, update_time) VALUES (4, '就业部', '2024-09-25 09:47:40', '2024-09-25 09:47:40');
INSERT INTO tlias.dept (id, name, create_time, update_time) VALUES (5, '人事部', '2024-09-25 09:47:40', '2024-09-25 09:47:40');
INSERT INTO tlias.dept (id, name, create_time, update_time) VALUES (7, '教研部', '2026-03-15 18:58:56', '2026-03-15 18:58:56');
INSERT INTO tlias.dept (id, name, create_time, update_time) VALUES (8, '财务部', '2026-03-15 18:59:40', '2026-03-15 21:18:09');
INSERT INTO tlias.dept (id, name, create_time, update_time) VALUES (9, '后勤部', '2026-03-15 21:29:00', '2026-03-16 14:27:36');
