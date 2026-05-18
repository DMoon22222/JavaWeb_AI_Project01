create table emp_login_log
(
    id         int unsigned auto_increment comment 'ID'
        primary key,
    username   varchar(20)      null comment '用户名',
    password   varchar(32)      null comment '密码',
    login_time datetime         null comment '登录时间',
    is_success tinyint unsigned null comment '是否成功, 1:成功, 0:失败',
    jwt        varchar(1000)    null comment 'JWT令牌',
    cost_time  bigint unsigned  null comment '耗时, 单位:ms'
)
    comment '登录日志表';

INSERT INTO tlias.emp_login_log (id, username, password, login_time, is_success, jwt, cost_time) VALUES (1, 'wuyong', '123456', '2026-04-10 10:12:28', 1, 'eyJhbGciOiJIUzI1NiJ9.eyJpZCI6NCwidXNlcm5hbWUiOiJ3dXlvbmciLCJleHAiOjE3NzU4MzAzNDh9.aYHfVGXiHi8nhBhbIrDX4vSSGMMfzv_Xz09n8fUEJjE', 513);
INSERT INTO tlias.emp_login_log (id, username, password, login_time, is_success, jwt, cost_time) VALUES (2, 'xs', '123456', '2026-04-14 00:22:19', 1, 'eyJhbGciOiJIUzI1NiJ9.eyJpZCI6NjgsInVzZXJuYW1lIjoieHMiLCJleHAiOjE3NzYxNDA1Mzl9.jY9On1jYIjiD7PtGV1v4WgG8TapWbrzAGWn283RpJwk', 487);
INSERT INTO tlias.emp_login_log (id, username, password, login_time, is_success, jwt, cost_time) VALUES (3, 'songjiang', '123', '2026-05-11 23:32:46', 0, null, 6);
INSERT INTO tlias.emp_login_log (id, username, password, login_time, is_success, jwt, cost_time) VALUES (4, 'songjiang', '123456', '2026-05-11 23:32:49', 1, 'eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MiwidXNlcm5hbWUiOiJzb25namlhbmciLCJleHAiOjE3Nzg1NTY3Njl9.0LkYVMQ2AcaHV_YIafpa2fLaT_NG8QwCd8ePy7cu0LM', 273);
INSERT INTO tlias.emp_login_log (id, username, password, login_time, is_success, jwt, cost_time) VALUES (5, 'songjiang', '123456', '2026-05-11 23:51:51', 1, 'eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MiwidXNlcm5hbWUiOiJzb25namlhbmciLCJleHAiOjE3Nzg1NTc5MTF9._0wTNA4pLkFyK5BdGYK803t8W-7hIdYCZu_Nl6zJCcA', 2);
INSERT INTO tlias.emp_login_log (id, username, password, login_time, is_success, jwt, cost_time) VALUES (6, 'songjiang', '123456', '2026-05-12 11:45:03', 1, 'eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MiwidXNlcm5hbWUiOiJzb25namlhbmciLCJleHAiOjE3Nzg2MDA3MDJ9.cwzXegufAmmtDoXXjI0GfHROpWfKPSfjG7aWlzT0oRU', 428);
INSERT INTO tlias.emp_login_log (id, username, password, login_time, is_success, jwt, cost_time) VALUES (7, 'xs', '123456', '2026-05-12 11:45:36', 1, 'eyJhbGciOiJIUzI1NiJ9.eyJpZCI6NjgsInVzZXJuYW1lIjoieHMiLCJleHAiOjE3Nzg2MDA3MzZ9.ngghv-KS1RCntZ5C7jxnA35YbNVWnrEYxo3RKIKi6yQ', 2);
INSERT INTO tlias.emp_login_log (id, username, password, login_time, is_success, jwt, cost_time) VALUES (8, 'xs', '123456', '2026-05-12 12:14:54', 1, 'eyJhbGciOiJIUzI1NiJ9.eyJpZCI6NjgsInVzZXJuYW1lIjoieHMiLCJleHAiOjE3Nzg2MDI0OTR9.EdAggFfJB9vQ9U0QGNkatM03L8J3VqwvuxryKpRBwtk', 2);
INSERT INTO tlias.emp_login_log (id, username, password, login_time, is_success, jwt, cost_time) VALUES (9, 'xs', '123456', '2026-05-12 12:25:39', 1, 'eyJhbGciOiJIUzI1NiJ9.eyJpZCI6NjgsInVzZXJuYW1lIjoieHMiLCJleHAiOjE3Nzg2MDMxMzl9.0c-tO-_mwBJa270PGGXU1HvKFU38nNaSzOgGksXK8Ok', 2);
INSERT INTO tlias.emp_login_log (id, username, password, login_time, is_success, jwt, cost_time) VALUES (10, 'songjiang', '123456', '2026-05-12 12:27:30', 1, 'eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MiwidXNlcm5hbWUiOiJzb25namlhbmciLCJleHAiOjE3Nzg2MDMyNTB9.hQ9tBp4RJNTAcDztnBsJGmPZ05jbBqlQhvZOvZkVtjk', 4);
INSERT INTO tlias.emp_login_log (id, username, password, login_time, is_success, jwt, cost_time) VALUES (11, 'xs', '123456', '2026-05-12 15:07:05', 1, 'eyJhbGciOiJIUzI1NiJ9.eyJpZCI6NjgsInVzZXJuYW1lIjoieHMiLCJleHAiOjE3Nzg2MTI4MjR9.F_DNBl7AoWLwhVRufYcp4bIbnu6MNAiEPXg2ng0YJV0', 7);
