--
-- 操作员客户信息收藏夹
--
-- v1.0 2016.09.11
-- author：wing
--
-- 说明
--
--
--
-- 修改历史：
--
-- drop table fxp.p_favorite_person;
create table  fxp.p_favorite_person (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- 用户ID
   fperson_id                    varchar2(32)   not null,   -- 客户id
   fperson_name                  varchar2(50)   not null,   -- 客户name
   fcreate_date                  date           not null,   -- 创建时间
   ffavorite_desc                varchar2(256),             -- 备注
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
   constraint pk_p_favorite_person primary key (fuser_id,fperson_id)
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
