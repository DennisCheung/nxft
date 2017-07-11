--
-- 用户最后位置表
--
-- v1.0 2016.11.10
-- author：wing
--
--
-- 修改历史：
--
--
--
-- drop table fxp.p_user_location;
create table  fxp.p_user_location (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- 用户id
   frec_time                     date           not null,   -- 记录时间         
   --
   --  位置数据
   --
   flocation_time                date           not null,   -- 定位时间   
   fcity                         varchar2(16),              -- 城市
   faddress                      varchar2(128),             -- 地址
   flongitude                    number(19,15)   not null,   -- 经度
   flatitude                     number(19,15)   not null,   -- 纬度
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
   constraint pk_p_user_location primary key (fuser_id)
);

--
-- 外部键约束
--
--
-- 索引
--


