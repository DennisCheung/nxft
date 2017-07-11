--
-- 微信企业号游客表
--
-- v1.0 2016.08.12
-- author：wing
--
-- 说明
-- 1、fqyh_user_id = 企业号通讯录 userId 
--
--
-- 
-- 修改历史：
--
-- drop table fxp.p_qyh_guest;
create table  fxp.p_qyh_guest (
-- +-----------------------------+--------------+-----------+
   fopen_id                      varchar2(256)  not null,   -- openid
   fqyh_user_id                  varchar2(64)   not null,   -- 微信企业号user id
   fuser_name                    varchar2(50)   not null,   -- 姓名
   fsex_id                       varchar2(32),              -- 性别id
   fsex_name                     varchar2(10),              -- 性别名称
   fweixinid                     varchar2(64),              -- 注册微信号
   fmobile                       varchar2(20),              -- 注册手机号
   femail                        varchar2(30),              -- 注册邮箱号
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
   constraint pk_p_qyh_guest primary key (fopen_id)
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
