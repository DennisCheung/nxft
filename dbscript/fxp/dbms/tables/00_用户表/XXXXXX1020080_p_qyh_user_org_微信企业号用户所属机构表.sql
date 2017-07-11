--
-- 微信企业号用户所属机构表
--
-- v1.0 2016.08.12
-- author：wing
--
-- 说明
--
-- 
-- 修改历史：
--
-- drop table fxp.p_qyh_user_org;
create table  fxp.p_qyh_user_org (
-- +-----------------------------+--------------+-----------+
   fqyh_user_id                  varchar2(64)   not null,   -- 微信企业号user id
   forg_id                       varchar2(32)   not null,   -- 机构ID     
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
   constraint pk_p_qyh_user_org primary key (fqyh_user_id,forg_id)
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
