--
-- 用户微信绑定表
--
-- v1.0 2016.03.15
-- author：wing
--
-- 说明
-- 1、此表为客户关注服务号时使用，企业号不用此表。
-- 2、PC端新增客户信息时不插p_user
-- 3、用户注册场景：
--    3.1 通过关注微信服务号“福来健康”， 成为用户并实现和微信服务号的绑定（同时插 p_user 和 p_user_wechat）。
-- 4、客户使用微信服务号应用，通过 open_id  在 p_user_wechat 中获取 fuser_id  
-- 5、微信应用不需用到p_user表,不需密码，PC端应用使用 p_user 表 。
-- 6、客户微信服务号作为一个独立的子系统。
-- 
-- 修改历史：
--
-- drop table fxp.p_user_wechat;
create table  fxp.p_user_wechat (
-- +-----------------------------+--------------+-----------+
   fopen_id                      varchar2(128)  not null,   -- 绑定的微信号id
   fuser_id                      varchar2(32)   not null,   -- 用户ID，     
   fpublic_no                    varchar2(128)  not null,   -- 微信公众号
   fwechat_name                  varchar2(50)   not null,   -- 微信昵称
   fwechat_area                  varchar2(50),              -- 微信地区
   fwechat_sex                   varchar2(10),              -- 微信性别
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
   constraint pk_p_user_wechat primary key (fopen_id),
   constraint uk_p_user_wechat unique (fuser_id,fpublic_no)
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
