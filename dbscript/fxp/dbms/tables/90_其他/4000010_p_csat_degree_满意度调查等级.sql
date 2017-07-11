--
-- 满意度调查等级
--
-- v1.0 2016.12.27
-- author：wing
--
-- 说明
-- 1、以后整个系统满意度调查分5级 1-5 1 很不满意  2 不满意 3 一般 4 满意 5 很满意
--
-- 
-- 修改历史：
--
-- drop table fxp.p_csat_degree;
create table  fxp.p_csat_degree (
-- +-----------------------------+--------------+-----------+
   fcsat_degree_id               varchar2(32)   not null,   -- 满意度调查等级ID
   fcsat_degree_name             varchar2(30)   not null,   -- 满意度调查等级名称 
   fcsat_degree_desc             varchar2(256),             -- 备注
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
   constraint pk_p_csat_degree primary key (fcsat_degree_id)
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
