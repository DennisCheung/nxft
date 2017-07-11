--
-- 职工表
--
-- v1.0 2015.06.01
-- author：wing
--
-- 说明：
-- 1. 手机、邮箱、微信号 三者至少一个不为空
-- 2. 增加职工，需同时在职工表、p_user 表中增加一条记录。
-- 3. 和微信企业号职工表数据同步方式
--    1）每天晚上全表更新。
--    2）PC端维护每机构增加职工，点同步按钮，同步本机构职工。
-- 4. PC端通过各子系统用户表 和 P_USER 登录系统。
-- 5. 微信企业号账号 = 职工表工号
-- 6. 微信企业号 femp_code -> fuser_id  -> p_user 表取 fuser_id，fuser_name = femp_name
--    微信企业号用不到 用户微信绑定表  p_user_wechat
--
--
-- 修改历史：
--
-- drop table fxp.p_employee;
create table  fxp.p_employee (
-- +-----------------------------+--------------+-----------+
   femp_id                       varchar2(32)   not null,   -- 职工id
   femp_code                     varchar2(20)   not null,   -- 职工编码(职工账号），唯一
   femp_name                     varchar2(30)   not null,   -- 职工姓名
   fsex_id                       varchar2(32),     			    -- 性别id
   fsex_name                     varchar2(10),     			    -- 性别名称
   fbirth_date                   date,                      -- 出生日期
   --
   -- 所属机构
   --
   forg_id                       varchar2(32)   not null,   -- 所属机构id
   fdept_id                      varchar2(32)   not null,   -- V1.1 部门id
   --
   -- 通讯录
   --
   fposition                     varchar2(100),             -- 职位描述信息
   fmobile                       varchar2(30),              -- 手机
   femail                        varchar2(30),              -- 邮箱
   fwechat                       varchar2(30),              -- 微信号
   fqq                           varchar2(30),              -- qq号
   --
   fuser_id                      varchar2(32),              -- 用户id（p_user.fuser_id）
   femp_desc                     varchar2(256),             -- 描述
-- +-----------------------------+--------------+-----------+
   fisavailable                  char(1)        not null,   -- 是否有效？
  --
   -- 日志
   --
   fversion                      number(6)                   -- 版本号
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- 创建者
   flogcdate                     date           not null,   -- 创建时间
   flogluby                      varchar2(32)   not null,   -- 最后修改者
   flogludate                    date           not null,   -- 最后修改时间
   floglaby                      varchar2(32)   not null,   -- 最后访问者
   flogladate                    date           not null,   -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_p_employee primary key (femp_id),
   constraint uk_p_employee_code unique (femp_code),
   constraint uk_p_employee_mobile unique (fmobile),
   constraint uk_p_employee_email unique (femail),
   constraint uk_p_employee_wechat unique (fwechat),
   constraint uk_p_employee_user unique (fuser_id)
   --
   -- 约束
   --
);

--
-- 授权
--

--
-- 索引
--
create index fxp.idx_p_employee2 on fxp.p_employee (forg_id);

--
-- 修改语句
--
