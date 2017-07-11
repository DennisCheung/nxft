--
-- 用户邮箱表
--
-- v1.0 2015.11.09
-- author：wing
--
-- 说明
-- 1、此表为记录用户的注册邮箱，如果注册邮箱可以使用以下功能
--   ① 忘记密码，通过邮箱链接，找到密码。
--   ② 输入邮箱号登录
--
--
-- 修改历史：
--
-- drop table fxp.p_user_email;
create table  fxp.p_user_email (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- 用户ID
   femail_no                     varchar2(30)   not null,   -- 邮箱号
-- +-----------------------------+--------------+-----------+
   --
   -- 日志
   --
   fversion                      number(6)                  -- 版本号
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
   constraint pk_p_user_email primary key (fuser_id),
   constraint uk_p_user_email unique (femail_no)
   --
   -- 约束
   --
);

--
-- 同义词
--

--
-- 授权
--

--
-- 索引
--

--
-- 修改语句
--
