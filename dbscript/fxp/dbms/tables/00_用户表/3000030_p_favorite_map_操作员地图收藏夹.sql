--
-- 操作员地图收藏夹
--
-- v1.0 2016.12.11
-- author：wing
--
-- 说明
--
--
--
-- 修改历史：
--
-- drop table fxp.p_favorite_map;
create table  fxp.p_favorite_map (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- 用户ID
   fmap_name                     varchar2(50)   not null,   -- 地图name
   flocation_city                varchar2(16),              -- 城市
   flocation_address             varchar2(128),             -- 地址
   flocation_longitude           number(19,16),              -- 经度
   flocation_latitude            number(19,16),              -- 纬度
   fcreate_date                  date           not null,   -- 创建时间
   fisDefault                    char(1)        not null,   -- 是否默认
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
   constraint pk_p_favorite_map primary key (fuser_id,fmap_name)
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
