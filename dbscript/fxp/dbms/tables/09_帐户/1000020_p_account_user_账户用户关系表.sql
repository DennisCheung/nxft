--
-- 账户和用户关系表
--
-- v1.0 2017.03.20
-- author：wing
--
-- 说明：
-- 
-- 
--
-- 修改历史：
--
--
-- Drop Table fxp.p_account_user ;
Create Table  fxp.p_account_user (
-- +-----------------------------+--------------+-----------+
   faccount_id                   varchar2(32)   not null,   -- 账户id
   fuser_id                      varchar2(32)   not null,   -- 用户id
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
   constraint pk_p_account_user primary key (faccount_id),
   constraint uk_p_account_user unique (fuser_id)
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


