--
-- 用户手机号表
--
-- v1.0 2015.07.29
-- author：wing
--
-- 说明
-- 1、此表为记录用户的手机号，如果登记手机号码可以使用以下功能
--   ① 通过手机号码，找到密码。
--   ② 输入手机号登录
--
--
-- 修改历史：
--
-- drop table fxp.p_user_mobile;
create table  fxp.p_user_mobile (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- 用户ID
   fmobile_no                    varchar2(30)   not null,   -- 手机号
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
   constraint pk_p_user_mobile primary key (fuser_id),
   constraint uk_p_user_mobile unique (fmobile_no)
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
